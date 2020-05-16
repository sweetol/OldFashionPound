package euris.test.oldfashionpound;

import euris.test.oldfashionpound.exceptions.*;

public class Scellini extends AbstractPenceConverter{
	private Integer scellini;
	
	public Scellini (Integer scellini) throws NegativeValueException{
		if(scellini<0) {
			throw new NegativeValueException();
		}
		this.scellini = scellini;
	}
	
	public Integer getAmount() {
		return this.scellini;
	}
	
	public Integer getPenceScale() {
		return 12;
	}
	
}
