package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;

/**
 * La clase {@code Paciente} representa a un paciente dentro del sistema.
 * Extiende la clase {@code Persona} e implementa la interfaz {@code Serializable}
 * para permitir la serialización de sus objetos.
 * <p>
 * Un paciente tiene un tratamiento asociado, además de los atributos básicos de una persona.
 * </p>
 * 
 * @see Persona
 * @see Serializable
 */
public class Paciente extends Persona implements Serializable {

    /**
     * Identificador de versión para la serialización de la clase {@code Paciente}.
     */
    private static final long serialVersionUID = -7419566607824740315L;

    /**
     * Tratamiento asignado al paciente.
     */
    private String tratamiento;

    /**
     * Constructor por defecto que inicializa un objeto {@code Paciente} sin atributos.
     */
    public Paciente() {
        // Constructor por defecto
    }

    /**
     * Constructor que inicializa un objeto {@code Paciente} con un tratamiento.
     * 
     * @param tratamiento el tratamiento asignado al paciente
     */
    public Paciente(String tratamiento) {
        super();
        this.tratamiento = tratamiento;
    }

    /**
     * Constructor que inicializa un objeto {@code Paciente} con los atributos básicos
     * de una persona y un tratamiento.
     * 
     * @param nombre          el nombre del paciente
     * @param fechaNacimiento la fecha de nacimiento del paciente
     * @param genero          el género del paciente
     * @param id              el identificador único del paciente
     * @param correo          el correo electrónico del paciente
     * @param tratamiento     el tratamiento asignado al paciente
     */
    public Paciente(String nombre, Date fechaNacimiento, String genero, int id, String correo, String tratamiento) {
        super(nombre, fechaNacimiento, genero, id, correo);
        this.tratamiento = tratamiento;
    }

    /**
     * Constructor que inicializa un objeto {@code Paciente} con los atributos básicos 
     * de una persona, sin especificar el tratamiento.
     * 
     * @param nombre          el nombre del paciente
     * @param fechaNacimiento la fecha de nacimiento del paciente
     * @param genero          el género del paciente
     * @param id              el identificador único del paciente
     * @param correo          el correo electrónico del paciente
     */
    public Paciente(String nombre, Date fechaNacimiento, String genero, int id, String correo) {
        super(nombre, fechaNacimiento, genero, id, correo);
    }

    /**
     * Obtiene el tratamiento asignado al paciente.
     * 
     * @return el tratamiento del paciente
     */
    public String getTratamiento() {
        return tratamiento;
    }

    /**
     * Establece el tratamiento asignado al paciente.
     * 
     * @param tratamiento el tratamiento a establecer
     */
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto {@code Paciente},
     * incluyendo los atributos heredados de {@code Persona} y su tratamiento.
     * 
     * @return una cadena con los detalles del paciente
     */
    @Override
    public String toString() {
        return super.toString() + ", tratamiento = " + tratamiento;
    }
}
