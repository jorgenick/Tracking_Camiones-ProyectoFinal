package ar.edu.unju.fi.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.tracking.model.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long>{

	@Query("from Usuario e order by e.nombreUsuario")
	public List<Usuario> obtenerUsuarios();
	
}
