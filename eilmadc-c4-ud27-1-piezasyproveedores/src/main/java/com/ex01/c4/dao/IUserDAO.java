/**
 * 
 */
package com.ex01.c4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex01.c4.dto.User;

/**
 * @author elena-01
 *
 */
public interface IUserDAO extends JpaRepository<User, Integer>{

	User findByUsername(String username);
}
