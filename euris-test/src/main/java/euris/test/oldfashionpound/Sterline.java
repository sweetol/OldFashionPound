package euris.test.oldfashionpound;

import euris.test.oldfashionpound.exceptions.*;

public class Sterline  extends AbstractPenceConverter{
	private Integer sterline;
	
	public Sterline (Integer sterline) throws NegativeValueException{
		if(sterline<0) {
			throw new NegativeValueException();
		}
		this.sterline = sterline;
	}
	
	public Integer getAmount() {
		return this.sterline;
	}
	
	public Integer getPenceScale() {
		return 240;
	}
	
}