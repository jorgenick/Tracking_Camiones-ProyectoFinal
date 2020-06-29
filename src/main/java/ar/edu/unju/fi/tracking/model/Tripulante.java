package ar.edu.unju.fi.tracking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Clase que permite representar el objeto de tipo Tripulante
 * @author Jorge Tolaba
 */
/**
 * Para que la Clase Tripulante sea administrada por el
 * contenedor de Spring agregamos la anotacion Component 
 * @author Jorge Tolaba
 */
@Component
@Entity
@Table(name="tripulantes")
public class Tripulante implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Long id;

	/**
	 * Atributo que representa el documento del Tripulante
	 */
	@Column
	private String documento;
	/**
	 * Atributo que representa el apellido del Tripulante
	 */
	@Column
	private String apellido;
	/**
	 * Atributo que representan los nombres del Tripulante
	 */
	@Column
	private String nombres;
	/**
	 * Atributo que representa la nacionalidad del Tripulante
	 */
	@Column
	private String nacionalidad;
	
	@Autowired
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name = "VEHICULO_ID")
	private Vehiculo vehiculo;
	
	
//------------METODOS CONSTRUCTORES--------------
	/**
	 * Constructor sin parametros
	 */
	public Tripulante() {
		
	}
	//------------ACCESORES------------
	/**
	 * Devuelve el documento del Tripulante
	 * @return
	 */
	public String getDocumento() {
		return documento;
	}
	/**
	 * Se asigna el documento del Tripulante
	 * @param documento
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	/**
	 * Devuelve el apellido del Tripulante
	 * @return apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * Se asigna el apellido del Tripulante
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * Devuelve los nombres del Tripulante
	 * @return nombres
	 */
	public String getNombres() {
		return nombres;
	}
	/**
	 * Se asignan los nombres del Tripulante
	 * @param nombres
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	/**
	 * Devuelve la nacionalidad del Tripulante
	 * @return nacionalidad
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}
	/**
	 * Se asigna la nacionalidad del Tripulante
	 * @param nacionalidad
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
//	agregados
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	//*********METODO TO STRING*************
	@Override
	public String toString() {
		return "Tripulante [documento=" + documento + ", apellido=" + apellido + ", nombres=" + nombres
				+ ", nacionalidad=" + nacionalidad + "]";
	}
	
}
