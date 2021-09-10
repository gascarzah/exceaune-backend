package com.gafahtec.exceaune.service.impl;

import org.springframework.stereotype.Service;

import com.gafahtec.exceaune.model.Persona;
import com.gafahtec.exceaune.repository.IGenericRepo;
import com.gafahtec.exceaune.repository.IPersonaRepo;
import com.gafahtec.exceaune.service.IPersonaService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class PersonaServiceImpl extends CRUDImpl<Persona, Long> implements IPersonaService{

	private IPersonaRepo iPersonaRepo;
	
	@Override
	protected IGenericRepo<Persona, Long> getRepo() {
		// TODO Auto-generated method stub
		return iPersonaRepo;
	}

}
