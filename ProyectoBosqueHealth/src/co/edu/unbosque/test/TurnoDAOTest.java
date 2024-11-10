package co.edu.unbosque.test;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import co.edu.unbosque.model.Especialista;
import co.edu.unbosque.model.Paciente;
import co.edu.unbosque.model.TratamientoMedicoDTO;
import co.edu.unbosque.model.TurnoDTO;
import co.edu.unbosque.model.persistence.DataMapper;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.model.persistence.TratamientoMedicoDAO;
import co.edu.unbosque.model.persistence.TurnoDAO;

public class TurnoDAOTest {

	static int numeroPrueba = 1;
	static String text = "";
	static boolean verifiedOut = false;
	static TurnoDAO trDAO;
	static Especialista esp;
	static Date fec;
	
	@Rule
	public TestName testName = new TestName();
	
	@BeforeClass //solo una vez
	public static void antesDeTodo () {
		trDAO = new TurnoDAO();
		System.out.println("Iniciando las pruebas TurnoDAO");
	}
	
	@Before
	public void antesDeCadaPrueba() {
		System.out.println("Iniciando la prueba " + testName.getMethodName() + " #" + numeroPrueba);
	}
	
	@Test 
	public void verificarShowAll() {
		
		boolean verified = false;
		String especialista = "Eduardo Portilla";
		Date fecha = new Date(2024-9-21);
	    int numId = 12345;
	    boolean pred1 = false;
	    boolean pred2 = false;
	    boolean pred3 = false;
	    boolean specialist = false;
	    boolean date = false;
	    boolean id = false;
	    
	    TurnoDTO newData = new TurnoDTO(esp, fecha, numId);
		trDAO.add(newData);
		
		String content = trDAO.showAll();
		String[] row = content.split("\n");
		for (String c : row) {
			String[] cols = c.split("= ");
			for (String col : cols) {

				if (col.equalsIgnoreCase("Especialista"))
					pred1 = true;
				if (col.equalsIgnoreCase(especialista))
					specialist = true;
				if (col.equalsIgnoreCase("Fecha"))
					pred2 = true;
				if (col.equalsIgnoreCase(fecha.toString()))
					date = true;
				if (col.equalsIgnoreCase("Número de id")) 
					pred3 = true;
				if (col.equalsIgnoreCase(String.valueOf(numId))) 
					id = true;
					
			}
		}

		if (pred1 && pred2 && pred3 && specialist && date && id)
			verified = true;

		assertTrue(verified);
		trDAO.delete(newData);
		verifiedOut = verified;
		
	}
	
	@Test
	
	public void verificarGetAll() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		fec = new Date(2024-9-21);
		boolean verified = false;
		trDAO.add(new TurnoDTO(esp, fec, 12345));
		ArrayList<TurnoDTO> testList = trDAO.getAll();
		if (!testList.isEmpty()) {
			verified = true;
		}
		trDAO.delete(new TurnoDTO(esp, fec, 12345));
		if (testList.isEmpty()) {
			verified = true;
		}
		assertTrue(verified);
		verifiedOut = verified;
	}
	
	@Test
	public void verificarAdd() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		fec = new Date(2024-9-21);
		boolean verified = false;
		TurnoDTO newData = new TurnoDTO(esp, fec, 12345);
		trDAO.add(newData);

		if (trDAO.find(DataMapper.turnoDTOToTurno(newData)) != null) {
			verified = true;
		}

		assertTrue(verified);
		trDAO.delete(newData);
		verifiedOut = verified;
		
	}
	
	@Test
	public void verificarDelete() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		fec = new Date(2024-9-21);
		boolean verified = false;
		TurnoDTO newData = new TurnoDTO(esp, fec, 12345);
		trDAO.add(newData);
		trDAO.delete(newData);

		if (trDAO.find(DataMapper.turnoDTOToTurno(newData)) == null) {
			verified = true;
		}
		assertTrue(verified);
		verifiedOut = verified;
		
	}
	
	@Test
	public void verificarFind() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		fec = new Date(2024-9-21);
		boolean verified = false;

		TurnoDTO newData = new TurnoDTO(esp, fec, 12345);
		trDAO.add(newData);

		if (trDAO.find(DataMapper.turnoDTOToTurno(newData)) != null) {
			verified = true;
		}

		assertTrue(verified);
		trDAO.delete(newData);
		verifiedOut = verified;
		//a
	}
	
	@Test
	public void verificarUpdate() {
		esp = new Especialista("Mario Rodríguez", null, null, 0, null, null);
		fec = new Date(2024-2-15);
		boolean verified = false;

		TurnoDTO newData = new TurnoDTO(esp, fec, 12345);
		trDAO.add(newData);

		TurnoDTO updateData = new TurnoDTO(esp, fec, 54321);
		trDAO.update(newData, updateData);

		if (trDAO.find(DataMapper.turnoDTOToTurno(updateData)) != null) {
			verified = true;
		}

		assertTrue(verified);
		trDAO.delete(updateData);
		verifiedOut = verified;
		
	}
	
	@Test
	public void verificarWriteSerialized() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		fec = new Date(2024-11-30);
		boolean verified = false;

		int id = 12345;

		FileHandler.checkFolder();

		TurnoDTO newData = new TurnoDTO(esp, fec, id);
		TurnoDTO delete = new TurnoDTO(esp, fec, 12345);
		trDAO.add(newData);
		trDAO.add(delete);

		if (trDAO.find(DataMapper.turnoDTOToTurno(newData)) != null) {
			verified = true;
		}

		assertTrue(verified);
		trDAO.delete(newData);
		trDAO.delete(delete);
		verifiedOut = verified;
		
	}
	
	@Test
	public void verificarReadSerialized() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		fec = new Date(2024-11-30);
		boolean verified = false;

		int id = 12345;

		FileHandler.checkFolder();

		TurnoDTO newData = new TurnoDTO(esp, fec, id);
		TurnoDTO delete = new TurnoDTO(esp, fec, 12345);
		trDAO.add(newData);
		trDAO.add(delete);

		if (trDAO.find(DataMapper.turnoDTOToTurno(newData)) != null) {
			verified = true;
		}

		assertTrue(verified);
		trDAO.delete(newData);
		trDAO.delete(delete);
		verifiedOut = verified;
	}
	
	@After
	public void despuesDeCadaPueba() {
		if (verifiedOut == true) {
			text = "Aprobada";
		} else {
			text = "Denegada";
		}
		System.out.println("Finalizando la prueba "+ testName.getMethodName() + " #" + numeroPrueba + "\nFue" + text);
		numeroPrueba++;
		System.out.println();
	}
	
	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Finalizando las pruebas de la clase TurnoDAO");
	}
}
