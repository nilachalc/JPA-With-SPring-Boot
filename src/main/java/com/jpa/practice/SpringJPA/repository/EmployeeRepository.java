package com.jpa.practice.SpringJPA.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.practice.bean.Employee;

@Repository
@Transactional
public class EmployeeRepository {
	@Autowired
	private EntityManager entityManager;
	
	public List<Employee> findAll() {
		return entityManager.createQuery("SELECT emp FROM Employee emp" , Employee.class).getResultList();
	}
	
	public void save(Employee employee) {
		entityManager.persist(employee);
	}
}
