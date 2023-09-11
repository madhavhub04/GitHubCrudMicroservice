package com.criatosoft.friends.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.criatosoft.friends.entities.Friends;

public interface FriendsRepository extends JpaRepository<Friends, String>{

}
