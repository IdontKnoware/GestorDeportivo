package com.grupob.practicafinal.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupob.practicafinal.backend.models.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Integer> {

	@Query("Select p from Partido p where jornada = ?1")
	List<Partido> getByJornada(String jornada);
	
	@Query("Select p from Partido p where id_estado != ?1")
	List<Partido> getByEstado(String estado);
}
