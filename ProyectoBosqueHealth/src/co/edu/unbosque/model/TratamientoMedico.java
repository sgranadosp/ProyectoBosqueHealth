package co.edu.unbosque.model;

import java.util.Date;

public class TratamientoMedico {
	
	private Paciente paciente;
	private Especialista especialista;
	private Date fecha;
	private String tratamiento;
	private String examen;
	private String Diagnostico;
	
	public TratamientoMedico() {
		// TODO Auto-generated constructor stub
	}

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

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Especialista getEspecialista() {
		return especialista;
	}

	public void setEspecialista(Especialista especialista) {
		this.especialista = especialista;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public String getExamen() {
		return examen;
	}

	public void setExamen(String examen) {
		this.examen = examen;
	}

	public String getDiagnostico() {
		return Diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		Diagnostico = diagnostico;
	}

	@Override
	public String toString() {
		return "paciente = " + paciente + ", especialista = " + especialista + ", fecha = " + fecha
				+ ", tratamiento = " + tratamiento + ", examen = " + examen + ", Diagnostico = " + Diagnostico;
	}
	
}
