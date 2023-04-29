/**
 * 
 */
package com.ex01.c4.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author elena-01
 *
 */

@Entity
@Table(name = "suministra")
public class Suministra {

	// Atributos de entidad curso
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;

	@ManyToOne
	@JoinColumn(name = "codigo_pieza")
	Pieza pieza;

	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	Proveedor proveedor;
	
	@Column(name = "precio")
	private int precio;

	// Constructores
	public Suministra() {

	}

	/**
	 * @param id
	 * @param pieza
	 * @param proveedor
	 */
	public Suministra(int id, Pieza pieza, Proveedor proveedor, int precio) {
		super();
		this.id = id;
		this.pieza = pieza;
		this.proveedor = proveedor;
		this.precio = precio;
	}

	// Getters y Setters

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the pieza
	 */
	public Pieza getPieza() {
		return pieza;
	}

	/**
	 * @param pieza the pieza to set
	 */
	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	/**
	 * @return the proveedor
	 */
	public Proveedor getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

		
	/**
	 * @return the precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Suministra [id=" + id + ", pieza=" + pieza + ", proveedor=" + proveedor + "]";
	}

}
