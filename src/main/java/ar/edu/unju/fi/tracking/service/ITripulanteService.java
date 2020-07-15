package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tracking.model.Tripulante;

/**
 * Se implementa la interfaz para bajar el acomplamiento
 * entre capas y se definen metodos para luego utilizarlos
 * @author Toconas Ulises
 */
public interface ITripulanteService {
	
	/**
	 * permite guardar un tripulante dado en la BD
	 * @param tripulante a guardar
	 */
	public void guardarTripulante(Tripulante tripulante);
	
	/**
	 * Permite obtener todos los tripulantes almacenados en la BD
	 * @return listado de tripulantes 
	 */
	List<Tripulante> obtenerTripulantes();
	
	/**
	 * Permite guardar un tripulante en la BD
	 * @param tripulante a guardar
	 */
	public void crearTri(Tripulante tripulante);
	
	/**
	 * Permite listar todos los tripulantes alamcenados en la BD
	 * @return
	 */
	public Iterable<Tripulante> listarTodos();
	
	/**
	 * Permite obtener un tripulante, de acuerdo a un ID dato
	 * @param id de tripulante a buscar
	 * @return el tripulante encontrado
	 */
	public Optional<Tripulante> obtenerUnTripulante(Long id);
	
	/**
	 * Permite eliminar un tripulante de la BD, de acuerdo a un ID dado
	 * @param id de tripulante a elimnar
	 */
	public void eliminarTripulante(Long id);
	
	/**
	 * Permite buscar los tripulantes de acuerdo a un ndeterminado DNI
	 * @param documento
	 * @return
	 */
	public Tripulante buscarTripulanteDNI(String documento);

	public List<Tripulante> listarTripulantesAgregados();
	
	/////
	//probando haber si sale la busqueda con ejemplo
		public Tripulante encontrarDni(String documento) throws Exception;
		
		//probando haber si sale la busqyeda con ejemplp
		public void guardarDNIEncontrado(Tripulante tripulante);
		
		//BRIAN
		public void guardarTripulanteEncontrado(Tripulante tripulante);
				
		public void guardarTripu(Tripulante tripulante);
				
		public List<Tripulante> buscarTodosTripulantes();
				
		public void borrarTodosTripulantes();
}
