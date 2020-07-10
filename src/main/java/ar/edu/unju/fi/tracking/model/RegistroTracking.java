package ar.edu.unju.fi.tracking.model;

import java.time.LocalDateTime;
//import java.util.List;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

//import org.springframework.beans.factory.annotation.Autowired;
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
@Entity
@Table(name="RegistroTracking")
public class RegistroTracking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	/**
	 * Atributo que representa la fecha y hora del Registro
	 */
	@Column
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private LocalDateTime fecha;
	
	/**
	 * Atributo que representa el vehiculo del Registro
	 */
	/**
	 * Se utiliza la anotacion Autowired para realizar la inyeccion 
	 * dependencias
	 */
//	@Autowired
	@ManyToOne
	@JoinColumn(name="ID_VEHICULO")
	private Vehiculo vehiculo;
	/**
	 * Atributo que representa el listado de tripulantes del Registro
	 */
	/**
	 * Se utiliza la anotacion Autowired para realizar la inyeccion 
	 * dependencias
	 */

	
	//@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//List<Tripulante> tripulantes;
	
	
	@ManyToMany
	@JoinTable(name="registro_Tracking_tripulante",
	joinColumns=@JoinColumn(name="registroTracking_id"),
	inverseJoinColumns = @JoinColumn(name="tripulante_id"))
	 List<Tripulante> tripulantes;
	
	/**
	 * Atributo que representa la localidad del Registro
	 */
	/**
	 * Se utiliza la anotacion Autowired para realizar la inyeccion 
	 * dependencias
	 */
//	@Autowired
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="LOCALIDAD_ID")
	private Localidad localidad;
	
	/**
	 * Atributo que representa el detalle del Lugar del registro
	 */
	@Column
	@NotBlank(message = "Los detalles no debe quedar en blanco")
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
		public LocalDateTime getFecha() {
			return fecha;
		}

		public void setFecha(LocalDateTime fecha) {
			this.fecha = fecha;
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
				
		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}
		
		
		//*********METODO TO STRING*****************
		@Override
		public String toString() {
			return "RegistroTracking [fechaHora=" + fecha + ", vehiculo=" + vehiculo + ", localidad=" + localidad + ", detalleLugarRegistro=" + detalleLugarRegistro + "]";
		}
}
