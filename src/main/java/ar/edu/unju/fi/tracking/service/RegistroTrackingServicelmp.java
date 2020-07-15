package ar.edu.unju.fi.tracking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.model.Vehiculo;
import ar.edu.unju.fi.tracking.repository.IRegistroTrackingDAO;

/**
 * Esta clase ultiza la anotacion @Repository para manejar las instancias de los
 * objetos de la clase e implementa los metodos de la interfaz
 * IRegistroTrackingService para poder utilizarlos luego para manipular los
 * datos
 * 
 * @author Toconas Ulises
 */
@Service
public class RegistroTrackingServicelmp implements IRegistroTrackingService {

	@Autowired
	IRegistroTrackingDAO registroTrackingImp;
	
	/**
	 * permite guardar un registro en la BD
	 * @param registroTracking registro a guardar
	 */
	@Override
	public void guardarRegistroTracking(RegistroTracking registroTracking) {
		// TODO Auto-generated method stub
		registroTrackingImp.save(registroTracking);
	}

	/**
	 * Permite obtener todos los registros almcaenados en la BD
	 * @return listado con los registros
	 */
	@Override
	public List<RegistroTracking> obtenerRegistros() {
		// TODO Auto-generated method stub
		return registroTrackingImp.findAll();
	}

	/**
	 * Permite obtener un determinado registro, de acuerdo a un ID
	 * @param id de registro a buscar
	 * @return registro tracking
	 */
	@Override
	public Optional<RegistroTracking> obtenerUnRegistro(Long id) {
		// TODO Auto-generated method stub
		return registroTrackingImp.findById(id);
	}

	/**
	 * Permite eliminar un registro, de acuerdo a un ID dado
	 * @param id de registro a eliminar
	 */
	@Override
	public void eliminarRegistro(Long id) {
		// TODO Auto-generated method stub
		registroTrackingImp.deleteById(id);
	}

	/**
	 * permite buscar los registos de un determinado vehiculo-patente ordenado por fecha
	 * @param vehiculo vehiculo a buscar
	 * @return listado con registros encontrados
	 */
	@Override
	public List<RegistroTracking> buscarPorVehiculoPatente(String patente) {
		// TODO Auto-generated method stub
		return registroTrackingImp.findByVehiculoPatente(patente);
	}

	/**
	 * permite buscar registros en la BD, de acuerdo a un rango de fechas y una localidad dada
	 * @param fechaDesde fecha inicial a buscar
	 * @param fechaHasta feciha final a buscar
	 * @param localidad localidad a buscar
	 * @return listado con los registros encontrados
	 */
	@Override
	public List<RegistroTracking> buscarRegistrosRangoFechasYLocalidad(LocalDateTime fechaDesde, LocalDateTime fechaHasta,
			Localidad localidad) {
		// TODO Auto-generated method stub
		return registroTrackingImp.findAllByFechaBetweenAndLocalidadOrderByFecha(fechaDesde, fechaHasta, localidad);
	}

	/**
	 * Permite buscar los registros de un determinado tripulante, ordenado por fecha
	 * @param tripulante a buscar
	 * @return listado con registros encontrados
	 */
	@Override
	public void guardar(RegistroTracking registro) {
		// TODO Auto-generated method stub
		registro.setFecha(LocalDateTime.now());
		registroTrackingImp.save(registro);
	}

	
	@Override
	public Iterable<RegistroTracking> listarTodos() {
		// TODO Auto-generated method stub
		return registroTrackingImp.findAll();
	}

	@Override
	public List<RegistroTracking> buscarPorPatenteOrdenFecha(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		return registroTrackingImp.findAllByVehiculoOrderByFecha(vehiculo);
	}

	@Override
	public List<RegistroTracking> buscarPorTripulanteOrdenFecha(Tripulante tripulante) {
		// TODO Auto-generated method stub
		return registroTrackingImp.findAllByTripulantesOrderByFecha(tripulante);
	}
	
	
	/*
		*//**
			 * se implementa un atributo de tipo IRegistroTracking y la anotacion @Autowired
			 * para la inyeccion de dependencia
			 */
	/*
	 * @Autowired private IRegistroTrackingDAO iregistrotracking;
	 * 
	 * 
	 *//**
		 * metodo que con la anotacion @Override invoca metodos de la capa repository
		 */
	/*
	 * @Override public void guardar() { //se invoca el metodo guardar de la
	 * interfaz para guardar los datos iregistrotracking.guardar(); }
	 * 
	 *//**
		 * Metodo que contiene un atributo de tipo RegistroTracking y que con la
		 * anotacion @Override invoca el metodo para mostrar los datos
		 * 
		 * @return registrotracking
		 */
	/*
	 * @Override public RegistroTracking mostrar() { RegistroTracking
	 * registrotracking=iregistrotracking.mostrar(); return registrotracking; }
	 * 
	 *//**
		 * metodo que con la anotacion @Override invoca metodos de la capa repository
		 */
	/*
	 * @Override public void eliminar() { //se invoca el metodo eliminar de la
	 * interfaz para borrar datos iregistrotracking.eliminar(); }
	 * 
	 *//**
		 * Metodo que contiene un atributo de tipo RegistroTracking y que con la
		 * anotacion @Override invoca el metodo para modificar los datos
		 * 
		 * @return registrotracking
		 *//*
			 * @Override public RegistroTracking modificar() { RegistroTracking
			 * registrotracking=iregistrotracking.modificar(); return registrotracking; }
			 * 
			 * @Override public List<RegistroTracking> listaRegistrosLocalidadRangoFecha(
			 * String localidad, LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
			 * 
			 * //declaracion de variable contenedora de todos los registros
			 * List<RegistroTracking> listaRegistros = new ArrayList<>();
			 * 
			 * //declaración de variable para registros encontrados List<RegistroTracking>
			 * registrosEncontrados = new ArrayList<>();
			 * 
			 * 
			 * //recorrer la lista de registros y buscar los elementos for(int i = 0;
			 * i<listaRegistros.size(); i++) {
			 * 
			 * if( localidad.equals( listaRegistros.get(i).getLocalidad().getNombre() )
			 * //verifico que la localidad sea la misma &&
			 * listaRegistros.get(i).getFechaHora().compareTo(fechaInicial) > 0 //si la
			 * fecha del registro es mayor a fechaInicial &&
			 * listaRegistros.get(i).getFechaHora().compareTo(fechaFinal) < 0 //si la fecha
			 * del registro es menor a fechaFinal ) {
			 * 
			 * registrosEncontrados.add(listaRegistros.get(i));
			 * 
			 * }
			 * 
			 * }
			 * 
			 * return registrosEncontrados; }
			 */
}
