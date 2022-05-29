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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.fi.unju.model.Candidato;
import ar.edu.fi.unju.service.ICandidatoService;

@Controller
@RequestMapping("/candidato")
public class CandidatoController {

	@Autowired
	@Qualifier("CandidatoServiceImpList")
	private ICandidatoService candidatoService;
	
	Log LOGGER = LogFactory.getLog(CandidatoController.class);
	
	@GetMapping("/cargar")
	public String cargarCandidatos(Model model) {
		model.addAttribute("aliasCandidato", candidatoService.getCandidato());
		return "cargar_candidato";
	}
	
	@PostMapping("")
	public ModelAndView agregarCandidato(@Validated @ModelAttribute("aliasCandidato") Candidato candidato, BindingResult bindingResult) {
		if(bindingResult.hasErrors() || candidatoService.existeCandidato(candidato)) {
			ModelAndView modeloVista = new ModelAndView("cargar_candidato");
			modeloVista.addObject("aliasCandidato", candidato);
			modeloVista.addObject("banderaCodigo", candidatoService.existeCandidato(candidato));
			return modeloVista;
		}
		
		ModelAndView modeloVista = new ModelAndView("redirect:/candidato/listacandidatos");
		
		if(candidatoService.guardarCandidato(candidato)) {
			LOGGER.info("Se agregó el candidato: "+candidato.getNombre());
		}
		
		return modeloVista;
	}
	
	
	@GetMapping("/listacandidatos")
	public String mostrarCandidatos(Model model) {
		candidatoService.obtenerPorcentaje();
		model.addAttribute("candidatos", candidatoService.getListaCandidato().getCandidatos());
		model.addAttribute("votos", candidatoService.getListaCandidato().getTotalVotos());
		return "lista_candidatos";
	}
	
	
	@GetMapping("/editar/{codigo}")
	public ModelAndView editarCandidato(@PathVariable("codigo") int codigo){
		
		if(codigo!=0) {
			ModelAndView modeloVista = new ModelAndView("editar_candidato");
			Candidato candidato = candidatoService.buscarCanditato(codigo);
			modeloVista.addObject("aliasCandidato", candidato);
			return modeloVista;
		}
		
		ModelAndView modeloVista = new ModelAndView("redirect:/candidato/listacandidatos");
		return modeloVista;
		
	}
	
	@PostMapping("/modificar")
	public ModelAndView modificarCandidato(@Validated @ModelAttribute("aliasCandidato") Candidato candidato, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView modeloVista = new ModelAndView("editar_candidato");
			modeloVista.addObject("aliasCandidato", candidato);
			return modeloVista;
		}
		
		ModelAndView modeloVista = new ModelAndView("redirect:/candidato/listacandidatos");
		if(candidato.getCodigo()!=0) {
			candidatoService.modificarCandidato(candidato);
		}
		
		
		return modeloVista;
	}
	
	
	@GetMapping("/eliminar/{codigo}")
	public ModelAndView eliminarCandidato(@PathVariable("codigo") int codigo) {
		ModelAndView modeloVista = new ModelAndView("redirect:/candidato/listacandidatos");
		if(codigo!=0) {
			candidatoService.eliminarCandidato(codigo);
		}
		return modeloVista;
	}
	
}
