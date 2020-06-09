package com.jpa.practice.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "studentdetails")
public class Student {
	@Id
	@GeneratedValue
	@Column(name = "studentid")
	private Integer Id;
	
	@Column(name = "studentname", nullable = false)
	private String name;
	
	@Column(name = "studentage", nullable = false)
	private Integer age;
	
	@Column(name = "studentaddress", nullable = false, length = 300)
	private String address;
	
	@OneToOne(targetEntity = Passport.class)
	@JsonIgnore
	private Passport passport;
	
	@ManyToMany(targetEntity = Course.class)
	@JoinTable(name = "studentcoursedetails",
				joinColumns = @JoinColumn(name = "STUDENTID"),
				inverseJoinColumns = @JoinColumn(name = "COURSEID"))
	@JsonIgnore
	private List<Course> courses = new ArrayList<Course>();
	
	public Student() {}
	
	public Student(String name, Integer age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public Student(String name, Integer age, String address, Passport passport) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.passport = passport;
	}

	public Integer getId() {
		return Id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public List<Course> getCourses() {
		return courses;
	}
	
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", age=" + age + ", address=" + address + ", passport="
				+ passport + "]";
	}
}
