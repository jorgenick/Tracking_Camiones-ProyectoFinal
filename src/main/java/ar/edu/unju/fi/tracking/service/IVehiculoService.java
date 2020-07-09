package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tracking.model.Vehiculo;

/**
 * Se implementa la interfaz para bajar el acomplamiento
 * entre capas y se definen metodos para luego utilizarlos
 * @author Toconas Ulises
 */
public interface IVehiculoService {
	
	public void guardaVehiculoLocalidad(Vehiculo vehiculo);
	
	List<Vehiculo> obtenerVehiculos();
	
	public Optional<Vehiculo> obtenerUnVehiculo(Long id);
	
	public void eliminarVehiculo(Long id);
}
