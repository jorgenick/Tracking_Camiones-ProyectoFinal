package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tracking.model.Vehiculo;
import ar.edu.unju.fi.tracking.repository.IVehiculoDAO;

/**
 * Esta clase ultiza la anotacion @Repository para manejar las instancias de los objetos  
 * de la clase e implementa los metodos de la interfaz IVehiculoService para poder
 * utilizarlos luego para manipular los datos 
 * @author Toconas Ulises
 */
@Service
public class VehiculoServicelmp implements IVehiculoService {

	/**
	 * se implementa un atributo de tipo IVehiculo 
	 * y la anotacion @Autowired para la inyeccion de dependencia  
	 */
	@Autowired
	private IVehiculoDAO vehiculoDAOImp;

	@Autowired
	private Vehiculo unicoVehiculo;
	
	@Override
	public void guardaVehiculoLocalidad(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		vehiculoDAOImp.save(vehiculo);
	}

	@Override
	public List<Vehiculo> obtenerVehiculos() {
		// TODO Auto-generated method stub
		return vehiculoDAOImp.findAll();
	}

	@Override
	public Optional<Vehiculo> obtenerUnVehiculo(Long id) {
		// TODO Auto-generated method stub
		return vehiculoDAOImp.findById(id);
	}

	@Override
	public void eliminarVehiculo(Long id) {
		// TODO Auto-generated method stub
		vehiculoDAOImp.deleteById(id);
	}

	@Override
	public void crear(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		vehiculoDAOImp.save(vehiculo);
	}

	@Override
	public void guardar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		unicoVehiculo=vehiculo;
	}

	@Override
	public Iterable<Vehiculo> listarTodos() {
		// TODO Auto-generated method stub
		return vehiculoDAOImp.findAll();
	}

	@Override
	public List<Vehiculo> buscarPatente(String patente) throws Exception {
		// TODO Auto-generated method stub
		return vehiculoDAOImp.findByPatente(patente);
	}

	@Override
	public Vehiculo buscarPatentePorNombre(String patente) {
		// TODO Auto-generated method stub
		return vehiculoDAOImp.findAllByPatente(patente);
	}

}
