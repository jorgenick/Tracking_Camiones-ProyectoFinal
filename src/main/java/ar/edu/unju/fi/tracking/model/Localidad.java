package ar.edu.unju.fi.tracking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
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
@Entity
public class Localidad implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
/**
 * Atributo que representa el nombre de la localidad
 */
	@Column
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

//Agregados . . .

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
//------------METODO TO STRING-------------
@Override
public String toString() {
	return "Localidad [nombre=" + nombre + "]";
}

}
