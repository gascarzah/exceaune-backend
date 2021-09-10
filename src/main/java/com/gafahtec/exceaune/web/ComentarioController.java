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
import com.gafahtec.exceaune.model.Comentario;
import com.gafahtec.exceaune.service.IComentarioService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/comentarios" )
public class ComentarioController {

	private final IComentarioService iComentarioService;

	@GetMapping
	public ResponseEntity<List<Comentario>> listar() throws Exception{
		List<Comentario> lista = iComentarioService.listar();
		return new ResponseEntity<List<Comentario>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Comentario> listarPorId(@PathVariable("id") Long id)throws Exception{
		Comentario obj = iComentarioService.listarPorId(id);
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Comentario>(obj, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Comentario> registrar(@Valid @RequestBody Comentario Comentario)throws Exception{
		Comentario obj = iComentarioService.registrar(Comentario);
		return new ResponseEntity<Comentario>(obj, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Comentario> modifiar(@Valid @RequestBody Comentario Comentario) throws Exception{
		Comentario obj = iComentarioService.modificar(Comentario);
		return new ResponseEntity<Comentario>(obj, HttpStatus.OK);
	}
	
	public ResponseEntity<Void> eliminar(@PathVariable("id") Long id) throws Exception{
		Comentario obj = iComentarioService.listarPorId(id);
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		iComentarioService.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
