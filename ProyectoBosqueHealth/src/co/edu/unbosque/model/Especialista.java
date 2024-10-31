package co.edu.unbosque.model;

import java.util.Date;

public class Especialista extends Persona{
	
	private String especialidad;
	
	public Especialista() {
		// TODO Auto-generated constructor stub
	}

	public Especialista(String especialidad) {
		super();
		this.especialidad = especialidad;
	}

	public Especialista(String nombre, Date fechaNacimiento, String genero, int id, String correo,
			String especialidad) {
		super(nombre, fechaNacimiento, genero, id, correo);
		this.especialidad = especialidad;
	}

	public Especialista(String nombre, Date fechaNacimiento, String genero, int id, String correo) {
		super(nombre, fechaNacimiento, genero, id, correo);
		// TODO Auto-generated constructor stub
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+ ", especialidad = " + especialidad;
	}
}
