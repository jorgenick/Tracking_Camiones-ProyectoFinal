package ar.edu.unju.fi.tracking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tracking.model.Vehiculo;

/**
 * Se implementa la interfaz para bajar el acomplamiento
 * entre capas y se definen metodos para luego utilizarlos
 * @author Toconas Ulises
 */
public interface IVehiculoDAO extends JpaRepository<Vehiculo, Long>{
	
	/**
	 * Permite buscar en la BD un vehculo, de cuerdo a una determinada patente
	 * @param nombre patente a buscar
	 * @return el vehiculo encontrado
	 */
	Vehiculo findAllByPatente(String nombre);
	
	//para la busqueda de patente
	/**
	 * Permite buscar en la BD un vehculo, de cuerdo a una determinada patente
	 * @param nombre patente a buscar
	 * @return el vehiculo encontrado de tipo optional, puedo o no haber sido encontrado
	 */
	public Optional<Vehiculo> findByPatente(String patente);
}
