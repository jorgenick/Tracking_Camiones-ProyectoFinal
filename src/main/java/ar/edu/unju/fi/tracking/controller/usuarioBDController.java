package ar.edu.unju.fi.tracking.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.model.Usuario;
import ar.edu.unju.fi.tracking.model.Vehiculo;
import ar.edu.unju.fi.tracking.service.ILocalidadService;
import ar.edu.unju.fi.tracking.service.IUsuarioService;

@Controller
@RequestMapping
public class usuarioBDController {
	@Autowired
	IUsuarioService equipoService;
	// cambiar equipo service
	
	@Autowired
	ILocalidadService localidadService;
	
	@Autowired
	private Usuario unUsuario;
	@Autowired
	private Localidad unaLocalidad;
	
	@RequestMapping("/usuarioBd")
	public String listaUsuariosLocalidades(Model model) {
		model.addAttribute("registroUsuario",new Usuario());
		model.addAttribute("registroLocalidad", unaLocalidad);
		model.addAttribute("usuarios", equipoService.obtenerUsuarios());
		model.addAttribute("localidades", localidadService.obtenerLocalidades());	
		return "usuarioBD";
	}

	@PostMapping("/saveUsuario")
	public String GuardarUsuario(@Valid @ModelAttribute("registroUsuario") Usuario usuario, BindingResult result, ModelMap model)
	{
		if (result.hasErrors()) {
			model.addAttribute("registroUsuario", usuario);
			model.addAttribute("agregarUTab", "active");
			model.addAttribute("registroLocalidad", unaLocalidad);
			model.addAttribute("usuarios", equipoService.obtenerUsuarios());
			model.addAttribute("localidades", localidadService.obtenerLocalidades());

		}  else {
			
//			si pasa el primer if entonces hago la verificacion de que el nombre ingresado no se encuentre en la base de datos
//			invoco el metodo de buscar un determinado objeto y lo asigno a una variable 
			 Usuario coincidenciaUs = equipoService.buscarUsuarioPorNombreUsuario(usuario.getNombreUsuario());
//			si la el resultado de coincidencias es diferente a null enctoces quiere decir que existen coincidencias
			 if(coincidenciaUs != null)
					{
						model.addAttribute("registroUsuario", new Usuario());
						model.addAttribute("registroLocalidad", new Localidad());
						model.addAttribute("usuarios", equipoService.obtenerUsuarios());
						model.addAttribute("localidades", localidadService.obtenerLocalidades());
						model.addAttribute("agregarUTab", "active");
						// activo el mensaje de la vista
						model.addAttribute("mensajeErrorUs1", true);
						// mando el mensaje de error
						model.addAttribute("errorUsuario1",
						"¡ATENCIÓN!	El Usuario ingresado ya existe en la base de datos");

					} else {
//							si pasa el 2do if compruebo que se hayan ingresado solo letras
//							variable de tipo boolean
							boolean band=false;
//							a la variable cadenaIngresada le asigno la cadena ingresada en el input nombre Real
							String cadenaIngresad= usuario.getNombreReal();
//							convierto cadena a miniscula y reemplazo acentos y espacios
							String cadenaIngresada=cadenaIngresad.toLowerCase().replace(" ", "").replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
									.replace("ú", "u").replace("Á", "a").replace("É", "e").replace("Í", "i").replace("Ó", "o")
									.replace("Ú", "u");
//							recorro la cadena
							for(int i=0;i<=cadenaIngresada.length()-1;i++)
							{
//								verifico que la cadena este entre los rangos correspondientes
								if(!(cadenaIngresada.charAt(i) > 96 && cadenaIngresada.charAt(i) < 123))
									band=true;
							}
//							si la badera es verdadera emito un nuevo mensaje de error
							if(band == true){
								model.addAttribute("registroUsuario", usuario);
								model.addAttribute("registroLocalidad", new Localidad());
								model.addAttribute("usuarios", equipoService.obtenerUsuarios());
								model.addAttribute("localidades", localidadService.obtenerLocalidades());
								model.addAttribute("agregarUTab", "active");
								// activo el mensaje de la vista
								model.addAttribute("mensajeErrorUs2", true);
								// mando el mensaje de error
								model.addAttribute("errorUsuario2",
								"¡ATENCIÓN! El campo nombre real solo admite letras!");		
							
								} else {
	//									si pasa el 3er if compruebo que se hayan ingresado solo letras
	//									variable de tipo boolean
										boolean band2=false;
	//									a la variable cadenaIngresada le asigno la cadena ingresada en el input apellido usuario
										String cadenaIngresad2= usuario.getApellidoReal();
//										convierto cadena a miniscula y reemplazo acentos y espacios
										String cadenaIngresada2=cadenaIngresad2.toLowerCase().replace(" ", "").replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
										.replace("ú", "u").replace("Á", "a").replace("É", "e").replace("Í", "i").replace("Ó", "o")
										.replace("Ú", "u");
	//									recorro la cadena
										for(int i=0;i<=cadenaIngresada2.length()-1;i++)
										{
	//										verifico que la cadena este entre los rangos correspondientes
											if(!(cadenaIngresada2.charAt(i) > 96 && cadenaIngresada2.charAt(i) < 123))
												band2=true;
										}
	//									si la badera es verdadera emito un nuevo mensaje de error
										if(band2 == true){
											model.addAttribute("registroUsuario", usuario);
											model.addAttribute("registroLocalidad", new Localidad());
											model.addAttribute("usuarios", equipoService.obtenerUsuarios());
											model.addAttribute("localidades", localidadService.obtenerLocalidades());
											model.addAttribute("agregarUTab", "active");
											// activo el mensaje de la vista
											model.addAttribute("mensajeErrorUs2b", true);
											// mando el mensaje de error
											model.addAttribute("errorUsuario2b",
											"¡ATENCIÓN! El campo nombre real solo admite letras!");}	
										else {
											
	//											si pasa el 3er if verifico que la cadena ingresada del nombre no sea muy extensa
												if(cadenaIngresada.length()>20)
												{
													model.addAttribute("registroUsuario", usuario);
													model.addAttribute("registroLocalidad", unaLocalidad);
													model.addAttribute("usuarios", equipoService.obtenerUsuarios());
													model.addAttribute("localidades", localidadService.obtenerLocalidades());
													model.addAttribute("agregarUTab", "active");
													// activo el mensaje de la vista
													model.addAttribute("mensajeErrorUs3", true);
													// mando el mensaje de error
													model.addAttribute("errorUsuario3",
													"¡ATENCIÓN! El nombre real es muy largo!");				
													
											} else
//												si pasa el 4to if verifico que la cadena ingresada del apellido no sea muy extensa
													if(cadenaIngresada2.length()>20)
													{
														model.addAttribute("registroUsuario", usuario);
														model.addAttribute("registroLocalidad", unaLocalidad);
														model.addAttribute("usuarios", equipoService.obtenerUsuarios());
														model.addAttribute("localidades", localidadService.obtenerLocalidades());
														model.addAttribute("agregarUTab", "active");
														// activo el mensaje de la vista
														model.addAttribute("mensajeErrorUs3b", true);
														// mando el mensaje de error
														model.addAttribute("errorUsuario3b",
														"¡ATENCIÓN! El nombre real es muy largo!");				
													
														} else{
				//												finalmente si pasa todas las validaciones recien se podria estar en condiciones de guardar el usuario
																equipoService.guardarUsuario(usuario);
																model.addAttribute("registroUsuario", unUsuario);
																model.addAttribute("registroLocalidad", unaLocalidad);
																model.addAttribute("usuarios", equipoService.obtenerUsuarios());
																model.addAttribute("localidades", localidadService.obtenerLocalidades());
																model.addAttribute("usuariosTab", "active");
															}		
													}						
											}
									}
							}
		return "usuarioBD";
	}
	
