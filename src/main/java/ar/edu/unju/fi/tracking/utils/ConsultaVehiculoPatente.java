/**
 * 
 */
package ar.edu.unju.fi.tracking.utils;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * Clase que representa un elemento de mundo real de tipo consulta de un vehiculo por patente
 * 
 * Implementa la interfaz Serializable:
 * --> Para que un programa java pueda convertir un objeto en un montón de bytes y pueda luego recuperarlo, 
 * el objeto necesita ser Serializable. Al poder convertir el objeto a bytes, ese objeto se puede enviar a 
 * través de red, guardarlo en un fichero, y después reconstruirlo al otra lado de la red, leerlo del fichero,...
 * 
 * @author Gonzalez Brian leonel
 *
 */

@Component
public class ConsultaVehiculoPatente implements Serializable {

	/**
	 * Valor por defecto de serializable
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * -------------------- ATRIBUTOS --------------------
	 */
	
	/**
	 * Atributo que representa una patente de vehiculo
	 */
	private String patente;

	/*
	 * -------------------- CONSTRUCTORES ---------------------
	 */
	
	/**
	 * Constructor sin parametros
	 */
	public ConsultaVehiculoPatente() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * ------------------ GETTERS AND SETTERS -------------------
	 */

	/**
	 * @return the patente
	 */
	public String getPatente() {
		return patente;
	}

	/**
	 * @param patente the patente to set
	 */
	public void setPatente(String patente) {
		this.patente = patente;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
