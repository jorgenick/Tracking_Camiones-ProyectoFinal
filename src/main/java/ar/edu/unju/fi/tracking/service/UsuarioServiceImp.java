package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tracking.model.Usuario;
import ar.edu.unju.fi.tracking.repository.IUsuarioDAO;

@Service
public class UsuarioServiceImp implements IUsuarioService {

	@Autowired
	IUsuarioDAO usuarioDAOimp;
	
	@Override
	public void guardarUsuario(Usuario usuario) {
		String pw = usuario.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		usuario.setPassword(bCryptPasswordEncoder.encode(pw));
		usuarioDAOimp.save(usuario);
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		return usuarioDAOimp.obtenerUsuarios();
	}

	@Override
	public Optional<Usuario> obtenerUnUsuario(Long id) {
		Optional<Usuario> usuario= usuarioDAOimp.findById(id);
		return usuario;
	}

	@Override
	public void eliminarUsuario(Long id) {
		usuarioDAOimp.deleteById(id);
	}
	
	@Override
	public Usuario buscarUsuarioPorNombreUsuario(String nombre) {
		return usuarioDAOimp.findByNombreUsuario(nombre);
	}



}
