package com.criatosoft.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.criatosoft.email.servicei.EmailServicei;

@RestController

public class EmailController {
	
	@Autowired
	private EmailServicei emailService;
	
	@PostMapping(value = "/emailsendattacment")
	public ResponseEntity<String> sendMail(@RequestParam ("photo") MultipartFile photo,
										@RequestParam ("pan") MultipartFile pan, 
										@RequestParam("data") String data){
		String msg =  emailService.sendEmail(photo,pan,data);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}

}
