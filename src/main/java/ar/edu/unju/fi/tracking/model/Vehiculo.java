package ar.edu.unju.fi.tracking.model;
/**
 * Clase que permite representar el objeto de tipo Vehiculo
 * @author Jorge Tolaba
 */
public class Vehiculo {
/**
 * Atributo que representa la patente del vehiculo
 */
	private String patente;
/**
* Atributo que representa el color del vehiculo
*/
	private String color;
/**
 * Atributo que representa el titular del vehiculo
 */
	private String titular;
/**
 * Atributo que representa la marca del vehiculo
 */
	private String marca;
/**
 * Atributo que representa el modelo del vehiculo
 */
	private String modelo;
/**
 * Atributo que representa el tipo de vehiculo
 */
	private String tipo;
/**
 * Atributo que representa el numero de chasis del vehiculo
 */
	private String numeroChasis;
/**
 * Atributo que representa el numeror de Motor del vehiculo
 */
	private String numeroMotor;
	
//************CONTRUCTORES**************
/**
 * Se utiliza un constructor sin parametros
 */
	public Vehiculo() {
		
	}
//**************ACCESORES***************
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
//*********METODO TO STRING*************

@Override
public String toString() {
	return "Vehiculo [patente=" + patente + ", color=" + color + ", titular=" + titular + ", marca=" + marca
			+ ", modelo=" + modelo + ", tipo=" + tipo + ", numeroChasis=" + numeroChasis + ", numeroMotor="
			+ numeroMotor + "]";
}

}
