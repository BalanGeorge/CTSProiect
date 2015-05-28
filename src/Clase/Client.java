package Clase;

import Exceptii.NumarRegistrulComertuluiGresitException;

public class Client implements IVerificariClient {
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
	
	public Client() {	}


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


	public boolean cuiCorect(String cui) {
		boolean corect = false;
		if(cui.length()!=6){
			corect = false;
		}
		else
			for(int i = 0; i<6;i++)
				if(Character.isDigit(cui.charAt(i)))
					corect = true;
				else
					corect = false;
		return corect;
	}

	public boolean nrRcCorect(String nrrc){
		boolean corect = false;
		if(nrrc.length()!=13){
			corect = false;
		}else {
			StringBuilder sb = new StringBuilder();
			sb.append(nrrc.charAt(1));
			sb.append(nrrc.charAt(2));
			int codJ = Integer.parseInt(sb.toString());
			char slash = '/';
			for(int i = 4; i<8;i++)
				if(Character.isDigit(nrrc.charAt(i)))
					if(nrrc.startsWith("J")
							&&codJ<=48
							&&codJ>=0
							&& nrrc.charAt(3)==slash
							&&nrrc.charAt(8)==slash)
						for(int j = 9; j<13;j++)
							if(Character.isDigit(nrrc.charAt(j)))
								corect = true;
							else
								corect = false;
					else
						corect = false;
				else
					corect = false;
		}
		
		return corect;
	}

	public boolean ibanCorect(String iban) {
		boolean corect = false;
		if(iban.length()!=24){
			corect = false;
		}else {
			if(iban.charAt(0)=='R' && iban.charAt(1)=='O' && Character.isDigit(iban.charAt(2))
					&& Character.isDigit(iban.charAt(3)) && Character.isLetter(iban.charAt(4))
					&& Character.isLetter(iban.charAt(5))
					&& Character.isLetter(iban.charAt(6))
					&& Character.isLetter(iban.charAt(7)))
				for(int i = 8; i<24;i++)
					if(Character.isDigit(iban.charAt(i)))
						corect = true;
					else
						corect = false;
			else
				corect = false;
		}
		return false;
	}
	
	
}
