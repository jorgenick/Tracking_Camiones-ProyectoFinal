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

	/**
	 * Metodo que permite obtener todas las localidades de la base de datos, ordenados por nombre
	 * @return lista con localidades
	 */
	@Query("from Localidad e order by e.nombre")
	public List<Localidad> obtenerLocalidades();
	
	/**
	 * Permite buscar en la BD una localidad por su nombre
	 * @param nombre nombre de la localidad a buscar
	 * @return Optional, podria haberse encontrado o no.
	 */
	public Optional<Localidad> findByNombre (String nombre);
		
	/**
	 * Permite buscar en la BD de acuerdo al ID
	 * @param id id de la localidad a buscar
	 * @return la localidad con id encontrada
	 */
	public Localidad findByNombre(Long id);
	
}
