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
import co.edu.unbosque.model.persistence.DataMapper;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.model.persistence.TratamientoMedicoDAO;

public class TratamientoMedicoDAOTest {

	static int numeroPrueba = 1;
	static String text = "";
	static boolean verifiedOut = false;
	static TratamientoMedicoDAO tDAO;
	static Especialista esp;
	static Paciente paciente;
	static Date fec;
	
	@Rule
	public TestName testName = new TestName();
	
	@BeforeClass //solo una vez
	public static void antesDeTodo () {
		tDAO = new TratamientoMedicoDAO();
		System.out.println("Iniciando las pruebas TratamientoMedicoDAO");
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
		Date fecha = new Date(2024-9-21);
	    String tratamiento = "Radioterapia";
	    String examen = "Radiografía";
	    String diagnostico = "Paciente sano";
	    boolean pred1 = false;
	    boolean pred2 = false;
	    boolean pred3 = false;
	    boolean pred4 = false;
	    boolean pred5 = false;
	    boolean pred6 = false;
	    boolean specialist = false;
	    boolean pacient = false;
	    boolean date = false;
	    boolean treatment = false;
	    boolean exam = false;
	    boolean diagnosis = false;
	    
	    TratamientoMedicoDTO newData = new TratamientoMedicoDTO(null, esp, fecha, tratamiento, examen, diagnostico);
		tDAO.add(newData);
		
		String content = tDAO.showAll();
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
				if (col.equalsIgnoreCase("Tratamiento")) 
					pred4 = true;
				if (col.equalsIgnoreCase(tratamiento)) 
					treatment = true;
				if (col.equalsIgnoreCase("Exámen")) 
					pred3 = true;
				if (col.equalsIgnoreCase(examen)) 
					exam = true;
				if (col.equalsIgnoreCase("Diagnóstico")) 
					pred3 = true;
				if (col.equalsIgnoreCase(diagnostico)) 
					diagnosis = true;
					
			}
		}

		if (pred1 && pred2 && pred3 && pred4 && pred5 && pred6 && specialist && pacient && date && treatment && exam && diagnosis)
			verified = true;

		assertTrue(verified);
		tDAO.delete(newData);
		verifiedOut = verified;
		
	}
	
	@Test
	
	public void verificarGetAll() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		paciente = new Paciente("Bianca Blanco", null, null, 0, null, null);
		fec = new Date(2024-9-21);
		boolean verified = false;
		tDAO.add(new TratamientoMedicoDTO(paciente, esp, fec, "Radioterapia", "Radiografía", "Paciente sano"));
		ArrayList<TratamientoMedicoDTO> testList = tDAO.getAll();
		if (!testList.isEmpty()) {
			verified = true;
		}
		tDAO.delete(new TratamientoMedicoDTO(paciente, esp, fec, "Radioterapia", "Radiografía", "Paciente sano"));
		if (testList.isEmpty()) {
			verified = true;
		}
		assertTrue(verified);
		verifiedOut = verified;
	}
	
	@Test
	public void verificarAdd() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		paciente = new Paciente("Bianca Blanco", null, null, 0, null, null);
		fec = new Date(2024-9-21);
		boolean verified = false;
		TratamientoMedicoDTO newData = new TratamientoMedicoDTO(paciente, esp, fec, "Radioterapia", "Radiografía", "Paciente sano");
		tDAO.add(newData);

		if (tDAO.find(DataMapper.tratamientoMedicoDTOToTratamientoMedico(newData)) != null) {
			verified = true;
		}

		assertTrue(verified);
		tDAO.delete(newData);
		verifiedOut = verified;
		
	}
	
	@Test
	public void verificarDelete() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		paciente = new Paciente("Bianca Blanco", null, null, 0, null, null);
		fec = new Date(2024-9-21);
		boolean verified = false;
		TratamientoMedicoDTO newData = new TratamientoMedicoDTO(paciente, esp, fec, "Radioterapia", "Radiografía", "Paciente sano");
		tDAO.add(newData);
		tDAO.delete(newData);

		if (tDAO.find(DataMapper.tratamientoMedicoDTOToTratamientoMedico(newData)) == null) {
			verified = true;
		}
		assertTrue(verified);
		verifiedOut = verified;
		
	}
	
	@Test
	public void verificarFind() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		paciente = new Paciente("Bianca Blanco", null, null, 0, null, null);
		fec = new Date(2024-9-21);
		boolean verified = false;

		TratamientoMedicoDTO newData = new TratamientoMedicoDTO(paciente, esp, fec, "Radioterapia", "Radiografía", "Paciente sano");
		tDAO.add(newData);

		if (tDAO.find(DataMapper.tratamientoMedicoDTOToTratamientoMedico(newData)) != null) {
			verified = true;
		}

		assertTrue(verified);
		tDAO.delete(newData);
		verifiedOut = verified;
		
	}
	
	@Test
	public void verificarUpdate() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		paciente = new Paciente("Bianca Blanco", null, null, 0, null, null);
		fec = new Date(2024-11-30);
		boolean verified = false;

		TratamientoMedicoDTO newData = new TratamientoMedicoDTO(paciente, esp, fec, "Radioterapia", "Radiografía", "Paciente sano");
		tDAO.add(newData);

		TratamientoMedicoDTO updateData = new TratamientoMedicoDTO(paciente, esp, fec, "Quimioterapia", "Medicina general", "Paciente en riesgo de cancer");
		tDAO.update(newData, updateData);

		if (tDAO.find(DataMapper.tratamientoMedicoDTOToTratamientoMedico(updateData)) != null) {
			verified = true;
		}

		assertTrue(verified);
		tDAO.delete(updateData);
		verifiedOut = verified;
		
	}
	
	@Test
	public void verificarWriteSerialized() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		paciente = new Paciente("Bianca Blanco", null, null, 0, null, null);
		fec = new Date(2024-11-30);
		boolean verified = false;

		String tratamiento = "Radioterapia";
	    String examen = "Radiografía";
	    String diagnostico = "Paciente sano";

		FileHandler.checkFolder();

		TratamientoMedicoDTO newData = new TratamientoMedicoDTO(paciente, esp, fec, tratamiento, examen, diagnostico);
		TratamientoMedicoDTO delete = new TratamientoMedicoDTO(paciente, esp, fec, "Quimioterapia", "Medicina general", "Paciente en riesgo de cancer");
		tDAO.add(newData);
		tDAO.add(delete);

		if (tDAO.find(DataMapper.tratamientoMedicoDTOToTratamientoMedico(newData)) != null) {
			verified = true;
		}

		assertTrue(verified);
		tDAO.delete(newData);
		tDAO.delete(delete);
		verifiedOut = verified;
		
	}
	
	@Test
	public void verificarReadSerialized() {
		esp = new Especialista("Eduardo Portilla", null, null, 0, null, null);
		paciente = new Paciente("Bianca Blanco", null, null, 0, null, null);
		fec = new Date(2024-11-30);
		boolean verified = false;

		String tratamiento = "Radioterapia";
	    String examen = "Radiografía";
	    String diagnostico = "Paciente sano";

		FileHandler.checkFolder();

		TratamientoMedicoDTO newData = new TratamientoMedicoDTO(paciente, esp, fec, tratamiento, examen, diagnostico);
		TratamientoMedicoDTO delete = new TratamientoMedicoDTO(paciente, esp, fec, "Quimioterapia", "Medicina general", "Paciente en riesgo de cancer");
		tDAO.add(newData);
		tDAO.add(delete);

		if (tDAO.find(DataMapper.tratamientoMedicoDTOToTratamientoMedico(newData)) != null) {
			verified = true;
		}

		assertTrue(verified);
		tDAO.delete(newData);
		tDAO.delete(delete);
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
		System.out.println("Finalizando las pruebas de la clase TratamientoMedicoDAO");
	}
}
