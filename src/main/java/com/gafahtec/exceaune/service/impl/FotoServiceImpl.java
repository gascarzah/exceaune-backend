package com.gafahtec.exceaune.service.impl;

import org.springframework.stereotype.Service;

import com.gafahtec.exceaune.model.Foto;
import com.gafahtec.exceaune.repository.IFotoRepo;
import com.gafahtec.exceaune.repository.IGenericRepo;
import com.gafahtec.exceaune.service.IFotoService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class FotoServiceImpl extends CRUDImpl<Foto, Long> implements IFotoService{

	private IFotoRepo iFotoRepo;
	
	@Override
	protected IGenericRepo<Foto, Long> getRepo() {
		// TODO Auto-generated method stub
		return iFotoRepo;
	}

}
