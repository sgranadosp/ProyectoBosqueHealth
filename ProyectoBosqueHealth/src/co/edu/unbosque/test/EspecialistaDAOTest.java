package co.edu.unbosque.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import co.edu.unbosque.model.EspecialistaDTO;
import co.edu.unbosque.model.persistence.DataMapper;
import co.edu.unbosque.model.persistence.EspecialistaDAO;
import co.edu.unbosque.model.persistence.FileHandler;

/**
 * Clase de pruebas unitarias para la clase {@link EspecialistaDAO}.
 * Esta clase utiliza JUnit para probar los métodos CRUD y otras funcionalidades
 * relacionadas con el manejo de datos de los especialistas médicos.
 * 
 * <p>
 * Se prueban los métodos:
 * <ul>
 *   <li>verificarShowAll(): Verifica que el método showAll() devuelva la información correcta.</li>
 *   <li>verificarGetAll(): Verifica que el método getAll() funcione adecuadamente.</li>
 *   <li>verificarAdd(): Verifica la adición de un nuevo especialista.</li>
 *   <li>verificarDelete(): Verifica la eliminación de un especialista.</li>
 *   <li>verificarFind(): Verifica la búsqueda de un especialista en el sistema.</li>
 *   <li>verificarUpdate(): Verifica la actualización de un especialista.</li>
 *   <li>verificarWriteSerialized(): Verifica la serialización y almacenamiento de los datos.</li>
 *   <li>verifyReadSerialized(): Verifica la lectura de datos serializados.</li>
 * </ul>
 * </p>
 * 
 * <p>Se utiliza la regla {@link TestName} para obtener el nombre del método que está siendo ejecutado
 * y se muestra un mensaje de estado al finalizar cada prueba.</p>
 * 
 * <p>El ciclo de vida de las pruebas incluye:</p>
 * <ul>
 *   <li>{@link BeforeClass}: Se ejecuta una sola vez antes de iniciar todas las pruebas.</li>
 *   <li>{@link Before}: Se ejecuta antes de cada prueba individual.</li>
 *   <li>{@link After}: Se ejecuta después de cada prueba individual.</li>
 *   <li>{@link AfterClass}: Se ejecuta una vez al finalizar todas las pruebas.</li>
 * </ul>
 * 
 * @author Santiago Granados Pascagaza
 * @since 2024-11-10
 * @version 1.0
 */
public class EspecialistaDAOTest {
	/**
     * Número de prueba para seguimiento de pruebas.
     */
	static int numeroPrueba = 1;

    /**
     * Texto que indica si la prueba fue aprobada o denegada.
     */
	static String text = "";
	  /**
     * Indica si la prueba fue exitosa.
     */
	static boolean verifiedOut = false;
	/**
     * DAO de especialistas médicos.
     */
	static EspecialistaDAO eDAO;
		
	/**
     * Regla para obtener el nombre del método de prueba actual.
     */
		@Rule
		public TestName testName = new TestName();

		/**
	     * Inicialización previa a todas las pruebas.
	     */
		@BeforeClass //solo una vez
		public static void antesDeTodo () {
			eDAO = new EspecialistaDAO();
			System.out.println("Iniciando las pruebas de la clase EspecialistaDAO");
		}
		
		 /**
	     * Inicialización previa a cada prueba individual.
	     */
		@Before
		public void antesDeCadaPrueba() {
			System.out.println("Iniciando la prueba " + testName.getMethodName() + " #" + numeroPrueba);
		}
		
		/**
	     * Verifica que el método showAll() devuelva la información correcta.
	     */
		@Test 
		public void verificarShowAll() {
			
			boolean verified = false;
			String especialidad = "Neumología";
			boolean pred1 = false;
			boolean specialty = false;
			
			EspecialistaDTO newData = new EspecialistaDTO(especialidad);
			eDAO.add(newData);
			
			String content = eDAO.showAll();
			String[] row = content.split("\n");
			for (String c : row) {
				String[] cols = c.split("= ");
				for (String col : cols) {

					if (col.equalsIgnoreCase("Especialidad"))
						pred1 = true;
					if (col.equalsIgnoreCase(especialidad))
						specialty = true;
				}
			
			}
			
			if (pred1 && specialty)
				verified = true;

			assertTrue(verified);
			eDAO.delete(newData);
			verifiedOut = verified;
			
		}
		
