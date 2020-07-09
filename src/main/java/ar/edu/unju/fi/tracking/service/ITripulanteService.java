package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tracking.model.Tripulante;

/**
 * Se implementa la interfaz para bajar el acomplamiento
 * entre capas y se definen metodos para luego utilizarlos
 * @author Toconas Ulises
 */
public interface ITripulanteService {
	
	public void guardarTripulante(Tripulante tripulante);
	
	List<Tripulante> obtenerTripulantes();
	
	public Optional<Tripulante> obtenerUnTripulante(Long id);
	
	public void eliminarTripulante(Long id);

	
}
