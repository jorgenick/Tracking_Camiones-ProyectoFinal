package ar.edu.unju.fi.tracking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tracking.model.Tripulante;

/**
 * Se implementa la interfaz para bajar el acomplamiento
 * entre capas y se definen metodos para luego utilizarlos
 * @author Toconas Ulises
 */
public interface ITripulanteDAO extends JpaRepository<Tripulante, Long> {
	
	/**
	 * Permite buscar en la BD a un tripulante, de acuerdo a su documento
	 * @param documento numero de documento a buscar
	 * @return tripulante encontrado
	 */
	Tripulante findAllByDocumento(String documento);
	
	/**
	 * Permite buscar en la BD a un tripulante, de acuerdo a su documento
	 * @param documento numero de documento a buscar
	 * @return tripulante encontrado
	 */
	public Optional<Tripulante> findByDocumento(String documento);
}
