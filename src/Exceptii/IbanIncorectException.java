package Exceptii;

public class IbanIncorectException extends Exception{
	public IbanIncorectException(){
		super("Ibanul introdus nu are un format Valid");
	}
}
