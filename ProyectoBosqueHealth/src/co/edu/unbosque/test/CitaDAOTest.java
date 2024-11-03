package co.edu.unbosque.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CitaDAOTest {

static int numeroPrueba = 1;
	
	
	@BeforeClass //solo una vez
	public static void antesDeTodo () {
		System.out.println("Iniciando las pruebas de las clases del main test");
	}
	
	@Before
	public void antesDeCadaPrueba() {
		System.out.println("Iniciando la prueba "+numeroPrueba);
		
	}
	
	@Test 
	public void verificar() {
		
	}
	

	@After
	public void despuesDeCadaPueba() {
		System.out.println("Finalizando la prueba "+numeroPrueba);
		numeroPrueba++;
	}
	
	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Fianlizando las preubas de las clases main");
	}
}
