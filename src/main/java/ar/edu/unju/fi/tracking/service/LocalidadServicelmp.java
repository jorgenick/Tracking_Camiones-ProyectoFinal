package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.repository.ILocalidadDAO;

/**
 * Esta clase ultiza la anotacion @Repository para manejar las instancias de los objetos  
 * de la clase e implementa los metodos de la interfaz ILocalidadService para poder
 * utilizarlos luego para manipular los datos 
 * @author Toconas Ulises
 */
@Repository
public class LocalidadServicelmp implements ILocalidadService {

	/**
	 * Inyeccion de ILocalidadDAO
	 */
	@Autowired
	ILocalidadDAO localidadDAOimp;

	/**
	 * Permite guardar una determinada localidad en la BD
	 * @param localidad localidad a guardar
	 */
	@Override
	public void guardarLocalidad(Localidad localidad) {
		localidadDAOimp.save(localidad);
	}

	/**
	 * Permite obtener todas las localidades almacenadas en la BD
	 * @return listado de localidades
	 */
	@Override
	public List<Localidad> obtenerLocalidades() {
		return localidadDAOimp.obtenerLocalidades();
	}

	/**
	 * Permite obtener una determinada localidad a traves de su ID
	 * @param id de localidad a buscar
	 * @return un Optional, puede o no encontrarse
	 */
	@Override
	public Optional<Localidad> obtenerUnaLocalidad(Long id) {
		Optional<Localidad> localidad=localidadDAOimp.findById(id);
		return localidad;
	}

	/**
	 * Permite eliminar una determinada localidad de la base de datos
	 * @param id localidad a eliminar
	 */
	@Override
	public void eliminarLocalidad(Long id) {
		localidadDAOimp.deleteById(id);;
		
	}

	/**
	 * Permite buscar en la BD una localidad, a gtraves de su nombre
	 * @param nombre de localidad a buscar
	 * @return Localidad encontrada
	 * @throws Exception
	 */
	@Override
	public Localidad buscarNombreLocalidad(String nombre) throws Exception {
		
		return localidadDAOimp.findByNombre(nombre).orElseThrow();
	}

	/**
	 * Permite buscar en la BD una localidad, a gtraves de su nombre
	 * @param nombre de localidad a buscar
	 * @return Localidad encontrada
	 */
	@Override
	public Localidad buscarLocalidadPorNombre(String nombre) {
		
		//control de bucle
		boolean encontrado = false;
		
		int i=0;
		
		//instancio un objeto del tipo localidad
		Localidad localidadEncontrada = new Localidad();
		
		//Localidad recorrer = new Localidad();
		
		//guardo todas las localidades
		List<Localidad> localidades = localidadDAOimp.findAll();
		
		//recorrer el List para buscar la localidad
		while(i<localidades.size() && encontrado==false) {
			
			//recorrer = localidades.get(i);
			
			//verificar el encontrado
			if(localidades.get(i).getNombre().equals(nombre)) {
				localidadEncontrada = localidades.get(i);
				encontrado=true;
			}
			
			i++;
			
		}
		
		if(localidadEncontrada.getId() == null) {
			localidadEncontrada = null;
		}
		
		return localidadEncontrada;
	}

	/**
	 * Permite listar todas las localidades de la BD
	 * @return listado de localidades
	 */
	@Override
	public Iterable<Localidad> listarTodos() {
		// TODO Auto-generated method stub
		return localidadDAOimp.findAll();
	}

	/**
	 * Permite buscar obtener una localidad de la BD buscado por su ID
	 * @param id de la localidad a buscar
	 * @return localidad encontrada
	 */
	@Override
	public Localidad encontrarUnaLocalidad(Long id) {
		// TODO Auto-generated method stub
		return localidadDAOimp.findByNombre(id);
	}
	
	
}
