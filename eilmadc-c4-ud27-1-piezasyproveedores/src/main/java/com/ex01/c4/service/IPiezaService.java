/**
 * 
 */
package com.ex01.c4.service;

import java.util.List;

import com.ex01.c4.dto.Pieza;


/**
 * @author elena-01
 *
 */
public interface IPiezaService {
	//Metodos del CRUD
	public List<Pieza> listarPiezas(); //Listar All 
	
	public Pieza guardarPieza(Pieza pieza);	//Guarda un Pieza CREATE
	
	public Pieza piezaXID(int codigo); //Leer datos de un Pieza READ
	
	public Pieza actualizarPieza(Pieza pieza); //Actualiza datos del Pieza UPDATE
	
	public void eliminarPieza(int codigo);// Elimina el Pieza DELETE
}
