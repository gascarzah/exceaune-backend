package com.gafahtec.exceaune.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gafahtec.exceaune.exception.ModeloNotFoundException;
import com.gafahtec.exceaune.model.Persona;
import com.gafahtec.exceaune.service.IPersonaService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/personas")
public class PersonaController {

	private final  IPersonaService iPersonaService;

	@GetMapping
	public ResponseEntity<List<Persona>> listar() throws Exception{
		List<Persona> lista = iPersonaService.listar();
		return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Persona> listarPorId(@PathVariable("id") Long id)throws Exception{
		Persona obj = iPersonaService.listarPorId(id);
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Persona> registrar(@Valid @RequestBody Persona Persona)throws Exception{
		Persona obj = iPersonaService.registrar(Persona);
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Persona> modifiar(@Valid @RequestBody Persona Persona) throws Exception{
		Persona obj = iPersonaService.modificar(Persona);
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}
	
	public ResponseEntity<Void> eliminar(@PathVariable("id") Long id) throws Exception{
		Persona obj = iPersonaService.listarPorId(id);
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		iPersonaService.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	

		

}
