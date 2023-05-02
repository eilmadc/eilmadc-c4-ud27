/**
 * 
 */
package com.ex02.c4.service;

import java.util.List;

import com.ex02.c4.dto.Cientifico;

/**
 * @author elena-01
 *
 */
public interface CientificoService {
	// Metodos del CRUD
	public List<Cientifico> listarCientificos(); // Listar All

	public Cientifico guardarCientifico(Cientifico cientifico); // Guarda un Cientifico CREATE

	public Cientifico cientificoXID(String codigo); // Leer datos de un Cientifico READ

	public Cientifico actualizarCientifico(Cientifico cientifico); // Actualiza datos del Cientifico UPDATE

	public void eliminarCientifico(String codigo);// Elimina el Cientifico DELETE
}
