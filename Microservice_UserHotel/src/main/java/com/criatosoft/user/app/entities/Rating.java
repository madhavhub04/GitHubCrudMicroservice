package com.criatosoft.user.app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Rating {
	private String ratingId;
	private String hotelId;
	private String userId;
	private int rating;
	private String feedback;
	

}
