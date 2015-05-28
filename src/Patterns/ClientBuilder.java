package Patterns;

import Clase.Client;
import Exceptii.CuiIncorectException;
import Exceptii.IbanIncorectException;
import Exceptii.NumarRegistrulComertuluiGresitException;

public class ClientBuilder implements IBuilder {
	
	private Client client = null;
	
	public ClientBuilder(){
		this.client = new Client();
	}
	
	public ClientBuilder Cod(int cod){
		this.client.setCodClient(cod);
		return this;
	}
	
	public ClientBuilder Denumire(String denumire){
		this.client.setDenumire(denumire);
		return this;
	}
	
	public ClientBuilder Cui(String cui) throws CuiIncorectException{
		if(client.cuiCorect(cui))
			this.client.setCUI(cui);
		else throw new CuiIncorectException();
		return this;
	}
	
	public ClientBuilder NrRegistrulComertului(String rc) throws NumarRegistrulComertuluiGresitException{
		if(client.nrRcCorect(rc))
			this.client.setNrRC(rc);
		else
			throw new NumarRegistrulComertuluiGresitException();
		return this;
	}
	
	public ClientBuilder Adresa(String ads){
		this.client.setAdresa(ads);
		return this;
	}
	public ClientBuilder Iban(String iban) throws IbanIncorectException{
		if(client.ibanCorect(iban))
			this.client.setIban(iban);
		else
			throw new IbanIncorectException();
		return this;
	}
	
	public ClientBuilder Banca(String banca){
		this.client.setBanca(banca);
		return this;
	}
	public Client build() {
		return this.client;
	}

}
