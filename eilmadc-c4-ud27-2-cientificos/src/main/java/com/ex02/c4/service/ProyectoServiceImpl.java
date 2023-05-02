/**
 * 
 */
package com.ex02.c4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex02.c4.dao.IProyectoDAO;
import com.ex02.c4.dto.Proyecto;

/**
 * @author elena-01
 *
 */
@Service
public class ProyectoServiceImpl implements ProyectoService {

	@Autowired
	IProyectoDAO iProyectoDAO;

	@Override
	public List<Proyecto> listarProyectos() {

		return iProyectoDAO.findAll();
	}

	@Override
	public Proyecto guardarProyecto(Proyecto proyecto) {

		return iProyectoDAO.save(proyecto);
	}

	@Override
	public Proyecto proyectoXID(String codigo) {

		return iProyectoDAO.findById(codigo).get();
	}

	@Override
	public Proyecto actualizarProyecto(Proyecto proyecto) {

		return iProyectoDAO.save(proyecto);
	}

	@Override
	public void eliminarProyecto(String codigo) {
		// TODO Auto-generated method stub
		iProyectoDAO.deleteById(codigo);
	}



}
