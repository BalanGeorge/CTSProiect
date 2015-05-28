package Exceptii;

public class NumarDeParametriException extends Exception {
	public NumarDeParametriException(){
		super("Numarul de coduri de produs introduse nu este acelasi cu numarul de cantitati introduse");
	}
}

