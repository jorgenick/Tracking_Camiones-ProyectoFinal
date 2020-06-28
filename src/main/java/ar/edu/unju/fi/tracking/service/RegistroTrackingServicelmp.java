package ar.edu.unju.fi.tracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.repository.IRegistroRepository;


/**
 * Esta clase ultiza la anotacion @Repository para manejar las instancias de los objetos  
 * de la clase e implementa los metodos de la interfaz IRegistroTrackingService para poder
 * utilizarlos luego para manipular los datos 
 * @author Toconas Ulises
 */
@Repository
public class RegistroTrackingServicelmp implements IRegistroTrackingService {

	/**
	 * se implementa un atributo de tipo IRegistroTracking
	 * y la anotacion @Autowired para la inyeccion de dependencia  
	 */
	@Autowired
	private IRegistroRepository iregistrotracking;
	
	

	@Override
	public void guardar(RegistroTracking registro) {
		iregistrotracking.save(registro);
	}
	
	/**
	 * metodo que con la anotacion @Override invoca metodos 
	 * de la capa repository
	 */
//	@Override
//	public void guardar() {
//		//se invoca el metodo guardar de la interfaz para guardar los datos
//		iregistrotracking.guardar();
//	}

	/**
	 * Metodo que contiene un atributo de tipo RegistroTracking
	 * y que con la anotacion @Override invoca el metodo para mostrar los datos
	 * @return registrotracking
	 */
//	@Override
//	public RegistroTracking mostrar() {
//		RegistroTracking registrotracking=iregistrotracking.mostrar();
//		return registrotracking;
//	}
	
	/**
	 * metodo que con la anotacion @Override invoca metodos 
	 * de la capa repository
	 */
//	@Override
//	public void eliminar() {
//		//se invoca el metodo eliminar de la interfaz para borrar datos
//		iregistrotracking.eliminar();
//	}

	/**
	 * Metodo que contiene un atributo de tipo RegistroTracking
	 * y que con la anotacion @Override invoca el metodo para modificar los datos
	 * @return registrotracking
	 */
//	@Override
//	public RegistroTracking modificar() {
//		RegistroTracking registrotracking=iregistrotracking.modificar();
//		return registrotracking;
//	}
}
