package com.criatosoft.airlines.servicei;

import java.util.List;

import com.criatosoft.airlines.entities.AirIndia;

public interface AirIndiaServicei {
	
	//create
	AirIndia saveAirInd(AirIndia air);
	
	//getAll
	List<AirIndia> getAllAir();
	
	//getOne
	AirIndia getSingle(String id);
	
	//deleteOne
	void deleteOne(String id);
	
	

}
