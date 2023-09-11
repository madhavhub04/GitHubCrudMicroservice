package com.criatosoft.airlines.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name="AirIndia")
public class AirIndia {
	@Id
	private String id;
	private String name;
	private String fromm;
	private String to;
	private String tikit;
	

}
