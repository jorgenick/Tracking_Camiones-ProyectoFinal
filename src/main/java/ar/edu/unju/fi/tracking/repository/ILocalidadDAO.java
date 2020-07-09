package ar.edu.unju.fi.tracking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.tracking.model.Localidad;

/**
 * Se implementa la interfaz para bajar el acomplamiento
 * entre capas y se definen metodos para luego utilizarlos
 * @author Toconas Ulises
 */
public interface ILocalidadDAO extends JpaRepository<Localidad, Long> {

	@Query("from Localidad e order by e.nombre")
	public List<Localidad> obtenerLocalidades();
	
	public Optional<Localidad> findByNombre (String nombre);
	
}
