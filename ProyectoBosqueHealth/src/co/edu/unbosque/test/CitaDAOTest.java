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

/**
 * La clase {@code CitaDAOTest} realiza pruebas unitarias para los métodos de la clase {@link CitaDAO}.
 * Esta clase valida las funcionalidades relacionadas con el manejo de citas dentro del sistema.
 * 
 * <p>Las pruebas verifican la correcta ejecución de métodos como agregar, eliminar, actualizar, 
 * y obtener citas, así como la correcta lectura y escritura de archivos serializados.</p>
 * 
 * @since 2024-11-10
 * @author Santiago Granados Pascagaza
 * @version 1.0
 */
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
	
	/**
     * Método ejecutado una vez antes de todas las pruebas. Inicializa el objeto {@link CitaDAO}.
     */
	@BeforeClass //solo una vez
	public static void antesDeTodo () {
		cDAO = new CitaDAO();
		System.out.println("Iniciando las pruebas CitasDAO");
	}
	
	 /**
     * Método ejecutado antes de cada prueba. Muestra información sobre la prueba en curso.
     */
	@Before
	public void antesDeCadaPrueba() {
		System.out.println("Iniciando la prueba " + testName.getMethodName() + " #" + numeroPrueba);
	}
	
	 /**
     * Verifica el método {@code showAll()} de {@link CitaDAO} asegurando que se muestren 
     * correctamente todas las citas almacenadas.
     */
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
	
	 /**
     * Verifica que el método {@code getAll()} retorne una lista no vacía de citas.
     */
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
	
	 /**
     * Verifica el método {@code add()} para asegurarse de que una cita se agrega correctamente.
     */
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
	
	 /**
     * Verifica el método {@code delete()} para eliminar una cita correctamente.
     */
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
	
	/**
     * Verifica el método {@code find()} para buscar una cita existente.
     */
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
	
	/**
	 * verifica el metodo {@code update} que actualiza los datos de la cita.
	 */
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
	
	/**
	 * verifica el metodo {@code writeSerilized} que sobrescribe el archivo serializado
	 */
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
	
	/**
	 * verifica el metodo {@code readSerialized} que lee los datos del archivo serializado.
	 */
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
	
	 /**
     * Método ejecutado después de cada prueba. Muestra si la prueba fue exitosa o no.
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
     * Método ejecutado una vez después de todas las pruebas. Finaliza la sesión de pruebas.
     */
	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Finalizando las pruebas de la clase CitaDAO");
	}
}
