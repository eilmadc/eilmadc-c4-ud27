/**
 * 
 */
package com.ex01.c4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex01.c4.dto.Proveedor;
import com.ex01.c4.service.ProveedorServiceImpl;



/**
 * @author elena-01
 *
 */

@RestController
@RequestMapping("/api")
public class ProveedorController {

	@Autowired
	ProveedorServiceImpl proveedorServiceImpl;
	
	@GetMapping("/proveedores")
	public List<Proveedor> listarCproveedores(){
		return proveedorServiceImpl.listarProveedors();
	}
	
	
	@PostMapping("/proveedores")
	public Proveedor salvarProveedor(@RequestBody Proveedor proveedor) {
		
		return proveedorServiceImpl.guardarProveedor(proveedor);
	}
	
	
	@GetMapping("/proveedores/{id}")
	public Proveedor proveedorXID(@PathVariable(name="id") String id) {

		return proveedorServiceImpl.proveedorXID(id);
	}
	
	@PutMapping("/proveedores/{id}")
	public Proveedor actualizarProveedor(@PathVariable(name="id")String id,@RequestBody Proveedor proveedor) {
		
		Proveedor Proveedor_seleccionado= new Proveedor();
		
		Proveedor_seleccionado= proveedorServiceImpl.proveedorXID(id);
		
		Proveedor_seleccionado.setNombre(proveedor.getNombre());
		
		return proveedorServiceImpl.actualizarProveedor(Proveedor_seleccionado);
	}
	
	@DeleteMapping("/proveedores/{id}")
	public void eliminarProveedor(@PathVariable(name="id") String id) {
		proveedorServiceImpl.eliminarProveedor(id);
	}
}
