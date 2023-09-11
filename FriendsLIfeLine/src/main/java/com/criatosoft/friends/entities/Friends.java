package com.criatosoft.friends.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

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
	private String id;
	private String name;
	private int age;
	private String mobile;
	private String email;
	private String city;
	
	

}
