package com.grupob.practicafinal.backend.services;

import java.util.List;
import com.grupob.practicafinal.backend.models.Clasificado;
import com.grupob.practicafinal.backend.models.ClasificadoDTO;

public interface ClasificacionServices {

	public List<Clasificado> getClasificacion();
	public List<ClasificadoDTO> getClasificacionEquipo(String condicion);
	
}
