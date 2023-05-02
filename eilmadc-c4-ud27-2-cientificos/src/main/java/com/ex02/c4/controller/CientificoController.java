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

import com.ex02.c4.dto.Cientifico;
import com.ex02.c4.service.CientificoServiceImpl;

/**
 * @author elena-01
 *
 */

@RestController
@RequestMapping("/api")
public class CientificoController {

	@Autowired
	CientificoServiceImpl cientificoServiceImpl;

	@GetMapping("/cientificos")
	public List<Cientifico> listarCientifico() {
		return cientificoServiceImpl.listarCientificos();
	}

	@PostMapping("/cientificos")
	public Cientifico salvarCientifico(@RequestBody Cientifico cientifico) {

		return cientificoServiceImpl.guardarCientifico(cientifico);
	}

	@GetMapping("/cientificos/{id}")
	public Cientifico CientificoXID(@PathVariable(name = "id") String id) {

		return cientificoServiceImpl.cientificoXID(id);
	}

	@PutMapping("/cientificos/{id}")
	public Cientifico actualizarCientifico(@PathVariable(name = "id") String id, @RequestBody Cientifico cientifico) {

		Cientifico cientifico_seleccionado = new Cientifico();

		cientifico_seleccionado = cientificoServiceImpl.cientificoXID(id);

		cientifico_seleccionado.setNomapels(cientifico.getNomapels());
		cientifico_seleccionado.setDni(cientifico.getDni());

		return cientificoServiceImpl.actualizarCientifico(cientifico_seleccionado);
	}

	@DeleteMapping("/cientificos/{id}")
	public void eliminarCientifico(@PathVariable(name = "id") String id) {
		cientificoServiceImpl.eliminarCientifico(id);
	}
}
