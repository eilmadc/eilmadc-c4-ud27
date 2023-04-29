/**
 * 
 */
package com.ex01.c4.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author elena-01
 *
 */
@Entity
@Table(name = "roles")
public class Rol {
	// Atributos de entidad curso
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;
	@Column(name = "rol")
	private String rol;

	@OneToMany
	@JoinColumn(name = "id")
	private List<UserRol> userrol;

	// Constructores

	public Rol() {

	}

	/**
	 * @param id
	 * @param rol
	 * @param userrol
	 */
	public Rol(int id, String rol, List<UserRol> userrol) {
		super();
		this.id = id;
		this.rol = rol;
		this.userrol = userrol;
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
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * @return the userrol
	 */
	public List<UserRol> getUserrol() {
		return userrol;
	}

	/**
	 * @param userrol the userrol to set
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "UserRol")
	public void setUserrol(List<UserRol> userrol) {
		this.userrol = userrol;
	}

	// Methods
	@Override
	public String toString() {
		return "Rol [id=" + id + ", rol=" + rol + ", userrol=" + userrol + "]";
	}

}
