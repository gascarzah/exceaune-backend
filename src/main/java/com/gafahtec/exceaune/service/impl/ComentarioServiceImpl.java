package com.gafahtec.exceaune.service.impl;

import org.springframework.stereotype.Service;

import com.gafahtec.exceaune.model.Comentario;
import com.gafahtec.exceaune.repository.IComentarioRepo;
import com.gafahtec.exceaune.repository.IGenericRepo;
import com.gafahtec.exceaune.service.IComentarioService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ComentarioServiceImpl extends CRUDImpl<Comentario, Long> implements IComentarioService{

	private IComentarioRepo iComentarioRepo;
	
	@Override
	protected IGenericRepo<Comentario, Long> getRepo() {
		// TODO Auto-generated method stub
		return iComentarioRepo;
	}

}
