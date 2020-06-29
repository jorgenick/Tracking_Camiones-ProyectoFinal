package ar.edu.unju.fi.tracking.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.model.Usuario;
import ar.edu.unju.fi.tracking.service.ILocalidadService;
import ar.edu.unju.fi.tracking.service.IUsuarioService;

@Controller
@RequestMapping
public class UsuarioBDController {
	@Autowired
	IUsuarioService equipoService;
	
	@Autowired
	ILocalidadService localidadService;
	
	@Autowired
	private Usuario unUsuario;
	@Autowired
	private Localidad unaLocalidad;
	
	@RequestMapping("/usuarioBd")
	public String listaUsuariosLocalidades(Model model) {
		model.addAttribute("registroUsuario", unUsuario);
		model.addAttribute("registroLocalidad", unaLocalidad);
		List<Usuario> usuarios = equipoService.obtenerUsuarios();
		List<Localidad> localidades = localidadService.obtenerLocalidades();
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("localidades", localidades);		
		return "usuarioBD";
	}
	
	
	@RequestMapping("/usuarioBdU")
	public String listaUsuarios(Model model) {
		model.addAttribute("usuariosTab", "active");
		model.addAttribute("registroUsuario", unUsuario);
		model.addAttribute("registroLocalidad", unaLocalidad);
		List<Usuario> usuarios = equipoService.obtenerUsuarios();
		List<Localidad> localidades = localidadService.obtenerLocalidades();
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("localidades", localidades);		
		return "usuarioBD";
	}
	
	@RequestMapping("/usuarioBdL")
	public String listaLocalidad(Model model) {
		model.addAttribute("localidadesTab", "active");
		model.addAttribute("registroUsuario", unUsuario);
		model.addAttribute("registroLocalidad", unaLocalidad);
		List<Usuario> usuarios = equipoService.obtenerUsuarios();
		List<Localidad> localidades = localidadService.obtenerLocalidades();
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("localidades", localidades);		
		return "usuarioBD";
	}
	
//	Mapeo para guardar, editar y eliminar un Usuario
	@PostMapping("/saveUsuario")
	public String inicioUsuarioBD(@Valid Usuario usuario, Model model)
	{
		equipoService.guardarUsuario(usuario);
		return "redirect:/usuarioBdU";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Usuario> usuario = equipoService.obtenerUnUsuario(id);
		model.addAttribute("registroUsuario", usuario);
		return "editarUsuario";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		equipoService.eliminarUsuario(id);
		return "redirect:/usuarioBdU";
	}
	

//	Mapeo para guardar, editar y eliminar una Localidad
	@PostMapping("/saveLocalidad")
	public String inicioLocalidadBD(@Valid Localidad localidad,ModelMap model)
	{
		localidadService.guardarLocalidad(localidad);
		return "redirect:/usuarioBdL";
	}

	@GetMapping("/editarloc/{id}")
	public String editarLoc(@PathVariable Long id, Model model) {
		Optional<Localidad> localidad = localidadService.obtenerUnaLocalidad(id);
		model.addAttribute("registroLocalidad", localidad);
		return "editarLocalidad";
	}
	
	@GetMapping("/eliminarloc/{id}")
	public String eliminarLoc(@PathVariable Long id, Model model) {
		localidadService.eliminarLocalidad(id);
		return "redirect:/usuarioBdL";
	}
	
//	@PostMapping("/saveUsuario")
//	public String inicioUsuarioBD(@Valid @ModelAttribute("registroUsuario") Usuario usuario, BindingResult result, ModelMap model)
//	{
//		if (result.hasErrors()) {
//			// si da error el objeto recibido se vuelve a enviar a la vista
//			model.addAttribute("registroUsuario", usuario);
//			model.addAttribute("formularioTab", "active");
//
//		} else {
//				equipoService.guardarUsuario(usuario);	
//		}		
//		return "redirect:/usuarioBdU";
//	}	
	

}
