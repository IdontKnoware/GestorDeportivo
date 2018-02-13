package com.grupob.practicafinal.backend.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grupob.practicafinal.backend.models.Partido;
import com.grupob.practicafinal.backend.repositories.PartidoRepository;


@Controller
@RequestMapping(value = "/practicafinal/app/partidos")
public class ControladorPartido {
	
	@Autowired
	private PartidoRepository partidoRepository;
	
	// GETALL
	@RequestMapping(value = "/getall",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Partido> getAll(){	
		System.out.println("Entramos en partidos getall...");
		List<Partido> partidos = partidoRepository.findAll();
		System.out.println(partidos.get(0));
		return partidos;
	}

}
