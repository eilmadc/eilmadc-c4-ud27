/**
 * 
 */
package com.ex01.c4.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author elena-01
 *
 */
@Entity
@Table(name = "proveedores")
public class Proveedor {

	// Atributos de entidad curso
	@Id 
	@Column(name = "id")
	private String id;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Suministra> suministra;

	// Constructores

	public Proveedor() {

	}

	/**
	 * @param id
	 * @param nombre
	 * @param suministra
	 */
	public Proveedor(String id, String nombre, List<Suministra> suministra) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.suministra = suministra;
	}

	// Getters y Setters
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the suministra
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Suministra")
	public List<Suministra> getSuministra() {
		return suministra;
	}

	/**
	 * @param suministra the suministra to set
	 */
	public void setSuministra(List<Suministra> suministra) {
		this.suministra = suministra;
	}

	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + ", suministra=" + suministra + "]";
	}

}
