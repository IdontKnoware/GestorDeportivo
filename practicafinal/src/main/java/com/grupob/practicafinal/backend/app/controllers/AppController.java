package com.grupob.practicafinal.backend.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grupob.practicafinal.backend.models.Lance;
import com.grupob.practicafinal.backend.models.Partido;
import com.grupob.practicafinal.backend.repositories.LanceRepository;
import com.grupob.practicafinal.backend.repositories.PartidoRepository;
import com.grupob.practicafinal.backend.services.ClasificacionServices;
import com.grupob.practicafinal.backend.services.PartidoServices;

@Controller
@RequestMapping(value="practicafinal/app")
public class AppController {
	
	@SuppressWarnings("unused")
	@Autowired
	private PartidoServices partidoServices;
	
	@SuppressWarnings("unused")
	@Autowired
	private ClasificacionServices clasificacionServices;
	
	@Autowired
	private PartidoRepository partidoRepository;
	
	@Autowired
	private LanceRepository lanceRepository;
	
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
		
		// Hemos de colocar la lista de partidos en el ModelMap para que llegue al JSP
		
		modelMap.put("partidos", partidos);
		
		return "partidos";
	}
	
	
	// Abrir/Cerrar partido
	@RequestMapping(value="/partidos/{id}",
					method=RequestMethod.GET)	
	public String cambiar(@PathVariable("id") Integer id, ModelMap modelMap) {
		
		try {
			partidoServices.cambiarEstado(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Partido> partidos = partidoRepository.findAll();
		
		modelMap.put("partidos", partidos);
		
		return "partidos";
	}
	
	
	
	// nuevo lance
	
		@RequestMapping(value="/nuevolance",
						method=RequestMethod.GET)	
		public String lances(ModelMap modelMap) {
			
			List<Partido> partidos = partidoRepository.findAll();
			List<Lance> lances = lanceRepository.findAll();
			
			// Hemos de colocar la lista de partidos en el ModelMap para que llegue al JSP
			
			modelMap.put("nuevolance", partidos);
			modelMap.put("nuevolance", lances);
			
			return "nuevolance";
		}
}
