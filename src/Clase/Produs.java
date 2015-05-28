package Clase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Produs {
	private int codProdus;
	private String denumire;
	private String um;
	private double pret;
	private double stoc;
	
	public Produs(int codProdus, String denumire, String um, float pret,
			float cantitateDisponibila) {
		super();
		this.codProdus = codProdus;
		this.denumire = denumire;
		this.um = um;
		this.pret = pret;
		this.stoc = cantitateDisponibila;
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
	@Override
	public String toString() {
		return "codProdus " + codProdus + ", " + denumire
				+ ", " + um + ", pret " + pret ;
	}
}
