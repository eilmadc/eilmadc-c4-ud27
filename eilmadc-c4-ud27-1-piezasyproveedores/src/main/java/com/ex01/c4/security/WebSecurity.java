package com.ex01.c4.security;

import static com.ex01.c4.security.Constants.LOGIN_URL;
import static com.ex01.c4.security.Constants.PIEZAS_URL;
import static com.ex01.c4.security.Constants.PROVEEDOR_URL;
import static com.ex01.c4.security.Constants.SUMINISTRA_URL;

import static com.ex01.c4.security.Constants.ROLE_ADMIN;
import static com.ex01.c4.security.Constants.ROLE_STANDARD;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class WebSecurity{

	private UserDetailsService userDetailsService;

	public WebSecurity(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


	protected SecurityFilterChain  filterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws Exception{
		/*
		 * 1. Se desactiva el uso de cookies
		 * 2. Se activa la configuración CORS con los valores por defecto
		 * 3. Se desactiva el filtro CSRF
		 * 4. Se indica que el login no requiere autenticación
		 * 5. Se indica que el resto de URLs esten securizadas
		 */
		try {
			httpSecurity
				.csrf().disable()
				.authorizeHttpRequests((authz) -> authz
				.requestMatchers(HttpMethod.GET, LOGIN_URL).permitAll()
				.requestMatchers(HttpMethod.GET, "/users/{username}").hasRole(ROLE_ADMIN)
				.requestMatchers(HttpMethod.POST, "/users/").hasRole(ROLE_ADMIN)
				.requestMatchers(HttpMethod.GET, "/api/**").hasRole(ROLE_STANDARD)
				.requestMatchers(HttpMethod.POST, "/api/**").hasRole(ROLE_STANDARD)
				.anyRequest().authenticated().and()
					.addFilter(new JWTAuthenticationFilter(authenticationManager))
					.addFilter(new JWTAuthorizationFilter(authenticationManager))
				
				)
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.httpBasic()
				;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return httpSecurity.build();
	}

	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Se define la clase que recupera los usuarios y el algoritmo para procesar las passwords
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
}