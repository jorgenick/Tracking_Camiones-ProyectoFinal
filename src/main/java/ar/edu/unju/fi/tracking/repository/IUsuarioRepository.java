package ar.edu.unju.fi.tracking.repository;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tracking.model.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {

//	@Query("from Usuario e order by e.nombre")
	public List<Usuario>obtnerUsuarios();
}
