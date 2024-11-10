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

import co.edu.unbosque.model.PacienteDTO;
import co.edu.unbosque.model.persistence.DataMapper;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.model.persistence.PacienteDAO;

public class PacienteDAOTest {

	static int numeroPrueba = 1;
	static String text = "";
	static boolean verifiedOut = false;
	static PacienteDAO pDAO;
		
		@Rule
		public TestName testName = new TestName();

		@BeforeClass //solo una vez
		public static void antesDeTodo () {
			pDAO = new PacienteDAO();
			System.out.println("Iniciando las pruebas de la clase PacienteDAO");
		}
		
		@Before
		public void antesDeCadaPrueba() {
			System.out.println("Iniciando la prueba " + testName.getMethodName() + " #" + numeroPrueba);
		}
		
		@Test 
		public void verificarShowAll() {
			
			boolean verified = false;
			String tratamiento = "Quimioterapia";
			boolean pred1 = false;
			boolean treatment = false;
			
			PacienteDTO newData = new PacienteDTO(tratamiento);
			pDAO.add(newData);
			
			String content = pDAO.showAll();
			String[] row = content.split("\n");
			for (String c : row) {
				String[] cols = c.split("= ");
				for (String col : cols) {

					if (col.equalsIgnoreCase("Tratamiento"))
						pred1 = true;
					if (col.equalsIgnoreCase(tratamiento))
						treatment = true;
				}
			
			}
			
			if (pred1 && treatment)
				verified = true;

			assertTrue(verified);
			pDAO.delete(newData);
			verifiedOut = verified;
			
		}
		
	@Test
		
		public void verificarGetAll() {
			boolean verified = false;
			pDAO.add(new PacienteDTO("Quimioterapia"));
			ArrayList<PacienteDTO> testList = pDAO.getAll();
			if (!testList.isEmpty()) {
				verified = true;
			}
			pDAO.delete(new PacienteDTO("Quimioterapia"));
			if (testList.isEmpty()) {
				verified = true;
			}
			assertTrue(verified);
			verifiedOut = verified;
			
		}

		@Test
		public void verificarAdd() {
			boolean verified = false;
			PacienteDTO newData = new PacienteDTO("Quimioterapia");
			pDAO.add(newData);
		
			if (pDAO.find(DataMapper.pacienteDTOToPaciente(newData)) != null) {
				verified = true;
			}
		
			assertTrue(verified);
			pDAO.delete(newData);
			verifiedOut = verified;
		
		}
		
		@Test
		public void verificarDelete() {
			boolean verified = false;
			PacienteDTO newData = new PacienteDTO("Quimioterapia");
			pDAO.add(newData);
			pDAO.delete(newData);

			if (pDAO.find(DataMapper.pacienteDTOToPaciente(newData)) == null) {
				verified = true;
			}
			assertTrue(verified);
			verifiedOut = verified;
			
		}
		
		@Test
		public void verificarFind() {
			boolean verified = false;

			PacienteDTO newData = new PacienteDTO("Quimioterapia");
			pDAO.add(newData);

			if (pDAO.find(DataMapper.pacienteDTOToPaciente(newData)) != null) {
				verified = true;
			}

			assertTrue(verified);
			pDAO.delete(newData);
			verifiedOut = verified;
			
		}
		
		@Test
		public void verificarUpdate() {
			boolean verified = false;

			PacienteDTO newData = new PacienteDTO("Quimioterapia");
			pDAO.add(newData);

			PacienteDTO updateData = new PacienteDTO("Radioterapia");
			pDAO.update(newData, updateData);

			if (pDAO.find(DataMapper.pacienteDTOToPaciente(updateData)) != null) {
				verified = true;
			}

			assertTrue(verified);
			pDAO.delete(updateData);
			verifiedOut = verified;
			
		}
		
		@Test
		public void verificarWriteSerialized() {
			boolean verified = false;

			String treatment = "Quimioterapia";

			FileHandler.checkFolder();

			PacienteDTO newData = new PacienteDTO(treatment);
			PacienteDTO delete = new PacienteDTO("Radioterapia");
			pDAO.add(newData);
			pDAO.add(delete);

			if (pDAO.find(DataMapper.pacienteDTOToPaciente(newData)) != null) {
				verified = true;
			}

			assertTrue(verified);
			pDAO.delete(newData);
			pDAO.delete(delete);
			verifiedOut = verified;
			
		}
		
		@Test
		public void verifyReadSerialized() {
			boolean verified = false;

			String treatment = "Quimioterapia";

			FileHandler.checkFolder();

			PacienteDTO newData = new PacienteDTO(treatment);
			PacienteDTO delete = new PacienteDTO("Radioterapia");
			pDAO.add(newData);
			pDAO.add(delete);

			if (pDAO.find(DataMapper.pacienteDTOToPaciente(newData)) != null) {
				verified = true;
			}

			assertTrue(verified);
			pDAO.delete(newData);
			pDAO.delete(delete);
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
			System.out.println("Finalizando las pruebas de la clase PacienteDAO");
		}
		
}
