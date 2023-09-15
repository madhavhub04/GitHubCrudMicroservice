package com.criatosoft.email.entities;

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
public class EmailSender {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
	private String receiver;
	private String sender;
	private String message;
	private String subject;
	@Lob
	private byte[] photo;
	@Lob
	private byte[] pan;
}
