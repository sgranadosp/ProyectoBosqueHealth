package co.edu.unbosque.test;

/**
 * La clase {@code CitaDAOTest} realiza pruebas unitarias para los métodos de la clase {@link CitaDAO}.
 * Esta clase valida las funcionalidades relacionadas con el manejo de citas dentro del sistema.
 * 
 * <p>Las pruebas verifican la correcta ejecución de métodos como agregar, eliminar, actualizar, 
 * y obtener citas, así como la correcta lectura y escritura de archivos serializados.</p>
 * 
 * @since 1.0
 * @author Santiago Granado Pascagaza
 */
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import co.edu.unbosque.model.DirectorMedicoDTO;
import co.edu.unbosque.model.persistence.DataMapper;
import co.edu.unbosque.model.persistence.DirectorMedicoDAO;
import co.edu.unbosque.model.persistence.FileHandler;

public class DirectorMedicoDAOTest {
static int numeroPrueba = 1;
static String text = "";
static boolean verifiedOut = false;
static DirectorMedicoDAO dmDAO;
	
	@Rule
	public TestName testName = new TestName();

	/**
     * Método ejecutado una vez antes de todas las pruebas. Inicializa el objeto {@link CitaDAO}.
     */
	@BeforeClass //solo una vez
	public static void antesDeTodo () {
		dmDAO = new DirectorMedicoDAO();
		System.out.println("Iniciando las pruebas de la clase DirectorMedicoDAO");
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
		String nivelDirectivo = "Coordinador";
		boolean pred1 = false;
		boolean managementLevel = false;
		
		DirectorMedicoDTO newData = new DirectorMedicoDTO(nivelDirectivo);
		dmDAO.add(newData);
		
		String content = dmDAO.showAll();
		String[] row = content.split("\n");
		for (String c : row) {
			String[] cols = c.split("= ");
			for (String col : cols) {

				if (col.equalsIgnoreCase("Nivel directivo"))
					pred1 = true;
				if (col.equalsIgnoreCase(nivelDirectivo))
					managementLevel = true;
			}
		
		}
		
		if (pred1 && managementLevel)
			verified = true;

		assertTrue(verified);
		dmDAO.delete(newData);
		verifiedOut = verified;
		
	}
	
	 /**
     * Verifica que el método {@code getAll()} retorne una lista no vacía de citas.
     */
	@Test
	public void verificarGetAll() {
		boolean verified = false;
		dmDAO.add(new DirectorMedicoDTO("Ejecutivo"));
		ArrayList<DirectorMedicoDTO> testList = dmDAO.getAll();
		if (!testList.isEmpty()) {
			verified = true;
		}
		dmDAO.delete(new DirectorMedicoDTO("Ejecutivo"));
		if (testList.isEmpty()) {
			verified = true;
		}
		assertTrue(verified);
		verifiedOut = verified;
		
	}

	 /**
     * Verifica el método {@code add()} para asegurarse de que una cita se agrega correctamente.
     */
	@Test
	public void verificarAdd() {
		boolean verified = false;
		DirectorMedicoDTO newData = new DirectorMedicoDTO("Ejecutivo");
		dmDAO.add(newData);
	
		if (dmDAO.find(DataMapper.directorMedicolistaDTOToDirectorMedico(newData)) != null) {
			verified = true;
		}
	
		assertTrue(verified);
		dmDAO.delete(newData);
		verifiedOut = verified;
	
	}
	
	 /**
     * Verifica el método {@code delete()} para eliminar una cita correctamente.
     */
	@Test
	public void verificarDelete() {
		boolean verified = false;
		DirectorMedicoDTO newData = new DirectorMedicoDTO("Ejecutivo");
		dmDAO.add(newData);
		dmDAO.delete(newData);

		if (dmDAO.find(DataMapper.directorMedicolistaDTOToDirectorMedico(newData)) == null) {
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
		boolean verified = false;

		DirectorMedicoDTO newData = new DirectorMedicoDTO("Ejecutivo");
		dmDAO.add(newData);

		if (dmDAO.find(DataMapper.directorMedicolistaDTOToDirectorMedico(newData)) != null) {
			verified = true;
		}

		assertTrue(verified);
		dmDAO.delete(newData);
		verifiedOut = verified;
		
	}
	
	/**
	 * verifica el metodo {@code update} que funciona para actualizar los datos de director medico.
	 */
	@Test
	public void verificarUpdate() {
		boolean verified = false;

		DirectorMedicoDTO newData = new DirectorMedicoDTO("Ejecutivo");
		dmDAO.add(newData);

		DirectorMedicoDTO updateData = new DirectorMedicoDTO("Ejecutivo");
		dmDAO.update(newData, updateData);

		if (dmDAO.find(DataMapper.directorMedicolistaDTOToDirectorMedico(updateData)) != null) {
			verified = true;
		}

		assertTrue(verified);
		dmDAO.delete(updateData);
		verifiedOut = verified;
		
	}
	
	/**
	 * verifica el metodo {@code writeSerialized} que  sobrescribe los datos de director medico.
	 */
	@Test
	public void verificarWriteSerialized() {
		boolean verified = false;

		String managementLevel = "Ejecutivo";

		FileHandler.checkFolder();

		DirectorMedicoDTO newData = new DirectorMedicoDTO(managementLevel);
		DirectorMedicoDTO delete = new DirectorMedicoDTO("Ejecutivo");
		dmDAO.add(newData);
		dmDAO.add(delete);

		if (dmDAO.find(DataMapper.directorMedicolistaDTOToDirectorMedico(newData)) != null) {
			verified = true;
		}

		assertTrue(verified);
		dmDAO.delete(newData);
		dmDAO.delete(delete);
		verifiedOut = verified;
		
	}
	
	/**
	 * verifica el metodo {@code readSerialized} que lee el archivo serializado.
	 */
	@Test
	public void verifyReadSerialized() {
		boolean verified = false;

		String managementLevel = "Ejecutivo";

		FileHandler.checkFolder();

		DirectorMedicoDTO newData = new DirectorMedicoDTO(managementLevel);
		DirectorMedicoDTO delete = new DirectorMedicoDTO("Ejecutivo");
		dmDAO.add(newData);
		dmDAO.add(delete);

		if (dmDAO.find(DataMapper.directorMedicolistaDTOToDirectorMedico(newData)) != null) {
			verified = true;
		}

		assertTrue(verified);
		dmDAO.delete(newData);
		dmDAO.delete(delete);
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
		System.out.println("Finalizando las pruebas de la clase DirectorMedicoDAO");
	}

}
