/**
 * 
 */
package com.ex02.c4.dto;

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
@Table(name = "proyecto")
public class Proyecto {

	// Atributos de entidad curso
	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "horas")
	private String horas;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Asignado> asignado;

	// Constructores

	public Proyecto() {

	}

	/**
	 * @param id
	 * @param nombre
	 * @param horas
	 * @param asignado
	 */
	public Proyecto(String id, String nombre, String horas, List<Asignado> asignado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
		this.asignado = asignado;
	}

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
	 * @return the horas
	 */
	public String getHoras() {
		return horas;
	}

	/**
	 * @param horas the horas to set
	 */
	public void setHoras(String horas) {
		this.horas = horas;
	}

	/**
	 * @return the asignado
	 */
	public List<Asignado> getAsignado() {
		return asignado;
	}

	/**
	 * @param asignado the asignado to set
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Asignado")
	public void setAsignado(List<Asignado> asignado) {
		this.asignado = asignado;
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", horas=" + horas + ", asignado=" + asignado + "]";
	}

}
