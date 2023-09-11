package com.criatosoft.friends.servicei;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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

	void sendMailWithAttachment(MultipartFile photo, Friends f);

	void saveMailDetails(Friends f);
	

}
