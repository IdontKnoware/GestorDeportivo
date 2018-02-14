package com.grupob.practicafinal.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupob.practicafinal.backend.models.Partido;
import com.grupob.practicafinal.backend.repositories.PartidoRepository;
import com.grupob.practicafinal.backend.services.PartidoServices;

@Service
public class PartidoServicesImpl implements PartidoServices {

	@Autowired
	private PartidoRepository partidoRepository;
	
	
	@Override
	public void cerrarPartido(int codigoPartido) throws Exception {
		
		Partido partido = partidoRepository.findOne(codigoPartido);
		
		System.out.println(partido);
		
		// TODO Auto-generated method stub
		
	}

}
