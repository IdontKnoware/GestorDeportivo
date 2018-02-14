package com.grupob.practicafinal.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.grupob.practicafinal.backend.models.Equipo;
import com.grupob.practicafinal.backend.models.Estado;

import com.grupob.practicafinal.backend.models.Partido;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {


	public List<Partido> getByEstado(Estado estado);


	@Query("Select p from Partido p where jornada = ?1")
	List<Partido> getByJornada(String jornada);
	
	@Query("Select p from Partido p where id_estado != ?1")
	List<Partido> getByEstado(String estado);

	
	@Query("select p from Partido p where p.local = ?1 or p.visitante = ?1")
	public List<Partido> getByEquipo(Equipo equipo);
	
	
}
