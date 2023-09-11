package com.criatosoft.friends.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.criatosoft.friends.entities.Friends;
import com.criatosoft.friends.servicei.FriendsServicei;

@RestController
@RequestMapping("friends")
public class FriendsController {
	@Autowired
	private FriendsServicei friendsServicei;
	
	@PostMapping
	public ResponseEntity<Friends> newFriend(Friends friend){
		Friends fsave = friendsServicei.addNewFriend(friend);
		return new ResponseEntity<Friends>(fsave,HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Friends>> getAll(){
		List<Friends> fAll = friendsServicei.getAll();
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Friends> getOne(String id){
		Friends singleF = friendsServicei.getSingleF(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	public ResponseEntity<?> removeOne(String id){
		friendsServicei.deleteOne(id);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
