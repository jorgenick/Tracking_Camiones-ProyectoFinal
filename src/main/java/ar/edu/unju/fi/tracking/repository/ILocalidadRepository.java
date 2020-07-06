/**
 * 
 */
package ar.edu.unju.fi.tracking.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tracking.model.Localidad;

/**
 * Interface de Localidad que implementa CrudRepository
 * @author Gonzalez Brian Leonel
 *
 */
public interface ILocalidadRepository extends CrudRepository<Localidad, Long> {

}
