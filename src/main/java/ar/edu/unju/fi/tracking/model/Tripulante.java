package ar.edu.unju.fi.tracking.model;

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
public class Tripulante {
	/**
	 * Atributo que representa el documento del Tripulante
	 */
	private String documento;
	/**
	 * Atributo que representa el apellido del Tripulante
	 */
	private String apellido;
	/**
	 * Atributo que representan los nombres del Tripulante
	 */
	private String nombres;
	/**
	 * Atributo que representa la nacionalidad del Tripulante
	 */
	private String nacionalidad;
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
	//*********METODO TO STRING*************
	@Override
	public String toString() {
		return "Tripulante [documento=" + documento + ", apellido=" + apellido + ", nombres=" + nombres
				+ ", nacionalidad=" + nacionalidad + "]";
	}
	
}
