package com.grupob.practicafinal.backend.app.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grupob.practicafinal.backend.models.Partido;
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
	@RequestMapping(value="/finalizar/{id}",
					method=RequestMethod.GET)	
	public String cambiar(@PathParam("id") Integer id, ModelMap modelMap) {
		
		System.out.println("\n***** ID DEL PARTIDO SELECCIONADO: " + id);
		
		try {
			partidoServices.cerrarPartido(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Partido> partidos = partidoRepository.findAll();
		
		modelMap.put("partidos", partidos);
		
		return "partidos";
	}
}
