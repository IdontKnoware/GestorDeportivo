package com.grupob.practicafinal.backend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupob.practicafinal.backend.models.Clasificado;
import com.grupob.practicafinal.backend.repositories.PartidoRepository;
import com.grupob.practicafinal.backend.services.ClasificacionServices;

@Service
public class ClasificacionServicesImpl implements ClasificacionServices {

	@SuppressWarnings("unused")
	@Autowired
	private PartidoRepository partidoRepository;
	
	@Override
	public List<Clasificado> getClasificacion() {
		// TODO Auto-generated method stub
		return null;
	}

}
