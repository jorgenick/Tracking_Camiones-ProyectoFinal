package ar.edu.unju.fi.tracking.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

//import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;


/**
 * Clase que permite representar el objeto de tipo Vehiculo
 * @author Jorge Tolaba
 */
/**
 * Para que la Clase Vehiculo sea administrada por el
 * contenedor de Spring agregamos la anotacion Component 
 * @author Jorge Tolaba
 */
@Component
@Entity
@Table(name="vehiculos")
public class Vehiculo implements Serializable{
		
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_VEHICULO", nullable=false)
	private Long id;	
	
	
	//	@GeneratedValue(strategy=GenerationType.AUTO,generator="native") estaba en el anterior en id
	//	@GenericGenerator(name="native",strategy="native")
		
		
	/**
	* Atributo que representa la patente del vehiculo
	*/	
		@Column
		@NotBlank(message = "La patente no debe quedar en blanco")
		private String patente;
			
	/**
	* Atributo que representa el color del vehiculo
	*/
		@Column
		private String color;
	/**
	 * Atributo que representa el titular del vehiculo
	 */
		@Column
		@NotBlank(message = "El titular no debe quedar en blanco")
		private String titular;
	/**
	 * Atributo que representa la marca del vehiculo
	 */
		@Column
		private String marca;
	/**
	 * Atributo que representa el modelo del vehiculo
	 */
		@Column
		private String modelo;
	/**
	 * Atributo que representa el tipo de vehiculo
	 */
		@Column
		private String tipo;
	/**
	 * Atributo que representa el numero de chasis del vehiculo
	 */
		@Column
		private String numeroChasis;
	/**
	 * Atributo que representa el numeror de Motor del vehiculo
	 */
		@Column
		private String numeroMotor;
		
		@OneToMany(mappedBy = "vehiculo", fetch = FetchType.LAZY)
		private List<RegistroTracking >registros;
		
		
		//verificar
		//@OneToMany(mappedBy = "unVehiculo", fetch = FetchType.LAZY)
		//private List<Tripulante >tripulantes;
			
		
	//************CONTRUCTORES**************
	/**
	 * Se utiliza un constructor sin parametros
	 */
		public Vehiculo() {
			
		}
		
	/**
	 * @param id
	 * @param patente
	 * @param color
	 * @param titular
	 * @param marca
	 * @param modelo
	 * @param tipo
	 * @param numeroChasis
	 * @param numeroMotor
	 * @param registros
	 */
	public Vehiculo(Long id, String patente, String color, String titular, String marca, String modelo, String tipo,
			String numeroChasis, String numeroMotor, List<RegistroTracking> registros) {
		this.id = id;
		this.patente = patente;
		this.color = color;
		this.titular = titular;
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		this.numeroChasis = numeroChasis;
		this.numeroMotor = numeroMotor;
		this.registros = registros;
	}
	
	//**************ACCESORES***************
		
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Devuelve el la patente del vehiculo
	 * @return patente
	 */
	public String getPatente() {
		return patente;
	}
	
	/**
	 * Se asigna el valor de la patente
	 * @param patente
	 */
	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	/**
	 * Devuelve el color del vehiculo
	 * @return color del vheiculo
	 */
	public String getColor() {
		return color;
	}
	/**
	 * Se asigna el color del vehiculo
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * Devuelve el titular del vehiculo
	 * @return titular
	 */
	public String getTitular() {
		return titular;
	}
	/**
	 * Se asigna el titular del vehiculo
	 * @param titular
	 */
	public void setTitular(String titular) {
		this.titular = titular;
	}
	/**
	 * Decuelve la marcar del vehiculo
	 * @return marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * Se asigna la marca del vehiculo
	 * @param marca
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * Devuelve el modelo del vehiculo
	 * @return modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * Se asigna el modelo del vehiculo
	 * @param modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * Devuelve el tipo de vehiculo
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * Se asigna el tipo de vehiculo
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * Devuelve el numero de chasis del vehiculo
	 * @return numero de chasis
	 */
	public String getNumeroChasis() {
		return numeroChasis;
	}
	/**
	 * Se asigan el numeero de chasis del vehiculo
	 * @param numeroChasis
	 */
	public void setNumeroChasis(String numeroChasis) {
		this.numeroChasis = numeroChasis;
	}
	/**
	 * Devuelve el numero de motor del vehiculo
	 * @return numero de motor
	 */
	public String getNumeroMotor() {
		return numeroMotor;
	}
	/**
	 * Se asigna el numero de motor del vehiculo
	 * @param numeroMotor
	 */
	public void setNumeroMotor(String numeroMotor) {
		this.numeroMotor = numeroMotor;
	}
	
	/**
	 * @return the registros
	 */
	public List<RegistroTracking> getRegistros() {
		return registros;
	}
	/**
	 * @param registros the registros to set
	 */
	public void setRegistros(List<RegistroTracking> registros) {
		this.registros = registros;
	}
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//*********METODO TO STRING*************
	
	@Override
	public String toString() {
		return "Vehiculo [patente=" + patente + ", color=" + color + ", titular=" + titular + ", marca=" + marca
				+ ", modelo=" + modelo + ", tipo=" + tipo + ", numeroChasis=" + numeroChasis + ", numeroMotor="
				+ numeroMotor + "]";
	}
}