/**
 * 
 */
package ar.edu.unju.fi.tracking.utils;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tracking.model.Localidad;

/**
 * Clase que representa un objecto de tipo consulta de registro 
 * @author Gonzalez Brian Leonel
 *
 */

@Component
public class ConsultaRegistro implements Serializable {

	/**
	 * Valor por defecto de serializable
	 */
	private static final long serialVersionUID = 1L;
	
	//----------------------- ATRIBUTOS -------------------
	
	/**
	 * Atributo que representa una localidad a consultar
	 */
	@Autowired
	private Localidad localidad;
	
	/**
	 * Artibuto que representa la fecha-hora desde donde consultar
	 */
	@DateTimeFormat( pattern = "dd/MM/yyyy" )
	private LocalDate fechaDesde;
	
	/**
	 * Atributo que representa la fecha-hora hasta donde consultar
	 */
	@DateTimeFormat( pattern = "dd/MM/yyyy" )
	private LocalDate fechaHasta;

	//--------------------- CONSTRUCTORES ------------------
	
	/**
	 * Constructor sin parametros
	 */
	public ConsultaRegistro() {
		// TODO Auto-generated constructor stub
	}
	
	//----------------------- TO STRING ----------------------
	
	@Override
	public String toString() {
		return "ConsultaVehiculo [localidad=" + localidad + ", fechaDesde=" + fechaDesde + ", fechaHasta="
				+ fechaHasta + "]";
	}

	//------------------- GETTERS AND SETTERS -------------------
	
	/**
	 * @return the localidad
	 */
	public Localidad getLocalidad() {
		return localidad;
	}

	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	/**
	 * @return the fechaHoraDesde
	 */
	public LocalDate getFechaDesde() {
		return fechaDesde;
	}

	/**
	 * @param fechaHoraDesde the fechaHoraDesde to set
	 */
	public void setFechaDesde(LocalDate fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	/**
	 * @return the fechaHoraHasta
	 */
	public LocalDate getFechaHasta() {
		return fechaHasta;
	}

	/**
	 * @param fechaHoraHasta the fechaHoraHasta to set
	 */
	public void setFechaHasta(LocalDate fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	

}
