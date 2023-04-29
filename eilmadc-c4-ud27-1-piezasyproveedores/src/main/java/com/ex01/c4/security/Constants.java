package com.ex01.c4.security;

public class Constants {

	// Spring Security

	public static final String LOGIN_URL = "/login";
	public static final String PIEZAS_URL = "/api/piezas";
	public static final String PROVEEDOR_URL = "/api/proveedor";
	public static final String SUMINISTRA_URL = "/api/suministra";
	
	public static final String ROLE_ADMIN = "admin";
	public static final String ROLE_MANAGER = "manager";
	public static final String ROLE_TECH = "technical";
	public static final String ROLE_STANDARD = "standard";
	
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";

	// JWT

	public static final String ISSUER_INFO = "Elena López";
	public static final String SUPER_SECRET_KEY = "1234";
	public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day

}