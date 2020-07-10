package ar.edu.unju.fi.tracking.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.model.Tripulante;

import ar.edu.unju.fi.tracking.model.Vehiculo;
import ar.edu.unju.fi.tracking.service.ILocalidadService;
import ar.edu.unju.fi.tracking.service.IRegistroTrackingService;
import ar.edu.unju.fi.tracking.service.ITripulanteService;
import ar.edu.unju.fi.tracking.service.IVehiculoService;

/**
 * Controlador principal para empezar a correr el proyecto
 * @author Toconas Ulises.
 *
 */
@Controller
public class AltaController {

	@Autowired
	IVehiculoService iVehiculo; 
	
	@Autowired
	private Vehiculo vehiculo;
	
	private Vehiculo unVehiculo, patenteEncontrada;
	
	@Autowired
	ITripulanteService itripulanteservice;
	
	@Autowired
	private Tripulante tripulante;
	
	private Tripulante unTripulante, docEncotrado;
	
	@Autowired
	private List<Tripulante> losTripulantes;
	
	@Autowired
	ILocalidadService localidadservice;
	
	@Autowired
	private Localidad localidad;
	
	@Autowired
	IRegistroTrackingService registroservice;
	
	@Autowired
	private RegistroTracking registro;
	
	
	@RequestMapping("/home")
	public String RegistroVehiculo(Model model) {
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("tripulante", tripulante);
		model.addAttribute("registro", registro);
		model.addAttribute("listaVehiculos", iVehiculo.listarTodos());
		model.addAttribute("listaTripulantes", itripulanteservice.listarTodos());
		model.addAttribute("listaRegistros", registroservice.listarTodos());
		model.addAttribute("localidades", localidadservice.listarTodos());
		return "listadoDatos";
	}
		
	@RequestMapping("/nuevoRegistro")
	public String agregar(Model model) {
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("tripulante", tripulante);
		model.addAttribute("registro", registro);
		model.addAttribute("localidades", localidadservice.listarTodos());
		
		model.addAttribute("vehiculoPatente", vehiculo);//de la busqueda
		model.addAttribute("tripulante", tripulante);//de las busqueda
		return "Vehiculo";	
	}
	
	//probando con la pagina de nuevo tripu
	@RequestMapping("/tripulante")
	public String agregarTrip(Model model) {
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("tripulante", tripulante);
		model.addAttribute("registro", registro);
		model.addAttribute("localidades", localidadservice.listarTodos());
	return "Tripulante";	
	}
	
	//probando con la pagina para el registro
	@RequestMapping("/registro")
	public String agregarReg(Model model){
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("tripulante", tripulante);
		model.addAttribute("registro", registro);
		model.addAttribute("localidades", localidadservice.listarTodos());
	return "Registro";	
	}
	
	
	@RequestMapping("/encontrado")
	public String encontrado(Model model) {
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("tripulante", tripulante);
		model.addAttribute("registro", registro);
		model.addAttribute("localidades", localidadservice.listarTodos());
	return "PatEncontrado";	
	}
	
	
	//busqueda correcta
	@GetMapping("/patente")
	public String buscarPorPatente(@RequestParam String patente, Model model, @ModelAttribute("vehiculo") Vehiculo vehiculo) throws Exception {
		
			model.addAttribute("vehiculoPatente", iVehiculo.buscarPatente(patente));
			Vehiculo encontrado=iVehiculo.buscarPatente(patente).get(0);
			
			model.addAttribute("tripulante", tripulante);
			model.addAttribute("registro", registro);
	
			return "Vehiculo";	
	}
	
	//busqueda correcta
	@GetMapping("/documento")
	public String buscarPorDNI(@RequestParam String documento, Model model, @ModelAttribute("tripulante") Tripulante tripulante) throws Exception{
		model.addAttribute("listaDoc", itripulanteservice.buscarDocumento(documento));
		
		model.addAttribute("tripulante", tripulante);
		model.addAttribute("registro", registro);
		model.addAttribute("vehiculo", vehiculo);
	return "Tripulante";	
	}
	
	
	@GetMapping
	public String cargarFormulario(Model model) {
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("tripulante",  tripulante);
		model.addAttribute("localidad",  localidad);
		model.addAttribute("registro", registro);
		model.addAttribute("listaVehiculos", iVehiculo.listarTodos());
		model.addAttribute("listaTripulantes", itripulanteservice.listarTodos());
		model.addAttribute("listaRegistros", registroservice.listarTodos());
		model.addAttribute("localidades", localidadservice.listarTodos());
		model.addAttribute("formTab", "active");
	return "Vehiculo";
	}
	
