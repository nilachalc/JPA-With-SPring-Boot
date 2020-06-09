package com.jpa.practice.SpringJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.practice.bean.Passport;

public interface PassportSpringDataRepository extends JpaRepository<Passport, Integer> {
	
}
