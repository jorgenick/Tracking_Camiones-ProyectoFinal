package ar.edu.unju.fi.tracking.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import ar.edu.unju.fi.tracking.repository.ILocalidadDAO;
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
	private Vehiculo vehiculo, vehRecuperado;
	
	private Vehiculo unVehiculo, patenteEncontrada;
	
	@Autowired
	ITripulanteService itripulanteservice;
	
	@Autowired
	private Tripulante tripulante;
	
	@Autowired
	private Tripulante  docEncontrado;
	
	private List<Tripulante> losTripulantes=new ArrayList<Tripulante>();
	
	List<Tripulante> tripulantesAgregados = new ArrayList<Tripulante>();//del for
	
	@Autowired
	ILocalidadService localidadservice;
	
	@Autowired
	private Localidad localidad;
	
	@Autowired
	ILocalidadDAO local;//del repositorio
	
	@Autowired
	IRegistroTrackingService registroservice;
	
	@Autowired
	private RegistroTracking registro;
	
	@Autowired
	private RegistroTracking unregistro;
	
	
	@RequestMapping("/home")
	public String RegistroVehiculo(Model model) {
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("tripulante", tripulante);
		model.addAttribute("registro", registro);
		model.addAttribute("listaVehiculos", iVehiculo.listarTodos());
		model.addAttribute("listaTripulantes", itripulanteservice.listarTodos());
		model.addAttribute("listaRegistros", registroservice.listarTodos());
		model.addAttribute("localidades", localidadservice.listarTodos());
		return "registrador";
	}
		
	@RequestMapping("/nuevoRegistro")
	public String agregar(Model model) {
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("tripulante", tripulante);
		model.addAttribute("registro", registro);
		model.addAttribute("localidades", localidadservice.listarTodos());
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
	

		//probando la busqueda de la patente con el modal
				@PostMapping("/buscarPat")
				public String buscarPat(@ModelAttribute("vehiculo") Vehiculo vehiculo,  Model model) throws Exception {	
				try {
					Vehiculo patenteEncontrada=iVehiculo.encontrarPatente(vehiculo.getPatente());
					vehRecuperado=patenteEncontrada;
					model.addAttribute("GUARDAR", "true");
					model.addAttribute("siguiente", "false");
					model.addAttribute("vehiculo", vehiculo);
					model.addAttribute("registro", registro);
					model.addAttribute("tripulante", tripulante);
						try {			
							iVehiculo.guardarPatEncontrado(patenteEncontrada);
							model.addAttribute("vehiculo", vehiculo);
							model.addAttribute("registro", registro);
							model.addAttribute("tripulante", tripulante);
							System.out.println("patente lograda: "+patenteEncontrada.getId());
						} catch (Exception e) {
							// TODO Auto-generated catch block				 
							model.addAttribute("formPATErrorMessage", e.getMessage());
							model.addAttribute("vehiculo", vehiculo);
							model.addAttribute("registro", registro);
							model.addAttribute("tripulante", tripulante);
						}
					}catch(Exception e) {			
						model.addAttribute("formPATErrorMessage", e.getMessage());
					//	model.addAttribute("vehiculo", vehiculo);
						model.addAttribute("registro", registro);
						model.addAttribute("tripulante", tripulante);
					}			
				return "Vehiculo";
				//return "redirect:/tripulante";
			}
	
				
				//probando la busqueda del dni con el modal
				@PostMapping("/buscarDocumento")
				public String buscarDoc(@ModelAttribute("tripulante") Tripulante tripulante,  Model model) throws Exception {	
				try {
					Tripulante dniEncontrado = itripulanteservice.encontrarDni(tripulante.getDocumento());
					model.addAttribute("vehiculo", vehiculo);
					model.addAttribute("registro", registro);
					model.addAttribute("tripulante", dniEncontrado);//con esto mando para que se llene el formulario
					
					docEncontrado=dniEncontrado;//variable inyectada
					
					losTripulantes.add(dniEncontrado);//lista que contiene los tripulantes encontrados
					model.addAttribute("guardar", "true");
					model.addAttribute("agregar", "false");
					model.addAttribute("cancelar", "true");
					model.addAttribute("encontrado", docEncontrado);//el primero seria variable iba tripulante
					model.addAttribute("siguiente", "true");
					
					System.out.println("la variable tripuante: "+tripulante.getNombres());
						try {			
							itripulanteservice.guardarDNIEncontrado(dniEncontrado);
							model.addAttribute("vehiculo", vehiculo);
							model.addAttribute("registro", registro);
				
							System.out.println("persona encontrada: "+dniEncontrado.getApellido());
						} catch (Exception e) {
							// TODO Auto-generated catch block				 
							model.addAttribute("formDNIErrorMessage", e.getMessage());
							model.addAttribute("vehiculo", vehiculo);
							model.addAttribute("registro", registro);
							model.addAttribute("guardar", "false");
							model.addAttribute("agregar", "true");
						}
					}catch(Exception e) {			
						model.addAttribute("formDNIErrorMessage", e.getMessage());
						model.addAttribute("vehiculo", vehiculo);
						model.addAttribute("registro", registro);
						model.addAttribute("guardar", "false");
						model.addAttribute("agregar", "true");
				
					}			
				//return "otroTripulante";
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
	public String crearVehiculo( @ModelAttribute("vehiculo") Vehiculo vehiculo, ModelMap model) {
	 
		iVehiculo.guardar(vehiculo);
		unVehiculo=vehiculo;
		
		model.addAttribute("listaVehiculos", iVehiculo.listarTodos());
		model.addAttribute("listaTripulantes", itripulanteservice.listarTodos());
		model.addAttribute("listaRegistros", registroservice.listarTodos());
	
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
	public String crearTripulante(@ModelAttribute("tripulante") Tripulante tripulante, ModelMap model) {
	
		itripulanteservice.guardarTripulante(tripulante);
	  
		model.addAttribute("listaTripulantes", itripulanteservice.listarTodos());
		model.addAttribute("listaVehiculos", iVehiculo.listarTodos());
		model.addAttribute("listaRegistros", registroservice.listarTodos());

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
	public String cargarRegistro(@ModelAttribute("registro") RegistroTracking registro, ModelMap model) {
	 
		//<<<<<<VEHICULO>><<<
		System.out.println("el id del vehiculo encontrado es "+vehRecuperado.getId());
		if(vehRecuperado.getId()==null)	{
			iVehiculo.crear(unVehiculo);//se da de alta el vehiculo guardado en la variable
			registro.setVehiculo(unVehiculo);//se setea con el registro el vehiculo guardado(de marcia)
		}else {	
			registro.setVehiculo(vehRecuperado);
		}

		model.addAttribute("unVehiculo", new Vehiculo());
		
		
		//<<<<<TRIPULANTES<<<<<<<<		
		System.out.println("el tamaño de encontrados: "+losTripulantes.size());
		
		losTripulantes = itripulanteservice.listarTripulantesAgregados();//se lista los tripulantes del registro
		System.out.println(" tamaño lista recuperada: "+tripulantesAgregados.size());//cantidad de tripulantes en lista
		
		List<Tripulante> general= new ArrayList<Tripulante>();
		boolean enc=false;
			
		for(Tripulante tripu : losTripulantes) {
			enc=false;
			for(Tripulante base : itripulanteservice.listarTodos()) {
					if(tripu.getDocumento().equals(base.getDocumento())) {
							enc=true;
					}
				}	
				 if(enc==false) {
					 itripulanteservice.crearTri(tripu); 
					 general.add(tripu);
				 }
				 if(enc==true) {
					 general.add(tripu);
				 }
			}
			
		registro.setTripulantes(general);		
		model.addAttribute("unTripulante", new Tripulante());
		
		
		///<<<<<LOCALIDAD<<>>>
		System.out.println("EL ID de la localidad seleccionada es: "+registro.getLocalidad().getId());//muestra id de la localidad seleccionada
		Optional<Localidad> unaLocal =local.findById(registro.getLocalidad().getId());//con la varible del repositorio y el findById busco el nombre de localidad
	
		unaLocal.ifPresent(localidad -> {//obtengo el nombre de localidad y lo seteo
		    registro.setLocalidad(localidad);
		});
	
		System.out.println("nombre de la localidad obtenida: "+localidad);
			
		
			
			///<<<<<<<<<REGISTRO>>><<<<<
		System.out.println("registroTracking: "+registro);
		registro.setFecha(LocalDateTime.now());
		registroservice.guardar(registro);//da de alta el regitro completo
		
		model.addAttribute("registro", new RegistroTracking());
		model.addAttribute("listTab", "active");
		
		unregistro=registro;//le asigno el registro entero a una variable
		
		//vaciar las listas y variables
		losTripulantes.clear();
		System.out.println("ya guardados "+losTripulantes.size());
		tripulantesAgregados.clear(); 
		System.out.println("los creados "+tripulantesAgregados.size());
		
	//	registro=null;//vacio la variable registro
	//	vehRecuperado=null;//vehiculo encontrado
	//	unVehiculo=null;//variable para crear
					
		model.addAttribute("listaRegistros", registroservice.listarTodos());
		model.addAttribute("listaVehiculos", iVehiculo.listarTodos());
		model.addAttribute("listaTripulantes", itripulanteservice.listarTodos());
		model.addAttribute("localidades", localidadservice.listarTodos());
		model.addAttribute("listTab", "active");
	  
		return "terminado";
	}
	
	
	//vista del registro resien cargado
			@RequestMapping("/cargado")
			public String registroCargado(Model model) {
				model.addAttribute("idRegistro", unregistro.getId());
				model.addAttribute("vehiculoRegistro", unregistro.getVehiculo());
				model.addAttribute("tripRegistro", unregistro.getTripulantes());
				model.addAttribute("locRegistro", unregistro.getLocalidad());
				model.addAttribute("fechaRegistro", unregistro.getFecha());
				model.addAttribute("detRegistro", unregistro.getDetalleLugarRegistro());
				model.addAttribute("todo", unregistro);
			return "terminado";	
			}
	
	
	//cancela la operacion de registrar con model
	@GetMapping("/registro/cancelar")
	public String cancelarRegistro(ModelMap model) {
		return "redirect:/nuevoRegistro";
	}
	
}
