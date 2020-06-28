package ar.edu.unju.fi.tracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tracking.model.Tripulante;

//import ar.edu.unju.fi.tracking.repository.ITripulanteDAO;
import ar.edu.unju.fi.tracking.repository.ITripulanteRepository;

/**
 * Esta clase ultiza la anotacion @Repository para manejar las instancias de los objetos  
 * de la clase e implementa los metodos de la interfaz ITripulanteService para poder
 * utilizarlos luego para manipular los datos 
 * @author Toconas Ulises
 */
@Service
public class TripulanteServicelmp implements ITripulanteService {

	/**
	 * se implementa un atributo de tipo ITripulante
	 * y la anotacion @Autowired para la inyeccion de dependencia  
	 */
	@Autowired
	private ITripulanteRepository itripulante;
	
	/**
	 * metodo que con la anotacion @Override invoca metodos 
	 * de la capa repository
	 */
	@Override
	public void guardar(Tripulante tripulante) {
		//se invoca el metodo guardar de la interfaz para guardar los datos
		itripulante.save(tripulante);
	}

	@Override
	public List<Tripulante> obtenerTodos() {
		List <Tripulante> tripulantes=(List<Tripulante>) itripulante.findAll();
		return tripulantes;
	}
	/**
	 * Metodo que contiene un atributo de tipo Tripulante
	 * y que con la anotacion @Override invoca el metodo para mostrar los datos
	 * @return tripulante
	 */
//	@Override
//	public Tripulante mostrar() {
//		Tripulante tripulante=itripulante.mostrar();
//		return tripulante;
//	}

	/**
	 * metodo que con la anotacion @Override invoca metodos 
	 * de la capa repository
	 */
//	@Override
//	public void eliminar() {
		//se invoca el metodo eliminar de la interfaz para borrar datos
//		itripulante.eliminar();
//	}

	/**
	 * Metodo que contiene un atributo de tipo Tripulante
	 * y que con la anotacion @Override invoca el metodo para modificar los datos
	 * @return tripulante
	 */
//	@Override
//	public Tripulante modificar() {
//		Tripulante tripulante=itripulante.modificar();
//		return tripulante;
//	}

//	@Override
//	public void guardar(Tripulante tripulante) {
		// TODO Auto-generated method stub
		
//	}

}
