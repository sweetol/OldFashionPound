package euris.test.oldfashionpound;

import euris.test.oldfashionpound.exceptions.*;

public class Pence extends AbstractPenceConverter{
	private Integer pence;
	
	public Pence (Integer pence) throws NegativeValueException{
		if(pence<0) {
			throw new NegativeValueException();
		}
		this.pence = pence;
	}
	
	public Integer getAmount() {
		return this.pence;
	}
	
	public Integer getPenceScale() {
		return 1;
	}
	
}
