package ar.edu.fi.unju.model;

import java.time.LocalDate;

public class Usuario {
	
	private String nombre;
	private String mail;
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
	
	
}
