package ar.edu.unju.fi.tracking.controller;
import java.util.List;

import javax.validation.Valid;

//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tracking.model.Tripulante;
//import ar.edu.unju.fi.model.Equipo;
//import ar.edu.unju.fi.tracking.model.Usuario;
import ar.edu.unju.fi.tracking.model.Vehiculo;
import ar.edu.unju.fi.tracking.service.ITripulanteService;
import ar.edu.unju.fi.tracking.service.IVehiculoService;
//import ar.edu.unju.fi.tracking.service.UsuarioServicelmp;
/**
 * Controlador principal para empezar a correr el proyecto
 * @author Gonzalez Brian L.
 *
 */
@Controller
public class MainController {

	@Autowired
	IVehiculoService iVehiculo; 
	
	@Autowired
	ITripulanteService itripulanteservice;
	
	@Autowired
	private Vehiculo vehiculo;
	
	@Autowired
	private Tripulante tripulante;
	

	@RequestMapping("/vehiculos")
	public String getVehiculoForm(Model model) {
		List<Vehiculo>vehiculos= iVehiculo.obtenerTodos();
		model.addAttribute("vehiculos", vehiculos);
	return "listadoDatos";	
	}
	
	
	@GetMapping("/nuevoVehiculo")
	public String crear(Model model) {
		model.addAttribute("vehiculo", vehiculo);
		return "Vehiculo";
	}
	
	@PostMapping("/save")
	public String guardar(@Valid Vehiculo vehiculo, Model model) {
		iVehiculo.crear(vehiculo);
		return "redirect:/vehiculos";
	}
	
	//tripulantes
	@RequestMapping("/tripulantes")
	public String getTripulanteForm(Model model) {
		List<Tripulante>tripulantes=itripulanteservice.obtenerTodos();
		model.addAttribute("tripulantes", tripulantes);
	return "listadoTripu";	
	}
	
	@GetMapping("/nuevoTripulante")
	public String crearTri(Model model) {
		model.addAttribute("tripulante", tripulante);
		return "Tripulantes";
	}
	
	@PostMapping("/save2")
	public String guardar(@Valid Tripulante tripulante, Model model) {
		itripulanteservice.guardar(tripulante);
		return "redirect:/tripulantes";
	}
	

//	@Autowired
//	private UsuarioServicelmp usuarioService;
	
//	@Autowired
//	Usuario unUsuario;
	
	/**
	 *  
	 * @param model
	 * @return el nombre de la pagina a ejecutar
	 */
/**	@RequestMapping("/home")
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
*/
}
