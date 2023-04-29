/**
 * 
 */
package com.ex01.c4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex01.c4.dao.IPiezaDAO;
import com.ex01.c4.dto.Pieza;

/**
 * @author elena-01
 *
 */
@Service
public class PiezaServiceImpl implements IPiezaService{
	
	@Autowired
	IPiezaDAO iPiezaDAO;

	@Override
	public List<Pieza> listarPiezas() {
		
		return iPiezaDAO.findAll();
	}

	@Override
	public Pieza guardarPieza(Pieza pieza) {
		
		return iPiezaDAO.save(pieza);
	}

	@Override
	public Pieza piezaXID(int id) {
		
		return iPiezaDAO.findById(id).get();
	}

	@Override
	public Pieza actualizarPieza(Pieza pieza) {
		
		return iPiezaDAO.save(pieza);
	}

	@Override
	public void eliminarPieza(int id) {
		
		iPiezaDAO.deleteById(id);
	}

}
