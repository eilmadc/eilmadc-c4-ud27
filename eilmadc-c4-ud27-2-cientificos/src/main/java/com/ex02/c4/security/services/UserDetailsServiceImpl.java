/**
 * 
 */
package com.ex02.c4.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ex02.c4.dao.auth.IUserDAO;
import com.ex02.c4.dto.auth.User;
import com.ex02.c4.security.services.UserDetailsImpl;

/**
 * @author elena-01
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	IUserDAO iUserDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = iUserDAO.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}
	
}
