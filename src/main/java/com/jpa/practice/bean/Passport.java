package com.jpa.practice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passportdetails")
public class Passport {
	@Id
	@GeneratedValue
	@Column(name = "passportid")
	private Integer Id;
	
	@Column(name = "passportnumber", nullable = false)
	private String passportNumber;
	
	@Column(name = "countryname", nullable = false)
	private String countryName;
	
	@OneToOne(targetEntity = Student.class, fetch = FetchType.LAZY, mappedBy = "passport")
	private Student student;
	
	public Passport() {}
	
	public Passport(String passportNumber, String countryName) {
		this.passportNumber = passportNumber;
		this.countryName = countryName;
	}

	public Integer getId() {
		return Id;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	@Override
	public String toString() {
		return "Passport [Id=" + Id + ", passportNumber=" + passportNumber + ", countryName=" + countryName + "]";
	}
}
