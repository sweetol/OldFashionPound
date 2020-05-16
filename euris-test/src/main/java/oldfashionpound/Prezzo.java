package oldfashionpound;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import oldfashionpound.exceptions.*;

public class Prezzo {

	private static final String PRICE_PATTERN = "((\\d+)[p]\\s(\\d+)[s]\\s(\\d+)[d])";
	public static final Integer PENCE_TO_SCELLINI_SCALE = 12;
	public static final Integer SCELLINI_TO_STERLINE_SCALE = 20;
	private Sterline sterline;
	private Scellini scellini;
	private Pence pence;
	private Prezzo resto = null;
	private boolean isNegative = false;
	
	public Prezzo(Sterline sterline, Scellini scellini, Pence pence) throws NegativeValueException {
		this.sterline = sterline == null ? new Sterline(0) : sterline;
		this.scellini = scellini == null ? new Scellini(0) :  scellini;
		this.pence = pence == null ? new Pence(0) :  pence;
	}
	
	public Prezzo(String prezzo) throws WrongAmountException, PriceFormatException, NegativeValueException{
	     Pattern p = Pattern.compile(PRICE_PATTERN);
		 Matcher m = p.matcher(prezzo);
	      if (m.find()) {
	    	  this.sterline = new Sterline(Integer.valueOf(m.group(2)));
	    	  this.scellini = new Scellini(Integer.valueOf(m.group(3)));
	    	  this.pence = new Pence(Integer.valueOf(m.group(4)));
	    	  
	    	  if(this.scellini.getAmount()>SCELLINI_TO_STERLINE_SCALE || this.pence.getAmount()>PENCE_TO_SCELLINI_SCALE) {
	    		  throw new WrongAmountException();
	    	  }
	      }else {
	         throw new PriceFormatException();
	      }
	}
	
	private Prezzo(Sterline sterline, Scellini scellini, Pence pence, boolean isNegative)  throws NegativeValueException{
		this(sterline, scellini, pence);
		this.isNegative = isNegative;
	}
	
	public Prezzo add(Prezzo p2) throws NegativeValueException {
		return getPrezzo(p2.getPence().getAmount()+getPence().getAmount());
	}
	
	public Prezzo subtract(Prezzo p2) throws NegativeValueException {
		return getPrezzo(getPence().getAmount() - p2.getPence().getAmount());
	}
	
	public Prezzo multiplicate(Integer m) throws NegativeValueException {
		return getPrezzo(getPence().getAmount() * m);
	}

	public Prezzo divide(Integer d) throws NegativeValueException {
		Prezzo resto = getPrezzo(getPence().getAmount()%d);
		Prezzo quoziente = getPrezzo(new BigDecimal(getPence().getAmount() / d).setScale(0,RoundingMode.FLOOR).intValue());
		quoziente.setResto(resto);
		return quoziente;
	}

	public Prezzo getResto()  throws NegativeValueException{
		return this.resto!=null ? this.resto : new Prezzo(null, null, null);
	}

	private void setResto(Prezzo resto) {
		this.resto = resto;
	}
	
	public String toString() {
		String resto = this.resto == null || this.resto.toString().equalsIgnoreCase("0p 0s 0d") ? "" : " ("+this.resto+")"; 
		String minus = this.isNegative ? "-" : "";
		return minus + this.sterline.getAmount()+"p " + this.scellini.getAmount() + "s " + this.pence.getAmount() + "d"+ resto;
	}

	
	
	private Prezzo getPrezzo(Integer totalPence) throws NegativeValueException {
		int pence = totalPence%sterline.getPenceScale()%scellini.getPenceScale();
		BigDecimal scellini = new BigDecimal((totalPence%this.sterline.getPenceScale()) / this.scellini.getPenceScale()).setScale(0,RoundingMode.FLOOR);
		BigDecimal sterline = new BigDecimal(totalPence/this.sterline.getPenceScale()).setScale(0,RoundingMode.FLOOR);
		
		return new Prezzo(
					new Sterline(Math.abs(sterline.intValue())),
					new Scellini(Math.abs(scellini.intValue())),
					new Pence(Math.abs(pence)),
					totalPence<0
				);			
	}
	
	private Pence getPence() throws NegativeValueException {
		return new Pence(
					sterline.getPence()+
					scellini.getPence()+
					pence.getPence()
				);
	}	
}
