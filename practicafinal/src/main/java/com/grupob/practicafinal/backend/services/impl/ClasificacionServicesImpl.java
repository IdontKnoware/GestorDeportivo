package com.grupob.practicafinal.backend.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupob.practicafinal.backend.models.Clasificado;
import com.grupob.practicafinal.backend.models.ClasificadoDTO;
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
	public List <Clasificado> getClasificacion() {
		
		Map <Integer, Clasificado> mapa = new HashMap<Integer, Clasificado>();
		
		List<Equipo> equipos = equipoRepository.findAll();
		
		//Variables Auxiliares
		int comodin = 0;
		
		for (Equipo equipo : equipos) {
			Clasificado clasificado = new Clasificado();
			clasificado.setEquipo(equipo);
			
			mapa.put(equipo.getId(), clasificado);
		}
	
		for (Partido partido : partidoRepository.getPartidosPuntuables()) {
			comodin=0;
			
			//Goles Favor Local
			comodin = mapa.get(partido.getLocal().getId()).getGFL() + partido.getGolesLocal();
			mapa.get(partido.getLocal().getId()).setGFL(comodin);
				
			//Goles Contra Local
			comodin = mapa.get(partido.getLocal().getId()).getGCL() + partido.getGolesVisitante();
			mapa.get(partido.getLocal().getId()).setGCL(comodin);
			
			//Goles Favor Visitante
			comodin = mapa.get(partido.getVisitante().getId()).getGFV() + partido.getGolesVisitante();
			mapa.get(partido.getVisitante().getId()).setGFV(comodin);
			
			//Goles Contra Visitante
			comodin = mapa.get(partido.getVisitante().getId()).getGCV() + partido.getGolesLocal();
			mapa.get(partido.getVisitante().getId()).setGCV(comodin);
				
			
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
				
				//Partidos Perdidos Local
				comodin = mapa.get(partido.getLocal().getId()).getPPL() + 1;
				mapa.get(partido.getLocal().getId()).setPPL(comodin);
				
			}
			
			if(partido.getGolesLocal() == partido.getGolesVisitante()) {
				
				//Partidos Empatados Visitante
				comodin = mapa.get(partido.getVisitante().getId()).getPEV() + 1;
				mapa.get(partido.getVisitante().getId()).setPEV(comodin);
				
				//Partidos Empatados Local
				comodin = mapa.get(partido.getLocal().getId()).getPEL() + 1;
				mapa.get(partido.getLocal().getId()).setPEL(comodin);
				
			}
		}
		List<Clasificado> lista = new ArrayList<Clasificado>(mapa.values());
		return lista;
	}

	public List<ClasificadoDTO> getClasificacionEquipo(String condicion){
		
		List<Clasificado> clasificacionGeneral = getClasificacion();
		List<ClasificadoDTO> clasificados = new ArrayList<ClasificadoDTO>();
		
		for (Clasificado clasificado : clasificacionGeneral) {
			
			if(condicion=="local") {//Si es local
				
				ClasificadoDTO comodin = new ClasificadoDTO();
				comodin.setEquipo(clasificado.getEquipo());
				comodin.setGolesContra(clasificado.getGCL());
				comodin.setGolesFavor(clasificado.getGFL());
				comodin.setPartidosPerdidos(clasificado.getPPL());
				comodin.setPartidosGanados(clasificado.getPGL());
				comodin.setPartidosEmpatados(clasificado.getPEL());
				
				clasificados.add(comodin);
			}else {//Si es visitante
				
				ClasificadoDTO comodin = new ClasificadoDTO();
				comodin.setEquipo(clasificado.getEquipo());
				comodin.setGolesContra(clasificado.getGCV());
				comodin.setGolesFavor(clasificado.getGFV());
				comodin.setPartidosPerdidos(clasificado.getPPV());
				comodin.setPartidosGanados(clasificado.getPGV());
				comodin.setPartidosEmpatados(clasificado.getPEV());
				
				clasificados.add(comodin);
			}
		}
		return clasificados;
	}
}
