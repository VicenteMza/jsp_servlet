package model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Usuario implements Serializable {

	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = -5513897237885402390L;
	
	private String nombre;
	private String apellido;
	private int dni;
	private LocalDate fechaNacimiento;
	private Profesion profesion;
	
	public Usuario() {
		this(null, null, -1, null, null);
	}
	
	public Usuario(String nombre, String apellido, int dni, LocalDate fechaNacimiento, Profesion p) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDni(dni);
		this.setFechaNacimiento(fechaNacimiento);
		this.setProfesion(p);
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Profesion getProfesion() {
		return profesion;
	}

	public void setProfesion(Profesion profesion) {
		this.profesion = profesion;
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"nombre='" + nombre + '\'' +
				", apellido='" + apellido + '\'' +
				", dni=" + dni +
				", fechaNacimiento=" + fechaNacimiento +
				", profesion=" + profesion +
				'}';
	}
}
