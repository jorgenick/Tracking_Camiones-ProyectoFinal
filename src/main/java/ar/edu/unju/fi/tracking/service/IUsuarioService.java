package ar.edu.unju.fi.tracking.service;

import ar.edu.unju.fi.tracking.model.Usuario;

/**
 * Se implementa la interfaz para bajar el acomplamiento
 * entre capas y se definen metodos para luego utilizarlos
 * @author Toconas Ulises
 */
public interface IUsuarioService {
	//metodo que permite crear un tipo de Usuario
	public void crear(Usuario unUsuario);
	
//	//metodo que muestra datos de tipo Usuario
//	public Usuario mostrar();
//	
//	//metodo que elimina datos de tipo Usuario
//	public void eliminar();
//	
//	//metodo que modifica datos de tipo Usuario
//	public Usuario modificar();
}
