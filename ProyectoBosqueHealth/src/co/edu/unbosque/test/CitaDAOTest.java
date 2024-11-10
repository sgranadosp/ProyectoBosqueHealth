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

import co.edu.unbosque.model.CitaDTO;
import co.edu.unbosque.model.Especialista;
import co.edu.unbosque.model.Paciente;
import co.edu.unbosque.model.persistence.CitaDAO;
import co.edu.unbosque.model.persistence.DataMapper;
import co.edu.unbosque.model.persistence.FileHandler;

public class CitaDAOTest {

	static int numeroPrueba = 1;
	static String text = "";
	static boolean verifiedOut = false;
	static CitaDAO cDAO;
	static Especialista esp;
	static Paciente paciente;
	static Date fec;
	
	@Rule
	public TestName testName = new TestName();
	
	@BeforeClass //solo una vez
	public static void antesDeTodo () {
		cDAO = new CitaDAO();
		System.out.println("Iniciando las pruebas CitasDAO");
	}
	
	@Before
	public void antesDeCadaPrueba() {
		System.out.println("Iniciando la prueba " + testName.getMethodName() + " #" + numeroPrueba);
	}
	
	@Test 
	public void verificarShowAll() {
		
		boolean verified = false;
		String especialista = "Eduardo Portilla";
		String paciente = "Bianca Blanco";
		Date fecha = new Date(2024-11-30);
	    String hora = "10 am";
	    int numeroCita = 12345;
	    String estado = "Activa";
	    boolean pred1 = false;
	    boolean pred2 = false;
	    boolean pred3 = false;
	    boolean pred4 = false;
	    boolean pred5 = false;
	    boolean pred6 = false;
	    boolean specialist = false;
	    boolean pacient = false;
	    boolean date = false;
	    boolean hour = false;
	    boolean id = false;
	    boolean state = false;
	    
	    CitaDTO newData = new CitaDTO(null, null, fecha, hora, numeroCita, estado);
		cDAO.add(newData);
		
		String content = cDAO.showAll();
		String[] row = content.split("\n");
		for (String c : row) {
			String[] cols = c.split("= ");
			for (String col : cols) {

				if (col.equalsIgnoreCase("Especialista"))
					pred1 = true;
				if (col.equalsIgnoreCase(especialista))
					specialist = true;
				if (col.equalsIgnoreCase("Paciente"))
					pred2 = true;
				if (col.equalsIgnoreCase(paciente))
					pacient = true;
				if (col.equalsIgnoreCase("Fecha")) 
					pred3 = true;
				if (col.equalsIgnoreCase(fecha.toString())) 
					date = true;
				if (col.equalsIgnoreCase("Hora")) 
					pred4 = true;
				if (col.equalsIgnoreCase(hora)) 
					hour = true;
				if (col.equalsIgnoreCase("Numero cita")) 
					pred3 = true;
				if (col.equalsIgnoreCase(String.valueOf(numeroCita))) 
					id = true;
				if (col.equalsIgnoreCase("Estado")) 
					pred3 = true;
				if (col.equalsIgnoreCase(estado)) 
					state = true;
					
				
			}
		}

		if (pred1 && pred2 && pred3 && pred4 && pred5 && pred6 && specialist && pacient && date && hour && id && state)
			verified = true;

		assertTrue(verified);
		cDAO.delete(newData);
		verifiedOut = verified;
		
	}
	
	@Test
	
