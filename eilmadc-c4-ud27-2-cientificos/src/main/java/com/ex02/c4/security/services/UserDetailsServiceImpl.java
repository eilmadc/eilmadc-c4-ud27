/**
 * 
 */
package com.ex02.c4.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ex02.c4.dao.auth.IUserDAO;
import com.ex02.c4.dto.auth.User;

import jakarta.transaction.Transactional;

/**
 * @author elena-01
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	IUserDAO iUserDAO;

	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = null;
		try {
		user = iUserDAO.findByUsername(username);

		}catch(UsernameNotFoundException e) {
			System.out.println(("User Not Found with username: " + username));
		}

		return UserDetailsImpl.build(user);
	}
	
}
