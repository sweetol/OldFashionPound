package oldfashionpound;

public abstract class AbstractPenceConverter{
	final Integer getPence() {
		return getAmount()*getPenceScale();
	}
	
	abstract Integer getAmount();
	abstract Integer getPenceScale();
}
