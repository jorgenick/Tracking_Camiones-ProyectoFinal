package ar.edu.unju.fi.tracking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.repository.ITripulanteDAO;

/**
 * Esta clase ultiza la anotacion @Repository para manejar las instancias de los objetos  
 * de la clase e implementa los metodos de la interfaz ITripulanteService para poder
 * utilizarlos luego para manipular los datos 
 * @author Toconas Ulises
 */
@Repository
public class TripulanteServicelmp implements ITripulanteService {
	
	private List<Tripulante> listadoAuxiliar = new ArrayList<Tripulante>();

	/**
	 * se implementa un atributo de tipo ITripulante
	 * y la anotacion @Autowired para la inyeccion de dependencia  
	 */
	@Autowired
	private ITripulanteDAO tripulanteDAOImp;

	private List<Tripulante>listaAuxTri =new ArrayList<Tripulante>(); 
	
	private Tripulante untripulante;
	
	/**
	 * permite guardar un tripulante dado en la BD
	 * @param tripulante a guardar
	 */
	@Override
	public void guardarTripulante(Tripulante tripulante) {
		// TODO Auto-generated method stub
		listaAuxTri.add(tripulante);
		System.out.println("tamaño de la lista: "+listaAuxTri.size()+ "  tripulante:"+tripulante.toString());
		untripulante=tripulante;
	}

	/**
	 * Permite guardar un tripulante en la BD
	 * @param tripulante a guardar
	 */
	@Override
	public void crearTri(Tripulante tripulante) {
		// TODO Auto-generated method stub
		tripulanteDAOImp.save(tripulante);
	}
		
	/**
	 * Permite obtener todos los tripulantes almacenados en la BD
	 * @return listado de tripulantes 
	 */
	@Override
	public List<Tripulante> obtenerTripulantes() {
		// TODO Auto-generated method stub
		return tripulanteDAOImp.findAll();
	}

	/**
	 * Permite obtener un tripulante, de acuerdo a un ID dato
	 * @param id de tripulante a buscar
	 * @return el tripulante encontrado
	 */
	@Override
	public Optional<Tripulante> obtenerUnTripulante(Long id) {
		// TODO Auto-generated method stub
		return tripulanteDAOImp.findById(id);
	}

	/**
	 * Permite eliminar un tripulante de la BD, de acuerdo a un ID dado
	 * @param id de tripulante a elimnar
	 */
	@Override
	public void eliminarTripulante(Long id) {
		// TODO Auto-generated method stub
		tripulanteDAOImp.deleteById(id);
	}

	/**
	 * Permite listar todos los tripulantes alamcenados en la BD
	 * @return
	 */
	@Override
	public Iterable<Tripulante> listarTodos() {
		// TODO Auto-generated method stub
		return tripulanteDAOImp.findAll();
	}

	/**
	 * Permite buscar los tripulantes de acuerdo a un ndeterminado DNI
	 * @param documento
	 * @return
	 */
	@Override
	public Tripulante buscarTripulanteDNI(String documento) {
		return tripulanteDAOImp.findAllByDocumento(documento);
	}

	@Override
	public List<Tripulante> listarTripulantesAgregados() {
		// TODO Auto-generated method stub
		return listaAuxTri;
	}

	@Override
	public Tripulante encontrarDni(String documento) throws Exception {
		// TODO Auto-generated method stub
	 return tripulanteDAOImp.findByDocumento(documento).orElseThrow(()-> new Exception("El dni no existe la base"));
	}

	@Override
	public void guardarDNIEncontrado(Tripulante tripulante) {
		// TODO Auto-generated method stub
		listaAuxTri.add(tripulante);
	}
	
	//BRIAN

			@Override
			public void guardarTripulanteEncontrado(Tripulante tripulante) {
				
				listadoAuxiliar.add(tripulante);
				
			}

			@Override
			public void guardarTripu(Tripulante tripulante) {
				
				tripulanteDAOImp.save(tripulante);
				listadoAuxiliar.add(tripulante);
				
			}

			@Override
			public List<Tripulante> buscarTodosTripulantes() {
				// TODO Auto-generated method stub
				return this.listadoAuxiliar;
			}

			@Override
			public void borrarTodosTripulantes() {
				
				listadoAuxiliar = new ArrayList<Tripulante>();
				
			}

}