		 /**
	     * Verifica que el método getAll() funcione adecuadamente.
	     */
		@Test
		public void verificarGetAll() {
			boolean verified = false;
			eDAO.add(new EspecialistaDTO("Neumología"));
			ArrayList<EspecialistaDTO> testList = eDAO.getAll();
			if (!testList.isEmpty()) {
				verified = true;
			}
			eDAO.delete(new EspecialistaDTO("Neumología"));
			if (testList.isEmpty()) {
				verified = true;
			}
			assertTrue(verified);
			verifiedOut = verified;
			
		}

		 /**
	     * Verifica la adición de un nuevo especialista.
	     */
		@Test
		public void verificarAdd() {
			boolean verified = false;
			EspecialistaDTO newData = new EspecialistaDTO("Neumología");
			eDAO.add(newData);
		
			if (eDAO.find(DataMapper.especialistaDTOToEspecialista(newData)) != null) {
				verified = true;
			}
		
			assertTrue(verified);
			eDAO.delete(newData);
			verifiedOut = verified;
		
		}
		
		/**
	     * Verifica la eliminación de un especialista.
	     */
		@Test
		public void verificarDelete() {
			boolean verified = false;
			EspecialistaDTO newData = new EspecialistaDTO("Neumología");
			eDAO.add(newData);
			eDAO.delete(newData);

			if (eDAO.find(DataMapper.especialistaDTOToEspecialista(newData)) == null) {
				verified = true;
			}
			assertTrue(verified);
			verifiedOut = verified;
			
		}
		
		/**
	     * Verifica la búsqueda de un especialista.
	     */
		@Test
		public void verificarFind() {
			boolean verified = false;

			EspecialistaDTO newData = new EspecialistaDTO("Neumología");
			eDAO.add(newData);

			if (eDAO.find(DataMapper.especialistaDTOToEspecialista(newData)) != null) {
				verified = true;
			}

			assertTrue(verified);
			eDAO.delete(newData);
			verifiedOut = verified;
			
		}
		
		 /**
	     * Verifica la actualización de un especialista.
	     */
		@Test
		public void verificarUpdate() {
			boolean verified = false;

			EspecialistaDTO newData = new EspecialistaDTO("Ejecutivo");
			eDAO.add(newData);

			EspecialistaDTO updateData = new EspecialistaDTO("Cirugía");
			eDAO.update(newData, updateData);

			if (eDAO.find(DataMapper.especialistaDTOToEspecialista(updateData)) != null) {
				verified = true;
			}

			assertTrue(verified);
			eDAO.delete(updateData);
			verifiedOut = verified;
			
		}
		
		 /**
	     * Verifica la escritura y serialización de datos.
	     */
		@Test
		public void verificarWriteSerialized() {
			boolean verified = false;

			String speciality = "Neumología";

			FileHandler.checkFolder();

			EspecialistaDTO newData = new EspecialistaDTO(speciality);
			EspecialistaDTO delete = new EspecialistaDTO("Cirugía");
			eDAO.add(newData);
			eDAO.add(delete);

			if (eDAO.find(DataMapper.especialistaDTOToEspecialista(newData)) != null) {
				verified = true;
			}

			assertTrue(verified);
			eDAO.delete(newData);
			eDAO.delete(delete);
			verifiedOut = verified;
			
		}
		
		 /**
	     * Verifica la lectura de datos serializados.
	     */
		@Test
		public void verifyReadSerialized() {
			boolean verified = false;

			String speciality = "Neumología";

			FileHandler.checkFolder();

			EspecialistaDTO newData = new EspecialistaDTO(speciality);
			EspecialistaDTO delete = new EspecialistaDTO("Cirugía");
			eDAO.add(newData);
			eDAO.add(delete);

			if (eDAO.find(DataMapper.especialistaDTOToEspecialista(newData)) != null) {
				verified = true;
			}

			assertTrue(verified);
			eDAO.delete(newData);
			eDAO.delete(delete);
			verifiedOut = verified;
		}
		
		  /**
	     * Limpieza posterior a cada prueba individual.
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
	     * Limpieza posterior a todas las pruebas.
	     */
		@AfterClass
		public static void despuesDeTodo() {
			System.out.println("Finalizando las pruebas de la clase EspecialistaDAO");
		}

}
