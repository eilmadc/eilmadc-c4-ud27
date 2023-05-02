/**
 * 
 */
package com.ex02.c4.dao.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex02.c4.dto.auth.*;

/**
 * @author elena-01
 *
 */
public interface IRoleDAO extends JpaRepository<Role, Integer>{

	Optional<Role> findByName(ERole name);
}
