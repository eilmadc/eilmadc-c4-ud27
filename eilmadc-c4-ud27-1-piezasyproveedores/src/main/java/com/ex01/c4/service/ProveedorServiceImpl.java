/**
 * 
 */
package com.ex01.c4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex01.c4.dao.IProveedorDAO;
import com.ex01.c4.dto.Proveedor;

/**
 * @author elena-01
 *
 */
@Service
public class ProveedorServiceImpl implements IProveedorService{
	
	@Autowired
	IProveedorDAO iProveedorDAO;

	@Override
	public List<Proveedor> listarProveedors() {
		
		return iProveedorDAO.findAll();
	}

	@Override
	public Proveedor guardarProveedor(Proveedor proveedor) {
		
		return iProveedorDAO.save(proveedor);
	}

	@Override
	public Proveedor proveedorXID(String id) {
		
		return iProveedorDAO.findById(id).get();
	}

	@Override
	public Proveedor actualizarProveedor(Proveedor proveedor) {
		
		return iProveedorDAO.save(proveedor);
	}

	public void eliminarProveedor(String id) {
		iProveedorDAO.deleteById(id);
	}

}
