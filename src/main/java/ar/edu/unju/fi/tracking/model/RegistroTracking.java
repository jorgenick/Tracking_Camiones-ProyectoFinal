package ar.edu.unju.fi.tracking.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * Clase que permite representar el objeto de tipo RegistroTracking
 * @author Jorge Tolaba
 */
/**
 * Para que la Clase RegistroTracking sea administrada por el
 * contenedor de Spring agregamos la anotacion Component 
 * @author Jorge Tolaba
 */
@Component
public class RegistroTracking {
	/**
	 * Atributo que representa la fecha y hora del Registro
	 */
	private LocalDateTime fechaHora;
	/**
	 * Atributo que representa el vehiculo del Registro
	 */
	/**
	 * Se utiliza la anotacion Autowired para realizar la inyeccion 
	 * dependencias
	 */
	@Autowired
	private Vehiculo vehiculo;
	/**
	 * Atributo que representa el listado de tripulantes del Registro
	 */
	/**
	 * Se utiliza la anotacion Autowired para realizar la inyeccion 
	 * dependencias
	 */
	@Autowired
	private List<Tripulante> tripulantes;
	/**
	 * Atributo que representa la localidad del Registro
	 */
	/**
	 * Se utiliza la anotacion Autowired para realizar la inyeccion 
	 * dependencias
	 */
	@Autowired
	private Localidad localidad;
	/**
	 * Atributo que representa el detalle del Lugar del registro
	 */
	private String detalleLugarRegistro;
	
	//------------METODOS CONSTRUCTORES--------------
		/**
		* Constructor sin parametros
		*/
		 public RegistroTracking() {
			// TODO Auto-generated constructor stub
		}
		//------------ACCESORES------------
		 /**
		  * Devuelve del Registro
		  * @return
		  */
		public LocalDateTime getFechaHora() {
			return fechaHora;
		}

		public void setFechaHora(LocalDateTime fechaHora) {
			this.fechaHora = fechaHora;
		}
		 /**
		  * Devuelve datos del vehiculo
		  * @return vehiculo
		  */
		public Vehiculo getVehiculo() {
			return vehiculo;
		}
		/**
		 * Se asigna datos del vehiculo al registro
		 * @param vehiculo
		 */
		public void setVehiculo(Vehiculo vehiculo) {
			this.vehiculo = vehiculo;
		}
		 /**
		  * Devuelve el listados de tripulantes 
		  * @return tripulantes
		  */
		public List<Tripulante> getTripulantes() {
			return tripulantes;
		}
		/**
		 * Se asigna el listado de Tripulantes
		 * @param tripulantes
		 */
		public void setTripulantes(List<Tripulante> tripulantes) {
			this.tripulantes = tripulantes;
		}
		 /**
		  * Devuelve la Localidad
		  * @return Localidad
		  */
		public Localidad getLocalidad() {
			return localidad;
		}
		/**
		 * Se asigna la localidad
		 * @param localidad
		 */
		public void setLocalidad(Localidad localidad) {
			this.localidad = localidad;
		}
		 /**
		  * Devuelve el detalle de Lugar del Registro
		  * @return detalle de Lugar de Registro
		  */
		public String getDetalleLugarRegistro() {
			return detalleLugarRegistro;
		}
		/**
		 * Se asignan los detalle de Lugar de Registro
		 * @param detalleLugarRegistro
		 */
		public void setDetalleLugarRegistro(String detalleLugarRegistro) {
			this.detalleLugarRegistro = detalleLugarRegistro;
		}
		//*********METODO TO STRING*****************
		@Override
		public String toString() {
			return "RegistroTracking [fechaHora=" + fechaHora + ", vehiculo=" + vehiculo + ", tripulantes="
					+ tripulantes + ", localidad=" + localidad + ", detalleLugarRegistro=" + detalleLugarRegistro + "]";
		}
}
