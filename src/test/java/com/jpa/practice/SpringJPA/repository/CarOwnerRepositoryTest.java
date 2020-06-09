package com.jpa.practice.SpringJPA.repository;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpa.practice.bean.Address;
import com.jpa.practice.bean.CarOwner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarOwnerRepositoryTest {
	
	@Autowired
	private CarOwnerRepository carOwnerRepository;
	
	@Test
	void test_findById() {
		CarOwner carOwner = carOwnerRepository.findById(43);
		System.out.println(carOwner);
		assertEquals("Neel", carOwner.getName());
	}
	
	@Test
	void test_save() {
		CarOwner carOwner = carOwnerRepository.save(new CarOwner("Neel", 29, new Address("L1", "L2", "Kolkata", "700056")));
		System.out.println(carOwner);
	}
}
