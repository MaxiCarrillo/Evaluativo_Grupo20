package ar.edu.fi.unju.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class Candidato {

	@NotNull
	private int codigo;
	@NotEmpty(message="El nombre no puede estar vacio")
	private String nombre;
	private String generoMusical;
	@NotEmpty(message="La descripcion no puede estar vacia")
	private String descripcion;
	private int cantidadVotos;
	
	public Candidato() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGeneroMusical() {
		return generoMusical;
	}

	public void setGeneroMusical(String generoMusical) {
		this.generoMusical = generoMusical;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidadVotos() {
		return cantidadVotos;
	}

	public void setCantidadVotos(int cantidadVotos) {
		this.cantidadVotos = cantidadVotos;
	}

	public Candidato(@NotNull int codigo, @NotEmpty(message = "El nombre no puede estar vacio") String nombre,
			String generoMusical, @NotEmpty(message = "La descripcion no puede estar vacia") String descripcion,
			int cantidadVotos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.generoMusical = generoMusical;
		this.descripcion = descripcion;
		this.cantidadVotos = cantidadVotos;
	}
	
	
	
}
