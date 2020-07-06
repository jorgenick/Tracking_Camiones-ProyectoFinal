package ar.edu.unju.fi.tracking.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tracking.model.RegistroTracking;

/**
 * Interfaz que permite la implementacion del crud repository
 * @author Gonzalez Brian
 */
public interface IRegistroTrackingRepository extends CrudRepository<RegistroTracking, Long> {
	
	

}
