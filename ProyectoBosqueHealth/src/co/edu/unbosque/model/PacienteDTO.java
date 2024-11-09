package co.edu.unbosque.model;

import java.util.Date;

/**
 * La clase {@code PacienteDTO} es un objeto de transferencia de datos (DTO) que 
 * representa a un paciente dentro del sistema.
 * <p>
 * Esta clase extiende de {@code Persona} y se utiliza para transferir datos 
 * de un paciente entre diferentes capas de la aplicación, como la capa de persistencia
 * y la capa de presentación.
 * </p>
 * 
 * @see Persona
 */
public class PacienteDTO extends Persona {

    /**
     * Tratamiento asignado al paciente.
     */
    private String tratamiento;

    /**
     * Constructor por defecto que inicializa un objeto {@code PacienteDTO} sin atributos.
     */
    public PacienteDTO() {
        
    }

    /**
     * Constructor que inicializa un objeto {@code PacienteDTO} con un tratamiento.
     * 
     * @param tratamiento el tratamiento asignado al paciente
     */
    public PacienteDTO(String tratamiento) {
        super();
        this.tratamiento = tratamiento;
    }

    /**
     * Constructor que inicializa un objeto {@code PacienteDTO} con los atributos básicos
     * de una persona y un tratamiento.
     * 
     * @param nombre          el nombre del paciente
     * @param fechaNacimiento la fecha de nacimiento del paciente
     * @param genero          el género del paciente
     * @param id              el identificador único del paciente
     * @param correo          el correo electrónico del paciente
     * @param tratamiento     el tratamiento asignado al paciente
     */
    public PacienteDTO(String nombre, Date fechaNacimiento, String genero, int id, String correo, String tratamiento) {
        super(nombre, fechaNacimiento, genero, id, correo);
        this.tratamiento = tratamiento;
    }

    /**
     * Constructor que inicializa un objeto {@code PacienteDTO} con los atributos básicos
     * de una persona, sin especificar el tratamiento.
     * 
     * @param nombre          el nombre del paciente
     * @param fechaNacimiento la fecha de nacimiento del paciente
     * @param genero          el género del paciente
     * @param id              el identificador único del paciente
     * @param correo          el correo electrónico del paciente
     */
    public PacienteDTO(String nombre, Date fechaNacimiento, String genero, int id, String correo) {
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
     * Devuelve una representación en forma de cadena del objeto {@code PacienteDTO},
     * incluyendo los atributos heredados de {@code Persona} y su tratamiento.
     * 
     * @return una cadena con los detalles del paciente
     */
    @Override
    public String toString() {
        return super.toString() + ", tratamiento = " + tratamiento;
    }
}
