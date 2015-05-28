package Teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Clase.Client;
import Clase.Factura;
import Clase.Produs;
import Exceptii.CantitateException;
import Exceptii.ClientInexistentException;
import Exceptii.CuiIncorectException;
import Exceptii.IbanIncorectException;
import Exceptii.NumarDeParametriException;
import Exceptii.NumarRegistrulComertuluiGresitException;
import Exceptii.ProdusInexistentException;
import Patterns.ClientBuilder;
import Patterns.Depozit;
import Patterns.Facade;

public class TestePaternuri {
	
	Client c;
	
	public TestePaternuri() {
	}

	@Before
	public final void setUp()
	{
		System.out.println("\nsetUp unit test");
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Test efectuat cu succes");
	}
	
	@Test
	public void testBuilderCORECT() throws NumarRegistrulComertuluiGresitException, IbanIncorectException {
		try {
			c = new ClientBuilder().Cod(123).Adresa("Bucuresti 12").Banca("BCR")
					.Cui("852456").Denumire("Delta").Iban("RO23RNCB1231234545877891")
					.NrRegistrulComertului("J39/4568/2001")
					.build();
			System.out.println(c.toString());
			assertNotNull(c);
		} catch (CuiIncorectException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void testBuilderFAIL1() throws NumarRegistrulComertuluiGresitException, IbanIncorectException {
		try {
			c = new ClientBuilder().Cod(123).Adresa("Bucuresti 12").Banca("BCR")
					.Cui("8L4456").Denumire("Delta").Iban("RO23RNCB1231234545877891")
					.NrRegistrulComertului("J39/4568/2001")
					.build();
			assertNotNull(c);
		} catch (CuiIncorectException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void testBuilderFAIL2() throws NumarRegistrulComertuluiGresitException, IbanIncorectException {
		try {
			c = new ClientBuilder().Cod(123).Adresa("Bucuresti 12").Banca("BCR")
					.Cui("8656").Denumire("Delta").Iban("RO23RNCB1231234545877891")
					.NrRegistrulComertului("J39/4568/2001")
					.build();
			assertNotNull(c);
		} catch (CuiIncorectException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void testBuilderFAIL3() {
		try {
			c = new ClientBuilder().Cod(123).Adresa("Bucuresti 12").Banca("BCR")
					.Cui("862256").Denumire("Delta").Iban("RO23RNCB12312345L5877891")
					.NrRegistrulComertului("J39/4568/2001")
					.build();
			assertNotNull("Iban cu litera",c);
		} catch (CuiIncorectException e) {
			System.out.println(e.getMessage());
		} catch (NumarRegistrulComertuluiGresitException e) {
			System.out.println(e.getMessage());
		} catch (IbanIncorectException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void testBuilderFAIL4() {
		try {
			c = new ClientBuilder().Cod(123).Adresa("Bucuresti 12").Banca("BCR")
					.Cui("862256").Denumire("Delta").Iban("ROC3RNCB1231234555877891")
					.NrRegistrulComertului("J39/4568/2001")
					.build();
			assertNotNull("Iban cu litera dupa RO",c);
		} catch (CuiIncorectException e) {
			System.out.println(e.getMessage());
		} catch (NumarRegistrulComertuluiGresitException e) {
			System.out.println(e.getMessage());
		} catch (IbanIncorectException e) {
			System.out.println(e.getMessage());
		}
		
	}
	@Test
	public void testBuilderFAIL5() {
		try {
			c = new ClientBuilder().Cod(123).Adresa("Bucuresti 12").Banca("BCR")
					.Cui("862256").Denumire("Delta").Iban("7OC3RNCB1231234555877891")
					.NrRegistrulComertului("J39/4568/2001")
					.build();
			assertNotNull("Iban fara R",c);
		} catch (CuiIncorectException e) {
			System.out.println(e.getMessage());
		} catch (NumarRegistrulComertuluiGresitException e) {
			System.out.println(e.getMessage());
		} catch (IbanIncorectException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void testBuilderFAIL6() {
		try {
			c = new ClientBuilder().Cod(123).Adresa("Bucuresti 12").Banca("BCR")
					.Cui("862256").Denumire("Delta").Iban("RO23RNCB123123455877891")
					.NrRegistrulComertului("J39/4568/2001")
					.build();
			assertNotNull("Iban scurt",c);
		} catch (CuiIncorectException e) {
			System.out.println(e.getMessage());
		} catch (NumarRegistrulComertuluiGresitException e) {
			System.out.println(e.getMessage());
		} catch (IbanIncorectException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void testBuilderFAIL7() {
		try {
			c = new ClientBuilder().Cod(123).Adresa("Bucuresti 12").Banca("BCR")
					.Cui("862256").Denumire("Delta").Iban("RO23RNCB1231234545877891")
					.NrRegistrulComertului("J70/4568/2001")
					.build();
			assertNotNull("Numar de inregistrare RC cod judet invalid",c);
		} catch (CuiIncorectException e) {
			System.out.println(e.getMessage());
		} catch (NumarRegistrulComertuluiGresitException e) {
			System.out.println(e.getMessage());
		} catch (IbanIncorectException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testBuilderFAIL8() {
		try {
			c = new ClientBuilder().Cod(123).Adresa("Bucuresti 12").Banca("BCR")
					.Cui("862256").Denumire("Delta").Iban("RO23RNCB1231234545877891")
					.NrRegistrulComertului("J20.4568/2001")
					.build();
			assertNotNull("Numar de inregistrare RC separator gresit",c);
		} catch (CuiIncorectException e) {
			System.out.println(e.getMessage());
		} catch (NumarRegistrulComertuluiGresitException e) {
			System.out.println(e.getMessage());
		} catch (IbanIncorectException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testBuilderFAIL9() {
		try {
			c = new ClientBuilder().Cod(123).Adresa("Bucuresti 12").Banca("BCR")
					.Cui("862256").Denumire("Delta").Iban("RO23RNCB1231234545877891")
					.NrRegistrulComertului("J20/45B8/2001")
					.build();
			assertNotNull("Numar de inregistrare RC separator gresit",c);
		} catch (CuiIncorectException e) {
			System.out.println(e.getMessage());
		} catch (NumarRegistrulComertuluiGresitException e) {
			System.out.println(e.getMessage());
		} catch (IbanIncorectException e) {
			System.out.println(e.getMessage());
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
		Factura fa = f.intocmesteFactura(100, 222, coduri, cantitati);
		assertNotNull(f);
		System.out.println("Clientul de pe factura este: "+fa.getClient().toString()+ "Totalul facturii este: "+fa.getTotal());
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

