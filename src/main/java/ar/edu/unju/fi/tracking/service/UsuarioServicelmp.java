package ar.edu.unju.fi.tracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tracking.model.Usuario;
import ar.edu.unju.fi.tracking.repository.IUsuario;

/**
 * Esta clase ultiza la anotacion @Repository para manejar las instancias de los objetos  
 * de la clase e implementa los metodos de la interfaz IUsuarioService para poder
 * utilizarlos luego para manipular los datos 
 * @author Toconas Ulises
 */
@Repository
public class UsuarioServicelmp implements IUsuarioService {

	/**
	 * se implementa un atributo de tipo IUsuario
	 * y la anotacion @Autowired para la inyeccion de dependencia  
	 */
	@Autowired
	private IUsuario iusuario;
	
	/**
	 * metodo que con la anotacion @Override invoca metodos 
	 * de la capa repository
	 */
	@Override
	public void guardar() {
		//se invoca el metodo guardar de la interfaz para guardar los datos
		iusuario.guardar();
	}

	/**
	 * Metodo que contiene un atributo de tipo Usuario
	 * y que con la anotacion @Override invoca el metodo para mostrar los datos
	 * @return usuario
	 */
	@Override
	public Usuario mostrar() {
		Usuario usuario=iusuario.mostrar();
		return usuario;
	}

	/**
	 * metodo que con la anotacion @Override invoca metodos 
	 * de la capa repository
	 */
	@Override
	public void eliminar() {
		//se invoca el metodo eliminar de la interfaz para borrar datos	
		iusuario.eliminar();
	}

	/**
	 * Metodo que contiene un atributo de tipo Usuario
	 * y que con la anotacion @Override invoca el metodo para modificar los datos
	 * @return usuario
	 */
	@Override
	public Usuario modificar() {
		Usuario usuario=iusuario.modificar();
		return usuario;
	}
}
