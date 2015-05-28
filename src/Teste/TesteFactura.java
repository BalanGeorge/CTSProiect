package Teste;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import Clase.Client;
import Clase.Factura;
import Clase.Produs;
import Clase.RandFactura;
import Patterns.Depozit;

public class TesteFactura {
	
	Client c = new Client(44,"Alfa SA","456789","J39/45/2000","Florilor","RO65RNCB456789789","BCR");
	Factura f= new Factura(10,c);
	public final void setUp()
	{
		System.out.println("setUp unit test");
	}

	@Test
	public void testAddProdus() {
		f.addProdus(111,50.0);
		f.addProdus(222,50.0);
		assertEquals(2, f.getProduse().size());
	}
	
	@Test
	public void testRemoveProdus() {
		f.addProdus(111,50.0);
		f.addProdus(222,50.0);
		f.addProdus(333,50.0);
		f.removeProdus(333);
		assertEquals(2, f.getProduse().size());
	}
	
	@Test
	public void testModificareCantitateSUCCES() {
		f.addProdus(111,50.0);
		f.addProdus(222,50.0);		
		f.modificareCantitate(222,3);
		assertEquals(3, f.findProdus(222).getCantitate(),0.001);
	}
	
	@Test
	public void testModificareCantitateIdInexistent() {
		f.addProduse(111,50.0);
		f.addProduse(222,50.0);		
		assertFalse(f.modificareCantitate(20, 50));
	}
	
	@Test
	public void testCalculeazaTotal() {
		Client c = new Client(44,"Alfa SA","456789","J39/45/2000","Florilor","RO65RNCB456789789","BCR");
		Factura f= new Factura(10,c);
		f.addProdus(111,2);
		f.addProdus(222,2);
		f.calculeazaTotal();
		assertEquals(170, f.getTotal(),0.001);
	}
	
	@Test
	public void testAplicaReducere() {
		f.addProdus(111,2);
		f.addProdus(222,2);
		f.calculeazaTotal();
		f.aplicaReducere(0.1);
		assertEquals(153, f.getTotal(),0.001);
	}
	
	@Test
	public void testFindProdusNotNull(){
		f.addProduse(111,50.0);
		f.addProduse(222,50.0);
		RandFactura produsCautat = f.findProdus(222);
		
		assertNotNull(produsCautat);
	}
	
	@Test
	public void testFindProdusNull(){
		f.addProduse(111,50.0);
		f.addProduse(222,50.0);
		RandFactura produsCautat = f.findProdus(20);
		assertNull(produsCautat);
	}
}
