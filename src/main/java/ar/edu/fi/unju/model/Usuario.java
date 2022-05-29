package ar.edu.fi.unju.model;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Usuario {
	
	int codigo;
	@NotEmpty(message="El nombre no puede estar vacio")
	private String nombre;
	@NotEmpty @Email
	private String mail;
	@Past
	@NotNull(message="La fecha no puede ser nula")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate nacimiento;
	private int edad;
	private int cantidadVotos;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String nombre, String mail, LocalDate nacimiento, int edad, int cantidadVotos) {
		super();
		this.nombre = nombre;
		this.mail = mail;
		this.nacimiento = nacimiento;
		this.edad = edad;
		this.cantidadVotos = cantidadVotos;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public LocalDate getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getCantidadVotos() {
		return cantidadVotos;
	}
	public void setCantidadVotos(int cantidadVotos) {
		this.cantidadVotos = cantidadVotos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
