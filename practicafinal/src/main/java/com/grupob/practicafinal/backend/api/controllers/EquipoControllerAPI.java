package com.grupob.practicafinal.backend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grupob.practicafinal.backend.models.Equipo;
import com.grupob.practicafinal.backend.repositories.EquipoRepository;

@Controller
@RequestMapping(value="grupob/api/")
public class EquipoControllerAPI {

	@Autowired
	EquipoRepository equipoRepository;
	
	
	//GetAllEquipos
	@RequestMapping (value = "/equipos",
					 method = RequestMethod.GET,
					 produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Equipo> getAllEquipos(){
		
		List<Equipo> equipos = equipoRepository.findAll();
		
		return equipos;		
	}
	
	//GetEquipo
	@RequestMapping (value="/equipos/{ID}",
					 method = RequestMethod.GET,
					 produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody Equipo getEquipo(@PathVariable ("ID") int ID) {
		Equipo equipo = equipoRepository.findOne(ID);
		
		return equipo;
	}
	
}
