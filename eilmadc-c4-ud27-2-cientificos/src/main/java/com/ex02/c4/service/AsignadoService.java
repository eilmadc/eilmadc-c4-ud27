/**
 * 
 */
package com.ex02.c4.service;

import java.util.List;

import com.ex02.c4.dto.Asignado;

/**
 * @author elena-01
 *
 */
public interface AsignadoService {

	//Metodos del CRUD
	public List<Asignado> listarAsignado(); //Listar All 
	
	public Asignado guardarAsignado(Asignado asignado);	//Guarda un Asignado CREATE
	
	public Asignado asignadoXID(int id); //Leer datos de un Asignado READ
	
	public Asignado actualizarAsignado(Asignado asignado); //Actualiza datos del Asignado UPDATE
	
	public void eliminarAsignado(int id);// Elimina el Asignado DELETE
}
