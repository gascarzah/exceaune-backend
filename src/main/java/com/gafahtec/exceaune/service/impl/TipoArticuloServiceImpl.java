package com.gafahtec.exceaune.service.impl;

import org.springframework.stereotype.Service;

import com.gafahtec.exceaune.model.TipoArticulo;
import com.gafahtec.exceaune.repository.IGenericRepo;
import com.gafahtec.exceaune.repository.ITipoArticuloRepo;
import com.gafahtec.exceaune.service.ITipoArticuloService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class TipoArticuloServiceImpl extends CRUDImpl<TipoArticulo, Long> implements ITipoArticuloService {

	private ITipoArticuloRepo iTipoArticuloRepo;

	@Override
	protected IGenericRepo<TipoArticulo, Long> getRepo() {
		return iTipoArticuloRepo;
	}

}
