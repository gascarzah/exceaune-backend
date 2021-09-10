package com.gafahtec.exceaune.service.impl;

import org.springframework.stereotype.Service;

import com.gafahtec.exceaune.model.Promocion;
import com.gafahtec.exceaune.repository.IGenericRepo;
import com.gafahtec.exceaune.repository.IPromocionRepo;
import com.gafahtec.exceaune.service.IPromocionService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class PromocionServiceImpl extends CRUDImpl<Promocion, Long> implements IPromocionService{

	private IPromocionRepo iPromocionRepo;
	
	@Override
	protected IGenericRepo<Promocion, Long> getRepo() {
		// TODO Auto-generated method stub
		return iPromocionRepo;
	}

}
