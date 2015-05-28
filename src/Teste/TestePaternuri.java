package Teste;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Clase.Client;
import Clase.Factura;
import Clase.Produs;
import Exceptii.CantitateException;
import Exceptii.ClientInexistentException;
import Exceptii.CuiIncorectException;
import Exceptii.NumarDeParametriException;
import Exceptii.ProdusInexistentException;
import Patterns.ClientBuilder;
import Patterns.Depozit;
import Patterns.Facade;

public class TestePaternuri {

	@Test
	public void testBuilder() {
		Client c;
		try {
			c = new ClientBuilder().Cod(123).Adresa("Bucuresti 12").Banca("BCR")
					.Cui("852456").Denumire("Delta").Iban("RO23RNCB1231234545877891")
					.NrRegistrulComertului("J39/4568/2001")
					.build();
			assertNotNull(c);
		} catch (CuiIncorectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testFacade_CORECT() throws CantitateException, NumarDeParametriException, ClientInexistentException, ProdusInexistentException{
		Facade f = new Facade();
		int coduri[] = new int[2];
		coduri[0]= 111;
		coduri[1] = 222;
		double cantitati[] = new double[2];
		cantitati[0]= 2;
		cantitati[1]= 1;
		f.intocmesteFactura(100, 222, coduri, cantitati);
		assertNotNull(f);
	}
	
	@Test
	public void testFacade_FAIL1(){
		Facade f = new Facade();
		int coduri[] = new int[2];
		coduri[0]= 111;
		coduri[1] = 222;
		double cantitati[] = new double[2];
		cantitati[0]= 2;
		cantitati[1]= 1;
		try {
			f.intocmesteFactura(100, 555, coduri, cantitati);
			fail("client inexistent");
		} catch (CantitateException e) {
			System.out.println(e.getMessage());
		} catch (NumarDeParametriException e) {
			System.out.println(e.getMessage());
		} catch (ClientInexistentException e) {
			System.out.println(e.getMessage());
		} catch (ProdusInexistentException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testFacade_FAIL2(){
		Facade f = new Facade();
		int coduri[] = new int[2];
		coduri[0]= 111;
		coduri[1] = 222;
		double cantitati[] = new double[2];
		cantitati[0]= -2;
		cantitati[1]= 1;
		try {
			f.intocmesteFactura(100, 111, coduri, cantitati);
			fail("trebuie sa avem cantitati > 0");
		} catch (CantitateException e) {
			System.out.println(e.getMessage());
		} catch (NumarDeParametriException e) {
			System.out.println(e.getMessage());
		} catch (ClientInexistentException e) {
			System.out.println(e.getMessage());
		} catch (ProdusInexistentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testFacade_FAIL3(){
		Facade f = new Facade();
		int coduri[] = new int[2];
		coduri[0]= 111;
		coduri[1] = 756;
		double cantitati[] = new double[2];
		cantitati[0]= 2;
		cantitati[1]= 1;
		try {
			f.intocmesteFactura(100, 222, coduri, cantitati);
			fail("produs inexistent");
		} catch (CantitateException e) {
			System.out.println(e.getMessage());
		} catch (NumarDeParametriException e) {
			System.out.println(e.getMessage());
		} catch (ClientInexistentException e) {
			System.out.println(e.getMessage());
		} catch (ProdusInexistentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testFacade_FAIL4(){
		Facade f = new Facade();
		int coduri[] = new int[2];
		coduri[0]= 111;
		coduri[1] = 222;
		double cantitati[] = new double[3];
		cantitati[0]= 2;
		cantitati[1]= 1;
		cantitati[2]= 1;
		try {
			f.intocmesteFactura(100, 222, coduri, cantitati);
			fail("numar de parametri gresit");
		} catch (CantitateException e) {
			System.out.println(e.getMessage());
		} catch (NumarDeParametriException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		} catch (ClientInexistentException e) {
			System.out.println(e.getMessage());
		} catch (ProdusInexistentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testCitireFisierListaProduse(){
		Depozit d = Depozit.getInstance();
		ArrayList<Produs>produse = d.getListaProduse();
		assertNotNull(produse);
	}
	
	@Test
	public void testCitireFisierListaClienti(){
		Depozit d = Depozit.getInstance();
		ArrayList<Client>clienti = d.getListaClienti();
		assertNotNull(clienti);
	}
}

