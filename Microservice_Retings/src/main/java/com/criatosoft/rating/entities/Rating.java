package com.criatosoft.rating.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rating {

	@Id
	@Column(name="ID")
	private String ratingsId;
	
	@Column(name="UserID") 
	private String userId;
	
	@Column(name="HotelID")
	private String hotelId;
	
	@Column(name="Rating")
	private int rating;
	
	@Column(name="Feedback")
	private String feedback;
	
}
