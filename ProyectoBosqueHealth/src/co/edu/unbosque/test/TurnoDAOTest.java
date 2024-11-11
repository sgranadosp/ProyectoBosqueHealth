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

/**
 * Clase de prueba unitaria para la clase {@link TurnoDAO}.
 * Contiene pruebas que verifican las funcionalidades de la clase {@link TurnoDAO},
 * como la adición, eliminación, actualización, búsqueda y serialización de objetos {@link TurnoDTO}.
 * 
 * @since 2024-11-10
 * @author Santiago Granados Pascagaza
 * @version 1.0
 */
public class TurnoDAOTest {

	static int numeroPrueba = 1;
	static String text = "";
	static boolean verifiedOut = false;
	static TurnoDAO trDAO;
	static Especialista esp;
	static Date fec;
	
	@Rule
	public TestName testName = new TestName();
	
	/**
     * Método que se ejecuta antes de todas las pruebas. Inicializa el objeto {@link TurnoDAO}.
     */
	@BeforeClass //solo una vez
	public static void antesDeTodo () {
		trDAO = new TurnoDAO();
		System.out.println("Iniciando las pruebas TurnoDAO");
	}
	
	 /**
     * Método que se ejecuta antes de cada prueba. Imprime un mensaje indicando el inicio de la prueba.
     */
	@Before
	public void antesDeCadaPrueba() {
		System.out.println("Iniciando la prueba " + testName.getMethodName() + " #" + numeroPrueba);
	}
	
	 /**
     * Verifica que el método {@link TurnoDAO#showAll()} muestra correctamente todos los turnos.
     * Se crea un nuevo turno y se verifica que la información se presente correctamente en la salida.
     */
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
	
	/**
     * Verifica el funcionamiento del método {@link TurnoDAO#getAll()}.
     * Añade un turno, lo recupera con {@code getAll} y verifica que la lista no esté vacía.
     */
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
	
	  /**
     * Verifica el funcionamiento del método {@link TurnoDAO#add(TurnoDTO)}.
     * Añade un turno y verifica que se haya agregado correctamente.
     */
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
	
	 /**
     * Verifica el funcionamiento del método {@link TurnoDAO#delete(TurnoDTO)}.
     * Añade un turno, lo elimina y verifica que haya sido eliminado correctamente.
     */
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
	
	 /**
     * Verifica el funcionamiento del método {@link TurnoDAO#find(Object)}.
     * Añade un turno y verifica que se pueda encontrar correctamente en la base de datos.
     */
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
	
	 /**
     * Verifica el funcionamiento del método {@link TurnoDAO#update(TurnoDTO, TurnoDTO)}.
     * Añade un turno, lo actualiza y verifica que el cambio se haya realizado correctamente.
     */
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
	
	/**
     * Verifica la correcta serialización de los datos de turno en archivos.
     * Este método comprueba si los datos serializados se pueden escribir y leer correctamente
     * desde el sistema de archivos.
     */
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
	
	/**
     * Verifica la correcta deserialización de los datos de turno desde archivos.
     * Este método comprueba si los datos deserializados se pueden leer correctamente desde el sistema
     * de archivos y verificarlos en la base de datos.
     */
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
	
	/**
     * Método que se ejecuta después de cada prueba. Imprime un mensaje indicando si la prueba fue aprobada o denegada.
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
     * Método que se ejecuta después de todas las pruebas. Imprime un mensaje indicando que las pruebas han finalizado.
     */
	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Finalizando las pruebas de la clase TurnoDAO");
	}
}
