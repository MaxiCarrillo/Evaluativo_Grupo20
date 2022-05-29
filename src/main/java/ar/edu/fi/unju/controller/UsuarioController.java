package ar.edu.fi.unju.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.fi.unju.model.Usuario;
import ar.edu.fi.unju.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	@Qualifier("UsuarioServiceImpList")
	private IUsuarioService usuarioService;
	
	Log LOGGER = LogFactory.getLog(UsuarioController.class);
	
	@GetMapping("/cargar")
	public String cargarUsuario(Model model) {
		model.addAttribute("aliasUsuario", usuarioService.getUsuario());
		return "cargar_usuario";
	}
	
	@PostMapping("")
	public ModelAndView agregarUsuario(@Validated @ModelAttribute("aliasUsuario") Usuario usuario, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView modeloVista = new ModelAndView("cargar_usuario");
			modeloVista.addObject("aliasUsuario",usuario);
			return modeloVista;
		}
		
		ModelAndView modeloVista = new ModelAndView("redirect:/usuario/listausuarios");
		if(usuarioService.guardarUsuario(usuario)) {
			LOGGER.info("Se agregó el usuario: "+usuario.getNombre());
		}
		
		return modeloVista;
	}
	
	@GetMapping("/listausuarios")
	public String mostrarUsuarios(Model model) {
		usuarioService.calcularEdad();
		model.addAttribute("usuarios", usuarioService.getListaUsuario().getUsuarios());
		LOGGER.info("Se lista los usuarios");
		return "lista_usuarios";
	}
	
}
