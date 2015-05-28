package Exceptii;

public class CantitateException extends Exception {
	public CantitateException(){
		super("Nu este permisa introducerea de cantitati negative sau egale cu 0");
	}
}
