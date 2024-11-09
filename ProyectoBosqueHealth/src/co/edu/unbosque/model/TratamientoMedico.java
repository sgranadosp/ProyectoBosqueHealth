package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;

/**
 * La clase {@code TratamientoMedico} representa un tratamiento médico asignado a un paciente,
 * proporcionado por un especialista. Esta clase contiene la información sobre el paciente, 
 * el especialista, la fecha del tratamiento, los detalles del tratamiento, el examen realizado 
 * y el diagnóstico del paciente.
 * <p>
 * Esta clase implementa la interfaz {@code Serializable}, lo que permite que los objetos de
 * esta clase puedan ser convertidos en un formato que pueda ser almacenado o transferido.
 * </p>
 */
public class TratamientoMedico implements Serializable {
    
    /** ID de versión para la serialización */
    private static final long serialVersionUID = 8957258151037367330L;

    /** El paciente al que se le asigna el tratamiento */
    private Paciente paciente;

    /** El especialista que asigna el tratamiento al paciente */
    private Especialista especialista;

    /** La fecha en la que se realiza el tratamiento */
    private Date fecha;

    /** El tipo de tratamiento administrado al paciente */
    private String tratamiento;

    /** El examen médico realizado al paciente */
    private String examen;

    /** El diagnóstico realizado por el especialista */
    private String Diagnostico;

    /**
     * Constructor por defecto que inicializa un objeto {@code TratamientoMedico} sin atributos.
     */
    public TratamientoMedico() {
        // Constructor por defecto
    }

    /**
     * Constructor que inicializa un objeto {@code TratamientoMedico} con todos los detalles del tratamiento.
     * 
     * @param paciente     el paciente al que se le asigna el tratamiento
     * @param especialista el especialista que realiza el tratamiento
     * @param fecha        la fecha del tratamiento
     * @param tratamiento  el tipo de tratamiento administrado
     * @param examen       el examen realizado
     * @param diagnostico  el diagnóstico dado por el especialista
     */
    public TratamientoMedico(Paciente paciente, Especialista especialista, Date fecha, String tratamiento,
            String examen, String diagnostico) {
        super();
        this.paciente = paciente;
        this.especialista = especialista;
        this.fecha = fecha;
        this.tratamiento = tratamiento;
        this.examen = examen;
        Diagnostico = diagnostico;
    }

    /**
     * Obtiene el paciente asignado a este tratamiento.
     * 
     * @return el paciente asignado al tratamiento
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Establece el paciente para este tratamiento.
     * 
     * @param paciente el paciente a establecer
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * Obtiene el especialista que asignó el tratamiento.
     * 
     * @return el especialista que realizó el tratamiento
     */
    public Especialista getEspecialista() {
        return especialista;
    }

    /**
     * Establece el especialista para este tratamiento.
     * 
     * @param especialista el especialista a establecer
     */
    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    /**
     * Obtiene la fecha en la que se realizó el tratamiento.
     * 
     * @return la fecha del tratamiento
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en la que se realizó el tratamiento.
     * 
     * @param fecha la fecha del tratamiento a establecer
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el tipo de tratamiento asignado al paciente.
     * 
     * @return el tipo de tratamiento
     */
    public String getTratamiento() {
        return tratamiento;
    }

    /**
     * Establece el tipo de tratamiento asignado al paciente.
     * 
     * @param tratamiento el tratamiento a establecer
     */
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    /**
     * Obtiene el examen médico realizado al paciente.
     * 
     * @return el examen realizado
     */
    public String getExamen() {
        return examen;
    }

    /**
     * Establece el examen médico realizado al paciente.
     * 
     * @param examen el examen a establecer
     */
    public void setExamen(String examen) {
        this.examen = examen;
    }

    /**
     * Obtiene el diagnóstico realizado por el especialista.
     * 
     * @return el diagnóstico realizado
     */
    public String getDiagnostico() {
        return Diagnostico;
    }

    /**
     * Establece el diagnóstico realizado por el especialista.
     * 
     * @param diagnostico el diagnóstico a establecer
     */
    public void setDiagnostico(String diagnostico) {
        Diagnostico = diagnostico;
    }

    /**
     * Devuelve una representación en forma de cadena de los detalles del tratamiento médico.
     * 
     * @return una cadena con los detalles del tratamiento médico
     */
    @Override
    public String toString() {
        return "paciente = " + paciente + ", especialista = " + especialista + ", fecha = " + fecha
                + ", tratamiento = " + tratamiento + ", examen = " + examen + ", Diagnostico = " + Diagnostico;
    }
}