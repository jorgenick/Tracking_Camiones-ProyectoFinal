package ar.edu.unju.fi.tracking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

//import org.springframework.stereotype.Component;

/**
 * Clase que permite representar el objeto de tipo Localidad
 * @author Jorge Tolaba
 */
/**
 * Para que la Clase Localidad sea administrada por el
 * contenedor de Spring agregamos la anotacion Component 
 * @author Jorge Tolaba
 */
@Component
@Entity
@Table(name="localidad")
public class Localidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;

	/**
	 * Atributo que representa el nombre de la localidad
	 */	
	@Column	
	private String nombre;
	
	@OneToOne(mappedBy = "localidad", fetch = FetchType.LAZY)
	private RegistroTracking registro;

	//------------METODOS CONSTRUCTORES--------------
	/**
	 * Constructor sin parametros
	 */
	public Localidad() {
	}
	//------------ACCESORES------------
	/**
	 * Devuelve el nombre de la localidad
	 * @return localidad
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Se asigna el nombre la localidad
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	/**
	 * @return the registro
	 */
	public RegistroTracking getRegistro() {
		return registro;
	}
	/**
	 * @param registro the registro to set
	 */
	public void setRegistro(RegistroTracking registro) {
		this.registro = registro;
	}
	//------------METODO TO STRING-------------
	@Override
	public String toString() {
		return "Localidad [nombre=" + nombre + "]";
	}
}