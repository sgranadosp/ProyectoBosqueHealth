package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;

public class Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private Date fechaNacimiento;
	private String genero;
	private int id;
	private String correo;
	
	public Persona() {
		
	}

	public Persona(String nombre, Date fechaNacimiento, String genero, int id, String correo) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.id = id;
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "nombre = " + nombre + ", fechaNacimiento = " + fechaNacimiento + ", genero = " + genero + ", id = "
				+ id + ", correo = " + correo;
	}
	
}
