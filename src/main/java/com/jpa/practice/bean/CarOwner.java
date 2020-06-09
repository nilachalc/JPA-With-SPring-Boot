package com.jpa.practice.bean;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carownerdetails")
public class CarOwner {
	@Id
	@GeneratedValue
	@Column(name = "carownerid")
	private Integer Id;
	
	@Column(name = "carownername", nullable = false)
	private String name;
	
	@Column(name = "carownerage", nullable = false)
	private Integer age;
	
	@Embedded
	private Address address;

	public CarOwner() {}
	
	public CarOwner(String name, Integer age, Address address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CarOwner [Id=" + Id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}
}
