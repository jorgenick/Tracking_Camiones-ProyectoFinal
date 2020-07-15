package ar.edu.unju.fi.tracking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.model.Vehiculo;
import ar.edu.unju.fi.tracking.service.LocalidadServicelmp;
import ar.edu.unju.fi.tracking.service.RegistroTrackingServicelmp;
import ar.edu.unju.fi.tracking.service.TripulanteServicelmp;
import ar.edu.unju.fi.tracking.service.VehiculoServicelmp;

/**
 * 
 * @author Brian's
 *
 */

@Controller
@RequestMapping
public class RegistradorController {
	
	@Autowired
	LocalidadServicelmp localidadServiceImp;
	
	@Autowired
	TripulanteServicelmp tripulanteServiceImp;
	
	@Autowired
	VehiculoServicelmp vehiculoService;
	
	@Autowired
	RegistroTrackingServicelmp registroTrackingserviceImp;
	
	@Autowired
	RegistroTracking unRegistroTracking;
	
	@Autowired
	Tripulante unTripulante;
	
	@Autowired
	Vehiculo unVehiculo;

	/**
	 * Este metodo permite crear un registro tracking, tanto buscar un tripulante, como agregarlo
	 * y de igual manera con un vehiculo
	 */
	@GetMapping("/registrar")
	public String crearRegistroTracking(Model model) {
		
		//List para almacenar el listado de las localidades
		List<Localidad> localidades = new ArrayList<Localidad>();
		
		//cargar el listado con las localidades
		localidades = localidadServiceImp.obtenerLocalidades();
		
		//enviar a la vista
		model.addAttribute("registroForm", this.unRegistroTracking);
		model.addAttribute("tripulanteForm", this.unTripulante);
		model.addAttribute("tripulantes", this.tripulanteServiceImp.buscarTodosTripulantes());
		model.addAttribute("vehiculos", this.vehiculoService.buscarVehiculoSeleccionado());
		model.addAttribute("vehiculoForm", this.unVehiculo);
		model.addAttribute("localidades", localidades);
		
		return "registroTracking";
	}
	
	/**
	 * Mapeo que permite guardar los datos de un registro en la BD
	 * @param registroTracking
	 * @param model
	 * @return
	 */
	@PostMapping("/agregarRegistro")
	public String crearRegistroTrackingFinal(@ModelAttribute("registroForm") RegistroTracking registroTracking, Model model) {
		
		//cargar datos añ registro
		registroTracking.setTripulantes(this.tripulanteServiceImp.buscarTodosTripulantes());
		
		registroTracking.setLocalidad(localidadServiceImp.buscarLocalidadPorNombre(registroTracking.getLocalidad().getNombre()));
		
		registroTracking.setVehiculo(this.vehiculoService.buscarVehiculoSeleccionado().get(0));
		
		try {
			
			//guardar el registro en la BD
			registroTrackingserviceImp.guardar(registroTracking);
			
		} catch (Exception e) {
			
			model.addAttribute("formTripulanteErrorMessage", e.getMessage());
		}
		
		//vaciar las listas
		tripulanteServiceImp.borrarTodosTripulantes();
		
		vehiculoService.borrarElVehiculoSeleccionado();
		
		return "redirect:/registrar";
	}

	/**
	 * Mapeo que permite agregar un nuevo tripulante a la BD, y lo carga en la lista de tripulantes seleccionados
	 * @param tripulante
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/agregarTripulante")
	public String crearTripulante(@ModelAttribute("tripulanteForm") Tripulante tripulante, Model model) throws Exception {
		
		try {
			
			this.tripulanteServiceImp.guardarTripu(tripulante);
			
		} catch (Exception e) {
			
			model.addAttribute("formTripulanteErrorMessage", e.getMessage());
		}
		
		return "redirect:/registrar";
	}
	
	/**
	 * Mapeo que permite buscar un tripulante en la BD,
	 * en el caso de que este se encuentre, se carga a una lista, que luego es almacenada en el registro
	 * @param tripulante
	 * @param model
	 * @return
	 */
	@PostMapping("/buscarTripulanteRegistrado")
	public String buscarTripulante(@ModelAttribute("tripulanteForm") Tripulante tripulante, Model model) {
		
		
		Tripulante tripulanteEncontrado = this.tripulanteServiceImp.buscarTripulanteDNI(tripulante.getDocumento());
			
		if( tripulanteEncontrado == null) {
			model.addAttribute("formTripulanteErrorMessage", "No se encontró el tripulante");
		} else {
			this.tripulanteServiceImp.guardarTripulanteEncontrado(tripulanteEncontrado);
		}
		
		return crearRegistroTracking(model);
	}
	
	/**
	 * Mapeo en el que se puede verificar la existencia de un vehiculo en la BD,
	 * si se lo encuentra, se carga en el registro
	 * @param vehiculo
	 * @param model
	 * @return
	 */
	@PostMapping("/buscarVehiculo")
	public String buscarVehiculo(@ModelAttribute("vehiculoForm") Vehiculo vehiculo, Model model) {
		
		//buscar vehiculo
		Vehiculo vehiculoEncontrado = new Vehiculo();
		vehiculoEncontrado = this.vehiculoService.buscarPatentePorNombre(vehiculo.getPatente());
		
		//verifico si se encontro el vehiculo
		if(vehiculoEncontrado != null) {
			
			this.vehiculoService.guardarVehiculoEncontrado(vehiculoEncontrado);
			
			
		} else {
			model.addAttribute("msgeNoVehiculo", "No se encontró el Vehiculo");
		}
		
		
		return crearRegistroTracking(model);
	} 
	
	/**
	 * Permite realizar el mapeo para agregar un vehiculo en la base de datos, y en la lista que mostrará
	 * el vehiculo cargado
	 * @param vehiculo
	 * @param model
	 * @return
	 */
	@PostMapping("/agregarVehiculo")
	public String agregarVehiculo( @ModelAttribute("vehiculoForm") Vehiculo vehiculo, Model model ) {
	
		//guardo el vehiculo en la lista y en la base de datos
		this.vehiculoService.guardarVehiculo(vehiculo);
		
		return "redirect:/registrar";
	}
	
	/**
	 * Realiza el mapeo en el caso que se desee cancelar el registro
	 * @return
	 */
	@GetMapping("/cancelar")
	public String cancelarRegistro() {
		
		//vaciar las listas cargadas
		tripulanteServiceImp.borrarTodosTripulantes();
		
		vehiculoService.borrarElVehiculoSeleccionado();
		
		return "redirect:/registrar";
	}

}
