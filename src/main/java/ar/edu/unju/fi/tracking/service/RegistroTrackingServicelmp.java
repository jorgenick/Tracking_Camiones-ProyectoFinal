package ar.edu.unju.fi.tracking.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.repository.IRegistroTrackingDAO;
import ar.edu.unju.fi.tracking.repository.IRegistroTrackingRepository;

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
	private IRegistroTrackingDAO iregistrotracking;
	
	private IRegistroTrackingRepository iRegistroRepository;
	
	/**
	 * metodo que con la anotacion @Override invoca metodos 
	 * de la capa repository
	 */
	@Override
	public void guardar() {
		//se invoca el metodo guardar de la interfaz para guardar los datos
		iregistrotracking.guardar();
	}

	/**
	 * Metodo que contiene un atributo de tipo RegistroTracking
	 * y que con la anotacion @Override invoca el metodo para mostrar los datos
	 * @return registrotracking
	 */
	@Override
	public RegistroTracking mostrar() {
		RegistroTracking registrotracking=iregistrotracking.mostrar();
		return registrotracking;
	}
	
	/**
	 * metodo que con la anotacion @Override invoca metodos 
	 * de la capa repository
	 */
	@Override
	public void eliminar() {
		//se invoca el metodo eliminar de la interfaz para borrar datos
		iregistrotracking.eliminar();
	}

	/**
	 * Metodo que contiene un atributo de tipo RegistroTracking
	 * y que con la anotacion @Override invoca el metodo para modificar los datos
	 * @return registrotracking
	 */
	@Override
	public RegistroTracking modificar() {
		RegistroTracking registrotracking=iregistrotracking.modificar();
		return registrotracking;
	}

	@Override
	public List<RegistroTracking> listaRegistrosLocalidadRangoFecha(
			String localidad, LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
		
		//declaracion de variable contenedora de todos los registros
		List<RegistroTracking> listaRegistros = new ArrayList<>();
		
		//declaración de variable para registros encontrados
		List<RegistroTracking> registrosEncontrados = new ArrayList<>();
		
		//Guardar en una variabe de tipo Iterable todos los registros tracking
		Iterable<RegistroTracking> iterableRegistrosTracking = iRegistroRepository.findAll();
		
		//almacenar los datos de iterableRegistroTracking en listaRegistros
		iterableRegistrosTracking.forEach(listaRegistros::add);
		
		//recorrer la lista de registros y buscar los elementos
		for(int i = 0; i<listaRegistros.size(); i++) {
			
			if( localidad.equals( listaRegistros.get(i).getLocalidad().getNombre() ) //verifico que la localidad sea la misma
				&& listaRegistros.get(i).getFechaHora().compareTo(fechaInicial) > 0 //si la fecha del registro es mayor a fechaInicial
				&& listaRegistros.get(i).getFechaHora().compareTo(fechaFinal) < 0 //si la fecha del registro es menor a fechaFinal
					) {
				
				registrosEncontrados.add(listaRegistros.get(i));
				
			}
			
		}
		
		return registrosEncontrados;
	}
}
