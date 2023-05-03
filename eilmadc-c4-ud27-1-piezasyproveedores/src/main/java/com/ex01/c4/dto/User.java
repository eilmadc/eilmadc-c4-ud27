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
@Table(name = "users")
public class User {
	// Atributos de entidad curso
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "rol")
	private String rol;

	@OneToMany

	@JoinColumn(name = "id")
	private List<UserRol> userrol;

	// Constructores

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param userrol
	 */
	public User(int id, String username, String email, String password, List<UserRol> userrol) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email=email;
		this.userrol = userrol;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*	*//**
			 * @return the userrol
			 */
	/*
	 * public List<UserRol> getUserrol() { return userrol; }
	 * 
	 *//**
		 * @param userrol the userrol to set
		 *//*
			 * @JsonIgnore
			 * 
			 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "UserRol") public void
			 * setUserrol(List<UserRol> userrol) { this.userrol = userrol; }
			 * 
			 * // Methods
			 * 
			 * @Override public String toString() { return "User [id=" + id + ", username="
			 * + username + ", password=" + password + ", userrol=" + userrol + "]"; }
			 */

}
