package com.criatosoft.airlines.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criatosoft.airlines.entities.AirIndia;
import com.criatosoft.airlines.exceptions.ResourseNotFoundException;
import com.criatosoft.airlines.repositories.AirIndRepository;
import com.criatosoft.airlines.servicei.AirIndiaServicei;

@Service
public class AirIndiaServiceimpl implements AirIndiaServicei{

	@Autowired
	private AirIndRepository airRepository;
	
	@Override
	public AirIndia saveAirInd(AirIndia air) {
		String randomId = UUID.randomUUID().toString();
		air.setId(randomId);
		AirIndia save = airRepository.save(air);
		return save;
	}

	@Override
	public List<AirIndia> getAllAir() {
		List<AirIndia> findAll = airRepository.findAll();
		return findAll;
	}

	@Override
	public AirIndia getSingle(String id) {
		AirIndia findById = airRepository.findById(id)
					.orElseThrow(()-> new ResourseNotFoundException
								("UserId not found on server...!!"));
		return findById;
	}

	@Override
	public void deleteOne(String id) {
		airRepository.deleteById(id);
	}

	

}
