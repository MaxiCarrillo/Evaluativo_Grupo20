package ar.edu.fi.unju.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.fi.unju.service.ICandidatoService;
import ar.edu.fi.unju.service.IUsuarioService;

@Controller
@RequestMapping("/votar")
public class VotarController {
	
	@Autowired
	@Qualifier("CandidatoServiceImpList")
	private ICandidatoService candidatoService;
	
	@Autowired
	@Qualifier("UsuarioServiceImpList")
	private IUsuarioService usuarioService;
	
	Log LOGGER = LogFactory.getLog(VotarController.class);
	
	public int codigoUsuario;
	
	@GetMapping("")
	public String paginaMostrar(Model model) {
		model.addAttribute("usuarios",usuarioService.getListaUsuario().getUsuarios());
		return "elegir_usuario";
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView paginaVotar (@PathVariable("codigo") int codUsuario) {
		codigoUsuario = codUsuario;
		ModelAndView modeloVista = new ModelAndView("votar");
		modeloVista.addObject("aliasCandidatos", candidatoService.getListaCandidato().getCandidatos());
		return modeloVista;
	}
	
	@GetMapping("/candidato/{codigo}")
	public ModelAndView aplicarVoto(@PathVariable("codigo") int codCandidato){
		ModelAndView modeloVista = new ModelAndView("gracias");
		candidatoService.sumarVoto(codCandidato);
		usuarioService.sumarVoto(codigoUsuario);
		LOGGER.info("Se realizo una votacion por parte del usuario con el codigo "+codigoUsuario);
		return modeloVista;
	}
	
	@GetMapping("/listavotantes")
	public String mostrarVotantes(Model model) {
		model.addAttribute("usuarios",usuarioService.getListaUsuario().getUsuarios());
		LOGGER.info("Lista los votantes");
		return "lista_votantes";
	}
}
