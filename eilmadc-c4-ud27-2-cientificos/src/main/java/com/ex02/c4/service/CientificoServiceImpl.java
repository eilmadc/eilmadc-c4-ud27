/**
 * 
 */
package com.ex02.c4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex02.c4.dao.ICientificoDAO;
import com.ex02.c4.dto.Cientifico;

/**
 * @author elena-01
 *
 */
@Service
public class CientificoServiceImpl implements CientificoService{

	@Autowired
	ICientificoDAO iCientificoDAO;
	
	@Override
	public List<Cientifico> listarCientificos() {
	
		return iCientificoDAO.findAll();
	}

	@Override
	public Cientifico guardarCientifico(Cientifico cientifico) {
	
		return iCientificoDAO.save(cientifico);
	}

	@Override
	public Cientifico cientificoXID(String codigo) {
	
		return iCientificoDAO.findById(codigo).get();
	}

	@Override
	public Cientifico actualizarCientifico(Cientifico cientifico) {
	
		return iCientificoDAO.save(cientifico);
	}

	@Override
	public void eliminarCientifico(String codigo) {
	
		iCientificoDAO.deleteById(codigo);
	}

}
