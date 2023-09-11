package com.criatosoft.airlines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.criatosoft.airlines.entities.AirIndia;
import com.criatosoft.airlines.servicei.AirIndiaServicei;

@RestController
@RequestMapping("/airIndia")
public class AirController {
	
	@Autowired
	private AirIndiaServicei airIndiaService;
	//create
	@PostMapping
	public ResponseEntity<AirIndia> createAir(AirIndia air){
		AirIndia saveAir = airIndiaService.saveAirInd(air);
		return new ResponseEntity<AirIndia>(saveAir,HttpStatus.CREATED);
	}
	//getall
	@GetMapping
	public ResponseEntity<List<AirIndia>> getAllAir(){
		List<AirIndia> list = airIndiaService.getAllAir();
		return new ResponseEntity<List<AirIndia>>(list,HttpStatus.OK);
	}
	//getOne
	@GetMapping(value = "/{id}")
	public ResponseEntity<AirIndia> getOneAir(String id){
		AirIndia getSingle = airIndiaService.getSingle(id);
		return new ResponseEntity<AirIndia>(getSingle,HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<AirIndia> deleteOne(String id){
		airIndiaService.deleteOne(id);
		return new ResponseEntity<AirIndia>(HttpStatus.NOT_FOUND);
	}
	
	
	

}
