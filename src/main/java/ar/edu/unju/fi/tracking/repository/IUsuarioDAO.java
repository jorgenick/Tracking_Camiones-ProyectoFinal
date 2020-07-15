package ar.edu.unju.fi.tracking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.tracking.model.Usuario;

/**
 * Clase que se extiende a JPARepository para poder interactuar de forma abstracta en la BD
 * @author Jorge Tolaba
 *
 */
public interface IUsuarioDAO extends JpaRepository<Usuario, Long>{

	/**
	 * Permite listar todos los usuarios almacenados en la base de datos, ordenados por nombre
	 * @return lista con los usuarios
	 */
	@Query("from Usuario e order by e.nombreUsuario")
	public List<Usuario> obtenerUsuarios();
	
	/**
	 * Permite buscar un usuario en la BD, de acuerdo a un determinado nombre de usuario
	 * @param nombre nombreUsuariop
	 * @return el usuario encontrado
	 */
	Usuario findByNombreUsuario(String nombre);
	
	/**
	 * Permite buscar un usuario en la BD, de acuerdo a un determinado nombre de usuario
	 * @param nombre nombreUsuariop
	 * @return el usuario encontrado
	 */
	public Optional<Usuario> findBynombreUsuario(String nombreUsuario);
	
}
