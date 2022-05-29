package ar.edu.fi.unju.lista;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.fi.unju.model.Usuario;

@Component
public class ListaUsuario {

	private ArrayList<Usuario> usuarios;
	private int contador;
	
	public ListaUsuario() {
		// TODO Auto-generated constructor stub
		usuarios = new ArrayList<Usuario>();
		contador = 0;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public ListaUsuario(ArrayList<Usuario> usuarios) {
		super();
		this.usuarios = usuarios;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
	
	
}
