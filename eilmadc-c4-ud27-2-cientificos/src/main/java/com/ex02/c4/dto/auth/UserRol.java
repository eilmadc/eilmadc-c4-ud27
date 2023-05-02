/**
 * 
 */
package com.ex02.c4.dto.auth;


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
/**
 * @author elena-01
 *
 */
@Entity
@Table(name = "user_roles")
public class UserRol {

	// Atributos de entidad curso
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;

	@ManyToOne
	@JoinColumn(name = "role_id")
	Role role;

	// Constructores
	public UserRol() {

	}

	/**
	 * @param id
	 * @param user
	 * @param rol
	 */
	public UserRol(int id, User user, Role rol) {
		super();
		this.id = id;
		this.user = user;
		this.role = rol;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the rol
	 */
	public Role getRol() {
		return role;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(Role rol) {
		this.role = rol;
	}

	// Methods
	@Override
	public String toString() {
		return "UserRol [id=" + id + ", user=" + user + ", rol=" + role + "]";
	}

}
