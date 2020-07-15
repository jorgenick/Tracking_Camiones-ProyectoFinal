package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tracking.model.Localidad;

/**
 * Se implementa la interfaz para bajar el acomplamiento
 * entre capas y se definen metodos para luego utilizarlos
 * @author Ulises Toconas
 */
public interface ILocalidadService {

	/**
	 * Permite guardar una determinada localidad en la BD
	 * @param localidad localidad a guardar
	 */
	public void guardarLocalidad(Localidad localidad);
	
	/**
	 * Permite obtener todas las localidades almacenadas en la BD
	 * @return listado de localidades
	 */
	List<Localidad> obtenerLocalidades();
	
	/**
	 * Permite obtener una determinada localidad a traves de su ID
	 * @param id de localidad a buscar
	 * @return un Optional, puede o no encontrarse
	 */
	public Optional<Localidad> obtenerUnaLocalidad(Long id);
	
	/**
	 * Permite eliminar una determinada localidad de la base de datos
	 * @param id localidad a eliminar
	 */
	public void eliminarLocalidad(Long id);
	
	/**
	 * Permite buscar en la BD una localidad, a gtraves de su nombre
	 * @param nombre de localidad a buscar
	 * @return Localidad encontrada
	 * @throws Exception
	 */
	public Localidad buscarNombreLocalidad(String nombre) throws Exception;
	
	/**
	 * Permite buscar en la BD una localidad, a gtraves de su nombre
	 * @param nombre de localidad a buscar
	 * @return Localidad encontrada
	 */
	public Localidad buscarLocalidadPorNombre(String nombre);
	
	/**
	 * Permite listar todas las localidades de la BD
	 * @return listado de localidades
	 */
	public Iterable<Localidad> listarTodos();

	/**
	 * Permite buscar obtener una localidad de la BD buscado por su ID
	 * @param id de la localidad a buscar
	 * @return localidad encontrada
	 */
	public Localidad encontrarUnaLocalidad(Long id);
}
