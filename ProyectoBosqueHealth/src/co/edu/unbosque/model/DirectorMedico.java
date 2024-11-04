package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;

public class DirectorMedico extends Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8823796857447526753L;
	private String nivelDirectivo;
	
	public DirectorMedico() {
		// TODO Auto-generated constructor stub
	}

	public DirectorMedico(String nivelDirectivo) {
		super();
		this.nivelDirectivo = nivelDirectivo;
	}

	public DirectorMedico(String nombre, Date fechaNacimiento, String genero, int id, String correo,
			String nivelDirectivo) {
		super(nombre, fechaNacimiento, genero, id, correo);
		this.nivelDirectivo = nivelDirectivo;
	}

	public DirectorMedico(String nombre, Date fechaNacimiento, String genero, int id, String correo) {
		super(nombre, fechaNacimiento, genero, id, correo);
		// TODO Auto-generated constructor stub
	}

	public String getNivelDirectivo() {
		return nivelDirectivo;
	}

	public void setNivelDirectivo(String nivelDirectivo) {
		this.nivelDirectivo = nivelDirectivo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "nivel directivo = " + nivelDirectivo;
	}
}
