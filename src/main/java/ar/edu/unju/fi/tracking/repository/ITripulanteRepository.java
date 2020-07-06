/**
 * 
 */
package ar.edu.unju.fi.tracking.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tracking.model.Tripulante;

/**
 * Interface de Tripulante que implementa CrudRepository
 * @author Gonzalez Brian Leonel
 *
 */
public interface ITripulanteRepository extends CrudRepository<Tripulante, Long> {

}
