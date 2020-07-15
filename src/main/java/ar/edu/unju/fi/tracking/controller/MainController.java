package ar.edu.unju.fi.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ar.edu.unju.fi.tracking.service.IUsuarioService;

@Controller
@RequestMapping
public class MainController {
	@Autowired
	IUsuarioService equipoService;

	@GetMapping({"/","/login"})
	public String ingresar(Model model) {
		return "login";
	}
	
}

