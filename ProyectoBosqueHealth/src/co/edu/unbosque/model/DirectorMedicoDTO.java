package co.edu.unbosque.model;

import java.util.Date;

public class DirectorMedicoDTO extends Persona{
	
private String nivelDirectivo;
	
	public DirectorMedicoDTO() {
		// TODO Auto-generated constructor stub
	}

	public DirectorMedicoDTO(String nivelDirectivo) {
		super();
		this.nivelDirectivo = nivelDirectivo;
	}

	public DirectorMedicoDTO(String nombre, Date fechaNacimiento, String genero, int id, String correo,
			String nivelDirectivo) {
		super(nombre, fechaNacimiento, genero, id, correo);
		this.nivelDirectivo = nivelDirectivo;
	}

	public DirectorMedicoDTO(String nombre, Date fechaNacimiento, String genero, int id, String correo) {
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
