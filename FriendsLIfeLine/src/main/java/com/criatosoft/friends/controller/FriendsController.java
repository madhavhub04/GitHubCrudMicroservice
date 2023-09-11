package com.criatosoft.friends.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.criatosoft.friends.entities.Friends;
import com.criatosoft.friends.servicei.FriendsServicei;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("friends")
public class FriendsController {

	@Value("${spring.mail.username}")
	String username;

	@Autowired
	private FriendsServicei friendsServicei;

	@PostMapping
	public ResponseEntity<Friends> newFriend(@RequestBody Friends friend) {
		Friends fsave = friendsServicei.addNewFriend(friend);
		return new ResponseEntity<Friends>(fsave, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Friends>> getAll() {
		List<Friends> fAll = friendsServicei.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(fAll);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Friends> getOne(@PathVariable String id) {
		Friends singleF = friendsServicei.getSingleF(id);
		return ResponseEntity.status(HttpStatus.OK).body(singleF);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> removeOne(@PathVariable String id) {
		friendsServicei.deleteOne(id);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// api for mail and message
	@PostMapping(value = "/mailWithAttachment")
	public ResponseEntity<String> sendMailmsg(@RequestParam("photo") MultipartFile photo,
			@RequestParam("data") String data) {

		//String randomId = UUID.randomUUID().toString();

		try {
			ObjectMapper om = new ObjectMapper();
			Friends f = om.readValue(data, Friends.class);

			f.setFromm(username); // sender email
			//f.setId(randomId);

			friendsServicei.saveMailDetails(f);

			f.setPhoto(photo.getBytes());
			friendsServicei.sendMailWithAttachment(photo, f);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Fail to send", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Mail sent Successfully...", HttpStatus.OK);

	}

}
