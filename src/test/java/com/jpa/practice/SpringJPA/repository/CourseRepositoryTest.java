package com.jpa.practice.SpringJPA.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.practice.bean.Course;
import com.jpa.practice.bean.Passport;
import com.jpa.practice.bean.Review;
import com.jpa.practice.bean.Student;
import com.jpa.practice.utility.ReviewRating;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	void test_findById() {
		Course course = courseRepository.findById(1);
		assertEquals("Spring1", course.getName());
	}
	
	@Test
	void test_save() {
		Course course = courseRepository.findById(2); 
		course.setDurationInWeek(4.5);
		courseRepository.save(course);
		assertEquals("Spring2", courseRepository.findById(2).getName());
	}
	
	@Test
	@DirtiesContext
	void test_delete() {
		courseRepository.delete(5);
		assertNull(courseRepository.findById(5));
	}

	@Test
	@Transactional
	public void test_saveWithStudentDetails() {
		List<Student> students = new ArrayList<Student>(); 
		students.add(new Student("Anikesh", 65, "Rathtala")); 
		students.add(new Student("Suparna", 55, "Rathtala"));
		students.add(new Student("Prodyot", 67, "Bansdroni", new Passport("Z15647", "India")));

		Course course = courseRepository.saveWithStudentDetails(new Course("Spring 9", "9th Spring Course", 9.5), students) ;
		
		System.out.println("Course Details: -->");
		System.out.println("Id --> " + course.getId());
		System.out.println("Name --> " + course.getName());
		System.out.println("Description --> " + course.getDescription());
		System.out.println("Duration In Week -> " + course.getDurationInWeek());
		System.out.println("Creation Time --> " + course.getCreationTime());
		System.out.println("Last Updated Time --> " + course.getLastUpdatedTime());
		System.out.println();
		
		System.out.println("Student Details For Course: -->");
		for (Student student : course.getStudents()) {
			System.out.println("Id --> " + student.getId());
			System.out.println("Name --> " + student.getName());
			System.out.println("Age --> " + student.getAge());
			System.out.println("Address --> " + student.getAddress());
			if (student.getPassport() != null) {
				System.out.println("This Student holds a Passport from " + student.getPassport().getCountryName());
				System.out.println("Passport Details: -->");
				System.out.println(student.getPassport().getId());
				System.out.println(student.getPassport().getPassportNumber());
				System.out.println(student.getPassport().getCountryName());
				System.out.println();
			}
			System.out.println();
		}
	}
	
	@Test
	void test_testingEntityManager() {
		courseRepository.testingEntityManager();
	}
	
	@Test
	//@Transactional
	public void test_saveCourseWithReviews() {
		List<Review> reviews = new ArrayList<Review>();
		reviews.add(new Review("Standard Course", ReviewRating.THREE));
		reviews.add(new Review("Good Course", ReviewRating.FOUR));
		reviews.add(new Review("Great Course", ReviewRating.FIVE));
		
		Course course = courseRepository.saveCourseWithReviews(new Course("Spring 10", "10th Spring Course", 10.5), reviews) ;
		
		System.out.println("Course Details: -->");
		System.out.println("Id --> " + course.getId());
		System.out.println("Name --> " + course.getName());
		System.out.println("Description --> " + course.getDescription());
		System.out.println("Duration In Week -> " + course.getDurationInWeek());
		System.out.println("Creation Time --> " + course.getCreationTime());
		System.out.println("Last Updated Time --> " + course.getLastUpdatedTime());
		
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
	
	@Test
	public void test_SolvingNPlusOneProblemViaGraph() {
		for (Course course : courseRepository.solvingNPlusOneProblemViaGraph()) {
			System.out.println("Course Details: -->");
			System.out.println("Id --> " + course.getId());
			System.out.println("Name --> " + course.getName());
			System.out.println("Description --> " + course.getDescription());
			System.out.println("Duration In Week -> " + course.getDurationInWeek());
			System.out.println("Creation Time --> " + course.getCreationTime());
			System.out.println("Last Updated Time --> " + course.getLastUpdatedTime());
			
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
	public void test_SolvingNPlusOneProblemViaJoinFetch() {
		for (Course course : courseRepository.solvingNPlusOneProblemViaJoinFetch()) {
			System.out.println("Course Details: -->");
			System.out.println("Id --> " + course.getId());
			System.out.println("Name --> " + course.getName());
			System.out.println("Description --> " + course.getDescription());
			System.out.println("Duration In Week -> " + course.getDurationInWeek());
			System.out.println("Creation Time --> " + course.getCreationTime());
			System.out.println("Last Updated Time --> " + course.getLastUpdatedTime());
			
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
