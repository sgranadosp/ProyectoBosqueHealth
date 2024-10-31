package co.edu.unbosque.model;

import java.util.Date;

public class EspecialistaDTO extends Persona{

private String especialidad;
	
	public EspecialistaDTO() {
		// TODO Auto-generated constructor stub
	}

	public EspecialistaDTO(String especialidad) {
		super();
		this.especialidad = especialidad;
	}

	public EspecialistaDTO(String nombre, Date fechaNacimiento, String genero, int id, String correo,
			String especialidad) {
		super(nombre, fechaNacimiento, genero, id, correo);
		this.especialidad = especialidad;
	}

	public EspecialistaDTO(String nombre, Date fechaNacimiento, String genero, int id, String correo) {
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
