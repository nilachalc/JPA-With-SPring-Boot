package com.jpa.practice.bean;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "pemp")
public class PermanentEmployee extends Employee {

	@Column(name = "employeesalary")
	private Double salary;
	
	@Column(name = "employeefacility")
	private String facility;

	public PermanentEmployee() {
		super();
	}
	
	public PermanentEmployee(String name, String organisationName, Double salary, String facility) {
		super(name, organisationName);
		this.salary = salary;
		this.facility = facility;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	@Override
	public String toString() {
		return "PermanentEmployee [salary=" + salary + ", facility=" + facility + "]";
	}
}
