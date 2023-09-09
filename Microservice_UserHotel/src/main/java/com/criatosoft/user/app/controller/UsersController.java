package com.criatosoft.user.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.criatosoft.user.app.entities.User;
import com.criatosoft.user.app.servicei.UserServicei;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UserServicei userService;
	
	//create
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User createUser = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
	}
	
	//get all
	@GetMapping
	public ResponseEntity<List<User>> getAll(){
		List<User> allUsers = userService.getUsers();
		return ResponseEntity.status(HttpStatus.OK).body(allUsers);		
	}
	
	//get single
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingle(@PathVariable String userId){
		User getOne = userService.getUser(userId);
		return ResponseEntity.status(HttpStatus.OK).body(getOne);
	}
	
	//delete one
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteOne(@PathVariable String userId){
		userService.deleteUser(userId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userId);
	}
}
