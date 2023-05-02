/**
 * 
 */
package com.ex02.c4.controller;

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

import com.ex02.c4.dto.Asignado;
import com.ex02.c4.service.AsignadoServiceImpl;

/**
 * @author elena-01
 *
 */

@RestController
@RequestMapping("/api")
public class AsignadoController {

	@Autowired
	AsignadoServiceImpl asignadoServiceImpl;

	@GetMapping("/asignado")
	public List<Asignado> listarAsignado() {
		return asignadoServiceImpl.listarAsignado();
	}

	@PostMapping("/asignado")
	public Asignado salvarAsignado(@RequestBody Asignado asignado) {

		return asignadoServiceImpl.guardarAsignado(asignado);
	}

	@GetMapping("/asignado/{id}")
	public Asignado AsignadoXID(@PathVariable(name = "id") int id) {

		return asignadoServiceImpl.asignadoXID(id);
	}

	@PutMapping("/asignado/{id}")
	public Asignado actualizarAsignado(@PathVariable(name = "id") int id, @RequestBody Asignado asignado) {

		Asignado Asignado_seleccionado = new Asignado();

		Asignado_seleccionado = asignadoServiceImpl.asignadoXID(id);

		Asignado_seleccionado.setCientifico(asignado.getCientifico());
		Asignado_seleccionado.setProyecto(asignado.getProyecto());

		return asignadoServiceImpl.actualizarAsignado(Asignado_seleccionado);
	}

	@DeleteMapping("/asignado/{id}")
	public void eliminarAsignado(@PathVariable(name = "id") int id) {
		asignadoServiceImpl.eliminarAsignado(id);
	}

}
