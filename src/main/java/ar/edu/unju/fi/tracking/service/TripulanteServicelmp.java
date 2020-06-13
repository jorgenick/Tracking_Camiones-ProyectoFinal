package ar.edu.unju.fi.tracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.repository.ITripulante;

/**
 * Esta clase ultiza la anotacion @Repository para manejar las instancias de los objetos  
 * de la clase e implementa los metodos de la interfaz ITripulanteService para poder
 * utilizarlos luego para manipular los datos 
 * @author Toconas Ulises
 */
@Repository
public class TripulanteServicelmp implements ITripulanteService {

	/**
	 * se implementa un atributo de tipo ITripulante
	 * y la anotacion @Autowired para la inyeccion de dependencia  
	 */
	@Autowired
	private ITripulante itripulante;
	
	/**
	 * metodo que con la anotacion @Override invoca metodos 
	 * de la capa repository
	 */
	@Override
	public void guardar() {
		//se invoca el metodo guardar de la interfaz para guardar los datos
		itripulante.guardar();
	}

	/**
	 * Metodo que contiene un atributo de tipo Tripulante
	 * y que con la anotacion @Override invoca el metodo para mostrar los datos
	 * @return tripulante
	 */
	@Override
	public Tripulante mostrar() {
		Tripulante tripulante=itripulante.mostrar();
		return tripulante;
	}

	/**
	 * metodo que con la anotacion @Override invoca metodos 
	 * de la capa repository
	 */
	@Override
	public void eliminar() {
		//se invoca el metodo eliminar de la interfaz para borrar datos
		itripulante.eliminar();
	}

	/**
	 * Metodo que contiene un atributo de tipo Tripulante
	 * y que con la anotacion @Override invoca el metodo para modificar los datos
	 * @return tripulante
	 */
	@Override
	public Tripulante modificar() {
		Tripulante tripulante=itripulante.modificar();
		return tripulante;
	}
}
