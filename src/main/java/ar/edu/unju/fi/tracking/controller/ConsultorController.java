/**
 * 
 */
package ar.edu.unju.fi.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tracking.service.LocalidadServicelmp;

//import ar.edu.unju.fi.tracking.service.RegistroTrackingServicelmp;

/**
 * Controlador de Usuario Consultor
 * @author Gonzalez Brian Leonel
 *
 */
@Controller
public class ConsultorController {

	//private RegistroTrackingServicelmp registroTrackingService;
	
	@Autowired
	private LocalidadServicelmp localidadServiceImp;

	/**
	 * 
	 */
	public ConsultorController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/bienvenida")
	public String bienvenidaConsutor(Model model) {
		return "consultorInfo";
	}
	
	@GetMapping("/consulta")
	public String realizarConsultas(Model model) {
		model.addAttribute("localidades", localidadServiceImp.listarLocalidades());
		return "consulta";
	}
}
