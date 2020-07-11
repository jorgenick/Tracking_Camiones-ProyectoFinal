/**
 * 
 */
package ar.edu.unju.fi.tracking.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import ar.edu.unju.fi.tracking.utils.ConsultaRegistro;
import ar.edu.unju.fi.tracking.utils.ConsultaTripulante;
import ar.edu.unju.fi.tracking.utils.ConsultaVehiculoPatente;

/**
 * Controlador de Usuario Consultor
 * 
 * @author Gonzalez Brian Leonel
 */

@Controller
@RequestMapping
public class ConsultorController {

	/*
	 * --------------- INSTANCIAR ---------------------
	 */
	
	/**
	 * Inyecta un objeto que implmenta un servicio de Localidad
	 */
	@Autowired
	private LocalidadServicelmp localidadServiceImp;

	/**
	 * Inyecta un objeto que implmenta un servicio de Registro Tracking
	 */
	@Autowired
	private RegistroTrackingServicelmp registroTrackingServiceImp;

	/**
	 * Inyecta un objeto que implmenta un servicio de Vehiculo
	 */
	@Autowired
	private VehiculoServicelmp vehiculoServiceImp;
	
	/**
	 * Inyecta un objeto usando un servicio de Tripulante
	 */
	@Autowired
	private TripulanteServicelmp tripulanteServiceImp;
	
	/**
	 * Inyecta un objeto que implmenta una clase de tipo ConsultaRegistro
	 */
	@Autowired
	private ConsultaRegistro consultaRegistro;
	
	/**
	 * Inyecta un objeto que implmenta una clase de tipo ConsultaTripulante
	 */
	@Autowired
	private ConsultaTripulante consultaTripulante;
	
	/**
	 * Inyecta un objeto que implmenta una clase de tipo ConsultaPatente
	 */
	@Autowired
	private ConsultaVehiculoPatente consultaPatente;
	
	/*
	 * ------------------ PATHS -----------------------
	 */
	
	/**
	 * Metodo del controlador para la Bienvenida al usuario
	 * @param model
	 * @return la pagina de bienvenida
	 */
	@RequestMapping("/bienvenida")
	public String bienvenidaConsutor(Model model) {
		
		return "consultorInfo";
	}

	/**
	 * Metodo controlador que permite mostrar la ventana para elegir la consulta a realizar
	 * @return la pagina de seleccion de consulta
	 */
	@RequestMapping("/seleccionConsulta")
	public String mostrarConsultas() {
		
		return "seleccionarConsulta";
	}
	
	/*
	 * --------------- BUSCAR POR LOCALIDAD Y RANGO DE FECHAS -------------------------
	 */
	/**
	 * Metodo controlador de ingreso a la pagina para ingresar los datos
	 * @param model
	 * @return
	 */
	@GetMapping("/ingresarLocalidadYFecha")
	public String ingresarLocaidadFecha(Model model) {
		
		// envio la clase de consulta
		model.addAttribute("consulta", this.consultaRegistro);

		// lista con localidades guardadas
		model.addAttribute("localidades", localidadServiceImp.obtenerLocalidades());

		// desactivar losmensajes en esta vista
		model.addAttribute("activar", false);
		model.addAttribute("activarSinRegistro", false);
		model.addAttribute("mensajeErr", false);
		model.addAttribute("activarRegLocFech", false);
				
		return "buscarLocalidad";
	}
	
