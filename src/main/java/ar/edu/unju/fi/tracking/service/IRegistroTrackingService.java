package ar.edu.unju.fi.tracking.service;

import ar.edu.unju.fi.tracking.model.RegistroTracking;

/**
 * Se implementa la interfaz para bajar el acomplamiento
 * entre capas y se definen metodos para luego utilizarlos
 * @author Toconas Ulises
 */
public interface IRegistroTrackingService {
	//metodo que permite guardar datos de tipo RegistroTracking
	public void guardar();
	
	//metodo que muestra datos de tipo RegistroTracking
	public RegistroTracking mostrar();
	
	//metodo que elimina datos de tipo RegistroTracking
	public void eliminar();
	
	//metodo que modifica datos de tipo RegistroTracking
	public RegistroTracking modificar();
}
