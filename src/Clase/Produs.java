package Clase;

import Exceptii.CantitateException;

public class Produs {
	private int codProdus;
	private String denumire;
	private String um;
	private double pret;
	private double stoc;
	
	public Produs(int codProdus, String denumire, String um, double pret,
			double cantitateDisponibila) throws CantitateException {
		super();
		this.codProdus = codProdus;
		this.denumire = denumire;
		this.um = um;
		this.pret = pret;
		if(Produs.checkStoc(cantitateDisponibila))
			this.stoc = cantitateDisponibila;
		else
			throw new CantitateException();
	}
	public Produs(){};
	public int getCodProdus() {
		return codProdus;
	}

	public void setCodProdus(int codProdus) {
		this.codProdus = codProdus;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public String getUm() {
		return um;
	}

	public void setUm(String um) {
		this.um = um;
	}

	public double getPret() {
		return pret;
	}

	public void setPret(double pret) {
		this.pret = pret;
	}

	public double getStoc() {
		return stoc;
	}

	public void setStoc(double cantitateDisponibila) {
		this.stoc = cantitateDisponibila;
	}
	
	public static boolean checkStoc(double stoc){
		boolean ok = false;
		if(stoc<=0)
			ok = false;
		else
			ok = true;
		return ok;
	}

	@Override
	public String toString() {
		return "codProdus " + codProdus + ", " + denumire
				+ ", " + um + ", pret " + pret ;
	}
}
