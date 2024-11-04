package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;

public class Cita implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4496922039651276720L;
	private Especialista especialista;
	private Paciente paciente;
	private Date fecha;
	private String hora;
	private int numeroCita;
	private String estado;
	
	public Cita() {
		
	}
	
	public Cita(Especialista especialista, Paciente paciente, Date fecha, String hora, int numeroCita, String estado) {
		super();
		this.especialista = especialista;
		this.paciente = paciente;
		this.fecha = fecha;
		this.hora = hora;
		this.numeroCita = numeroCita;
		this.estado = estado;
	}

	public Especialista getEspecialista() {
		return especialista;
	}

	public void setEspecialista(Especialista especialista) {
		this.especialista = especialista;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getNumeroCita() {
		return numeroCita;
	}

	public void setNumeroCita(int numeroCita) {
		this.numeroCita = numeroCita;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "especialista = " + especialista + ", paciente = " + paciente + ", fecha = " + fecha + ", hora = " + hora
				+ ", numeroCita = " + numeroCita + ", estado = " + estado;
	}
	
}
