package com.grupob.practicafinal.backend.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grupob.practicafinal.backend.models.Equipo;
import com.grupob.practicafinal.backend.models.Estado;
import com.grupob.practicafinal.backend.models.Partido;
import com.grupob.practicafinal.backend.repositories.EquipoRepository;
import com.grupob.practicafinal.backend.repositories.PartidoRepository;


@Controller
@RequestMapping(value = "/practicafinal/app/partidos")
public class ControladorPartido {
	
	@Autowired
	private PartidoRepository partidoRepository;
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	// GETALL
	@RequestMapping(value = "/getall",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Partido> getAll(){	
		System.out.println("Entramos en partidos getall...");
		List<Partido> partidos = partidoRepository.findAll();
		System.out.println("1r elemento: ");
		return partidos;
	}
	
	// PRUEBAS
	@RequestMapping(value = "/prueba/{id}",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Partido> prueba(@PathVariable("id") Integer id){	
		
		//List<Partido> partidos = partidoRepository.getByEstado(Estado.PENDIENTE);
		//List<Partido> partidos = partidoRepository.findAll();
		
		// Vamos a hacer trampa...
		
	//	Equipo equipo = new Equipo();
	//	equipo.setId(id);;
		
		Equipo equipo = this.equipoRepository.findOne(id);
		
		List<Partido> partidos = partidoRepository.getByEquipo(equipo);
		
		return partidos;
	}
	
	// ABRIR
		@RequestMapping(value = "/abrirpartido/{id}",
						method=RequestMethod.GET)
//						produces=MediaType.APPLICATION_JSON_VALUE)
//						consumes=MediaType.APPLICATION_JSON_VALUE)
		public String abrirPartido(@PathVariable("id") Integer id){	

			System.out.println("\n***********IN METHOD <abrirPartido>*****");
			Partido partido = this.partidoRepository.findOne(id);
			if (partido.getEstado().equals(Estado.PENDIENTE)) {
				System.out.println("Este partido se puede abrir");
				partido.setEstado(Estado.ABIERTO);
				partidoRepository.save(partido);
			}else {
				System.out.println("Partido ya abierto/cerrado");
				return null; 
			}
			return "abrirCerrarPartido";
		}
	
		// ABRIR
		@RequestMapping(value = "/abrirpartido/{id}",
						method=RequestMethod.GET)
//						produces=MediaType.APPLICATION_JSON_VALUE)
//						consumes=MediaType.APPLICATION_JSON_VALUE)
		public String cerrarPartido(@PathVariable("id") Integer id){	

			System.out.println("\n***********IN METHOD <abrirPartido>*****");
			Partido partido = this.partidoRepository.findOne(id);
			if (partido.getEstado().equals(Estado.PENDIENTE)) {
				System.out.println("Este partido se puede abrir");
				partido.setEstado(Estado.ABIERTO);
				partidoRepository.save(partido);
			}else {
				System.out.println("Partido ya abierto/cerrado");
				return null; 
			}
			return "abrirCerrarPartido";
		}

}
