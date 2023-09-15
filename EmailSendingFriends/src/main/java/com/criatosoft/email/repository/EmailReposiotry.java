package com.criatosoft.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.criatosoft.email.entities.EmailSender;

public interface EmailReposiotry extends JpaRepository<EmailSender, Integer>{

}