	@PostMapping("/saveUsuarioE")
	public String EditarUsuario(@Valid @ModelAttribute("registroUsuario") Usuario usuario, BindingResult result, ModelMap model)
	{
		if (result.hasErrors()) {
			model.addAttribute("registroUsuario", usuario);
			model.addAttribute("agregarUTab", "active");
			model.addAttribute("registroLocalidad", unaLocalidad);
			model.addAttribute("usuarios", equipoService.obtenerUsuarios());
			model.addAttribute("localidades", localidadService.obtenerLocalidades());

		}  else {
//							si pasa el 2do if compruebo que se hayan ingresado solo letras
//							variable de tipo boolean
							boolean band=false;
//							a la variable cadenaIngresada le asigno la cadena ingresada en el input nombre Real
							String cadenaIngresad= usuario.getNombreReal();
//							convierto cadena a miniscula y reemplazo acentos y espacios
							String cadenaIngresada=cadenaIngresad.toLowerCase().replace(" ", "").replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
									.replace("ú", "u").replace("Á", "a").replace("É", "e").replace("Í", "i").replace("Ó", "o")
									.replace("Ú", "u");
//							recorro la cadena
							for(int i=0;i<=cadenaIngresada.length()-1;i++)
							{
//								verifico que la cadena este entre los rangos correspondientes
								if(!(cadenaIngresada.charAt(i) > 96 && cadenaIngresada.charAt(i) < 123))
									band=true;
							}
//							si la badera es verdadera emito un nuevo mensaje de error
							if(band == true){
								model.addAttribute("registroUsuario", usuario);
								model.addAttribute("registroLocalidad", new Localidad());
								model.addAttribute("usuarios", equipoService.obtenerUsuarios());
								model.addAttribute("localidades", localidadService.obtenerLocalidades());
								model.addAttribute("agregarUTab", "active");
								// activo el mensaje de la vista
								model.addAttribute("mensajeErrorUs2", true);
								// mando el mensaje de error
								model.addAttribute("errorUsuario2",
								"¡ATENCIÓN! El campo nombre real solo admite letras!");		
							
								} else {
	//									si pasa el 3er if compruebo que se hayan ingresado solo letras
	//									variable de tipo boolean
										boolean band2=false;
	//									a la variable cadenaIngresada le asigno la cadena ingresada en el input apellido usuario
										String cadenaIngresad2= usuario.getApellidoReal();
//										convierto cadena a miniscula y reemplazo acentos y espacios
										String cadenaIngresada2=cadenaIngresad2.toLowerCase().replace(" ", "").replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
												.replace("ú", "u").replace("Á", "a").replace("É", "e").replace("Í", "i").replace("Ó", "o")
												.replace("Ú", "u");
	//									recorro la cadena
										for(int i=0;i<=cadenaIngresada2.length()-1;i++)
										{
	//										verifico que la cadena este entre los rangos correspondientes
											if(!(cadenaIngresada2.charAt(i) > 96 && cadenaIngresada2.charAt(i) < 123))
												band2=true;
										}
	//									si la badera es verdadera emito un nuevo mensaje de error
										if(band2 == true){
											model.addAttribute("registroUsuario", usuario);
											model.addAttribute("registroLocalidad", new Localidad());
											model.addAttribute("usuarios", equipoService.obtenerUsuarios());
											model.addAttribute("localidades", localidadService.obtenerLocalidades());
											model.addAttribute("agregarUTab", "active");
											// activo el mensaje de la vista
											model.addAttribute("mensajeErrorUs2b", true);
											// mando el mensaje de error
											model.addAttribute("errorUsuario2b",
											"¡ATENCIÓN! El campo nombre real solo admite letras!");}	
										else {
											
	//											si pasa el 3er if verifico que la cadena ingresada del nombre no sea muy extensa
												if(cadenaIngresada.length()>20)
												{
													model.addAttribute("registroUsuario", usuario);
													model.addAttribute("registroLocalidad", unaLocalidad);
													model.addAttribute("usuarios", equipoService.obtenerUsuarios());
													model.addAttribute("localidades", localidadService.obtenerLocalidades());
													model.addAttribute("agregarUTab", "active");
													// activo el mensaje de la vista
													model.addAttribute("mensajeErrorUs3", true);
													// mando el mensaje de error
													model.addAttribute("errorUsuario3",
													"¡ATENCIÓN! El nombre real es muy largo!");				
													
											} else
//												si pasa el 4to if verifico que la cadena ingresada del apellido no sea muy extensa
													if(cadenaIngresada2.length()>20)
													{
														model.addAttribute("registroUsuario", usuario);
														model.addAttribute("registroLocalidad", unaLocalidad);
														model.addAttribute("usuarios", equipoService.obtenerUsuarios());
														model.addAttribute("localidades", localidadService.obtenerLocalidades());
														model.addAttribute("agregarUTab", "active");
														// activo el mensaje de la vista
														model.addAttribute("mensajeErrorUs3b", true);
														// mando el mensaje de error
														model.addAttribute("errorUsuario3b",
														"¡ATENCIÓN! El nombre real es muy largo!");				
													
														} else{
				//												finalmente si pasa todas las validaciones recien se podria estar en condiciones de guardar el usuario
																equipoService.guardarUsuario(usuario);
																model.addAttribute("registroUsuario", unUsuario);
																model.addAttribute("registroLocalidad", unaLocalidad);
																model.addAttribute("usuarios", equipoService.obtenerUsuarios());
																model.addAttribute("localidades", localidadService.obtenerLocalidades());
																model.addAttribute("usuariosTab", "active");
																return "usuarioBD";
															}		
													}						
											}
									
							}
		return "editarUsuario";
	}
	
