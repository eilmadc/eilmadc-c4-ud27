/**
 * 
 */
package com.ex02.c4.dao.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex02.c4.dto.auth.*;

/**
 * @author elena-01
 *
 */
public interface IRoleDAO extends JpaRepository<Role, Integer>{
	Role findByRole(ERole name);
}
