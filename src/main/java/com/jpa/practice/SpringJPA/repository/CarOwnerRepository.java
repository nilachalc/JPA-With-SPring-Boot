package com.jpa.practice.SpringJPA.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.practice.bean.CarOwner;

@Repository
@Transactional
public class CarOwnerRepository {
	@Autowired
	private EntityManager entityManager;

	public CarOwner save(CarOwner carOwner) {
		if (carOwner.getId() == null) {
			entityManager.persist(carOwner);
			entityManager.flush(); 
		} else {
			entityManager.merge(carOwner);
		}
		return carOwner; 
	}

	public CarOwner findById(Integer id) { 
		CarOwner carOwner = entityManager.find(CarOwner.class, id);
		return carOwner; 
	}
}
