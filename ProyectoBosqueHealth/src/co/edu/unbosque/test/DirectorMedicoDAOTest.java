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

	@BeforeClass //solo una vez
	public static void antesDeTodo () {
		dmDAO = new DirectorMedicoDAO();
		System.out.println("Iniciando las pruebas de la clase DirectorMedicoDAO");
	}
	
	@Before
	public void antesDeCadaPrueba() {
		System.out.println("Iniciando la prueba " + testName.getMethodName() + " #" + numeroPrueba);
	}
	
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
		System.out.println("Finalizando las pruebas de la clase DirectorMedicoDAO");
	}

}
