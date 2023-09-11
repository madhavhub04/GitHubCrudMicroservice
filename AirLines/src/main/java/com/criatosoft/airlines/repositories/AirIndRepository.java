package com.criatosoft.airlines.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.criatosoft.airlines.entities.AirIndia;

@Repository
public interface AirIndRepository extends JpaRepository<AirIndia, String>{

	
}
