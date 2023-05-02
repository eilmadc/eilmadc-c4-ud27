/**
 * 
 */
package com.ex02.c4.service;

import java.util.List;

import com.ex02.c4.dto.Proyecto;



/**
 * @author elena-01
 *
 */
public interface ProyectoService {
	// Metodos del CRUD
	public List<Proyecto> listarProyectos(); // Listar All

	public Proyecto guardarProyecto(Proyecto proyecto); // Guarda un Proyecto CREATE

	public Proyecto proyectoXID(String codigo); // Leer datos de un Proyecto READ

	public Proyecto actualizarProyecto(Proyecto proyecto); // Actualiza datos del Proyecto UPDATE

	public void eliminarProyecto(String codigo);// Elimina el Proyecto DELETE
}
