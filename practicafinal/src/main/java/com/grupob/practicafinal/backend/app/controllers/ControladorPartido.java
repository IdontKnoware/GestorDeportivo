package com.grupob.practicafinal.backend.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grupob.practicafinal.backend.models.Equipo;
import com.grupob.practicafinal.backend.models.Estado;
import com.grupob.practicafinal.backend.models.Lance;
import com.grupob.practicafinal.backend.models.Partido;
import com.grupob.practicafinal.backend.models.TipoLance;
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
		@RequestMapping(value = "/cambiarestado/{id}",
						method=RequestMethod.GET)
//						produces=MediaType.APPLICATION_JSON_VALUE)
//						consumes=MediaType.APPLICATION_JSON_VALUE)
		public String cambiarEstado(@PathVariable("id") Integer id){	

			System.out.println("\n***********IN METHOD <abrir o cerrar Partido>*****");
			
			Partido partido = this.partidoRepository.findOne(id);
			
			if (partido.getEstado().equals(Estado.PENDIENTE)) {
				System.out.println("Este partido se puede abrir");
				partido.setEstado(Estado.ABIERTO);
				partidoRepository.save(partido);
			}else if (partido.getEstado().equals(Estado.ABIERTO)) {
				System.out.println("Este partido se puede abrir");
				partido.setEstado(Estado.CERRADO);
				partidoRepository.save(partido);
			}else {
				System.out.println("No puedo abrir o cerrar el partido. Probablemente ya esté cerrado, porqué sino hubiera entrado por otro de los if");
				
				throw new IllegalStateException();
			}
			return "abrirCerrarPartido";
		}
		
		@RequestMapping(value = "/crearlance/",
						method=RequestMethod.GET)
		public String introducirLance(	@RequestParam("p1") int idPartido,
										
										@RequestParam("p2") int idEquipo,
										@RequestParam("p3") int minuto,
										/*@RequestParam("p4") TipoLance tipoLance,*/
										@RequestParam("p5") String comentario) {
			System.out.println("\n***********IN METHOD <añadir LANCE>*****");
			
			System.out.println("p1: " + idPartido);
			System.out.println("p2: " + idEquipo);
			System.out.println("p3: " + minuto);
			//System.out.println("p4: " + tipoLance);
			System.out.println("p5: " + comentario);
			
			/*Lance elLance = new Lance();
			elLance.setId(lance.getId());
			elLance.setPartido(lance.getPartido());
			elLance.setEquipo(lance.getEquipo());
			elLance.setMinuto(lance.getMinuto());
			elLance.setTipos(lance.getTipos());
			elLance.setComentario(lance.getComentario());*/
			
			//partidoRepository.introducirLance(lance);
			
			return null;
		}
	

}
