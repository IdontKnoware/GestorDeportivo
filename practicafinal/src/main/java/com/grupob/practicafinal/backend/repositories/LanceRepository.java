package com.grupob.practicafinal.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupob.practicafinal.backend.models.Lance;

@Repository
public interface LanceRepository extends JpaRepository<Lance, Integer> {

}
