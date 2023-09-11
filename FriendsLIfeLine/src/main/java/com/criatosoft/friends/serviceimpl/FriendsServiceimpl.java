package com.criatosoft.friends.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criatosoft.friends.entities.Friends;
import com.criatosoft.friends.repositories.FriendsRepository;
import com.criatosoft.friends.servicei.FriendsServicei;

@Service
public class FriendsServiceimpl implements FriendsServicei{

	@Autowired
	private FriendsRepository friendsRepository;
	@Override
	public Friends addNewFriend(Friends friend) {
		String randomId = UUID.randomUUID().toString();
		friend.setId(randomId);
		Friends fsave = friendsRepository.save(friend);
		return fsave;
	}

	@Override
	public List<Friends> getAll() {
		List<Friends> fAll = friendsRepository.findAll();
		return fAll;
	}

	@Override
	public Friends getSingleF(String id) {
		Optional<Friends> findById = friendsRepository.findById(id);
		return null;
	}

	@Override
	public void deleteOne(String id) {
		friendsRepository.deleteById(id);	
	}
	

}
