package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;

/**
 * La clase {@code DirectorMedico} representa a un director médico en un sistema de gestión hospitalaria.
 * Extiende la clase {@code Persona} y añade información específica del nivel directivo.
 * <p>
 * Implementa la interfaz {@code Serializable} para permitir la serialización de sus instancias.
 * </p>
 * 
 * @author Sebastian Perez Herrera
 * @version 1.0
 * @since 2024-11-10
 */
public class DirectorMedico extends Persona implements Serializable{
	
	/**
     * Identificador de versión para la serialización de la clase {@code Especialista}.
     */
    private static final long serialVersionUID = -1119936467395148006L;

    /**
	
	/** Nivel directivo del director médico (por ejemplo, "Alto", "Medio", "Bajo") */
    private String nivelDirectivo;

    /**
     * Constructor por defecto que crea una instancia de {@code DirectorMedico} sin inicializar los atributos.
     */
    public DirectorMedico() {
        // Constructor vacío
    }

    /**
     * Constructor que crea una instancia de {@code DirectorMedico} con el nivel directivo especificado.
     * 
     * @param nivelDirectivo El nivel directivo del director médico
     */
    public DirectorMedico(String nivelDirectivo) {
        super();
        this.nivelDirectivo = nivelDirectivo;
    }

    /**
     * Constructor que crea una instancia de {@code DirectorMedico} con los atributos de la clase {@code Persona}
     * y el nivel directivo.
     * 
     * @param nombre El nombre del director médico
     * @param fechaNacimiento La fecha de nacimiento del director médico
     * @param genero El género del director médico
     * @param id El identificador único del director médico
     * @param correo El correo electrónico del director médico
     * @param nivelDirectivo El nivel directivo del director médico
     */
	public DirectorMedico(String nombre, Date fechaNacimiento, String genero, int id, String correo,
			String nivelDirectivo) {
		super(nombre, fechaNacimiento, genero, id, correo);
		this.nivelDirectivo = nivelDirectivo;
	}

	 /**
     * Constructor que crea una instancia de {@code DirectorMedico} utilizando los atributos de la clase {@code Persona}.
     * 
     * @param nombre El nombre del director médico
     * @param fechaNacimiento La fecha de nacimiento del director médico
     * @param genero El género del director médico
     * @param id El identificador único del director médico
     * @param correo El correo electrónico del director médico
     */
	public DirectorMedico(String nombre, Date fechaNacimiento, String genero, int id, String correo) {
		super(nombre, fechaNacimiento, genero, id, correo);
		// TODO Auto-generated constructor stub
	}

	 /**
     * Obtiene el nivel directivo del director médico.
     * 
     * @return El nivel directivo del director médico
     */
	public String getNivelDirectivo() {
		return nivelDirectivo;
	}

	/**
     * Establece el nivel directivo del director médico.
     * 
     * @param nivelDirectivo El nivel directivo a establecer
     */
	public void setNivelDirectivo(String nivelDirectivo) {
		this.nivelDirectivo = nivelDirectivo;
	}
	
	/**
     * Devuelve una representación en forma de cadena del objeto {@code DirectorMedico}.
     * 
     * @return Una cadena que representa al director médico y su nivel directivo
     */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "nivel directivo = " + nivelDirectivo;
	}
}
