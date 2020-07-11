/**
 * 
 */
package ar.edu.unju.fi.tracking.utils;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * Clase que representa un objeto de tipo consulta de tripulante en el mundo real
 * 
 * Implementa la interfaz Serializable:
 * --> Para que un programa java pueda convertir un objeto en un montón de bytes y pueda luego recuperarlo, 
 * el objeto necesita ser Serializable. Al poder convertir el objeto a bytes, ese objeto se puede enviar a 
 * través de red, guardarlo en un fichero, y después reconstruirlo al otra lado de la red, leerlo del fichero,...
 * 
 * @author Gonzalez Brian Leonel
 *
 */

@Component
public class ConsultaTripulante implements Serializable {

	/**
	 * Valor por defecto de serializable
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * --------------- ATRIBUTOS --------------------
	 */
	
	/**
	 * Atributo que representa el dni de una persona
	 */
	private Long dni;
	

	/*
	 * -------------- CONSTRUCTORES ------------------
	 */
	
	/**
	 * Constructor sin parametros
	 */
	public ConsultaTripulante() {
		// TODO Auto-generated constructor stub
	}


	/*
	 * -------------- GETTERS AND SETTERS ---------------
	 */
	/**
	 * @return the dni
	 */
	public Long getDni() {
		return dni;
	}


	/**
	 * @param dni the dni to set
	 */
	public void setDni(Long dni) {
		this.dni = dni;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
