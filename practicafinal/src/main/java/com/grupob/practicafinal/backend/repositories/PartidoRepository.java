package com.grupob.practicafinal.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupob.practicafinal.backend.models.Partido;

public interface PartidoRepository extends JpaRepository<Partido, String> {

}
