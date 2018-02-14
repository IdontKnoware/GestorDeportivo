package com.grupob.practicafinal.backend.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	
	// Welcome page
	
	@RequestMapping(value="/",
					method=RequestMethod.GET)	
	public String home() {
		return "index";
	}

}
