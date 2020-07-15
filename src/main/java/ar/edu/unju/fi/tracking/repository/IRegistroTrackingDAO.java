package ar.edu.unju.fi.tracking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.model.Vehiculo;

/**
 * Se implementa la interfaz para bajar el acomplamiento
 * entre capas y se definen metodos para luego utilizarlos
 * @author Toconas Ulises
 */
public interface IRegistroTrackingDAO extends JpaRepository<RegistroTracking, Long> {
	
	//buscar registro por patente de vehiculo
	/**
	 * Permite buscar los registros por la patente de un vehiculo
	 * @param patente la patente a buscar
	 * @return listado con registros encontrados
	 */
	List<RegistroTracking> findByVehiculoPatente(String patente);
		
	//buscar registro entre un rango de fechas y localidad ordenado por fecha
	/**
	 * Permite buscar en la BD los registros entre un rango de fechas y una determinada localidad, ordenados por fecha
	 * @param fechaDesde fecha inicial de busqueda
	 * @param fechaHasta fecha final de busqueda
	 * @param localidad localidad a buscar
	 * @return lista con registros encontrados
	 */
	public List<RegistroTracking> findAllByFechaBetweenAndLocalidadOrderByFecha(LocalDateTime fechaDesde, LocalDateTime fechaHasta, Localidad localidad);

	/**
	 * Permite buscar en la BD los registro de un determinado vehiculo, ordenado por fecha
	 * @param vehiculo vehiculo a buscar
	 * @return listado con registros encontrados
	 */
	public List<RegistroTracking> findAllByVehiculoOrderByFecha(Vehiculo vehiculo);
	
	/**
	 * Permite buscar en la BD los registros de n determinado tripulante
	 * @param tripulante tripulante a buscar
	 * @return listado con registros encontradoss
	 */
	public List<RegistroTracking> findAllByTripulantesOrderByFecha(Tripulante tripulante);
	/*
	 * //metodo que permite guardar datos de tipo RegistroTracking public void
	 * guardar();
	 * 
	 * //metodo que muestra datos de tipo RegistroTracking public RegistroTracking
	 * mostrar();
	 * 
	 * //metodo que elimina datos de tipo RegistroTracking public void eliminar();
	 * 
	 * //metodo que modifica datos de tipo RegistroTracking public RegistroTracking
	 * modificar();
	 */
}
