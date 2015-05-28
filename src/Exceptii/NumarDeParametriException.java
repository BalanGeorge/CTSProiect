package Exceptii;

public class NumarDeParametriException extends Exception {
	public NumarDeParametriException(){
		super("Numarul de coduri de produs introduse nu este acelasi cu numarul de cantitati introduse");
	}
}

/*
public void testNegativeValuesDeposit(){
	try{
	account.deposit(-200.0);
	assertFalse("Metoda nu arunca exceptie pe valori negative", true);
	}
	catch(AccountException ex){
		assertTrue(true);
	}
}
*/