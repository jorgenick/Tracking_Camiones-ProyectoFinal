package ar.edu.unju.fi.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tracking.model.Vehiculo;
import ar.edu.unju.fi.tracking.service.VehiculoServicelmp;

@Controller
@RequestMapping
public class VehiculoController  {

	@Autowired
	private VehiculoServicelmp vehiculoService;
	
	//prueba
		@Autowired
		private Vehiculo unVehiculo;
		
		
		//prueba
		@RequestMapping("/vehiculo")
		public String RegistroVehiculo(Model model) {
			model.addAttribute("vehiculoDelForm", unVehiculo);
		return "Vehiculo";
		}
		
		//prueba aqui sin formulario
		@GetMapping("/formulario")
		public String cargarVehiculo(Model model) {
			model.addAttribute("vehiculoDelForm", new Vehiculo());
			return "vehiculoForm";
		}
		//aqui sin formulario
		@PostMapping("/formulario")
		public String crearVehiculo(@ModelAttribute("vehiculoDelForm") Vehiculo vehiculo, ModelMap model) {
			try {
				vehiculoService.crear(vehiculo);
				model.addAttribute("vehiculoDelForm", new Vehiculo());
				model.addAttribute("listTab", "active");
			}catch (Exception d) {
				//excepciones del html
				model.addAttribute("formUsuarioErrorMessage",d.getMessage());
				model.addAttribute("userForm", vehiculo);
				model.addAttribute("formTab", "active");
			}
			return "vehiculoForm";
		}
}
