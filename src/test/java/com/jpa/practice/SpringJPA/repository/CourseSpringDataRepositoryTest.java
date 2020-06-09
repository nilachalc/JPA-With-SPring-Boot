package com.jpa.practice.SpringJPA.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.practice.bean.Course;
import com.jpa.practice.bean.Review;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseSpringDataRepositoryTest {
	@Autowired
	private CourseSpringDataRepository courseSpringDataRepository;
	
	@Test
	@Transactional
	public void test_Spring_Data_JPA_findCoursesWithLikeKey() {
		for (Course course : courseSpringDataRepository.findCoursesWithLikeKey()) {
			System.out.println("Id --> " + course.getId());
			System.out.println("Name --> " + course.getName());
			System.out.println("Description --> " + course.getDescription());
			System.out.println("Duration In Week -> " + course.getDurationInWeek());
			System.out.println("Creation Time --> " + course.getCreationTime());
			System.out.println("Last Updated Time --> " + course.getLastUpdatedTime());
			System.out.println();
			if (course.getReviews() != null) {
				for (Review review : course.getReviews()) {
					System.out.println("Review Details For Course: -->");
					System.out.println("Id --> " + review.getId());
					System.out.println("Description --> " + review.getDescription());
					System.out.println("Rating --> " + review.getRating());
					System.out.println("Creation Time --> " + review.getCreationTime());
					System.out.println("Last Updated Time --> " + review.getLastUpdatedTime());
					System.out.println();
				}
			}
		}
	}
	
	@Test
	@Transactional
	public void test_Spring_Data_JPA_findCoursesWithLikeKeyNative() {
		for (Course course : courseSpringDataRepository.findCoursesWithLikeKeyNative()) {
			System.out.println("Id --> " + course.getId());
			System.out.println("Name --> " + course.getName());
			System.out.println("Description --> " + course.getDescription());
			System.out.println("Duration In Week -> " + course.getDurationInWeek());
			System.out.println("Creation Time --> " + course.getCreationTime());
			System.out.println("Last Updated Time --> " + course.getLastUpdatedTime());
			System.out.println();
			if (course.getReviews() != null) {
				for (Review review : course.getReviews()) {
					System.out.println("Review Details For Course: -->");
					System.out.println("Id --> " + review.getId());
					System.out.println("Description --> " + review.getDescription());
					System.out.println("Rating --> " + review.getRating());
					System.out.println("Creation Time --> " + review.getCreationTime());
					System.out.println("Last Updated Time --> " + review.getLastUpdatedTime());
					System.out.println();
				}
			}
		}
	}
	
	@Test
	@Transactional
	public void test_Spring_Data_JPA_findCoursesWithLikeKeyNamed() {
		for (Course course : courseSpringDataRepository.findCoursesWithLikeKeyNamed()) {
			System.out.println("Id --> " + course.getId());
			System.out.println("Name --> " + course.getName());
			System.out.println("Description --> " + course.getDescription());
			System.out.println("Duration In Week -> " + course.getDurationInWeek());
			System.out.println("Creation Time --> " + course.getCreationTime());
			System.out.println("Last Updated Time --> " + course.getLastUpdatedTime());
			System.out.println();
			if (course.getReviews() != null) {
				for (Review review : course.getReviews()) {
					System.out.println("Review Details For Course: -->");
					System.out.println("Id --> " + review.getId());
					System.out.println("Description --> " + review.getDescription());
					System.out.println("Rating --> " + review.getRating());
					System.out.println("Creation Time --> " + review.getCreationTime());
					System.out.println("Last Updated Time --> " + review.getLastUpdatedTime());
					System.out.println();
				}
			}
		}
	}
	
	@Test
	@Transactional
	public void test_Spring_Data_JPA_findCoursesWithNamed() {
		for (Course course : courseSpringDataRepository.findCoursesWithNamed(135)) {
			System.out.println("Id --> " + course.getId());
			System.out.println("Name --> " + course.getName());
			System.out.println("Description --> " + course.getDescription());
			System.out.println("Duration In Week -> " + course.getDurationInWeek());
			System.out.println("Creation Time --> " + course.getCreationTime());
			System.out.println("Last Updated Time --> " + course.getLastUpdatedTime());
			System.out.println();
			if (course.getReviews() != null) {
				for (Review review : course.getReviews()) {
					System.out.println("Review Details For Course: -->");
					System.out.println("Id --> " + review.getId());
					System.out.println("Description --> " + review.getDescription());
					System.out.println("Rating --> " + review.getRating());
					System.out.println("Creation Time --> " + review.getCreationTime());
					System.out.println("Last Updated Time --> " + review.getLastUpdatedTime());
					System.out.println();
				}
			}
		}
	}
}
