package ar.edu.unju.fi.tracking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tracking.model.Usuario;
import ar.edu.unju.fi.tracking.service.ILocalidadService;
import ar.edu.unju.fi.tracking.service.IUsuarioService;

@Controller
@RequestMapping
public class MainController {
	@Autowired
	IUsuarioService equipoService;
	
	@Autowired
	ILocalidadService localidadService;
	
	@Autowired
	private Usuario unUsuario;

	
	@RequestMapping({"/","/login"})
	public String RegistroUsuario(Model model) {
		model.addAttribute("registroUsuario", unUsuario);
		return "index";
	}
	@PostMapping("/formulario")
	public String crearUsuario(@Valid @ModelAttribute("registroUsuario") Usuario usuario, BindingResult result, ModelMap model) {
		equipoService.guardarUsuario(usuario);
		model.addAttribute("registroUsuario", new Usuario());
		return "index";
	}
	
}
