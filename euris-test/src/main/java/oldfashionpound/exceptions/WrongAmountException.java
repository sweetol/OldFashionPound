package oldfashionpound.exceptions;

public class WrongAmountException extends Exception{

	public WrongAmountException(){
		super("Wrong amount in Scelini or Pence field");
	}
	
}
