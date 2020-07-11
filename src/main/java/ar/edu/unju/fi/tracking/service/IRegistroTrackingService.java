package ar.edu.unju.fi.tracking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.model.Vehiculo;

/**
 * Se implementa la interfaz para bajar el acomplamiento
 * entre capas y se definen metodos para luego utilizarlos
 * @author Toconas Ulises
 */
public interface IRegistroTrackingService {
	
	public void guardarRegistroTracking(RegistroTracking registroTracking);
	
	public List<RegistroTracking> obtenerRegistros();
	
	public Optional<RegistroTracking> obtenerUnRegistro(Long id);
	
	public void eliminarRegistro(Long id);
	
	public List<RegistroTracking> buscarPorPatenteOrdenFecha(Vehiculo vehiculo);
	
	//buscar registro por patente de vehiculo
	List<RegistroTracking> buscarPorVehiculoPatente(String patente);
	
	//buscar registro por rango de fechas y localidad
	public List<RegistroTracking> buscarRegistrosRangoFechasYLocalidad(LocalDateTime fechaDesde, LocalDateTime fechaHasta, Localidad localidad);
	
	//metodo para buscar registros por localidad y rango de fechas
	//public List<RegistroTracking> listaRegistrosLocalidadRangoFecha(String locaidad, LocalDateTime fechaInicial, LocalDateTime fechaFinal);

    public void guardar(RegistroTracking registro );
	
	Iterable<RegistroTracking> listarTodos();
}
