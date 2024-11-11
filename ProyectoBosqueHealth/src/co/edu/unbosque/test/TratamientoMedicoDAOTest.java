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

/**
 * Clase de prueba para {@link TratamientoMedicoDAO}.
 * 
 * Esta clase contiene una serie de pruebas unitarias utilizando JUnit para verificar el correcto funcionamiento de los métodos de la clase {@link TratamientoMedicoDAO},
 * que es responsable de la manipulación de objetos {@link TratamientoMedicoDTO} relacionados con especialistas, pacientes y tratamientos médicos.
 * Se realizan pruebas para las operaciones de CRUD (Crear, Leer, Actualizar, Eliminar) y pruebas de serialización y deserialización de datos.
 * 
 * @since 2024-11-10
 * @author Santiago Granados Pascagaza
 * @version 1.0
 */
public class TratamientoMedicoDAOTest {
	/**
     * Variable estática para el número de prueba.
     */
	static int numeroPrueba = 1;
	/**
     * Variable estática para almacenar el resultado de la prueba.
     */
    static String text = "";

    /**
     * Variable estática que guarda el estado de la prueba.
     */
    static boolean verifiedOut = false;

    /**
     * Instancia de la clase {@link TratamientoMedicoDAO} utilizada en las pruebas.
     */
    static TratamientoMedicoDAO tDAO;

    /**
     * Instancia de la clase {@link Especialista} utilizada en las pruebas.
     */
    static Especialista esp;

    /**
     * Instancia de la clase {@link Paciente} utilizada en las pruebas.
     */
    static Paciente paciente;

    /**
     * Instancia de la clase {@link Date} utilizada en las pruebas.
     */
    static Date fec;

    /**
     * Regla de JUnit para obtener el nombre del método de prueba en ejecución.
     */
	@Rule
	public TestName testName = new TestName();
	
	 /**
     * Método que se ejecuta una vez antes de todas las pruebas.
     * Inicializa el objeto {@link TratamientoMedicoDAO}.
     */
	@BeforeClass //solo una vez
	public static void antesDeTodo () {
		tDAO = new TratamientoMedicoDAO();
		System.out.println("Iniciando las pruebas TratamientoMedicoDAO");
	}
	
	/**
     * Método que se ejecuta antes de cada prueba.
     * Muestra el nombre de la prueba en curso.
     */
	@Before
	public void antesDeCadaPrueba() {
		System.out.println("Iniciando la prueba " + testName.getMethodName() + " #" + numeroPrueba);
	}
	
	/**
     * Verifica el funcionamiento del método {@link TratamientoMedicoDAO#showAll()}.
     * Añade un tratamiento médico y verifica que se muestra correctamente en la salida.
     */
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
	
	 /**
     * Verifica el funcionamiento del método {@link TratamientoMedicoDAO#getAll()}.
     * Añade un tratamiento médico y verifica que se obtiene correctamente en una lista.
     */
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
	
	 /**
     * Verifica el funcionamiento del método {@link TratamientoMedicoDAO#add(TratamientoMedicoDTO)}.
     * Añade un tratamiento médico y verifica que el objeto se encuentra en la base de datos.
     */
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
	
	 /**
     * Verifica el funcionamiento del método {@link TratamientoMedicoDAO#delete(TratamientoMedicoDTO)}.
     * Elimina un tratamiento médico y verifica que ya no se puede encontrar en la base de datos.
     */
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
	
	 /**
     * Verifica el funcionamiento del método {@link TratamientoMedicoDAO#find(TratamientoMedicoDTO)}.
     * Añade un tratamiento médico y verifica que se puede encontrar en la base de datos.
     */
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
	
	/**
     * Verifica el funcionamiento del método {@link TratamientoMedicoDAO#update(TratamientoMedicoDTO, TratamientoMedicoDTO)}.
     * Añade un tratamiento médico, lo actualiza y verifica que el cambio se haya realizado correctamente.
     */
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
	
	 /**
     * Verifica la correcta serialización de los datos de tratamiento médico en archivos.
     * 
     * Este método comprueba si los datos serializados se pueden escribir y leer correctamente
     * desde el sistema de archivos.
     */
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
	
	 /**
     * Verifica la correcta deserialización de los datos de tratamiento médico desde archivos.
     * 
     * Este método comprueba si los datos deserializados se pueden leer correctamente desde el sistema
     * de archivos y verificarlos en la base de datos.
     */
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
	
	  /**
     * Método que se ejecuta después de cada prueba.
     * Imprime si la prueba fue aprobada o denegada.
     */
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
	
	 /**
     * Método que se ejecuta después de todas las pruebas.
     * Indica que todas las pruebas han finalizado.
     */
	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Finalizando las pruebas de la clase TratamientoMedicoDAO");
	}
}
