package ar.edu.unju.fi.tracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tracking.model.Vehiculo;
import ar.edu.unju.fi.tracking.repository.IVehiculoDAO;

/**
 * Esta clase ultiza la anotacion @Repository para manejar las instancias de los objetos  
 * de la clase e implementa los metodos de la interfaz IVehiculoService para poder
 * utilizarlos luego para manipular los datos 
 * @author Toconas Ulises
 */
@Repository
public class VehiculoServicelmp implements IVehiculoService {

	/**
	 * se implementa un atributo de tipo IVehiculo 
	 * y la anotacion @Autowired para la inyeccion de dependencia  
	 */
	@Autowired
	private IVehiculoDAO ivehiculo;
	
	/**
	 * metodo que con la anotacion @Override invoca metodos 
	 * de la capa repository
	 */
	@Override
	public void guardar() {
	//se invoca el metodo guardar de la interfaz para guardar los datos	
		ivehiculo.guardar();
	}

	/**
	 * Metodo que contiene un atributo de tipo Vehiculo
	 * y que con la anotacion @Override invoca el metodo para mostrar los datos
	 * @return vehiculo
	 */
	@Override
	public Vehiculo mostrar() {
		Vehiculo vehiculo=ivehiculo.mostrar();
		return vehiculo;
	}

	/**
	 * metodo que con la anotacion @Override invoca metodos 
	 * de la capa repository
	 */
	@Override
	public void eliminar() {
	//se invoca el metodo eliminar de la interfaz para borrar datos	
		ivehiculo.eliminar();
	}

	/**
	 * Metodo que contiene un atributo de tipo Vehiculo
	 * y que con la anotacion @Override invoca el metodo para modificar los datos
	 * @return vehiculo
	 */
	@Override
	public Vehiculo modificar() {
		Vehiculo vehiculo=ivehiculo.modificar();
		return vehiculo;
	}
}
