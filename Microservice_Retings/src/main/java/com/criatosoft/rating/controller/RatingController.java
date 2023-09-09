package com.criatosoft.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.criatosoft.rating.entities.Rating;
import com.criatosoft.rating.servicei.RatingServicei;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingServicei ratingservice;
	
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingservice.create(rating));
	}
	@GetMapping
	public ResponseEntity<List<Rating>> getAll(){
		return ResponseEntity.ok(ratingservice.getAll());
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(String userId){
		return ResponseEntity.ok(ratingservice.getByUserId(userId));
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId( String hotelId){
		return ResponseEntity.ok(ratingservice.getByHotelId(hotelId));
	}

}