	/**
	 * Metodo controlador de consultas post para buscar por localidad y un rango de
	 * fechas ingresado por el usuario
	 * 
	 * @param consultaRegistro datos que recibe desde la vista para realizar la
	 *                         busqueda
	 * @param model            interfaz de modelo
	 * @param result           interfaz de errores
	 * @return la vista html a enviar
	 */
	@PostMapping("/buscarPorLocalidadYRangoFechaHora")
	public String buscarPorLocalidadYRangoFechaHora(
			@Valid @ModelAttribute("consulta") ConsultaRegistro consultaRegistro, Model model, BindingResult result) {
		/*
		 * ------------- ENVIO DE DATOS A LA VISTA ----------------
		 */

		// envio la clase de consulta
		model.addAttribute("consulta", this.consultaRegistro);

		// envio de una clase Vehiculo
		model.addAttribute("vehiculo", new String());

		// lista con localidades guardadas
		model.addAttribute("localidades", localidadServiceImp.obtenerLocalidades());

		// todos los registros
		model.addAttribute("todosRegistros", registroTrackingServiceImp.obtenerRegistros());
		// model.addAttribute("activar", false);

		/*
		 * -------------- INSTANCIAR ELEMENTOS ---------------------
		 */

		// se instancia una clase de tipo Localidad
		Localidad localidadBuscar = new Localidad();

		// se instancia una clase de tipo RegistroTracking
		List<RegistroTracking> registrosEncontrados = new ArrayList<RegistroTracking>();

		/*
		 * ------------ EMPEZAR A VERIFICAR
		 */

		if (result.hasErrors() == false) {

			// verifico que fechaDesde sea antes que fechaHasta
			if (consultaRegistro.getFechaDesde().compareTo(consultaRegistro.getFechaHasta()) < 0) {

				model.addAttribute("activar", true);

				// buscar la localidad seleccionada anteriormente
				try {
					localidadBuscar = localidadServiceImp
							.buscarNombreLocalidad(consultaRegistro.getLocalidad().getNombre());
				} catch (Exception e) {
					e.printStackTrace();
				}

				// model.addAttribute("activar", true);
				model.addAttribute("verBuscado", consultaRegistro.getFechaDesde());
				model.addAttribute("mostrarLocalidad", localidadBuscar.getNombre());

				// buscar registros para la localidad encontrada y elrango de fechas
				// seleccionado
				registrosEncontrados = registroTrackingServiceImp.buscarRegistrosRangoFechasYLocalidad(
						consultaRegistro.getFechaDesde(), consultaRegistro.getFechaHasta(), localidadBuscar);

				// model.addAttribute("verReg", registrosEncontrados.get(0).getId());

				// verificar si se encontraron registros
				if (registrosEncontrados.isEmpty()) {

					// activar mensaje de sin registros
					model.addAttribute("activarSinRegistro", true);
					// enviar el mensaje
					model.addAttribute("registroVacio", "No se encontraron registros para el rango de fechas seleccionado");

				} else {

					model.addAttribute("activarRegLocFech", true);
					// enviar los registros encontrados a la vista
					model.addAttribute("registrosLocalidadFechas", registrosEncontrados);

				}

				return "buscarLocalidad";

			} else if (consultaRegistro.getFechaDesde().compareTo(consultaRegistro.getFechaHasta()) > 0) {

				// activo el mensaje de la vista
				model.addAttribute("mensajeErr", true);
				// mando el mensaje de error
				model.addAttribute("errorFecha",
						"¡ATENCIÓN!: La fecha inicial es mayor a la fecha final, intente nuevamente");

				return "buscarLocalidad";
			}

		} else {

			return "buscarLocalidad";
		}

		return "buscarLocalidad";
	}
	
	/*
	 * ---------------------- BUSCAR POR TRIPULANTE -----------------------
	 */
	
	/**
	 * Metodo de controller de consultas que envia la vista para consultar por Tripulante
	 * @param model
	 * @return
	 */
	@GetMapping("/ingresarTripulante")
	public String ingresarDNITipulante(Model model) {
		
		model.addAttribute("consultTrip", this.consultaTripulante);
		
		//desactivar el panel de error
		model.addAttribute("activarNoTripu", false);
		model.addAttribute("activarVerTripuBusc", false);
		model.addAttribute("activarSinReg", false);
		model.addAttribute("activarTabla", false);
		
		return "buscarTripulante";
	}
	
	/**
	 * Metodo de controller de consultas que recibe los datos a buscar por tripulante,
	 * y realiza la respectiva consulta y muestra los correspondientes mensajes
	 * @param consultaTripulante
	 * @param model
	 * @return
	 */
	@PostMapping("/buscarTripulante")
	public String buscarTripulante(@Valid @ModelAttribute("consultTrip") ConsultaTripulante consultaTripulante, Model model) {
		
		//enviar un objeto a la vista
		model.addAttribute("consultTrip", this.consultaTripulante);
		
		//instanciar un objeto de tipo Tripulante
		Tripulante tripulanteBusc = new Tripulante();
		
		//busco el DNI del tripulante
		tripulanteBusc = tripulanteServiceImp.buscarTripulanteDNI(consultaTripulante.getDni().toString());
		
		//verifico si esque se encontro el tripulante
		if(tripulanteBusc == null) {
			
			//activar el panel de error
			model.addAttribute("activarNoTripu", true);
			
			//enviar mensaje de no encontrado
			model.addAttribute("noTripu", "No se encontro la tripulante con DNI: " + consultaTripulante.getDni());
			
		} else {
			//tripuEncontrado
			model.addAttribute("activarVerTripuBusc", true);
			model.addAttribute("tripuEncontrado", tripulanteBusc);
			
			//instanciar un List que alamcenara registros
			List<RegistroTracking> registrosEnco = new ArrayList<RegistroTracking>();
			
			//buscar los registros para un tripulante
			registrosEnco = registroTrackingServiceImp.buscarPorTripulanteOrdenFecha(tripulanteBusc);
			
			//verificar si hay registros
			if(registrosEnco.isEmpty()) {
				
				//enviar mensaje correspondiente
				model.addAttribute("activarSinReg", true);
				model.addAttribute("msgSinTripu", "No se encontraron registros para el tripulante seleccionado");
				
			} else {
				
				//activar vista de registros
				model.addAttribute("activarTabla", true);
				
				//enviar registros encontrados
				model.addAttribute("registrosTrip", registrosEnco);
				
				
			}
			
		}
		
		return "buscarTripulante";
	}
	
