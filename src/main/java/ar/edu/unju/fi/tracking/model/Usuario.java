package ar.edu.unju.fi.tracking.model;

import org.springframework.stereotype.Component;

/**
 * Clase que permite representar el objeto de tipo Usuario
 * @author Jorge Tolaba
 */
/**
 * Para que la Clase Usuario sea administrada por el
 * contenedor de Spring agregamos la anotacion Component 
 * @author Jorge Tolaba
 */
@Component
public class Usuario {
	/**
	 * Atributo que representa el nombre del Usuario
	 */
	private String nombreUsuario;
	/**
	 * Atributo que representa la contraseña del Usuario
	 */
	private String password;
	/**
	 * Atributo que representa el nombre real del Usuario
	 */
	private String nombreReal;
	/**
	 * Atributo que representa el apellido real del Usuario
	 */
	private String apellidoReal;
	/**
	 * Atributo que representa el tipo de Usuario
	 */
	private String tipoUsuario;
	
//------------METODOS CONSTRUCTORES--------------
	/**
	* Constructor sin parametros
	*/
	public Usuario() {
			
	}
	//------------ACCESORES------------
	/**
	 * Devuelve el nombre del Usuario
	 * @return nombre
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * Se asigna nombre de usuario
	 * @param nombreUsuario
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * Devuelve la contraseña del Usuario
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Se asigna la contraseña del usuario
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Devuelve nombre real del Usuario
	 * @return nombre real
	 */
	public String getNombreReal() {
		return nombreReal;
	}
	/**
	 * Se asigna el nombre real del usuario
	 * @param nombreReal
	 */
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}
	/**
	 * Devuelve apellido real del Usuario
	 * @return apellido real
	 */
	public String getApellidoReal() {
		return apellidoReal;
	}
	/**
	 * Se asigna el apellido real del usuario
	 * @param apellidoReal
	 */
	public void setApellidoReal(String apellidoReal) {
		this.apellidoReal = apellidoReal;
	}
	/**
	 * Devuelve tipo de Usuario
	 * @return tipo
	 */
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	/**
	 * Se asigna tipo de usuario
	 * @param tipoUsuario
	 */
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	//*********METODO TO STRING*************
	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", password=" + password + ", nombreReal=" + nombreReal
				+ ", apellidoReal=" + apellidoReal + ", tipoUsuario=" + tipoUsuario + "]";
	}
	
}
