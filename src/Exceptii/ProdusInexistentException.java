package Exceptii;

public class ProdusInexistentException extends Exception {
	public ProdusInexistentException(){
		super("Ati introdus un Cod pprodus inexistent!");
	}
}
