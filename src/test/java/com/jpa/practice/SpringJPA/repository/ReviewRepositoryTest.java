package com.jpa.practice.SpringJPA.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.practice.bean.Review;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewRepositoryTest {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Test
	@Transactional
	void test_findById() {
		Review review = reviewRepository.findById(150);
		if (review != null) {
			System.out.println("Review Details: -->");
			System.out.println("Id --> " + review.getId());
			System.out.println("Description --> " + review.getDescription());
			System.out.println("Rating --> " + review.getRating());
			System.out.println("Creation Time --> " + review.getCreationTime());
			System.out.println("Last Updated Time --> " + review.getLastUpdatedTime());
			System.out.println();
			
			System.out.println("Course Details: -->");
			System.out.println("Id --> " + review.getCourse().getId());
			System.out.println("Name --> " + review.getCourse().getName());
			System.out.println("Description --> " + review.getCourse().getDescription());
			System.out.println("Duration In Week -> " + review.getCourse().getDurationInWeek());
			System.out.println("Creation Time --> " + review.getCourse().getCreationTime());
			System.out.println("Last Updated Time --> " + review.getCourse().getLastUpdatedTime());
		} else {
			System.out.println("Data Not Present.");
		}
		assertEquals("Spring4", review.getCourse().getName());
	}
	
	@Test
	void test_delete() {
		reviewRepository.delete(555);
		Review review = reviewRepository.findById(555);
		
		if (review == null) {
			System.out.println("Soft Deleted.");
		} else {
			System.out.println("Value is there.");
			
			System.out.println("Review Details: -->");
			System.out.println("Id --> " + review.getId());
			System.out.println("Description --> " + review.getDescription());
			System.out.println("Rating --> " + review.getRating());
			System.out.println("Creation Time --> " + review.getCreationTime());
			System.out.println("Last Updated Time --> " + review.getLastUpdatedTime());
			System.out.println();
		}
		assertNull(review);
	}
}
