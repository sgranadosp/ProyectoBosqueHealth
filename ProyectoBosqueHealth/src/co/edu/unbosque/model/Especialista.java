package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;

/**
 * La clase {@code Especialista} representa a un profesional especializado en un área determinada.
 * Esta clase extiende de la clase {@code Persona} e implementa la interfaz {@code Serializable}
 * para permitir la serialización de sus objetos.
 * <p>
 * Un especialista tiene una especialidad, además de las características básicas de una persona.
 * </p>
 * 
 * @author Sebastian Perez Herrera
 * @version 1.0
 * @since 2024-11-10
 */
public class Especialista extends Persona implements Serializable{
	
	/**
     * Identificador de versión para la serialización de la clase {@code Especialista}.
     */
    private static final long serialVersionUID = -1119936467395148006L;

    /**
     * Especialidad del especialista.
     */
    private String especialidad;

    /**
     * Constructor por defecto que inicializa un especialista sin atributos.
     */
    /**
     * Constructor que inicializa un especialista con una especialidad.
     * 
     * @param especialidad la especialidad del especialista
     */
    public Especialista(String especialidad) {
        super();
        this.especialidad = especialidad;
    }

    /**
     * Constructor que inicializa un especialista con los atributos básicos de una persona 
     * y una especialidad.
     * 
     * @param nombre          el nombre del especialista
     * @param fechaNacimiento la fecha de nacimiento del especialista
     * @param genero          el género del especialista
     * @param id              el identificador único del especialista
     * @param correo          el correo electrónico del especialista
     * @param especialidad    la especialidad del especialista
     */
    public Especialista(String nombre, Date fechaNacimiento, String genero, int id, String correo, String especialidad) {
        super(nombre, fechaNacimiento, genero, id, correo);
        this.especialidad = especialidad;
    }

    /**
     * Constructor que inicializa un especialista con los atributos básicos de una persona,
     * pero sin especificar la especialidad.
     * 
     * @param nombre          el nombre del especialista
     * @param fechaNacimiento la fecha de nacimiento del especialista
     * @param genero          el género del especialista
     * @param id              el identificador único del especialista
     * @param correo          el correo electrónico del especialista
     */
    public Especialista(String nombre, Date fechaNacimiento, String genero, int id, String correo) {
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
     * Devuelve una representación en forma de cadena del especialista, 
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
