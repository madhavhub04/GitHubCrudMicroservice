package com.criatosoft.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.criatosoft.rating.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer>{

	public List<Rating> findByUserId(String userId);
	public List<Rating> findByHotelId(String hotelId);
}
