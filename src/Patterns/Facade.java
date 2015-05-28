package Patterns;

import java.util.ArrayList;
import java.util.Date;

import Clase.Client;
import Clase.Factura;
import Exceptii.CantitateException;
import Exceptii.ClientInexistentException;
import Exceptii.NumarDeParametriException;
import Exceptii.ProdusInexistentException;

public class Facade {
	public Factura intocmesteFactura(int numarFactura, int codClient,
			int[]coduriProduse,double[]cantitati)throws CantitateException,NumarDeParametriException,ClientInexistentException, ProdusInexistentException{
		
		Depozit d = Depozit.getInstance();
		ArrayList<Client>clienti = d.getListaClienti();
		Factura f = new Factura(numarFactura);
		for(int i = 0; i<cantitati.length;i++)
			if(cantitati[i]<=0)
				throw new CantitateException();
		
		if(coduriProduse.length!=cantitati.length)
			throw new NumarDeParametriException();
		else{
			Client c = null;
			for(int k = 0; k<clienti.size();k++){
				if(clienti.get(k).getCodClient() == codClient){
					c = clienti.get(k);
				}
			}
			if(c!=null)
				f.setClient(c);
			else
				throw new ClientInexistentException();
			
			for(int j = 0; j<coduriProduse.length;j++)
				if(f.verificaExistentaProdus(coduriProduse[j]))
					f.addProduse(coduriProduse[j], cantitati[j]);
				else
					throw new ProdusInexistentException();
			}
			f.setData(new Date());
			f.calculeazaTotal();
			return f;
	}
}
