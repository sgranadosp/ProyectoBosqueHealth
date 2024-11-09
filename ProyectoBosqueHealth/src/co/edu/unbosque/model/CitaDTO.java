package co.edu.unbosque.model;

import java.util.Date;

/**
 * La clase {@code CitaDTO} es un Data Transfer Object (DTO) que representa los datos 
 * de una cita médica. Se utiliza para transferir información entre diferentes capas
 * de la aplicación sin exponer la entidad original.
 * <p>
 * Contiene información sobre el especialista, paciente, fecha, hora, número de la cita 
 * y estado de la misma.
 * </p>
 * 
 * @author Sebastian Perez Herrera
 * @version 1.0
 * @since 2024-11-10
 */
public class CitaDTO {

	 /** El especialista asignado a la cita */
    private Especialista especialista;
    
    /** El paciente que asiste a la cita */
    private Paciente paciente;
    
    /** La fecha en la que se llevará a cabo la cita */
    private Date fecha;
    
    /** La hora en la que se llevará a cabo la cita */
    private String hora;
    
    /** El número identificador de la cita */
    private int numeroCita;
    
    /** El estado actual de la cita (por ejemplo, "Programada", "Cancelada", "Completada") */
    private String estado;

    /**
     * Constructor por defecto que crea una instancia de {@code CitaDTO} sin inicializar los atributos.
     */	
    public CitaDTO() {
    }
	
    /**
     * Constructor que crea una instancia de {@code CitaDTO} con los atributos especificados.
     * 
     * @param especialista El especialista asignado a la cita
     * @param paciente El paciente que asiste a la cita
     * @param fecha La fecha en la que se llevará a cabo la cita
     * @param hora La hora en la que se llevará a cabo la cita
     * @param numeroCita El número identificador de la cita
     * @param estado El estado actual de la cita
     */
	public CitaDTO(Especialista especialista, Paciente paciente, Date fecha, String hora, int numeroCita, String estado) {
		super();
		this.especialista = especialista;
		this.paciente = paciente;
		this.fecha = fecha;
		this.hora = hora;
		this.numeroCita = numeroCita;
		this.estado = estado;
	}

	/**
     * Obtiene el especialista asignado a la cita.
     * 
     * @return El especialista asignado
     */
	public Especialista getEspecialista() {
		return especialista;
	}

	 /**
     * Establece el especialista asignado a la cita.
     * 
     * @param especialista El especialista a asignar
     */
	public void setEspecialista(Especialista especialista) {
		this.especialista = especialista;
	}

	 /**
     * Obtiene el paciente que asiste a la cita.
     * 
     * @return El paciente asignado
     */
	public Paciente getPaciente() {
		return paciente;
	}

	/**
     * Establece el paciente que asiste a la cita.
     * 
     * @param paciente El paciente a asignar
     */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	/**
     * Obtiene la fecha de la cita.
     * 
     * @return La fecha de la cita
     */
	public Date getFecha() {
		return fecha;
	}

	/**
     * Establece la fecha de la cita.
     * 
     * @param fecha La fecha a establecer
     */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
     * Obtiene la hora de la cita.
     * 
     * @return La hora de la cita
     */
	public String getHora() {
		return hora;
	}

	/**
     * Establece la hora de la cita.
     * 
     * @param hora La hora a establecer
     */
	public void setHora(String hora) {
		this.hora = hora;
	}

	 /**
     * Obtiene el número identificador de la cita.
     * 
     * @return El número de la cita
     */
	public int getNumeroCita() {
		return numeroCita;
	}

	/**
     * Establece el número identificador de la cita.
     * 
     * @param numeroCita El número de la cita a establecer
     */
	public void setNumeroCita(int numeroCita) {
		this.numeroCita = numeroCita;
	}

	/**
     * Obtiene el estado actual de la cita.
     * 
     * @return El estado de la cita
     */
	public String getEstado() {
		return estado;
	}

	 /**
     * Establece el estado actual de la cita.
     * 
     * @param estado El estado de la cita a establecer
     */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	 /**
     * Devuelve una representación en forma de cadena del objeto {@code CitaDTO}.
     * 
     * @return Una cadena que representa los detalles de la cita
     */
	@Override
	public String toString() {
		return "especialista = " + especialista + ", paciente = " + paciente + ", fecha = " + fecha + ", hora = " + hora
				+ ", numeroCita = " + numeroCita + ", estado = " + estado;
	}
}
