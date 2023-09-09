package com.criatosoft.rating.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criatosoft.rating.entities.Rating;
import com.criatosoft.rating.repository.RatingRepository;
import com.criatosoft.rating.servicei.RatingServicei;
@Service
public class RatingServiceImpl implements RatingServicei{
	
	@Autowired
	private RatingRepository ratingrepository;

	@Override
	public Rating create(Rating rating) {
		
		String randomId = UUID.randomUUID().toString();
		rating.setRatingsId(randomId);
		return ratingrepository.save(rating);
	}

	@Override
	public List<Rating> getAll() {
		return ratingrepository.findAll();
	}

	@Override
	public List<Rating> getByUserId(String userId) {
		return ratingrepository.findByUserId(userId) ;
	}

	@Override
	public List<Rating> getByHotelId(String hotelId) {
		return ratingrepository.findByHotelId(hotelId);
	}

}
