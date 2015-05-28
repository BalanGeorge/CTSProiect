package Clase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.print.DocFlavor.STRING;

import Patterns.Depozit;

public class Factura {
	private int numarFactura;
	private Date data;
	private Client client;
	private ArrayList<RandFactura>produse;
	private double total;
	
	public Factura(int numarFactura, Client client) {
		super();
		this.numarFactura = numarFactura;
		this.client = client;
		this.produse = new ArrayList<RandFactura>();
		this.data = new Date(); ////////////
		this.total = 0;
	}
	public Factura(int numarFactura){
		this.numarFactura = numarFactura;
		this.data = new Date();
	}
	
	public Date getData() {
		return data;
	}
	
	public int getNumarFactura() {
		return numarFactura;
	}

	public void setNumarFactura(int numarFactura) {
		this.numarFactura = numarFactura;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ArrayList<RandFactura> getProduse() {
		return produse;
	}

	public void setProduse(ArrayList<RandFactura> produse) {
		this.produse = produse;
	}
	
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void addProduse(int codProdus,double cantitate){
		Depozit d = Depozit.getInstance();
		ArrayList<Produs>prod = d.getListaProduse();
		ArrayList<RandFactura>lrf = new ArrayList<RandFactura>();
		for(int i = 0;i<prod.size();i++){
			
			if(prod.get(i).getCodProdus() == codProdus){
				RandFactura rf = null;
				rf = new RandFactura(prod.get(i), cantitate);
				lrf.add(rf); 
			}
			else
				continue;
		}
		for(int j = 0;j<lrf.size();j++){
			this.setProduse(lrf);
		}
		
	}
	
	public void addProdus(int codProdus,double cantitate){
		Depozit d = Depozit.getInstance();
		ArrayList<Produs>prod = d.getListaProduse();
		ArrayList<RandFactura>lrf = new ArrayList<RandFactura>();
		RandFactura rf = null;
		for(int i = 0;i<prod.size();i++)
			if(prod.get(i).getCodProdus() == codProdus){
				rf = new RandFactura(prod.get(i), cantitate);
			}
				
		this.produse.add(rf);
	}
	
	public boolean verificaExistentaProdus(int cod){
		Depozit d = Depozit.getInstance();
		ArrayList<Produs>prod = d.getListaProduse();
		Produs pr = null;
		for(Produs p : prod)
			if(p.getCodProdus() == cod)
				pr=p;
		if(pr!=null)
			return true;
		else
			return false;
	}
	
	
	public void removeProdus(int codProdus){
		for(int i=0;i<produse.size();i++){
			if(produse.get(i).getProdus().getCodProdus() == codProdus)
				produse.remove(produse.get(i));
			
		}
	}
	
	public boolean modificareCantitate(int codProdus, double cantitatNoua){
		boolean gasit = false;
		for(RandFactura p : produse){
			if(p.getProdus().getCodProdus() == codProdus){
				p.setCantitate(cantitatNoua);
				gasit = true;
			}
		}
		if(gasit == false)
			System.out.println("Nu exista produs cu acest id: "+codProdus +" pe factura");
		return gasit;
	}
	
	public void calculeazaTotal(){
		double valoareTotala = 0;
		for(RandFactura r : produse){
			valoareTotala= valoareTotala + r.getValoare()+r.getValoareTVA();
		}
		this.setTotal(valoareTotala);
	}
	
	public void aplicaReducere(double procent){
		double reducere = 0;
		reducere = this.total * procent;
		double total = this.getTotal() - reducere;
		this.setTotal(total);
	}
	
	public RandFactura findProdus(int cod){
		RandFactura p = null;
		for(RandFactura r : produse)
			if(r.getProdus().getCodProdus() == cod)
				p = r;
		return p;
	}
	
	String afisareRF(){
		StringBuilder st = null;
		for(RandFactura rf : produse)
			st.append(rf.toString());
		String afisare = st.toString();
		return afisare;
			
	}
	@Override
	public String toString() {
		return "Factura " + numarFactura + ", " + data
				 + client.toString() + ", produse: " + afisareRF() + "\n total="
				+ total + "]";
	}
	
	
}
