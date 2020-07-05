package ar.edu.unju.fi.tracking.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
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
@Entity
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	/**
	 * Atributo que representa el nombre del Usuario
	 */
	@Column
	private String nombreUsuario;
	/**
	 * Atributo que representa la contraseña del Usuario
	 */
	@Column
	private String password;
	/**
	 * Atributo que representa el nombre real del Usuario
	 */
	@Column
	private String nombreReal;
	/**
	 * Atributo que representa el apellido real del Usuario
	 */
	@Column
	private String apellidoReal;
	/**
	 * Atributo que representa el tipo de Usuario
	 */
	@Column
	private String tipoUsuario;
	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaRegistro;
	
	/**
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<RegistroTracking> registro =new ArrayList<RegistroTracking>();
	*/
	
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
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * @return the registro
	 */
//	public List<RegistroTracking> getRegistro() {
//		return registro;
//	}
	/**
	 * @param registro the registro to set
	 */
//	public void setRegistro(List<RegistroTracking> registro) {
//		this.registro = registro;
//	}
	
	/**
	 * @return the fechaRegistro
	 */
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}
	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	//*********METODO TO STRING*************
	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", password=" + password + ", nombreReal=" + nombreReal
				+ ", apellidoReal=" + apellidoReal + ", tipoUsuario=" + tipoUsuario + "]";
	}
	
}