package com.grupob.practicafinal.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.grupob.practicafinal.backend.models.Equipo;
import com.grupob.practicafinal.backend.models.Estado;
import com.grupob.practicafinal.backend.models.Lance;
import com.grupob.practicafinal.backend.models.Partido;
import com.grupob.practicafinal.backend.models.TipoLance;

public interface PartidoRepository extends JpaRepository<Partido, Integer> {

	
	public List<Partido> getByEstado(Estado estado);
	

	@Query("select p from Partido p where p.local = ?1 or p.visitante = ?1")
	public List<Partido> getByEquipo(Equipo equipo);
	
	public String cambiarEstado(Integer id) throws IllegalStateException;
	
	public String setLance(int idPartido, int idEquipo, int minuto/*, TipoLance tipoLance*/, String comentario) throws IllegalStateException;
	
}
