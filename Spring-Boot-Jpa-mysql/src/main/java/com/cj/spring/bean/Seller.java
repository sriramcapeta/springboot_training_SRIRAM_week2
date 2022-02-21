package com.cj.spring.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Seller")
public class Seller {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="company_name")
	private String cname;
	
	
	@Column(name="country")
	private String country;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
}
