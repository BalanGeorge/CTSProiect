package Clase;

import Exceptii.NumarRegistrulComertuluiGresitException;

public interface IVerificariClient {
	public boolean cuiCorect(String cui);
	public boolean nrRcCorect(String nrrc);
	public boolean ibanCorect(String iban);
}
