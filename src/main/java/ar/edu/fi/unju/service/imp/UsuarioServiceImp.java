package ar.edu.fi.unju.service.imp;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.fi.unju.lista.ListaUsuario;
import ar.edu.fi.unju.model.Usuario;
import ar.edu.fi.unju.service.IUsuarioService;

@Service("UsuarioServiceImpList")
public class UsuarioServiceImp implements IUsuarioService {
	
	@Autowired
	private ListaUsuario listaUsuario;

	@Override
	public Usuario getUsuario() {
		return new Usuario();
	}

	@Override
	public ListaUsuario getListaUsuario() {
		return listaUsuario;
	}

	@Override
	public boolean guardarUsuario(Usuario usuario) {
		usuario.setCodigo(listaUsuario.getContador());
		listaUsuario.setContador(listaUsuario.getContador()+1);
		return listaUsuario.getUsuarios().add(usuario);
	}

	public void calcularEdad() {
		
		Period años;
		for (Usuario user : listaUsuario.getUsuarios()) {
			años=Period.between(user.getNacimiento(), LocalDate.now());
			user.setEdad(años.getYears());
		}
	}

}
