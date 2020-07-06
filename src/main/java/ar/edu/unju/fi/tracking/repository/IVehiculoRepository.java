/**
 * 
 */
package ar.edu.unju.fi.tracking.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tracking.model.Vehiculo;

/**
 * Interfaz de Vehiculo que implementa el Crud Repository
 * @author Brian's
 *
 */
public interface IVehiculoRepository extends CrudRepository<Vehiculo, Long> {

}
