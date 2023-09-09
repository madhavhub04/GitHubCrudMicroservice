package com.criatosoft.user.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="USER_TABLE")
public class User {
	@Id
	@Column(name="ID")
	private String userId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="MOBILE")
	private String mobile;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="DESIGNATION")
	private String designation;
	
	
	@Transient
	List<Rating> ratings = new ArrayList<>();

}
