package ar.edu.unju.fi.tracking.model;

import org.springframework.stereotype.Component;

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
public class Localidad {
/**
 * Atributo que representa el nombre de la localidad
 */
private String nombre;
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
//------------METODO TO STRING-------------
@Override
public String toString() {
	return "Localidad [nombre=" + nombre + "]";
}

}
