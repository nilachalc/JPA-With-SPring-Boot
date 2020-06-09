package com.jpa.practice.SpringJPA.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpa.practice.bean.Course;
import com.jpa.practice.bean.Review;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPQLRepositoryTest {
	@Autowired
	private JPQLRepository jpqlRepository;
	
	@Test
	void test_JPQL_findCourses() {
		for (Course course: jpqlRepository.findCourses()) {
			System.out.println(course);
		}
	}
	
	@Test
	void test_JPQL_findCourseById() {
		System.out.println(jpqlRepository.findCourseById(2));
	}
	
	@Test
	void test_JPQL_findCoursesWithNativeQuery() {
		for (Course course: jpqlRepository.findCoursesWithNativeQuery()) {
			System.out.println(course);
		}
	}
	
	@Test
	void test_JPQL_findCourseByIdWithNativeQuery() {
		System.out.println(jpqlRepository.findCourseByIdWithNativeQuery(2));
	}
	
	@Test
	void test_jpqlQueryCourseWithOutReviews() {
		for (Course course : jpqlRepository.jpqlQueryCourseWithOutReviews()) {
			System.out.println("Course Details: -->");
			System.out.println("Id --> " + course.getId());
			System.out.println("Name --> " + course.getName());
			System.out.println("Description --> " + course.getDescription());
			System.out.println("Duration In Week -> " + course.getDurationInWeek());
			System.out.println("Creation Time --> " + course.getCreationTime());
			System.out.println("Last Updated Time --> " + course.getLastUpdatedTime());
			System.out.println();
		}
	}
	
	@Test
	void test_jpqlQueryCourseWithStudentsWithPassport() {
		for (Course course : jpqlRepository.jpqlQueryCourseWithStudentsWithPassport()) {
			System.out.println("Course Details: -->");
			System.out.println("Id --> " + course.getId());
			System.out.println("Name --> " + course.getName());
			System.out.println("Description --> " + course.getDescription());
			System.out.println("Duration In Week -> " + course.getDurationInWeek());
			System.out.println("Creation Time --> " + course.getCreationTime());
			System.out.println("Last Updated Time --> " + course.getLastUpdatedTime());
			System.out.println();
		}
	}
	
	@Test
	void test_jpqlQueryAllReviewsForCourseTakenByStudentsOfAgeBetween0_20() {
		for (Review review : jpqlRepository.jpqlQueryAllReviewsForCourseTakenByStudentsOfAgeBetween0_20()) {
			System.out.println("Review Details: -->");
			System.out.println("Id --> " + review.getId());
			System.out.println("Description --> " + review.getDescription());
			System.out.println("Rating --> " + review.getRating());
			System.out.println("Creation Time --> " + review.getCreationTime());
			System.out.println("Last Updated Time --> " + review.getLastUpdatedTime());
			System.out.println();
		}
	}
	
	@Test
	void test_findReviewsWithNativeQuery() {
		for (Review review : jpqlRepository.findReviewsWithNativeQuery()) {
			System.out.println("Review Details: -->");
			System.out.println("Id --> " + review.getId());
			System.out.println("Description --> " + review.getDescription());
			System.out.println("Rating --> " + review.getRating());
			System.out.println("Creation Time --> " + review.getCreationTime());
			System.out.println("Last Updated Time --> " + review.getLastUpdatedTime());
			System.out.println();
		}
	}
}
