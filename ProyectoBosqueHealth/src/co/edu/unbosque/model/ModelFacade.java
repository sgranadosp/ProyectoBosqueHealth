package co.edu.unbosque.model;


import co.edu.unbosque.model.persistence.CitaDAO;
import co.edu.unbosque.model.persistence.DirectorMedicoDAO;
import co.edu.unbosque.model.persistence.EspecialistaDAO;
import co.edu.unbosque.model.persistence.PacienteDAO;
import co.edu.unbosque.model.persistence.TratamientoMedicoDAO;
import co.edu.unbosque.model.persistence.TurnoDAO;


public class ModelFacade {
	
	private PacienteDAO pacienteDAO;
	private EspecialistaDAO especialistaDAO;
	private DirectorMedicoDAO directorMedicoDAO;
	private CitaDAO citaDAO;
	private TurnoDAO turnoDAO;
	private TratamientoMedicoDAO tratamientoMedicoDAO;

	
	public ModelFacade() {
		pacienteDAO = new PacienteDAO();
		especialistaDAO = new EspecialistaDAO();
		directorMedicoDAO = new DirectorMedicoDAO();
		citaDAO = new CitaDAO();
		turnoDAO = new TurnoDAO();
		tratamientoMedicoDAO = new TratamientoMedicoDAO();
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

	public CitaDAO getCitaDAO() {
		return citaDAO;
	}

	public void setCitaDAO(CitaDAO citaDAO) {
		this.citaDAO = citaDAO;
	}

	public TurnoDAO getTurnoDAO() {
		return turnoDAO;
	}

	public void setTurnoDAO(TurnoDAO turnoDAO) {
		this.turnoDAO = turnoDAO;
	}

	public TratamientoMedicoDAO getTratamientoMedicoDAO() {
		return tratamientoMedicoDAO;
	}

	public void setTratamientoMedicoDAO(TratamientoMedicoDAO tratamientoMedicoDAO) {
		this.tratamientoMedicoDAO = tratamientoMedicoDAO;
	}
	
}
