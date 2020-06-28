package ar.edu.unju.fi.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tracking.model.Tripulante;

public interface ITripulanteRepository extends CrudRepository<Tripulante, Long>{

	@Query
	public List<Tripulante> obtenerTripulantes();
	
}
