package com.gafahtec.exceaune.service.impl;

import org.springframework.stereotype.Service;

import com.gafahtec.exceaune.model.Rango;
import com.gafahtec.exceaune.repository.IGenericRepo;
import com.gafahtec.exceaune.repository.IRangoRepo;
import com.gafahtec.exceaune.service.IRangoService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class RangoServiceImpl extends CRUDImpl<Rango, Long> implements IRangoService{

	private IRangoRepo iRangoRepo;
	
	@Override
	protected IGenericRepo<Rango, Long> getRepo() {
		// TODO Auto-generated method stub
		return iRangoRepo;
	}

}
