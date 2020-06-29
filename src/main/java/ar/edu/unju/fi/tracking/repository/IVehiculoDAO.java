package ar.edu.unju.fi.tracking.repository;

import ar.edu.unju.fi.tracking.model.Vehiculo;

/**
 * Se implementa la interfaz para bajar el acomplamiento
 * entre capas y se definen metodos para luego utilizarlos
 * @author Toconas Ulises
 */
public interface IVehiculoDAO {
	//metodo que permite guardar datos de tipo Vehiculo
	public void guardar();
	
	//metodo que muestra datos de tipo Vehiculo
	public Vehiculo mostrar();
	
	//metodo que elimina datos de tipo Vehiculo
	public void eliminar();
	
	//metodo que modifica datos de tipo Vehiculo
	public Vehiculo modificar();
}
