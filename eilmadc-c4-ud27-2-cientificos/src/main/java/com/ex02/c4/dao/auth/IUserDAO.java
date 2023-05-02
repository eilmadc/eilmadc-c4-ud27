/**
 * 
 */
package com.ex02.c4.dao.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex02.c4.dto.auth.User;

/**
 * @author elena-01
 *
 */
public interface IUserDAO extends JpaRepository<User, Integer> {
	User findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
