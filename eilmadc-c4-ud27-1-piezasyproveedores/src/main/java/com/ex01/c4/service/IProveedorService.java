/**
 * 
 */
package com.ex01.c4.service;

import java.util.List;

import com.ex01.c4.dto.Proveedor;

/**
 * @author elena-01
 *
 */
public interface IProveedorService {
	
	// Metodos del CRUD
	public List<Proveedor> listarProveedors(); // Listar All

	public Proveedor guardarProveedor(Proveedor proveedor); // Guarda un Proveedor CREATE

	public Proveedor proveedorXID(String id); // Leer datos de un Proveedor READ

	public Proveedor actualizarProveedor(Proveedor proveedor); // Actualiza datos del Proveedor UPDATE

	public void eliminarProveedor(String id);// Elimina el Proveedor DELETE
	
}
