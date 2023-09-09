package com.criatosoft.user.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.criatosoft.user.app.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

}
