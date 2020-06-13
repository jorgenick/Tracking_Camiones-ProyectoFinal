package ar.edu.unju.fi.tracking.repository;

import ar.edu.unju.fi.tracking.model.Localidad;

/**
 * Se implementa la interfaz para bajar el acomplamiento
 * entre capas y se definen metodos para luego utilizarlos
 * @author Toconas Ulises
 */
public interface ILocalidad {
	//metodo que permite guardar datos de tipo Localidad
	public void guardar();
	
	//metodo que muestra datos de tipo Localidad
	public Localidad mostrar();
	
	//metodo que elimina datos de tipo Localidad
	public void eliminar();
	
	//metodo que modifica datos de tipo Localidad
	public Localidad modificar();
}
