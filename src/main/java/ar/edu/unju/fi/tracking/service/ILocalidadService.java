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

	public void guardarLocalidad(Localidad localidad);
	
	List<Localidad> obtenerLocalidades();
	
	public Optional<Localidad> obtenerUnaLocalidad(Long id);
	
	public void eliminarLocalidad(Long id);
	
	public Localidad buscarNombreLocalidad(String nombre) throws Exception;
	
	public Localidad buscarLocalidadPorNombre(String nombre);
	
	
	public Iterable<Localidad> listarTodos();


	public Localidad encontrarUnaLocalidad(Long id);
}
