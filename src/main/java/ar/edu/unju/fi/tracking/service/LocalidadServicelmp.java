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

	@Autowired
	ILocalidadDAO localidadDAOimp;

	@Override
	public void guardarLocalidad(Localidad localidad) {
		localidadDAOimp.save(localidad);
	}

	@Override
	public List<Localidad> obtenerLocalidades() {
		return localidadDAOimp.obtenerLocalidades();
	}

	@Override
	public Optional<Localidad> obtenerUnaLocalidad(Long id) {
		Optional<Localidad> localidad=localidadDAOimp.findById(id);
		return localidad;
	}

	@Override
	public void eliminarLocalidad(Long id) {
		localidadDAOimp.deleteById(id);;
		
	}

	@Override
	public Localidad buscarNombreLocalidad(String nombre) throws Exception {
		
		return localidadDAOimp.findByNombre(nombre).orElseThrow();
	}

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

	@Override
	public Iterable<Localidad> listarTodos() {
		// TODO Auto-generated method stub
		return localidadDAOimp.findAll();
	}
	
}
