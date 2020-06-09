package com.jpa.practice.bean;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "temp")
public class TemporaryEmployee extends Employee{
	@Column(name = "wedgeperhour")
	private Double wedgePerHour;
	
	@Column(name = "daysserved")
	private Integer daysServed;

	public TemporaryEmployee() {
		super();
	}

	public TemporaryEmployee(String name, String organisationName, Double wedgePerHour, Integer daysServed) {
		super(name, organisationName);
		this.wedgePerHour = wedgePerHour;
		this.daysServed = daysServed;
	}
	
	public Double getWedgePerHour() {
		return wedgePerHour;
	}

	public void setWedgePerHour(Double wedgePerHour) {
		this.wedgePerHour = wedgePerHour;
	}

	public Integer getDaysServed() {
		return daysServed;
	}

	public void setDaysServed(Integer daysServed) {
		this.daysServed = daysServed;
	}

	@Override
	public String toString() {
		return "TemporaryEmployee [wedgePerHour=" + wedgePerHour + ", daysServed=" + daysServed + "]";
	}
}
