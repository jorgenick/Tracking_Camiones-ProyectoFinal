package ar.edu.unju.fi.tracking.service;

import java.util.List;

import ar.edu.unju.fi.tracking.model.Vehiculo;

/**
 * Se implementa la interfaz para bajar el acomplamiento
 * entre capas y se definen metodos para luego utilizarlos
 * @author Toconas Ulises
 */
public interface IVehiculoService {
	//metodo que permite crear datos de tipo Vehiculo
	public void crear(Vehiculo vehiculo);
	
//	List<Vehiculo> obtenerVehiculos();
	
	public List<Vehiculo> obtenerTodos();
	//metodo que muestra datos de tipo Vehiculo
//	public Vehiculo mostrar();
	
	public List<Vehiculo> obtenerVehiculos();
	//metodo que elimina datos de tipo Vehiculo
//	public void eliminar();
	
	//metodo que modifica datos de tipo Vehiculo
//	public Vehiculo modificar();
}
