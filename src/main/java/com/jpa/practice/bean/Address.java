package com.jpa.practice.bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(name = "firstline")
	private String lineOne;
	
	@Column(name = "secondline")
	private String lineTwo;
	
	private String city;
	
	@Column(name = "pincode")
	private String pinCode;
	
	public Address() {}
	
	public Address(String lineOne, String lineTwo, String city, String pinCode) {
		this.lineOne = lineOne;
		this.lineTwo = lineTwo;
		this.city = city;
		this.pinCode = pinCode;
	}
	public String getLineOne() {
		return lineOne;
	}
	public void setLineOne(String lineOne) {
		this.lineOne = lineOne;
	}
	public String getLineTwo() {
		return lineTwo;
	}
	public void setLineTwo(String lineTwo) {
		this.lineTwo = lineTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "Address [LineOne=" + lineOne + ", LineTwo=" + lineTwo + ", City=" + city + ", pinCode=" + pinCode + "]";
	}
}
