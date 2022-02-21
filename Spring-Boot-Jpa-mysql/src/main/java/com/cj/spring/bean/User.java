package com.cj.spring.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="UserInfo")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="country")
	private String country;
	@Column(name="name")
	
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
