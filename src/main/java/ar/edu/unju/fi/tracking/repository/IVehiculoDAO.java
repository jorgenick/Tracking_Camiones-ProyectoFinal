package ar.edu.unju.fi.tracking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.model.Vehiculo;

/**
 * Se implementa la interfaz para bajar el acomplamiento
 * entre capas y se definen metodos para luego utilizarlos
 * @author Toconas Ulises
 */
public interface IVehiculoDAO extends JpaRepository<Vehiculo, Long>{
	
	Vehiculo findAllByPatente(String nombre);
	
	//para la busqueda de patente
	public Optional<Vehiculo> findByPatente(String patente);
}
