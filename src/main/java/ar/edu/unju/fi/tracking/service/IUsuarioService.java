package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tracking.model.Usuario;

public interface IUsuarioService {
	
	public void guardarUsuario(Usuario usuario);
	
	public List<Usuario> obtenerUsuarios();
	
	public Optional<Usuario> obtenerUnUsuario(Long id);
	
	public void eliminarUsuario(Long id);

}
