package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;

/**
 * La clase {@code Persona} representa los atributos básicos de una persona dentro del sistema.
 * Esta clase es la superclase de otras clases que heredan estos atributos, como {@code Paciente} o {@code Especialista}.
 * <p>
 * La clase incluye los atributos comunes a una persona, tales como nombre, fecha de nacimiento, 
 * género, identificación y correo electrónico.
 * </p>
 */
public class Persona implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -5530354979153613199L;

	/** Nombre de la persona. */
    private String nombre;

    /** Fecha de nacimiento de la persona. */
    private Date fechaNacimiento;

    /** Género de la persona. */
    private String genero;

    /** Identificador único de la persona. */
    private int id;

    /** Correo electrónico de la persona. */
    private String correo;

    /**
     * Constructor por defecto que inicializa una persona sin atributos.
     */
    public Persona() {
        // Constructor por defecto
    }

    /**
     * Constructor que inicializa una persona con los atributos proporcionados.
     * 
     * @param nombre          el nombre de la persona
     * @param fechaNacimiento la fecha de nacimiento de la persona
     * @param genero          el género de la persona
     * @param id              el identificador único de la persona
     * @param correo          el correo electrónico de la persona
     */
    public Persona(String nombre, Date fechaNacimiento, String genero, int id, String correo) {
        super();
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.id = id;
        this.correo = correo;
    }

    /**
     * Obtiene el nombre de la persona.
     * 
     * @return el nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     * 
     * @param nombre el nombre a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     * 
     * @return la fecha de nacimiento de la persona
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     * 
     * @param fechaNacimiento la fecha de nacimiento a establecer
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el género de la persona.
     * 
     * @return el género de la persona
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género de la persona.
     * 
     * @param genero el género a establecer
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el identificador único de la persona.
     * 
     * @return el identificador de la persona
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único de la persona.
     * 
     * @param id el identificador a establecer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el correo electrónico de la persona.
     * 
     * @return el correo electrónico de la persona
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico de la persona.
     * 
     * @param correo el correo electrónico a establecer
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Devuelve una representación en forma de cadena de los atributos de la persona.
     * 
     * @return una cadena con los detalles de la persona
     */
    @Override
    public String toString() {
        return "nombre = " + nombre + ", fechaNacimiento = " + fechaNacimiento + ", genero = " + genero + ", id = "
                + id + ", correo = " + correo;
    }
}