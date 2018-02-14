package com.grupob.practicafinal.backend.services;

import com.grupob.practicafinal.backend.models.TipoLance;

public interface PartidoServices {

	public void abrirPartido(int codigoPartido) throws Exception;
	
	public void cerrarPartido(int codigoPartido) throws Exception;
	
	public void cambiarEstado(int codigoPartido) throws Exception;
	
	public void anadirLance(int codigoPartido, int codigoEquipo, 
							 TipoLance tipoLance, int minuto, 
							 String comentario) throws Exception;

	
}
