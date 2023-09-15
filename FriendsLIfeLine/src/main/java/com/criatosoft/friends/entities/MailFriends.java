package com.criatosoft.friends.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MailFriends {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String sender;
	private String receiver;
	private String message;
	private String subject;
	@Lob
	private byte[] photo;
	
}
