package com.grupob.practicafinal.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupob.practicafinal.backend.models.Equipo;
import com.grupob.practicafinal.backend.models.Estado;
import com.grupob.practicafinal.backend.models.Lance;
import com.grupob.practicafinal.backend.models.Partido;
import com.grupob.practicafinal.backend.models.TipoLance;
import com.grupob.practicafinal.backend.repositories.EquipoRepository;
import com.grupob.practicafinal.backend.repositories.LanceRepository;
import com.grupob.practicafinal.backend.repositories.PartidoRepository;
import com.grupob.practicafinal.backend.services.PartidoServices;

@Service
public class PartidoServicesImpl implements PartidoServices {

	@Autowired
	private PartidoRepository partidoRepository;
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	@Autowired
	private LanceRepository lanceRepository;
	
	@Override
	public void abrirPartido(int codigoPartido) throws Exception {
		
		Partido partido = partidoRepository.findOne(codigoPartido);
		
		if (partido.getEstado().equals(Estado.PENDIENTE)) {
			partido.setEstado(Estado.ABIERTO);
		}else{
			throw new IllegalStateException("Partido no pendiente. No se puede abrir");
		}
	}

	@Override
	public void cerrarPartido(int codigoPartido) throws Exception {
		
		Partido partido = partidoRepository.findOne(codigoPartido);
		
		if (partido.getEstado().equals(Estado.ABIERTO)) {
			partido.setEstado(Estado.CERRADO);
		}else{
			throw new IllegalStateException("Partido no abierto. No se puede cerrar");
		}
	}
		
	@Override
	public void cambiarEstado(int codigoPartido) throws Exception{
		Partido partido = partidoRepository.findOne(codigoPartido);
		if (partido.getEstado().equals(Estado.PENDIENTE)) {
			partido.setEstado(Estado.ABIERTO);
			
		}else if (partido.getEstado().equals(Estado.ABIERTO)) {
			partido.setEstado(Estado.CERRADO);
			
		}else{
			throw new IllegalStateException("No puedo cambiar estado del partido...WTF?!?!?!");
		}
		partidoRepository.save(partido);
	}

	@Override
	public void anadirLance(int codigoPartido, int codigoEquipo, TipoLance tipoLance, int minuto, String comentario)
			throws Exception {
		
		Partido partido = partidoRepository.findOne(codigoPartido);
		Equipo equipo = equipoRepository.findOne(codigoEquipo);
		
		if (tipoLance.equals(TipoLance.GOL)) {
			if(partido.getLocal().equals(equipo)) {
				partido.setGolesLocal(partido.getGolesLocal()+1);
			} else {
				partido.setGolesVisitante(partido.getGolesVisitante()+1);
			}
		}
		
		
		Lance lance = new Lance	(partido, equipo, minuto, tipoLance, comentario);
		
		lanceRepository.save(lance);
		
	}
}
