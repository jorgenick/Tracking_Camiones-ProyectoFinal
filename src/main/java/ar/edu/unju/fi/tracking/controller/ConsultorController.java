/**
 * 
 */
package ar.edu.unju.fi.tracking.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.service.IRegistroTrackingService;
import ar.edu.unju.fi.tracking.service.LocalidadServicelmp;
import ar.edu.unju.fi.tracking.service.RegistroTrackingServicelmp;
import ar.edu.unju.fi.tracking.utils.ConsultaRegistro;

//import ar.edu.unju.fi.tracking.service.RegistroTrackingServicelmp;

/**
 * Controlador de Usuario Consultor
 * @author Gonzalez Brian Leonel
 *
 */
@Controller
@RequestMapping
public class ConsultorController {

	//private RegistroTrackingServicelmp registroTrackingService;
	
	@Autowired
	private LocalidadServicelmp localidadServiceImp;
	
	@Autowired
	private RegistroTrackingServicelmp registroTrackingServiceImp;
	
	@Autowired
	private IRegistroTrackingService registroService;
	
	@Autowired
	private ConsultaRegistro consultaRegistro;

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
		//model.addAttribute("vehiculo", new Vehiculo());
		
		//envio la clase de consulta
		model.addAttribute("consulta", this.consultaRegistro);
		
		//todos los registros
		model.addAttribute("todosRegistros", registroTrackingServiceImp.obtenerRegistros());
		
		//lista con localidades guardadas
		model.addAttribute("localidades", localidadServiceImp.obtenerLocalidades());
		
		//desactivar losmensajes en esta vista
		model.addAttribute("activar", false);
		model.addAttribute("activarSinRegistro", false);
		
		return "consulta";
	}
	
	@PostMapping("/buscarPorLocalidadYRangoFechaHora")
	public String buscarPorLocalidadYRangoFechaHora(
				@Valid @ModelAttribute("consulta") ConsultaRegistro consultaRegistro, 
				Model model, BindingResult result
			) {
		
		model.addAttribute("activar", true);
		
		// se instancia una clase de tipo Localidad
		Localidad localidadBuscar = new Localidad();
		
		// se instancia una clase de tipo RegistroTracking
		List<RegistroTracking> registrosEncontrados = new ArrayList<RegistroTracking>();
		
		//envio la clase de consulta
		model.addAttribute("consulta", this.consultaRegistro);
		
		//lista con localidades guardadas
		model.addAttribute("localidades", localidadServiceImp.obtenerLocalidades());
		
		if(result.hasErrors() == false) {
			try {
				
				//buscar la localidad seleccionada anteriormente
				localidadBuscar = localidadServiceImp.buscarNombreLocalidad(consultaRegistro.getLocalidad().getNombre());
				
				//model.addAttribute("activar", true);
				model.addAttribute("verBuscado", consultaRegistro.getFechaDesde());
				model.addAttribute("mostrarLocalidad", localidadBuscar.getId());

					
				//buscar registros para la localidad encontrada y elrango de fechas seleccionado
				registrosEncontrados = registroTrackingServiceImp.buscarRegistrosRangoFechasYLocalidad(
							consultaRegistro.getFechaDesde(), consultaRegistro.getFechaHasta(), localidadBuscar);
				
				model.addAttribute("verReg", registrosEncontrados.get(0).getId());
				
				if(registrosEncontrados.isEmpty()) {
					//activar mensaje de sin registros
					model.addAttribute("activarSinRegistro", true);
					//enviar el mensaje
					model.addAttribute("registroVacio", "No se encontraron registros para el rango de fechas seleccionado");
				}
				
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return "consulta";
	}
	
	@GetMapping("/buscarPorPatente")
	public String buscarPorPatente(
				@RequestParam String patente, Model model, @ModelAttribute("registroTracking") RegistroTracking registroTrack 
			) {
		model.addAttribute("registrosPorPatene", registroService.buscarPorVehiculoPatente(patente));
		return "consulta";
	}
}
