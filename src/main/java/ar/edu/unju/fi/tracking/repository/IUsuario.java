package ar.edu.unju.fi.tracking.repository;

import ar.edu.unju.fi.tracking.model.Usuario;

/**
 * Se implementa la interfaz para bajar el acomplamiento
 * entre capas y se definen metodos para luego utilizarlos
 * @author Toconas Ulises
 */
public interface IUsuario {
	//metodo que permite guardar datos de tipo Usuario
	public void guardar();
	
	//metodo que muestra datos de tipo Usuario
	public Usuario mostrar();
	
	//metodo que elimina datos de Usuario
	public void eliminar();
	
	//metodo que modifica datos de tipo Usuario
	public Usuario modificar();
}
