package com.grupob.practicafinal.backend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grupob.practicafinal.backend.models.Clasificado;
import com.grupob.practicafinal.backend.models.ClasificadoDTO;
import com.grupob.practicafinal.backend.models.Partido;
import com.grupob.practicafinal.backend.repositories.PartidoRepository;
import com.grupob.practicafinal.backend.services.ClasificacionServices;

@Controller
@RequestMapping(value = "grupob/api/")
public class PartidoControllerAPI {

	@Autowired
	private PartidoRepository partidoRepository;

	@Autowired
	private ClasificacionServices clasificacionServices;

	// GetClasificacionGlobal
	@RequestMapping(value = "/clasificacion",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<?> getClasificacion(@RequestParam(name = "condicion",
																required = false,
																defaultValue = "todos") String condicion) {
		if (condicion == "todos") {
			List<Clasificado> lista = this.clasificacionServices.getClasificacion();
				return lista;
		} else {
			List<ClasificadoDTO> lista = this.clasificacionServices.getClasificacionEquipo(condicion);
				return lista;
		}
	}

	// GetAllPartidos
	@RequestMapping(value = "/partidos",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Partido> getAllEquipos() {
		List<Partido> partido = partidoRepository.findAll();
			return partido;
	}

	// GetPartido
	@RequestMapping(value = "/partidos/{ID}",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Partido getPartido(@PathVariable("ID") int ID) {
		Partido partido = partidoRepository.findOne(ID);
			return partido;
	}
}
