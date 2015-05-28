package Clase;

public class RandFactura {
	private Produs produs;
	private double cantitate;
	private double valoare;
	private double valoareTVA;
	
	public RandFactura(Produs produs, double cantitate) {
		super();
		this.produs = produs;
		this.cantitate = cantitate;
		this.valoare = produs.getPret()*this.cantitate;
		this.valoareTVA = this.valoare*(24/100);
	}
	
	public RandFactura(){}
	public Produs getProdus() {
		return produs;
	}

	public void setProdus(Produs produs) {
		this.produs = produs;
	}

	public double getCantitate() {
		return cantitate;
	}

	public void setCantitate(double cantitate) {
		this.cantitate = cantitate;
	}

	public double getValoare() {
		return valoare;
	}

	public void setValoare(float valoare) {
		this.valoare = valoare;
	}

	public double getValoareTVA() {
		return valoareTVA;
	}

	public void setValoareTVA(float valoareTVA) {
		this.valoareTVA = valoareTVA;
	}
	
	public void CalculeazaValoare(){
		this.valoare = produs.getPret()*this.cantitate;
		this.valoareTVA = this.valoare*(24/100);
	}
	
	@Override
	public String toString() {
		return "\n " + produs.toString() + ", cantitate: " + cantitate
				+ ", valoare=" + valoare + ", valoareTVA " + valoareTVA ;
	}
	
	
	
}
