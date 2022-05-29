package ar.edu.fi.unju.service;

import ar.edu.fi.unju.lista.ListaUsuario;
import ar.edu.fi.unju.model.Usuario;

public interface IUsuarioService {

	public Usuario getUsuario();
	public ListaUsuario getListaUsuario();
	public boolean guardarUsuario(Usuario usuario);
	public void calcularEdad();
	
}
