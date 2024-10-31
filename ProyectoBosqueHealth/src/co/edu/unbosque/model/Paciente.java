package co.edu.unbosque.model;

import java.util.Date;

public class Paciente extends Persona {
	
	private String tratamiento;
	
	public Paciente() {
		
	}

	public Paciente(String tratamiento) {
		super();
		this.tratamiento = tratamiento;
	}

	public Paciente(String nombre, Date fechaNacimiento, String genero, int id, String correo, String tratamiento) {
		super(nombre, fechaNacimiento, genero, id, correo);
		this.tratamiento = tratamiento;
	}

	public Paciente(String nombre, Date fechaNacimiento, String genero, int id, String correo) {
		super(nombre, fechaNacimiento, genero, id, correo);
		// TODO Auto-generated constructor stub
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+ "tratamiento = " + tratamiento;
	}
}
