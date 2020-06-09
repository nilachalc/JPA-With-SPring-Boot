package com.jpa.practice.SpringJPA.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.practice.bean.Course;
import com.jpa.practice.bean.Review;

@Repository
@Transactional
public class ReviewRepository {
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private CourseRepository courseRepository;
	
	public Course saveReviewsToCourse(Integer courseId, List<Review> reviews) {
		Course course = courseRepository.findById(courseId);
		
		for (Review review : reviews) {
			course.getReviews().add(review);
			review.setCourse(course);
			entityManager.persist(review);
		}
		entityManager.flush();
		return course;
	}

	public Review findById(Integer id) {
		return entityManager.find(Review.class, id);
	}
	
	public void delete(Integer id) {
		Review review = findById(id);
		entityManager.remove(review);
		entityManager.flush();
		System.out.println("The value for IsDeleted -->  " + review.getIsDeleted());
	}
}
