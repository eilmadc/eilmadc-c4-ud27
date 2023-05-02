/**
 * 
 */
package com.ex02.c4.dto.auth;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

/**
 * @author elena-01
 *
 */

@Entity
@Table(name = "roles")
public class Role {

	// ---------- Attributes ----------

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/*
	 * Attribute that get the value from enum ERole.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name="rol",length = 20)
	private ERole name;

	@OneToMany
	@JoinColumn(name = "id")
	private List<UserRol> userrol;
	
	
	
	// ---------- Constructors ----------

	/*
	 * Constructor by default
	 */
	public Role() {

	}

	/**
	 * Constructor with params
	 * 
	 * @param id
	 * @param name
	 */
	public Role(Integer id, ERole name) {
		this.id = id;
		this.name = name;
	}

	// ---------- Getters and Setters ----------

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public ERole getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	@JsonIgnore 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "UserRol")
	public void setName(ERole name) {
		this.name = name;
	}

}
