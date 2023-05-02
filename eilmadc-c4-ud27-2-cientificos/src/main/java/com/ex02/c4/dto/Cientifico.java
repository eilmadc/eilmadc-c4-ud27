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
@Table(name = "cientificos")
public class Cientifico {

	// Atributos de entidad curso
	@Id
	@Column(name = "dni")
	private String dni;

	@Column(name = "nomapels")
	private String nomapels;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Asignado> asignado;

	// Constructores

	public Cientifico() {

	}

	/**
	 * @param dni
	 * @param nomapels
	 * @param asignado
	 */
	public Cientifico(String dni, String nomapels, List<Asignado> asignado) {
		super();
		this.dni = dni;
		this.nomapels = nomapels;
		this.asignado = asignado;
	}

	// Getters y Setters

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the nomapels
	 */
	public String getNomapels() {
		return nomapels;
	}

	/**
	 * @param nomapels the nomapels to set
	 */
	public void setNomapels(String nomapels) {
		this.nomapels = nomapels;
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
		return "Cientifico [dni=" + dni + ", nomapels=" + nomapels + ", asignado=" + asignado + "]";
	}

	
}
