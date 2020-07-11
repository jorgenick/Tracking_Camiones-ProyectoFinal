package ar.edu.unju.fi.tracking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.model.RegistroTracking;
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
	
	@Override
	public void guardarRegistroTracking(RegistroTracking registroTracking) {
		// TODO Auto-generated method stub
		registroTrackingImp.save(registroTracking);
	}

	@Override
	public List<RegistroTracking> obtenerRegistros() {
		// TODO Auto-generated method stub
		return registroTrackingImp.findAll();
	}

	@Override
	public Optional<RegistroTracking> obtenerUnRegistro(Long id) {
		// TODO Auto-generated method stub
		return registroTrackingImp.findById(id);
	}

	@Override
	public void eliminarRegistro(Long id) {
		// TODO Auto-generated method stub
		registroTrackingImp.deleteById(id);
	}

	@Override
	public List<RegistroTracking> buscarPorVehiculoPatente(String patente) {
		// TODO Auto-generated method stub
		return registroTrackingImp.findByVehiculoPatente(patente);
	}

	@Override
	public List<RegistroTracking> buscarRegistrosRangoFechasYLocalidad(LocalDateTime fechaDesde, LocalDateTime fechaHasta,
			Localidad localidad) {
		// TODO Auto-generated method stub
		return registroTrackingImp.findAllByFechaBetweenAndLocalidadOrderByFecha(fechaDesde, fechaHasta, localidad);
	}

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
