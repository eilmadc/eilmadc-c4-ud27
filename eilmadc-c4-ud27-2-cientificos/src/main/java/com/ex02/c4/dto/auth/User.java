/**
 * 
 */
package com.ex02.c4.dto.auth;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

/**
 * @author elena-01
 *
 */
@Entity
@Table(name = "users")
public class User {

	// ---------- Attributes ----------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@OneToMany
	@JoinColumn(name = "id")
	private List<UserRol> userrol;

	// ---------- Constructors ----------

	public User() {

	}

	/**
	 * @param id
	 * @param username
	 * @param email
	 * @param password
	 * @param userrol
	 */
	public User(Long id, String username, String email, String password, List<UserRol> userrol) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.userrol = userrol;
	}

	// ---------- Getters and Setters ----------

	public User(String username, String email, String password) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.email = email;
		this.password = password;
	}

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

}
