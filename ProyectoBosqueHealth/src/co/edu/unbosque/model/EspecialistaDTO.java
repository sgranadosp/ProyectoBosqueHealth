package co.edu.unbosque.model;

import java.util.Date;

/**
 * La clase {@code EspecialistaDTO} es un objeto de transferencia de datos (DTO) que 
 * representa a un especialista con sus datos personales y su especialidad.
 * <p>
 * Esta clase extiende de {@code Persona} y se utiliza para transferir datos de un 
 * especialista entre diferentes capas de la aplicación.
 * </p>
 * 
 * @author Sebastian Perez Herrera
 * @version 1.0
 * @since 2024-11-10
 */
public class EspecialistaDTO extends Persona{

	 /**
     * Especialidad del especialista.
     */
    private String especialidad;

    /**
     * Constructor por defecto que inicializa un objeto {@code EspecialistaDTO} sin atributos.
     */
    public EspecialistaDTO() {
        // Constructor por defecto
    }

    /**
     * Constructor que inicializa un objeto {@code EspecialistaDTO} con una especialidad.
     * 
     * @param especialidad la especialidad del especialista
     */
    public EspecialistaDTO(String especialidad) {
        super();
        this.especialidad = especialidad;
    }

    /**
     * Constructor que inicializa un objeto {@code EspecialistaDTO} con los atributos básicos 
     * de una persona y una especialidad.
     * 
     * @param nombre          el nombre del especialista
     * @param fechaNacimiento la fecha de nacimiento del especialista
     * @param genero          el género del especialista
     * @param id              el identificador único del especialista
     * @param correo          el correo electrónico del especialista
     * @param especialidad    la especialidad del especialista
     */
    public EspecialistaDTO(String nombre, Date fechaNacimiento, String genero, int id, String correo, String especialidad) {
        super(nombre, fechaNacimiento, genero, id, correo);
        this.especialidad = especialidad;
    }

    /**
     * Constructor que inicializa un objeto {@code EspecialistaDTO} con los atributos básicos 
     * de una persona, sin especificar la especialidad.
     * 
     * @param nombre          el nombre del especialista
     * @param fechaNacimiento la fecha de nacimiento del especialista
     * @param genero          el género del especialista
     * @param id              el identificador único del especialista
     * @param correo          el correo electrónico del especialista
     */
    public EspecialistaDTO(String nombre, Date fechaNacimiento, String genero, int id, String correo) {
        super(nombre, fechaNacimiento, genero, id, correo);
    }

    /**
     * Obtiene la especialidad del especialista.
     * 
     * @return la especialidad del especialista
     */
	public String getEspecialidad() {
		return especialidad;
	}

	/**
     * Establece la especialidad del especialista.
     * 
     * @param especialidad la especialidad a establecer
     */
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	/**
     * Devuelve una representación en forma de cadena del objeto {@code EspecialistaDTO}, 
     * incluyendo los atributos heredados de {@code Persona} y su especialidad.
     * 
     * @return una cadena con los detalles del especialista
     */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+ ", especialidad = " + especialidad;
	}
}
