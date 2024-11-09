package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;

/**
 * La clase {@code Turno} representa un turno asignado a un especialista para un paciente. 
 * Contiene la información sobre el especialista que atenderá el turno, la fecha en la que se llevará a cabo 
 * y un número de identificación único del turno.
 * <p>
 * Esta clase se utiliza para gestionar la asignación de turnos médicos en el sistema.
 * </p>
 */
public class Turno implements Serializable {

    /** El especialista asignado a este turno */
    private Especialista especialista;

    /** La fecha en la que se llevará a cabo el turno */
    private Date fecha;

    /** El número de identificación del turno */
    private int numId;

    /**
     * Constructor por defecto que inicializa un objeto {@code Turno} sin atributos.
     */
    public Turno() {
        // Constructor por defecto
    }

    /**
     * Constructor que inicializa un objeto {@code Turno} con los detalles del especialista, la fecha y el número de identificación.
     * 
     * @param especialista el especialista asignado al turno
     * @param fecha        la fecha en la que se realizará el turno
     * @param numId        el número de identificación único del turno
     */
    public Turno(Especialista especialista, Date fecha, int numId) {
        super();
        this.especialista = especialista;
        this.fecha = fecha;
        this.numId = numId;
    }

    /**
     * Obtiene el especialista asignado a este turno.
     * 
     * @return el especialista asignado al turno
     */
    public Especialista getEspecialista() {
        return especialista;
    }

    /**
     * Establece el especialista para este turno.
     * 
     * @param especialista el especialista a asignar al turno
     */
    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    /**
     * Obtiene la fecha en la que se realizará este turno.
     * 
     * @return la fecha del turno
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en la que se realizará este turno.
     * 
     * @param fecha la fecha del turno a asignar
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el número de identificación único del turno.
     * 
     * @return el número de identificación del turno
     */
    public int getNumId() {
        return numId;
    }

    /**
     * Establece el número de identificación único para este turno.
     * 
     * @param numId el número de identificación a asignar
     */
    public void setNumId(int numId) {
        this.numId = numId;
    }

    /**
     * Devuelve una representación en forma de cadena de los detalles del turno.
     * 
     * @return una cadena con la información del turno, incluyendo el especialista, la fecha y el número de identificación
     */
    @Override
    public String toString() {
        return "especialista = " + especialista + ", fecha = " + fecha + ", numId = " + numId;
    }
}