	@RequestMapping("/usuarioBdU")
	public String listaUsuarios(Model model) {
		model.addAttribute("usuariosTab", "active");
		model.addAttribute("registroUsuario", new Usuario());
		model.addAttribute("registroLocalidad", unaLocalidad);
		List<Usuario> usuarios = equipoService.obtenerUsuarios();
		List<Localidad> localidades = localidadService.obtenerLocalidades();
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("localidades", localidades);		
		return "usuarioBD";
	}
	
	@RequestMapping("/usuarioBdL")
	public String listaLocalidad(Model model) {
		model.addAttribute("localidadesTab", "active");
		model.addAttribute("registroUsuario", new Usuario());

		model.addAttribute("registroLocalidad", unaLocalidad);
		List<Usuario> usuarios = equipoService.obtenerUsuarios();
		List<Localidad> localidades = localidadService.obtenerLocalidades();
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("localidades", localidades);		
		return "usuarioBD";
	}
	

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Usuario> usuario = equipoService.obtenerUnUsuario(id);
		model.addAttribute("registroUsuario", usuario);
		return "editarUsuario";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		equipoService.eliminarUsuario(id);
		return "redirect:/usuarioBdU";
	}
	
	@GetMapping("/cancelarUs")
	public String cancelarUsuario(ModelMap model) {
		return "redirect:/usuarioBdU";
	}
	

