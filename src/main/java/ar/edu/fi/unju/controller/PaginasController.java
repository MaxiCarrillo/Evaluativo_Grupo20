package ar.edu.fi.unju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginasController {

	@GetMapping("/inicio")
	public String PaginaInicio(Model model) {
		return "index";
	}
	
}