	/*
	 * ----------------------- BUSCAR POR PATENTE ---------------------
	 */
	
	/**
	 * Metodo del controlador que permite ingresar los datosa buscar
	 * @param model modelo de la vista
	 * @return la pagina para realizar la consulta
	 */
	@GetMapping("/ingresarPatente")
	public String ingresarPatente(Model model) {
		
		model.addAttribute("consPatente", this.consultaPatente);
		model.addAttribute("activarNoPatente", false);
		model.addAttribute("activarSinRegistro", false);
		model.addAttribute("activarTabla", false);
		
		return "buscarPatente";
	}
	
	/**
	 * Metodo del controlador que permite realizar las consultas post y verificar los registros a buscar
	 * @param consultaPatente
	 * @param model
	 * @return
	 */
	@PostMapping("/buscarPatente")
	public String buscarPatente(@Valid @ModelAttribute("consPatente") ConsultaVehiculoPatente consultaPatente, Model model) {
		
		//enviar objeto a la vista
		model.addAttribute("consPatente", this.consultaPatente);
		
		// instancir una clase Vehiculo a buscar
		Vehiculo vehiculoBusc = new Vehiculo();

		// busco la patente en la base de datos
		vehiculoBusc = vehiculoServiceImp.buscarPatentePorNombre(consultaPatente.getPatente());
		
		//verificar si existe la patente en la BD
		if(vehiculoBusc == null) {
			
			//activar el panel de error
			model.addAttribute("activarNoPatente", true);
			
			//enviar mensaje de no encontrado
			model.addAttribute("noPatente", "No se encontro la patente: " + consultaPatente.getPatente());
			
		} else {
			
			//instanciar un objeto para guardar los registros encontrados
			List<RegistroTracking> registrosEncontrados = new ArrayList<RegistroTracking>();
			
			//guardar los registros encontrados
			registrosEncontrados = registroTrackingServiceImp.buscarPorPatenteOrdenFecha(vehiculoBusc);
			
			//verificar si se encontro u registro para la patente
			if(registrosEncontrados.isEmpty()) {
				
				//enviar mensaje de sin registros para la patente
				model.addAttribute("activarSinRegistro", true);
				model.addAttribute("sinRegistro", "No se han encontrado registros para la patente: " + consultaPatente.getPatente());
				
			} else {
				//activar tabla para ver registros
				model.addAttribute("activarTabla", true);
				//mostrar los registros encontrados
				model.addAttribute("registrosPatente", registrosEncontrados);
				
			}
			
		}
		
		return "buscarPatente";
	}
	
	/*
	 * ------------------------ MOSTRAR TODOS LOS REGISTROS -------------------------
	 */
	
	/**
	 * Metodo de controller que permite redireccionar a la pagina que muestra todos los registros guardados
	 * @param model
	 * @return
	 */
	@GetMapping("/verRegistros")
	public String mostrarRegistros(Model model) {
		
		model.addAttribute("activar", false);
		model.addAttribute("tabla", false);
		
		List<RegistroTracking> registros = new ArrayList<RegistroTracking>();
		
		registros = registroTrackingServiceImp.obtenerRegistros();
		
		if(registros.isEmpty()) {
			
			model.addAttribute("activar", true);
			model.addAttribute("alerta", "NO HAY REGISTROS");
			return "verRegistros";
			
		} else {
			model.addAttribute("tabla", true);
			model.addAttribute("registrosTracking", registros);
			return "verRegistros";
		}
		
	}
	
}