package Teste;

import junit.framework.TestCase;

import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import Clase.Produs;

public class TesteMock extends TestCase {
	
	Produs p;
	@Before
	protected void setUp() throws Exception {
		p = mock(Produs.class);
		when(p.getCodProdus()).thenAnswer(new Answer<Integer>() {

			public Integer answer(InvocationOnMock invocation) throws Throwable {
				return 555;
			}
		});
		
		when(p.getDenumire()).then(new Answer<String>(){
			public String answer(InvocationOnMock i ) throws Throwable{
				return "Faianta";
			}
		});
		
		when(p.getUm()).then(new Answer<String>(){
			public String answer(InvocationOnMock i ) throws Throwable{
				return "mp";
			}
		});
		when(p.getPret()).then(new Answer<Double>(){
			public Double answer(InvocationOnMock i ) throws Throwable{
				return 200.4;
			}
		});
		
		when(p.getStoc()).then(new Answer<Double>(){
			public Double answer(InvocationOnMock i ) throws Throwable{
				return 200.5;
			}
		});
	}
	
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testCod(){
		assertEquals("getCod", 555,p.getCodProdus());
	}
	
	@Test
	public void testDenumire(){
		assertEquals("getDenumire", "Faianta",p.getDenumire());
	}
	
	@Test
	public void testUm(){
		assertEquals("getUm", "mp",p.getUm());
	}
	
	@Test
	public void testPret(){
		assertEquals("getPret", 200.4 ,p.getPret());
	}
	
	@Test
	public void testStoc(){
		assertEquals("getStoc", 200.5 ,p.getStoc());
	}
}