	/**
	 * Formulario para guardar y dar de alta datos de un vehiculo
	 * @param vehiculo
	 * @param result
	 * @param model
	 * @return "redirect:/nuevoRegistro"
	 */
	@PostMapping("/formularioVehiculo")
	public String crearVehiculo(@Valid @ModelAttribute("vehiculo") Vehiculo vehiculo, BindingResult result, ModelMap model) {
	  if(result.hasErrors()) {
			model.addAttribute("userForm", vehiculo);
			model.addAttribute("formTab", "active");
	  }else {
		try {
			iVehiculo.guardar(vehiculo);
			unVehiculo=vehiculo;
		//	model.addAttribute("vehiculo", new Vehiculo());
		//	model.addAttribute("listTab", "active");
		}catch (Exception d) {
			//excepciones del html
			model.addAttribute("formUsuarioErrorMessage",d.getMessage());
			model.addAttribute("userForm", vehiculo);
			model.addAttribute("formTab", "active");
		}
		model.addAttribute("listaVehiculos", iVehiculo.listarTodos());
		model.addAttribute("listaTripulantes", itripulanteservice.listarTodos());
		model.addAttribute("listaRegistros", registroservice.listarTodos());
	//	model.addAttribute("listTab", "active");
	  }
	
		return "redirect:/tripulante";
	}
	
	
	/**
	 * Formulario para guardar y dar de alta varios tripulantes 
	 * @param tripulante
	 * @param result
	 * @param model
	 * @return "redirect:/nuevoRegistro"
	 */
	@PostMapping("/formularioTripu")
	public String crearTripulante(@Valid @ModelAttribute("tripulante") Tripulante tripulante, BindingResult result, ModelMap model) {
	  if(result.hasErrors()) {
		  model.addAttribute("userForm", tripulante);
		  model.addAttribute("formTab", "active");
	  }else {
		try {
			itripulanteservice.guardarTripulante(tripulante);
	    	unTripulante=tripulante;
			//	list=tripulante;
		//	losTripulantes.add(tripulante);
		//	list=(Tripulante) losTripulantes;//habria que probar
		//	model.addAttribute("tripulante", new Tripulante());
		//	model.addAttribute("listTab", "active");
		}catch (Exception d) {
			//excepciones del html
			model.addAttribute("formTripulanteErrorMessage",d.getMessage());
			model.addAttribute("userForm", tripulante);
			model.addAttribute("formTab", "active");
		}
		model.addAttribute("listaTripulantes", itripulanteservice.listarTodos());
		model.addAttribute("listaVehiculos", iVehiculo.listarTodos());
		model.addAttribute("listaRegistros", registroservice.listarTodos());
//		model.addAttribute("listTab", "active");
	  }	
		return "redirect:/registro";
	}
	
	
	/**
	 * Formulario para dar de alta un registro
	 * @param registro
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/formularioRegistro")
	public String cargarRegistro(@Valid @ModelAttribute("registro") RegistroTracking registro, BindingResult result, ModelMap model) {
	  if(result.hasErrors()) {
			  model.addAttribute("userForm", registro);
			  model.addAttribute("formTab", "active");
	  }else {		
		try {	
			iVehiculo.crear(unVehiculo);
			model.addAttribute("unVehiculo", new Vehiculo());
			
			registroservice.guardar(registro);
			model.addAttribute("registro", new RegistroTracking());
			
			itripulanteservice.crearTri(unTripulante);
			model.addAttribute("unTripulante", new Tripulante());
			
			model.addAttribute("listTab", "active");
		}catch (Exception d) {
			//excepciones del html
			model.addAttribute("formRTrackingErrorMessage",d.getMessage());
			model.addAttribute("userForm", registro);
			model.addAttribute("formTab", "active");
		}
		model.addAttribute("listaRegistros", registroservice.listarTodos());
		model.addAttribute("listaVehiculos", iVehiculo.listarTodos());
		model.addAttribute("listaTripulantes", itripulanteservice.listarTodos());
		model.addAttribute("localidades", localidadservice.listarTodos());
		model.addAttribute("listTab", "active");
	  }	
		return "listadoDatos";
	}
	
	//cancela la operacion de registrar con model
	@GetMapping("/registro/cancelar")
	public String cancelarRegistro(ModelMap model) {
		return "redirect:/nuevoRegistro";
	}
	
}
