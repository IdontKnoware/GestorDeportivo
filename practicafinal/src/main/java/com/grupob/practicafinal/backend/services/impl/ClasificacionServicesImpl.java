package com.grupob.practicafinal.backend.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupob.practicafinal.backend.models.Clasificado;
import com.grupob.practicafinal.backend.models.Equipo;
import com.grupob.practicafinal.backend.models.Partido;
import com.grupob.practicafinal.backend.repositories.EquipoRepository;
import com.grupob.practicafinal.backend.repositories.PartidoRepository;
import com.grupob.practicafinal.backend.services.ClasificacionServices;

@Service
public class ClasificacionServicesImpl implements ClasificacionServices {

	@Autowired
	private PartidoRepository partidoRepository;
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	
	@Override
	public List<Clasificado> getClasificacion() {
		
		Map <Integer, Clasificado> mapa = new HashMap<Integer, Clasificado>();
		
		//Variables Auxiliares
		int comodin = 0;
		
		for (Equipo equipo : equipoRepository.findAll()) {
			Clasificado clasificado = new Clasificado();
			clasificado.setEquipo(equipo);
			
			mapa.put(equipo.getId(), clasificado);
		}
		
		for (Partido partido : partidoRepository.findAll()) {
			comodin=0;
			
			//Goles Favor Local
			comodin = mapa.get(partido.getLocal().getId()).getGFL() + partido.getGolesLocal();
			mapa.get(partido.getLocal().getId()).setGFL(comodin);
				
			//Goles Contra Local
			comodin = mapa.get(partido.getLocal().getId()).getGCL() + partido.getGolesVisitante();
			mapa.get(partido.getVisitante().getId()).setGCV(comodin);
			
			//Goles Favor Visitante
			comodin = mapa.get(partido.getVisitante().getId()).getGFV() + partido.getGolesVisitante();
			mapa.get(partido.getVisitante().getId()).setGFL(comodin);
			
			//Goles Contra Visitante
			comodin = mapa.get(partido.getVisitante().getId()).getGCV() + partido.getGolesLocal();
			mapa.get(partido.getLocal().getId()).setGCV(comodin);
				
			
			if(partido.getGolesLocal() > partido.getGolesVisitante()) {
				
				//Partidos Ganados Local
				comodin = mapa.get(partido.getLocal().getId()).getPGL() + 1;
				mapa.get(partido.getLocal().getId()).setPGL(comodin);
				
				//Partidos Perdidos Visitante
				comodin = mapa.get(partido.getVisitante().getId()).getPPV() + 1;
				mapa.get(partido.getVisitante().getId()).setPPV(comodin);
				
			}
		
			if(partido.getGolesLocal() < partido.getGolesVisitante()) {
				
				//Partidos Ganados Visitante
				comodin = mapa.get(partido.getVisitante().getId()).getPGV() + 1;
				mapa.get(partido.getVisitante().getId()).setPGV(comodin);
				
				//Partidos Perdidos Visitante
				comodin = mapa.get(partido.getLocal().getId()).getPPL() + 1;
				mapa.get(partido.getLocal().getId()).setPPL(comodin);
				
			}
			
			if(partido.getGolesLocal() == partido.getGolesVisitante()) {
				
				//Partidos Ganados Visitante
				comodin = mapa.get(partido.getVisitante().getId()).getPGV() + 1;
				mapa.get(partido.getVisitante().getId()).setPGV(comodin);
				
				//Partidos Perdidos Visitante
				comodin = mapa.get(partido.getLocal().getId()).getPPL() + 1;
				mapa.get(partido.getLocal().getId()).setPPL(comodin);
				
			}
			
		}
		
		
		
		return null;
	}

}
