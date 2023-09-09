package com.criatosoft.rating.servicei;

import java.util.List;

import com.criatosoft.rating.entities.Rating;

public interface RatingServicei {
	
	//create
	Rating create(Rating rating);
	
	//get all ratings
	List<Rating> getAll();
	
	//get all rating by userId
	List<Rating> getByUserId(String userId);
	
	//get all rating by hotelId
	List<Rating> getByHotelId(String hotelId);

}
