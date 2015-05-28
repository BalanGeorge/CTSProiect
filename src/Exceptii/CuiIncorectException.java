package Exceptii;

public class CuiIncorectException extends Exception {
	public CuiIncorectException(){
		super("Codul unic de inregistrare introdus nu este valid!!!");
	}
}
