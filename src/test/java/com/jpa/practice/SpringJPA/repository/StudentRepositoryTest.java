package com.jpa.practice.SpringJPA.repository;

import static org.junit.Assert.assertEquals; 
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

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

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
	@Autowired
	private StudentRepository studentRepository;

	@Test 
	public void test_findByStudentId() {
		Student student = studentRepository.findByStudentId(109);
		
		System.out.println("Student Details: -->");
		System.out.println("Id --> " + student.getId());
		System.out.println("Name --> " + student.getName());
		System.out.println("Age --> " + student.getAge());
		System.out.println("Address --> " + student.getAddress());
		if (student.getPassport() != null) {
			System.out.println("This Student holds a Passport from " + student.getPassport().getCountryName());
			System.out.println("Passport Details: -->");
			System.out.println("Id --> " + student.getPassport().getId());
			System.out.println("Number --> " + student.getPassport().getPassportNumber());
			System.out.println("Country --> " + student.getPassport().getCountryName());
			System.out.println();
		}
		System.out.println();
		
		System.out.println("Course Details For Student: -->");
		for (Course course : student.getCourses()) {
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
			System.out.println();
		}
	}

	@Test
	public void test_findByPassportId() {
		studentRepository.findByPassportId(6); 
	}

	@Test 
	public void test_save() { 
		Student student = studentRepository.findByStudentId(2); student.setAge(25);
		studentRepository.save(student); 
		assertEquals("Spring2",	studentRepository.findByStudentId(2).getName());
	}

	@Test
	@DirtiesContext 
	public void test_delete() {
		studentRepository.delete(5);
		assertNull(studentRepository.findByStudentId(5));
	}

	@Test 
	public void test_saveWithPassport() {
		Passport passport1 = new Passport("L85945","India");
		Student student = new Student("Nilachal", 29, "Rathtala", passport1);
		System.out.println(studentRepository.saveWithPassport(student)); 
	}
	
	@Test 
	public void test_saveWithCourseDetails() {
		List<Course> courses = new ArrayList<Course>(); 
		courses.add(new Course("Spring6", "6th Spring Course", 6.5)); 
		courses.add(new Course("Spring7", "7th Spring Course", 7.5));
		courses.add(new Course("Spring8", "8th Spring Course", 8.5));

		Student student = studentRepository.saveWithCourseDetails(new Student("Hia", 10, "Rathtala"), courses) ;
		
		System.out.println("Student Details: -->");
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getAge());
		System.out.println(student.getAddress());
		System.out.println();
		
		System.out.println("Course Details For Student: -->");
		for (Course course : student.getCourses()) {
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
	@Transactional
	public void test_firstlevelCache() {
		Student studentOne = studentRepository.findByStudentId(24);
		System.out.println("Data fetched from DB...Query fired.");
		System.out.println("Student Details: -->");
		System.out.println("Id --> " + studentOne.getId());
		System.out.println("Name --> " + studentOne.getName());
		System.out.println("Age --> " + studentOne.getAge());
		System.out.println("Address --> " + studentOne.getAddress());
		if (studentOne.getPassport() != null) {
			System.out.println("This Student holds a Passport from " + studentOne.getPassport().getCountryName());
			System.out.println("Passport Details: -->");
			System.out.println("Id --> " + studentOne.getPassport().getId());
			System.out.println("Number --> " + studentOne.getPassport().getPassportNumber());
			System.out.println("Country --> " + studentOne.getPassport().getCountryName());
			System.out.println();
		}
		Student studentTwo = studentRepository.findByStudentId(24);
		System.out.println("Data fetched from 1st level Cache, so no query is used.");
		System.out.println("Student Details: -->");
		System.out.println("Id --> " + studentTwo.getId());
		System.out.println("Name --> " + studentTwo.getName());
		System.out.println("Age --> " + studentTwo.getAge());
		System.out.println("Address --> " + studentTwo.getAddress());
		if (studentTwo.getPassport() != null) {
			System.out.println("This Student holds a Passport from " + studentTwo.getPassport().getCountryName());
			System.out.println("Passport Details: -->");
			System.out.println("Id --> " + studentTwo.getPassport().getId());
			System.out.println("Number --> " + studentTwo.getPassport().getPassportNumber());
			System.out.println("Country --> " + studentTwo.getPassport().getCountryName());
			System.out.println();
		}
	}
}
