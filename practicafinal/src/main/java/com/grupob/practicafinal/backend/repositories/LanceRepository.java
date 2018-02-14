package com.grupob.practicafinal.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupob.practicafinal.backend.models.Lance;

@Repository
public interface LanceRepository extends JpaRepository<Lance, Integer> {

	@Query("select l from Lance l where l.partido = ?1")
	public List<Lance> getLancesByPartido(Integer idPartido);
	
}
