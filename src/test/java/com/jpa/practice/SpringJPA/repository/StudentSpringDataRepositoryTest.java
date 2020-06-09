package com.jpa.practice.SpringJPA.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.practice.bean.Course;
import com.jpa.practice.bean.Passport;
import com.jpa.practice.bean.Review;
import com.jpa.practice.bean.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentSpringDataRepositoryTest {
	@Autowired
	private StudentSpringDataRepository studentSpringDataRepository;
	
	@Autowired
	private PassportSpringDataRepository passportSpringDataRepository;
	
	@Autowired
	private CourseSpringDataRepository courseSpringDataRepository;
	
	@Test
	public void test_Spring_Data_JPA_findStudents() {
		Optional<Student> optionalStudent = studentSpringDataRepository.findById(7);
		showData(optionalStudent.get());
	}
	
	@Test
	public void test_Spring_Data_JPA_countByName() {
		System.out.println("Number of Student name 'Jia': "+ studentSpringDataRepository.countByName("Jia"));
	}
	
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
	public void test_Spring_Data_JPA_saveStudents() {
		Passport passport = passportSpringDataRepository.save(new Passport("US90897", "USA"));
		Student student = studentSpringDataRepository.save(
				new Student("Jia", 6, "San Jose", passport));
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
	}
	
	@Test
	@Transactional
	public void test_Spring_Data_JPA_queryByIdOrderByAge() {
		List<Student> students = studentSpringDataRepository.queryByCoursesOrderByAgeDesc(courseSpringDataRepository.findById(135).get());
		for (Student student : students) {
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
		}
	}
	
	@Test
	@Transactional
	public void test_Spring_Data_JPA_queryByName() {
		Student student = studentSpringDataRepository.queryByName("Jia");
		showData(student);
	}
	
	@Test
	@Transactional
	public void test_Spring_Data_JPA_queryByAge() {
		Student student = studentSpringDataRepository.queryByAge(65);
		showData(student);
	}
	
	@Test
	@Transactional
	public void test_Spring_Data_JPA_findAll() {
		Sort sort = Sort.by(Sort.Direction.DESC, "age");
		for (Student student : studentSpringDataRepository.findAll(sort)) {
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
		} 
	}
	
	@Test
	public void test_Spring_Data_JPA_paginationDemo() {
		PageRequest pageRequest = PageRequest.of(0, 3 , Sort.by(Sort.Direction.DESC, "age") );
		Page<Student> firstPageStudent = studentSpringDataRepository.findAll(pageRequest);
		Pageable firstPageable = firstPageStudent.nextPageable();
		System.out.println("-::THIS IS THE FIRST PAGE OF STUDENTS::-");
		for (Student student : firstPageStudent.getContent()) {
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
		}
		Page<Student> secondPageStudent = studentSpringDataRepository.findAll(firstPageable);
		Pageable secondPageable = secondPageStudent.nextOrLastPageable();
		System.out.println("-::THIS IS THE SECOND PAGE OF STUDENTS::-");
		for (Student secondStudent : secondPageStudent.getContent()) {
			System.out.println("Student Details: -->");
			System.out.println("Id --> " + secondStudent.getId());
			System.out.println("Name --> " + secondStudent.getName());
			System.out.println("Age --> " + secondStudent.getAge());
			System.out.println("Address --> " + secondStudent.getAddress());
			if (secondStudent.getPassport() != null) {
				System.out.println("This Student holds a Passport from " + secondStudent.getPassport().getCountryName());
				System.out.println("Passport Details: -->");
				System.out.println("Id --> " + secondStudent.getPassport().getId());
				System.out.println("Number --> " + secondStudent.getPassport().getPassportNumber());
				System.out.println("Country --> " + secondStudent.getPassport().getCountryName());
				System.out.println();
			}
			System.out.println();
		}
		System.out.println("-::THIS IS THE LAST PAGE OF STUDENTS::-");
		for (Student secondStudent : studentSpringDataRepository.findAll(secondPageable)) {
			System.out.println("Student Details: -->");
			System.out.println("Id --> " + secondStudent.getId());
			System.out.println("Name --> " + secondStudent.getName());
			System.out.println("Age --> " + secondStudent.getAge());
			System.out.println("Address --> " + secondStudent.getAddress());
			if (secondStudent.getPassport() != null) {
				System.out.println("This Student holds a Passport from " + secondStudent.getPassport().getCountryName());
				System.out.println("Passport Details: -->");
				System.out.println("Id --> " + secondStudent.getPassport().getId());
				System.out.println("Number --> " + secondStudent.getPassport().getPassportNumber());
				System.out.println("Country --> " + secondStudent.getPassport().getCountryName());
				System.out.println();
			}
			System.out.println();
		}
	}
	
	private void showData(Student student) {
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
		}
	}
}
