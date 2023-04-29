/**
 * 
 */
package com.ex01.c4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex01.c4.dao.ISuministraDAO;
import com.ex01.c4.dto.Suministra;

/**
 * @author elena-01
 *
 */
@Service
public class SuministraServiceImpl implements ISuministraService {

	@Autowired
	ISuministraDAO iSuministraDAO;

	@Override
	public List<Suministra> listarSuministra() {

		return iSuministraDAO.findAll();
	}

	@Override
	public Suministra guardarSuministra(Suministra suministra) {

		return iSuministraDAO.save(suministra);
	}

	@Override
	public Suministra suministraXID(int id) {

		return iSuministraDAO.findById(id).get();
	}

	@Override
	public Suministra actualizarSuministra(Suministra suministra) {

		return iSuministraDAO.save(suministra);
	}

	@Override
	public void eliminarSuministra(int id) {

		iSuministraDAO.deleteById(id);
	}

}