//	Mapeo para guardar, editar y eliminar una Localidad
	
	@PostMapping("/saveLocalidad")
	public String GuardarLocalidad(@Valid @ModelAttribute("registroLocalidad") Localidad unaLocalidad, BindingResult result, ModelMap model)
	{
//		si existe un error entonces muestro el formulario - Control de campos vacios y de password
		if (result.hasErrors()) {
			model.addAttribute("registroLocalidad", unaLocalidad);
			model.addAttribute("agregarLTab", "active");
			model.addAttribute("registroUsuario", unUsuario);
			model.addAttribute("usuarios", equipoService.obtenerUsuarios());
			model.addAttribute("localidades", localidadService.obtenerLocalidades());

		} else {
			
//			si pasa el primer if entonces hago la verificacion de que el nombre ingresado no se encuentre en la base de datos
//			invoco el metodo de buscar un determinado objeto y lo asigno a una variable 
			 Localidad coincidenciaLoc = localidadService.buscarLocalidadPorNombre(unaLocalidad.getNombre());
//			si la el resultado de coincidencias es diferente a null enctoces quiere decir que existen coincidencias
			 if(coincidenciaLoc != null)
					{
						model.addAttribute("registroUsuario", unUsuario);
						model.addAttribute("registroLocalidad", new Localidad());
						model.addAttribute("usuarios", equipoService.obtenerUsuarios());
						model.addAttribute("localidades", localidadService.obtenerLocalidades());
						model.addAttribute("agregarLTab", "active");
						// activo el mensaje de la vista
						model.addAttribute("mensajeErrorLoc1", true);
						// mando el mensaje de error
						model.addAttribute("errorLocalidad1",
						"¡ATENCIÓN!	La localidad ingresada ya existe en la base de datos");

					} else {
//						si pasa el 2do if compruebo que se hayan ingresado solo letras
//							variable de tipo boolean
							boolean band=false;
//							a la variable cadenaIngresada le asigno la cadena ingresada en el input
							String cadenaIngresad= unaLocalidad.getNombre();
//							convierto cadena a miniscula y reemplazo acentos y espacios
							String cadenaIngresada=cadenaIngresad.toLowerCase().replace(" ", "").replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
									.replace("ú", "u").replace("Á", "a").replace("É", "e").replace("Í", "i").replace("Ó", "o")
									.replace("Ú", "u");
//							recorro la cadena
							for(int i=0;i<=cadenaIngresada.length()-1;i++)
							{
//								verifico que la cadena este entre los rangos correspondientes
								if(!(cadenaIngresada.charAt(i) > 96 && cadenaIngresada.charAt(i) < 123))
									band=true;
							}
//							si la badera es verdadera emito un nuevo mensaje de error
							if(band == true){
								model.addAttribute("registroUsuario", unUsuario);
								model.addAttribute("registroLocalidad", unaLocalidad);
								model.addAttribute("usuarios", equipoService.obtenerUsuarios());
								model.addAttribute("localidades", localidadService.obtenerLocalidades());
								model.addAttribute("agregarLTab", "active");
								// activo el mensaje de la vista
								model.addAttribute("mensajeErrorLoc2", true);
								// mando el mensaje de error
								model.addAttribute("errorLocalidad2",
								"¡ATENCIÓN! Solo se permite el ingreso de letras!");		
							
								} else {
//									si pasa el 3er if verifico que la cadena ingresada no sea muy extensa
									if(cadenaIngresada.length()>20)
									{
										model.addAttribute("registroUsuario", unUsuario);
										model.addAttribute("registroLocalidad", unaLocalidad);
										model.addAttribute("usuarios", equipoService.obtenerUsuarios());
										model.addAttribute("localidades", localidadService.obtenerLocalidades());
										model.addAttribute("agregarLTab", "active");
										// activo el mensaje de la vista
										model.addAttribute("mensajeErrorLoc3", true);
										// mando el mensaje de error
										model.addAttribute("errorLocalidad3",
										"¡ATENCIÓN! La cadena ingresada es muy larga!");				
										
									} else{
//											finalmente si pasa todas las validaciones recien se podria estar en condiciones de guardar la localidad
												localidadService.guardarLocalidad(unaLocalidad);
												model.addAttribute("registroUsuario", unUsuario);
												model.addAttribute("registroLocalidad", new Localidad());
												model.addAttribute("usuarios", equipoService.obtenerUsuarios());
												model.addAttribute("localidades", localidadService.obtenerLocalidades());
												model.addAttribute("localidadesTab", "active");
							
												}		
							
										}
							}
					}
		return "usuarioBD";
	}	
	
	@PostMapping("/saveLocalidadE")
	public String EditarLocalidad(@Valid @ModelAttribute("registroLocalidad") Localidad unaLocalidad, BindingResult result, ModelMap model)
	{
//		si existe un error entonces muestro el formulario - Control de campos vacios y de password
		if (result.hasErrors()) {
			model.addAttribute("registroLocalidad", unaLocalidad);
			model.addAttribute("agregarLTab", "active");
			model.addAttribute("registroUsuario", unUsuario);
			model.addAttribute("usuarios", equipoService.obtenerUsuarios());
			model.addAttribute("localidades", localidadService.obtenerLocalidades());

		} else {
			
//			si pasa el primer if entonces hago la verificacion de que el nombre ingresado no se encuentre en la base de datos
//			invoco el metodo de buscar un determinado objeto y lo asigno a una variable 
			 Localidad coincidenciaLoc = localidadService.buscarLocalidadPorNombre(unaLocalidad.getNombre());
//			si la el resultado de coincidencias es diferente a null enctoces quiere decir que existen coincidencias
			 if(coincidenciaLoc != null)
					{
						model.addAttribute("registroUsuario", unUsuario);
						model.addAttribute("registroLocalidad", new Localidad());
						model.addAttribute("usuarios", equipoService.obtenerUsuarios());
						model.addAttribute("localidades", localidadService.obtenerLocalidades());
						model.addAttribute("agregarLTab", "active");
						// activo el mensaje de la vista
						model.addAttribute("mensajeErrorLoc1", true);
						// mando el mensaje de error
						model.addAttribute("errorLocalidad1",
						"¡ATENCIÓN!	La localidad ingresada ya existe en la base de datos");

					} else {
//						si pasa el 2do if compruebo que se hayan ingresado solo letras
//							variable de tipo boolean
							boolean band=false;
//							a la variable cadenaIngresada le asigno la cadena ingresada en el input
							String cadenaIngresad= unaLocalidad.getNombre();
//							convierto cadena a miniscula y reemplazo acentos y espacios
							String cadenaIngresada=cadenaIngresad.toLowerCase().replace(" ", "").replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
									.replace("ú", "u").replace("Á", "a").replace("É", "e").replace("Í", "i").replace("Ó", "o")
									.replace("Ú", "u");
//							recorro la cadena
							for(int i=0;i<=cadenaIngresada.length()-1;i++)
							{
//								verifico que la cadena este entre los rangos correspondientes
								if(!(cadenaIngresada.charAt(i) > 96 && cadenaIngresada.charAt(i) < 123))
									band=true;
							}
//							si la badera es verdadera emito un nuevo mensaje de error
							if(band == true){
								model.addAttribute("registroUsuario", unUsuario);
								model.addAttribute("registroLocalidad", unaLocalidad);
								model.addAttribute("usuarios", equipoService.obtenerUsuarios());
								model.addAttribute("localidades", localidadService.obtenerLocalidades());
								model.addAttribute("agregarLTab", "active");
								// activo el mensaje de la vista
								model.addAttribute("mensajeErrorLoc2", true);
								// mando el mensaje de error
								model.addAttribute("errorLocalidad2",
								"¡ATENCIÓN! Solo se permite el ingreso de letras!");		
							
								} else {
//									si pasa el 3er if verifico que la cadena ingresada no sea muy extensa
									if(cadenaIngresada.length()>20)
									{
										model.addAttribute("registroUsuario", unUsuario);
										model.addAttribute("registroLocalidad", unaLocalidad);
										model.addAttribute("usuarios", equipoService.obtenerUsuarios());
										model.addAttribute("localidades", localidadService.obtenerLocalidades());
										model.addAttribute("agregarLTab", "active");
										// activo el mensaje de la vista
										model.addAttribute("mensajeErrorLoc3", true);
										// mando el mensaje de error
										model.addAttribute("errorLocalidad3",
										"¡ATENCIÓN! La cadena ingresada es muy larga!");				
										
									} else{
//											finalmente si pasa todas las validaciones recien se podria estar en condiciones de guardar la localidad
												localidadService.guardarLocalidad(unaLocalidad);
												model.addAttribute("registroUsuario", unUsuario);
												model.addAttribute("registroLocalidad", new Localidad());
												model.addAttribute("usuarios", equipoService.obtenerUsuarios());
												model.addAttribute("localidades", localidadService.obtenerLocalidades());
												model.addAttribute("localidadesTab", "active");
							return "usuarioBD";
												}		
							
										}
							}
					}
		return "editarLocalidad";
	}

	@GetMapping("/editarloc/{id}")
	public String editarLoc(@PathVariable Long id, Model model) {
		Optional<Localidad> localidad = localidadService.obtenerUnaLocalidad(id);
		model.addAttribute("registroLocalidad", localidad);
		return "editarLocalidad";
	}
	
	@GetMapping("/eliminarloc/{id}")
	public String eliminarLoc(@PathVariable Long id, Model model) {
		localidadService.eliminarLocalidad(id);
		return "redirect:/usuarioBdL";
	}
	
	@GetMapping("/cancelarLoc")
	public String cancelarEditarLocalidad(ModelMap model) {
		return "redirect:/usuarioBdL";
	}
	
}
