package com.jpa.practice.bean;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

//@MappedSuperclass()
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "employeetype")
public abstract class Employee {

	@Id
	@GeneratedValue
	@Column(name = "employeeid")
	private Integer Id;
	
	@Column(name = "employeename")
	private String name;
	
	@Column(name = "organisationname")
	private String organisationName;

	public Employee() {}
	
	public Employee(String name, String organisationName) {
		this.name = name;
		this.organisationName = organisationName;
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

	public String getOrganisationName() {
		return organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", name=" + name + ", organisationName=" + organisationName + "]";
	}
}
