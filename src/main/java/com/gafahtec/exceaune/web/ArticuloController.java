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
import com.gafahtec.exceaune.model.Articulo;
import com.gafahtec.exceaune.service.IArticuloService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/articulos" )
public class ArticuloController {

	private final IArticuloService iArticuloService;

	@GetMapping
	public ResponseEntity<List<Articulo>> listar() throws Exception{
		List<Articulo> lista = iArticuloService.listar();
		return new ResponseEntity<List<Articulo>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Articulo> listarPorId(@PathVariable("id") Long id)throws Exception{
		Articulo obj = iArticuloService.listarPorId(id);
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Articulo>(obj, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Articulo> registrar(@Valid @RequestBody Articulo articulo)throws Exception{
		Articulo obj = iArticuloService.registrar(articulo);
		return new ResponseEntity<Articulo>(obj, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Articulo> modifiar(@Valid @RequestBody Articulo articulo) throws Exception{
		Articulo obj = iArticuloService.modificar(articulo);
		return new ResponseEntity<Articulo>(obj, HttpStatus.OK);
	}
	
	public ResponseEntity<Void> eliminar(@PathVariable("id") Long id) throws Exception{
		Articulo obj = iArticuloService.listarPorId(id);
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		iArticuloService.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
