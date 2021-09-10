package com.gafahtec.exceaune.service.impl;

import org.springframework.stereotype.Service;

import com.gafahtec.exceaune.model.Articulo;
import com.gafahtec.exceaune.repository.IArticuloRepo;
import com.gafahtec.exceaune.repository.IGenericRepo;
import com.gafahtec.exceaune.service.IArticuloService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArticuloServiceImpl extends CRUDImpl<Articulo, Long> implements IArticuloService{

	private IArticuloRepo iArticuloRepo;
	
	@Override
	protected IGenericRepo<Articulo, Long> getRepo() {
		
		return iArticuloRepo;
	}

}
