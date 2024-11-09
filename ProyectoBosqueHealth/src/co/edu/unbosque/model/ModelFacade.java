package co.edu.unbosque.model;


import co.edu.unbosque.model.persistence.CitaDAO;
import co.edu.unbosque.model.persistence.DirectorMedicoDAO;
import co.edu.unbosque.model.persistence.EspecialistaDAO;
import co.edu.unbosque.model.persistence.PacienteDAO;
import co.edu.unbosque.model.persistence.TratamientoMedicoDAO;
import co.edu.unbosque.model.persistence.TurnoDAO;


/**
 * La clase {@code ModelFacade} actúa como una fachada que proporciona un punto de acceso unificado
 * para interactuar con los diferentes Data Access Objects del sistema.
 * <p>
 * Esta clase simplifica la interacción con la capa de persistencia al encapsular 
 * las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para pacientes, especialistas, 
 * directores médicos, citas, turnos y tratamientos médicos.
 * </p>
 */
public class ModelFacade {
	
	/** DAO para manejar las operaciones relacionadas con los pacientes. */
    private PacienteDAO pacienteDAO;

    /** DAO para manejar las operaciones relacionadas con los especialistas. */
    private EspecialistaDAO especialistaDAO;

    /** DAO para manejar las operaciones relacionadas con los directores médicos. */
    private DirectorMedicoDAO directorMedicoDAO;

    /** DAO para manejar las operaciones relacionadas con las citas médicas. */
    private CitaDAO citaDAO;

    /** DAO para manejar las operaciones relacionadas con los turnos. */
    private TurnoDAO turnoDAO;

    /** DAO para manejar las operaciones relacionadas con los tratamientos médicos. */
    private TratamientoMedicoDAO tratamientoMedicoDAO;

    /**
     * Constructor por defecto que inicializa todos los DAOs.
     */
    public ModelFacade() {
        pacienteDAO = new PacienteDAO();
        especialistaDAO = new EspecialistaDAO();
        directorMedicoDAO = new DirectorMedicoDAO();
        citaDAO = new CitaDAO();
        turnoDAO = new TurnoDAO();
        tratamientoMedicoDAO = new TratamientoMedicoDAO();
    }

    /**
     * Obtiene el DAO para los pacientes.
     * 
     * @return el objeto {@code PacienteDAO}
     */
    public PacienteDAO getPacienteDAO() {
        return pacienteDAO;
    }

    /**
     * Establece el DAO para los pacientes.
     * 
     * @param pacienteDAO el objeto {@code PacienteDAO} a establecer
     */
    public void setPacienteDAO(PacienteDAO pacienteDAO) {
        this.pacienteDAO = pacienteDAO;
    }

    /**
     * Obtiene el DAO para los especialistas.
     * 
     * @return el objeto {@code EspecialistaDAO}
     */
    public EspecialistaDAO getEspecialistaDAO() {
        return especialistaDAO;
    }

    /**
     * Establece el DAO para los especialistas.
     * 
     * @param especialistaDAO el objeto {@code EspecialistaDAO} a establecer
     */
    public void setEspecialistaDAO(EspecialistaDAO especialistaDAO) {
        this.especialistaDAO = especialistaDAO;
    }

    /**
     * Obtiene el DAO para los directores médicos.
     * 
     * @return el objeto {@code DirectorMedicoDAO}
     */
    public DirectorMedicoDAO getDirectorMedicoDAO() {
        return directorMedicoDAO;
    }

    /**
     * Establece el DAO para los directores médicos.
     * 
     * @param directorMedicoDAO el objeto {@code DirectorMedicoDAO} a establecer
     */
    public void setDirectorMedicoDAO(DirectorMedicoDAO directorMedicoDAO) {
        this.directorMedicoDAO = directorMedicoDAO;
    }

    /**
     * Obtiene el DAO para las citas médicas.
     * 
     * @return el objeto {@code CitaDAO}
     */
    public CitaDAO getCitaDAO() {
        return citaDAO;
    }

    /**
     * Establece el DAO para las citas médicas.
     * 
     * @param citaDAO el objeto {@code CitaDAO} a establecer
     */
    public void setCitaDAO(CitaDAO citaDAO) {
        this.citaDAO = citaDAO;
    }

    /**
     * Obtiene el DAO para los turnos.
     * 
     * @return el objeto {@code TurnoDAO}
     */
    public TurnoDAO getTurnoDAO() {
        return turnoDAO;
    }

    /**
     * Establece el DAO para los turnos.
     * 
     * @param turnoDAO el objeto {@code TurnoDAO} a establecer
     */
    public void setTurnoDAO(TurnoDAO turnoDAO) {
        this.turnoDAO = turnoDAO;
    }

    /**
     * Obtiene el DAO para los tratamientos médicos.
     * 
     * @return el objeto {@code TratamientoMedicoDAO}
     */
    public TratamientoMedicoDAO getTratamientoMedicoDAO() {
        return tratamientoMedicoDAO;
    }

    /**
     * Establece el DAO para los tratamientos médicos.
     * 
     * @param tratamientoMedicoDAO el objeto {@code TratamientoMedicoDAO} a establecer
     */
    public void setTratamientoMedicoDAO(TratamientoMedicoDAO tratamientoMedicoDAO) {
        this.tratamientoMedicoDAO = tratamientoMedicoDAO;
    }
}