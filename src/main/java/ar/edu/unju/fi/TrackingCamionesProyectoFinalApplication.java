package ar.edu.unju.fi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.fi.tracking.model.Usuario;
import ar.edu.unju.fi.tracking.service.IUsuarioService;

@SpringBootApplication
public class TrackingCamionesProyectoFinalApplication implements CommandLineRunner {
	
//	@Autowired
//	Usuario usuario;
//	@Autowired
//	IUsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(TrackingCamionesProyectoFinalApplication.class, args);
	}
	
	public void run(String... args) throws Exception{
//		usuario.setId((long)1);
//		usuario.setNombreUsuario("jorge");
//		usuario.setNombreReal("Jorge");
//		usuario.setApellidoReal("Tolaba");
//		usuario.setPassword("12345");
//		usuario.setTipoUsuario("BD");
	}

}
