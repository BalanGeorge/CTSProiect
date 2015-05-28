package Patterns;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Clase.Client;
import Clase.Factura;
import Clase.Produs;

public class Depozit {
	private ArrayList<Produs> listaProduse;
	private ArrayList<Client> listaClienti;
	private static Depozit instance = new Depozit();
	
	private Depozit(){
		try {
			this.listaProduse = citireListaProduse();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			this.listaClienti = citireListaClienti();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Depozit getInstance(){
		return instance;
	}
	
	private ArrayList<Produs> citireListaProduse() throws IOException{
		 ArrayList<Produs>produse = new ArrayList<Produs>();
		 try {
			FileReader fr = new FileReader("ListaProduse.txt");
			BufferedReader in = new BufferedReader(fr);
			String str;
			while((str = in.readLine())!=null){
				String cuvinte[]= str.split(",");
				Produs p = new Produs();
				p.setCodProdus(Integer.parseInt(cuvinte[0]));
				p.setDenumire(cuvinte[1]);
				p.setUm(cuvinte[2]);
				p.setPret(Double.parseDouble(cuvinte[3]));
				p.setStoc(Double.parseDouble(cuvinte[4]));
				produse.add(p);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
		return produse;
	}
	
	private ArrayList<Client> citireListaClienti() throws IOException{
		 ArrayList<Client>clienti = new ArrayList<Client>();
		 try {
			FileReader fr = new FileReader("ListaClienti.txt");
			BufferedReader in = new BufferedReader(fr);
			String str;
			while((str = in.readLine())!=null){
				String c[]= str.split(",");
				Client p = new Client();
				p.setCodClient(Integer.parseInt(c[0]));
				p.setDenumire(c[1]);
				p.setCUI(c[2]);
				p.setNrRC(c[3]);
				p.setAdresa(c[4]);
				p.setIban(c[5]);
				p.setBanca(c[6]);
				clienti.add(p);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
		return clienti;
	}

	public ArrayList<Produs> getListaProduse() {
		return listaProduse;
	}

	public void setListaProduse(ArrayList<Produs> listaProduse) {
		this.listaProduse = listaProduse;
	}

	public ArrayList<Client> getListaClienti() {
		return listaClienti;
	}

	public void setListaClienti(ArrayList<Client> listaClienti) {
		this.listaClienti = listaClienti;
	}
	
	
}
