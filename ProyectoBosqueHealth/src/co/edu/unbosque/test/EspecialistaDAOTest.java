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

public class EspecialistaDAOTest {
	static int numeroPrueba = 1;
	static String text = "";
	static boolean verifiedOut = false;
	static EspecialistaDAO eDAO;
		
		@Rule
		public TestName testName = new TestName();

		@BeforeClass //solo una vez
		public static void antesDeTodo () {
			eDAO = new EspecialistaDAO();
			System.out.println("Iniciando las pruebas de la clase EspecialistaDAO");
		}
		
		@Before
		public void antesDeCadaPrueba() {
			System.out.println("Iniciando la prueba " + testName.getMethodName() + " #" + numeroPrueba);
		}
		
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
			System.out.println("Finalizando las pruebas de la clase EspecialistaDAO");
		}

}
