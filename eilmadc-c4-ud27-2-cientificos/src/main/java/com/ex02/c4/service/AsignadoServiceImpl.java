/**
 * 
 */
package com.ex02.c4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex02.c4.dao.IAsignadoDAO;
import com.ex02.c4.dto.Asignado;

/**
 * @author elena-01
 *
 */
@Service
public class AsignadoServiceImpl implements AsignadoService {

	@Autowired
	IAsignadoDAO iAsignadoDAO;

	@Override
	public List<Asignado> listarAsignado() {

		return iAsignadoDAO.findAll();
	}

	@Override
	public Asignado guardarAsignado(Asignado asignado) {

		return iAsignadoDAO.save(asignado);
	}

	@Override
	public Asignado asignadoXID(int id) {

		return iAsignadoDAO.findById(id).get();
	}

	@Override
	public Asignado actualizarAsignado(Asignado asignado) {

		return iAsignadoDAO.save(asignado);
	}

	@Override
	public void eliminarAsignado(int id) {

		iAsignadoDAO.deleteById(id);

	}
}
