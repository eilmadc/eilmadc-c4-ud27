/**
 * 
 */
package com.ex01.c4.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex01.c4.dao.IUserDAO;
import com.ex01.c4.dto.User;

/**
 * @author elena-01
 *
 */

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class UserController {

	// Attributes
	private IUserDAO iUserDAO;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// Constructor
	public UserController(IUserDAO iUserDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.iUserDAO = iUserDAO;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		System.out.println("Password: "+bCryptPasswordEncoder.encode("test"));
	}

	// EndPoints

	@GetMapping("/response-entity-builder-with-http-headers")
	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Baeldung-Example-Header", "Value-ResponseEntityBuilderWithHttpHeaders");

		return ResponseEntity.ok().headers(responseHeaders).body("Response with header using ResponseEntity");
	}

	@PostMapping("/users/")
	public User saveUser(@RequestBody User user) {
		try {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			iUserDAO.save(user);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	@GetMapping("/users/")
	public List<User> getAllUsers() {
		return iUserDAO.findAll();
	}

	@GetMapping("/users/{username}")
	public User getUser(@PathVariable String username) {
		return iUserDAO.findByUsername(username);
	}

	@DeleteMapping("/users/{id}")
	public String eliminarUser(@PathVariable(name = "id") Integer id) {
		iUserDAO.deleteById(id);
		return "User deleted.";
	}

}
