package Clase;

public class Client {
	int codClient;
	String denumire;
	String CUI;
	String nrRC;
	String adresa;
	String iban;
	String banca;
	
	
	
	public Client(int codClient, String denumire, String cUI, String nrRC,
			String adresa, String iban, String banca) {
		super();
		this.codClient = codClient;
		this.denumire = denumire;
		CUI = cUI;
		this.nrRC = nrRC;
		this.adresa = adresa;
		this.iban = iban;
		this.banca = banca;
	}
	
	public Client() {
		// TODO Auto-generated constructor stub
	}


	public int getCodClient() {
		return codClient;
	}
	public void setCodClient(int codClient) {
		this.codClient = codClient;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public String getCUI() {
		return CUI;
	}
	public void setCUI(String cUI) {
		CUI = cUI;
	}
	public String getNrRC() {
		return nrRC;
	}
	public void setNrRC(String nrRC) {
		this.nrRC = nrRC;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getBanca() {
		return banca;
	}
	public void setBanca(String banca) {
		this.banca = banca;
	}

	@Override
	public String toString() {
		return "Client codClient " + codClient + ", denumire=" + denumire
				+ ", CUI " + CUI + ", nrRC " + nrRC + ", adresa " + adresa
				+ ", iban " + iban + ", banca " + banca+"/n";
	}
	
	
}
