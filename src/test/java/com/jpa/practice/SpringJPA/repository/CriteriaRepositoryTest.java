package com.jpa.practice.SpringJPA.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.practice.bean.Course;
import com.jpa.practice.bean.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CriteriaRepositoryTest {
	@Autowired
	private CriteriaRepository criteriaRepository;
	
	@Test
	@Transactional
	
	void test_Criteria_findCourses() {
		for (Course course: criteriaRepository.findCourses()) {
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
	}
	
	@Test
	void test_Criteria_findCourseById() {
		Course course = criteriaRepository.findCourseById(2); 
		System.out.println("Course Details: -->");
		System.out.println("Id --> " + course.getId());
		System.out.println("Name --> " + course.getName());
		System.out.println("Description --> " + course.getDescription());
		System.out.println("Duration In Week -> " + course.getDurationInWeek());
		System.out.println("Creation Time --> " + course.getCreationTime());
		System.out.println("Last Updated Time --> " + course.getLastUpdatedTime());
	}
	
	@Test
	void test_Criteria_findCoursesContaningSpring() {
		for (Course course: criteriaRepository.findCoursesContaningSpring()) {
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
	void test_Criteria_findCourseWithStudents() {
		for (Course course: criteriaRepository.findCourseWithStudents()) {
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
}
