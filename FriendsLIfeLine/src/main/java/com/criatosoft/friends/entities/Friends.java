package com.criatosoft.friends.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Friends {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String fromm;
	private String to;
	private String subject;
	private String message;
	@Lob
	private byte[] photo;

}
