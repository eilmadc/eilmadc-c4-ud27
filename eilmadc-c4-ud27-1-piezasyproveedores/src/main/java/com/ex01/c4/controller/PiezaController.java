/**
 * 
 */
package com.ex01.c4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex01.c4.dto.Pieza;
import com.ex01.c4.service.PiezaServiceImpl;



/**
 * @author elena-01
 *
 */

@RestController
@RequestMapping("/api")
public class PiezaController {

	
	@Autowired
	PiezaServiceImpl piezaServiceImpl;
	
	@GetMapping("/piezas")
	public List<Pieza> listarPiezas(){
		return piezaServiceImpl.listarPiezas();
	}
	
	
	@PostMapping("/piezas")
	public Pieza salvarPieza(@RequestBody Pieza pieza) {
		
		return piezaServiceImpl.guardarPieza(pieza);
	}
	
	
	@GetMapping("/piezas/{id}")
	public Pieza piezaXID(@PathVariable(name="id") int codigo) {
		

		return piezaServiceImpl.piezaXID(codigo);
	}
	
	@PutMapping("/piezas/{id}")
	public Pieza actualizarPieza(@PathVariable(name="id")int codigo,@RequestBody Pieza pieza) {
		
		Pieza Pieza_seleccionado= new Pieza();
		
		Pieza_seleccionado= piezaServiceImpl.piezaXID(codigo);
		
		Pieza_seleccionado.setNombre(pieza.getNombre());
		
		return piezaServiceImpl.actualizarPieza(Pieza_seleccionado);
	}
	
	@DeleteMapping("/piezas/{codigo}")
	public void eliminarPieza(@PathVariable(name="codigo")int codigo) {
		piezaServiceImpl.eliminarPieza(codigo);
	}
}
