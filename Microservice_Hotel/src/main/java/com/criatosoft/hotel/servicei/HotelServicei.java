package com.criatosoft.hotel.servicei;

import java.util.List;

import com.criatosoft.hotel.entities.Hotel;

public interface HotelServicei {
	
	Hotel createNew(Hotel hotel);
	
	List<Hotel> getAll();
	Hotel getSinlge(String id);
	void deleteOne(String id);

}
