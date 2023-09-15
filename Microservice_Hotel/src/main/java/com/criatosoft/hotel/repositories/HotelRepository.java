package com.criatosoft.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.criatosoft.hotel.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
