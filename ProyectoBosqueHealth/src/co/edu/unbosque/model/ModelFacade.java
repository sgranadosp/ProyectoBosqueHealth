package co.edu.unbosque.model;


import co.edu.unbosque.model.persistence.DirectorMedicoDAO;
import co.edu.unbosque.model.persistence.EspecialistaDAO;
import co.edu.unbosque.model.persistence.PacienteDAO;


public class ModelFacade {
	
	private PacienteDAO pacienteDAO;
	private EspecialistaDAO especialistaDAO;
	private DirectorMedicoDAO directorMedicoDAO;

	
	public ModelFacade() {
		pacienteDAO = new PacienteDAO();
		especialistaDAO = new EspecialistaDAO();
		directorMedicoDAO = new DirectorMedicoDAO();

	}

	public PacienteDAO getPacienteDAO() {
		return pacienteDAO;
	}

	public void setPacienteDAO(PacienteDAO pacienteDAO) {
		this.pacienteDAO = pacienteDAO;
	}

	public EspecialistaDAO getEspecialistaDAO() {
		return especialistaDAO;
	}

	public void setEspecialistaDAO(EspecialistaDAO especialistaDAO) {
		this.especialistaDAO = especialistaDAO;
	}

	public DirectorMedicoDAO getDirectorMedicoDAO() {
		return directorMedicoDAO;
	}

	public void setDirectorMedicoDAO(DirectorMedicoDAO directorMedicoDAO) {
		this.directorMedicoDAO = directorMedicoDAO;
	}


	

}
