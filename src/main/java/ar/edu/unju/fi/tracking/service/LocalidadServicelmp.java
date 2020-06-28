package ar.edu.unju.fi.tracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tracking.model.Localidad;

import ar.edu.unju.fi.tracking.repository.ILocalidadRepository;

/**
 * Esta clase ultiza la anotacion @Repository para manejar las instancias de los objetos  
 * de la clase e implementa los metodos de la interfaz ILocalidadService para poder
 * utilizarlos luego para manipular los datos 
 * @author Toconas Ulises
 */
@Repository
public class LocalidadServicelmp implements ILocalidadService {

	/**
	 * se implementa un atributo de tipo ILocalidadRepository
	 * y la anotacion @Autowired para la inyeccion de dependencia  
	 */
	@Autowired
	private ILocalidadRepository iLocalidad;
	
	
	/**
	 * metodo que con la anotacion @Override invoca metodos 
	 * de la capa repository
	 */
	@Override
	public void crear(Localidad unaLocalidad) {
		iLocalidad.save(unaLocalidad);
	}

	/**
	 * Metodo que contiene un atributo de tipo Localidad
	 * y que con la anotacion @Override invoca el metodo para mostrar los datos
	 * @return localidad
	 */
//	@Override
//	public Localidad mostrar() {
//		Localidad localidad=ilocalidad.mostrar();
//		return localidad;
//	}

	/**
	 * metodo que con la anotacion @Override invoca metodos 
	 * de la capa repository
	 */
//	@Override
//	public void eliminar() {
		//se invoca el metodo eliminar de la interfaz para borrar datos	
//		ilocalidad.eliminar();
//	}

	/**
	 * Metodo que contiene un atributo de tipo Localidad
	 * y que con la anotacion @Override invoca el metodo para modificar los datos
	 * @return localidad
	 */
//	@Override
//	public Localidad modificar() {
//		Localidad localidad=ilocalidad.modificar();
//		return localidad;
//	}
}
