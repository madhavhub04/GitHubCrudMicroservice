package com.criatosoft.friends.servicei;

import java.util.List;

import com.criatosoft.friends.entities.Friends;

public interface FriendsServicei {
	//create
	
	Friends addNewFriend(Friends friend);
	
	//getAll
	List<Friends> getAll();
	
	//getsingle
	Friends getSingleF(String id);
	
	//deleteOne
	
	void deleteOne(String id);
	

}
