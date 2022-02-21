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
@Table(name="Product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long pid;
	@Column(name="product_name")
	private String pname;
	@OneToOne(cascade = CascadeType.ALL)
	private Seller seller;
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	
	

}
