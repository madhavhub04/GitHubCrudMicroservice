package com.criatosoft.user.app.servicei;

import java.util.List;

import com.criatosoft.user.app.entities.User;

public interface UserServicei {
	//create
	User createUser( User user);

	//get all
	List<User> getUsers();
	
	//get single
	User getUser(String userId);
	
	//delete user
	void deleteUser(String userId);
	
	//update user
	User updateUser(String userId ,User user);
}
