package ar.edu.unju.fi.tracking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.model.Vehiculo;

/**
 * Se implementa la interfaz para bajar el acomplamiento
 * entre capas y se definen metodos para luego utilizarlos
 * @author Toconas Ulises
 */
public interface IRegistroTrackingService {
	
	/**
	 * permite guardar un registro en la BD
	 * @param registroTracking registro a guardar
	 */
	public void guardarRegistroTracking(RegistroTracking registroTracking);
	
	/**
	 * Permite obtener todos los registros almcaenados en la BD
	 * @return listado con los registros
	 */
	public List<RegistroTracking> obtenerRegistros();
	
	/**
	 * Permite obtener un determinado registro, de acuerdo a un ID
	 * @param id de registro a buscar
	 * @return registro tracking
	 */
	public Optional<RegistroTracking> obtenerUnRegistro(Long id);
	
	/**
	 * Permite eliminar un registro, de acuerdo a un ID dado
	 * @param id de registro a eliminar
	 */
	public void eliminarRegistro(Long id);
	
	/**
	 * permite buscar los registos de un determinado vehiculo-patente ordenado por fecha
	 * @param vehiculo vehiculo a buscar
	 * @return listado con registros encontrados
	 */
	public List<RegistroTracking> buscarPorPatenteOrdenFecha(Vehiculo vehiculo);
	
	/**
	 * Permite buscar los registros de un determinado tripulante, ordenado por fecha
	 * @param tripulante a buscar
	 * @return listado con registros encontrados
	 */
	public List<RegistroTracking> buscarPorTripulanteOrdenFecha(Tripulante tripulante);
	
	//buscar registro por patente de vehiculo
	/**
	 * Permite buscar los registros de un determinado tripulante, ordenado por fecha
	 * @param tripulante a buscar
	 * @return listado con registros encontrados
	 */
	List<RegistroTracking> buscarPorVehiculoPatente(String patente);
	
	//buscar registro por rango de fechas y localidad
	/**
	 * permite buscar registros en la BD, de acuerdo a un rango de fechas y una localidad dada
	 * @param fechaDesde fecha inicial a buscar
	 * @param fechaHasta feciha final a buscar
	 * @param localidad localidad a buscar
	 * @return listado con los registros encontrados
	 */
	public List<RegistroTracking> buscarRegistrosRangoFechasYLocalidad(LocalDateTime fechaDesde, LocalDateTime fechaHasta, Localidad localidad);
	
	//metodo para buscar registros por localidad y rango de fechas
	//public List<RegistroTracking> listaRegistrosLocalidadRangoFecha(String locaidad, LocalDateTime fechaInicial, LocalDateTime fechaFinal);

	/**
	 * Permite guardar un registro dado, en la BD
	 * @param registro a guardar
	 */
    public void guardar(RegistroTracking registro );
	
    /**
     * Permite listar todos los registros almacenados en la BD
     * @return listado de registross
     */
	Iterable<RegistroTracking> listarTodos();
}
