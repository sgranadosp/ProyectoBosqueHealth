package co.edu.unbosque.model;

import java.util.Date;

public class TurnoDTO {

	private Especialista especialista;
	private Date fecha;
	private int numId;
	
	public TurnoDTO() {
		// TODO Auto-generated constructor stub
	}

	public TurnoDTO(Especialista especialista, Date fecha, int numId) {
		super();
		this.especialista = especialista;
		this.fecha = fecha;
		this.numId = numId;
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

	public int getNumId() {
		return numId;
	}

	public void setNumId(int numId) {
		this.numId = numId;
	}

	@Override
	public String toString() {
		return "especialista = " + especialista + ", fecha = " + fecha + ", numId = " + numId;
	}
}
