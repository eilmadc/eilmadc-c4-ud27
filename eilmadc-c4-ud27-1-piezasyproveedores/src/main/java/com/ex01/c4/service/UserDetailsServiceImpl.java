/**
 * 
 */
package com.ex01.c4.service;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ex01.c4.dao.IUserDAO;

/**
 * @author elena-01
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	// Atributo
	private IUserDAO iUserDAO;

	// Constructor
	public UserDetailsServiceImpl(IUserDAO iUserDAO) {
		this.iUserDAO = iUserDAO;
	}

	// Methods
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		com.ex01.c4.dto.User user = iUserDAO.findByUsername(username);
		// exception control
		// check that user is not null
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		return new User (user.getUsername(), user.getPassword(), emptyList());
	}

}
