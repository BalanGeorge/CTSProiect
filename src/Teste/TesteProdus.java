package Teste;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Clase.Produs;
import Patterns.Depozit;

public class TesteProdus {
	Produs p = new Produs(444,"Gresie","mp",25,400);
	public final void setUp()
	{
		System.out.println("setUp unit test");
	}
	@Test
	public void testScriereProdusFisier() {
		Depozit d = Depozit.getInstance();
		ArrayList<Produs>produse = d.getListaProduse();
		//p.scrieFisier("ListaProduse.txt", p);
		d = Depozit.getInstance();
		ArrayList<Produs>produse2 = d.getListaProduse();
		assertTrue(produse.size()==produse2.size());
	}

}
