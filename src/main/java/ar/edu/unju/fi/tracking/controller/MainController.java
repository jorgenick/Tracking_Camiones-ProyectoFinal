/**
 * 
 */
package ar.edu.unju.fi.tracking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador principal para empezar a correr el proyecto
 * @author Gonzalez Brian L.
 *
 */

@Controller
public class MainController {

	/**
	 *  
	 * @param model
	 * @return el nombre de la pagina a ejecutar
	 */
	@RequestMapping("/home")
	public String main(Model model) {
		return "index";
	}

}
