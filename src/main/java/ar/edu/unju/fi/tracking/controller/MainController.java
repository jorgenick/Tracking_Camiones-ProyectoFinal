package ar.edu.unju.fi.tracking.controller;
//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tracking.model.Usuario;
import ar.edu.unju.fi.tracking.service.UsuarioServicelmp;
/**
 * Controlador principal para empezar a correr el proyecto
 * @author Gonzalez Brian L.
 *
 */
@Controller
@RequestMapping
public class MainController {

	@Autowired
	private UsuarioServicelmp usuarioService;
	
	@Autowired
	Usuario unUsuario;
	
	/**
	 *  
	 * @param model
	 * @return el nombre de la pagina a ejecutar
	 */
	@RequestMapping("/home")
	public String RegistroUsuario(Model model) {
		model.addAttribute("usuarioDelForm", unUsuario);
		return "index";
	}
		
	@GetMapping
	public String CargarFormulario(Model model) {
		model.addAttribute("usuarioDelForm", new Usuario());
		return "usuarioForm";
	}
	
	@PostMapping("/formulario")
	public String crearUsuario(@ModelAttribute("usuarioDelForm") Usuario usuario, ModelMap model) {
		try {
			usuarioService.crear(usuario);
			model.addAttribute("usuarioDelForm", new Usuario());
			model.addAttribute("listTab", "active");
		}catch (Exception d) {
			//excepciones del html
			model.addAttribute("formUsuarioErrorMessage",d.getMessage());
			model.addAttribute("userForm", usuario);
			model.addAttribute("formTab", "active");
		}
		return "listadoUser";
	}
}