	public void verificarGetAll() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		paciente = new Paciente("Bianca Blanco", null, null, 0, null, null);
		fec = new Date(2024-11-30);
		boolean verified = false;
		cDAO.add(new CitaDTO(esp, paciente, fec, "10 am", 12345, "Activa"));
		ArrayList<CitaDTO> testList = cDAO.getAll();
		if (!testList.isEmpty()) {
			verified = true;
		}
		cDAO.delete(new CitaDTO(esp, paciente, fec, "10 am", 12345, "Activa"));
		if (testList.isEmpty()) {
			verified = true;
		}
		assertTrue(verified);
		verifiedOut = verified;
		//"Eduardo Portilla", "Bianca Blanco", 2024-11-30, "10 am", 12345, "Activa"
	}
	
	@Test
	public void verificarAdd() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		paciente = new Paciente("Bianca Blanco", null, null, 0, null, null);
		fec = new Date(2024-11-30);
		boolean verified = false;
		CitaDTO newData = new CitaDTO(esp, paciente, fec, "10 am", 12345, "Activa");
		cDAO.add(newData);

		if (cDAO.find(DataMapper.citaDTOToCita(newData)) != null) {
			verified = true;
		}

		assertTrue(verified);
		cDAO.delete(newData);
		verifiedOut = verified;
		
	}
	
	@Test
	public void verificarDelete() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		paciente = new Paciente("Bianca Blanco", null, null, 0, null, null);
		fec = new Date(2024-11-30);
		boolean verified = false;
		CitaDTO newData = new CitaDTO(esp, paciente, fec, "10 am", 12345, "Activa");
		cDAO.add(newData);
		cDAO.delete(newData);

		if (cDAO.find(DataMapper.citaDTOToCita(newData)) == null) {
			verified = true;
		}
		assertTrue(verified);
		verifiedOut = verified;
		
	}
	
	@Test
	public void verificarFind() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		paciente = new Paciente("Bianca Blanco", null, null, 0, null, null);
		fec = new Date(2024-11-30);
		boolean verified = false;

		CitaDTO newData = new CitaDTO(esp, paciente, fec, "10 am", 12345, "Activa");
		cDAO.add(newData);

		if (cDAO.find(DataMapper.citaDTOToCita(newData)) != null) {
			verified = true;
		}

		assertTrue(verified);
		cDAO.delete(newData);
		verifiedOut = verified;
		
	}
	
	@Test
	public void verificarUpdate() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		paciente = new Paciente("Bianca Blanco", null, null, 0, null, null);
		fec = new Date(2024-11-30);
		boolean verified = false;

		CitaDTO newData = new CitaDTO(esp, paciente, fec, "10 am", 12345, "Activa");
		cDAO.add(newData);

		CitaDTO updateData = new CitaDTO(esp, paciente, fec, "10 am", 12345, "Activa");
		cDAO.update(newData, updateData);

		if (cDAO.find(DataMapper.citaDTOToCita(updateData)) != null) {
			verified = true;
		}

		assertTrue(verified);
		cDAO.delete(updateData);
		verifiedOut = verified;
		
	}
	
	@Test
	public void verificarWriteSerialized() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		paciente = new Paciente("Bianca Blanco", null, null, 0, null, null);
		fec = new Date(2024-11-30);
		boolean verified = false;

	    String hora = "10 am";
	    int numeroCita = 12345;
	    String estado = "Activa";

		FileHandler.checkFolder();

		CitaDTO newData = new CitaDTO(esp, paciente, fec, hora, numeroCita, estado);
		CitaDTO delete = new CitaDTO(esp, paciente, fec, "10 am", 12345, "Activa");
		cDAO.add(newData);
		cDAO.add(delete);

		if (cDAO.find(DataMapper.citaDTOToCita(newData)) != null) {
			verified = true;
		}

		assertTrue(verified);
		cDAO.delete(newData);
		cDAO.delete(delete);
		verifiedOut = verified;
		
	}
	
	@Test
	public void verificarReadSerialized() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		paciente = new Paciente("Bianca Blanco", null, null, 0, null, null);
		fec = new Date(2024-11-30);
		boolean verified = false;

		String hora = "10 am";
	    int numeroCita = 12345;
	    String estado = "Activa";

		FileHandler.checkFolder();

		CitaDTO newData = new CitaDTO(esp, paciente, fec, hora, numeroCita, estado);
		CitaDTO delete = new CitaDTO(esp, paciente, fec, "10 am", 12345, "Activa");
		cDAO.add(newData);
		cDAO.add(delete);

		if (cDAO.find(DataMapper.citaDTOToCita(newData)) != null) {
			verified = true;
		}

		assertTrue(verified);
		cDAO.delete(newData);
		cDAO.delete(delete);
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
		System.out.println("Finalizando las pruebas de la clase CitaDAO");
	}
}
