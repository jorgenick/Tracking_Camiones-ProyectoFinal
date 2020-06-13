package ar.edu.unju.fi.tracking.service;

import ar.edu.unju.fi.tracking.model.Tripulante;

/**
 * Se implementa la interfaz para bajar el acomplamiento
 * entre capas y se definen metodos para luego utilizarlos
 * @author Toconas Ulises
 */
public interface ITripulanteService {
	//metodo que permite guardar datos de tipo Tripulante
	public void guardar();
	
	//metodo que muestra datos de tipo Tripulante
	public Tripulante mostrar();
	
	//metodo que elimina datos de tipo Tripulante
	public void eliminar();
	
	//metodo que modifica datos de tipo Tripulante
	public Tripulante modificar();
}
