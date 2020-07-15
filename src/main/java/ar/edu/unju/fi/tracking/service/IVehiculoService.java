package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tracking.model.Tripulante;
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
	
	//
	//metodo que permite crear datos de tipo Vehiculo
	public void crear(Vehiculo vehiculo);
		
	public void guardar(Vehiculo vehiculo);
		
	Iterable<Vehiculo> listarTodos();
		
	public Vehiculo buscarPatentePorNombre(String patente);
	
/////
	//probando haber si sale la busqueda con ejemplo
		public Vehiculo encontrarPatente(String patente) throws Exception;
		
		//probando haber si sale la busqyeda con ejemplp
		public void guardarPatEncontrado(Vehiculo vehiculo);
		
	//BRIAN
		
	public void guardarVehiculoEncontrado(Vehiculo vehiculo);
		
	public void guardarVehiculo(Vehiculo vehiculo);
		
	public List<Vehiculo> buscarVehiculoSeleccionado();
		
	public void borrarElVehiculoSeleccionado();
		
}
