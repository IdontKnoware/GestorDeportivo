package com.grupob.practicafinal.backend.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupob.practicafinal.backend.models.Equipo;
import com.grupob.practicafinal.backend.models.Lance;
import com.grupob.practicafinal.backend.models.Partido;
import com.grupob.practicafinal.backend.models.TipoLance;
import com.grupob.practicafinal.backend.repositories.EquipoRepository;
import com.grupob.practicafinal.backend.repositories.LanceRepository;
import com.grupob.practicafinal.backend.repositories.PartidoRepository;
import com.grupob.practicafinal.backend.services.ClasificacionServices;
import com.grupob.practicafinal.backend.services.PartidoServices;

@Controller
@RequestMapping(value="practicafinal/app")
public class AppController {
	
	@Autowired
	private PartidoServices partidoServices;
	
	@SuppressWarnings("unused")
	@Autowired
	private ClasificacionServices clasificacionServices;
	
	@Autowired
	private PartidoRepository partidoRepository;
	
	@Autowired
	private LanceRepository lanceRepository;
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	// Welcome page
	
	@RequestMapping(value="/",
					method=RequestMethod.GET)	
	public String home() {
		return "index";
	}
	
	
	// Listar todos los partidos
	
	@RequestMapping(value="/partidos",
					method=RequestMethod.GET)	
	public String listado(ModelMap modelMap) {
		List<Partido> partidos = partidoRepository.findAll();
		modelMap.put("partidos", partidos);
		return "partidos";
	}
	
	
	// Abrir/Cerrar partido
	@RequestMapping(value="/partidos/{id}",
					method=RequestMethod.GET)	
	public String cambiar(@PathVariable("id") Integer id, ModelMap modelMap) {;
		try {
			partidoServices.cambiarEstado(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Partido partido = partidoRepository.findOne(id);
		
		modelMap.put("partido", partido);
		
		return "redirect:./../fichapartido/"+partido.getId();
	}
	
//	// nuevo lance
//	
	@RequestMapping(value="/fichapartido/{id}",
					method=RequestMethod.GET)	
	public String anadirLance(@PathVariable("id") Integer id, ModelMap modelMap) {
		
		Partido partido = partidoRepository.findOne(id);
		List<Lance> lances = lanceRepository.getByPartido(id);
		
		modelMap.put("partido", partido);			
		modelMap.put("lances", lances);				
		modelMap.put("tiposLance", Arrays.toString(TipoLance.values()).replaceAll("^.|.$", "").split(", "));
	
		
		return "fichapartido";
	}
	
	@RequestMapping(value="/guardarlance", method=RequestMethod.POST)
	public String anadirLance(@RequestParam("partido") int partido,
						  @RequestParam("equipo") int equipo,
						  @RequestParam("minuto") int minuto,
						  @RequestParam("tipolance") String tipoLance,
						  @RequestParam("comentario") String comentario) {
		
		try {
			this.partidoServices.anadirLance(partido, equipo, TipoLance.valueOf(tipoLance), minuto, comentario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:fichapartido/"+partido;
	}
}
