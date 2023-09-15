package com.criatosoft.friends.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.criatosoft.friends.servicei.MailServicei;

@RestController
@RequestMapping("/sendMailToFriend")
public class MailFriendController {
	
	@Autowired
	private MailServicei mailFService;
	
	public ResponseEntity<String> sendMail(@RequestParam ("photo")MultipartFile photo,
			@RequestParam ("data") String data){
		
		String msg = mailFService.sendMail(photo,data);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

}
