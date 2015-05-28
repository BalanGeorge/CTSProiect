package Exceptii;

public class ClientInexistentException extends Exception {
	public ClientInexistentException(){
		super("clientul nu exista!!!");
	}
}
