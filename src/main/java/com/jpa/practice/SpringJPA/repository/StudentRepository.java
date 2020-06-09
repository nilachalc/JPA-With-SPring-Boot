package com.jpa.practice.SpringJPA.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.practice.bean.Course;
import com.jpa.practice.bean.Passport;
import com.jpa.practice.bean.Student;

@Repository
@Transactional
public class StudentRepository {
	@Autowired
	private EntityManager entityManager;

	public Student save(Student student) {
		if (student.getId() == null) {
			entityManager.persist(student);
			entityManager.flush(); 
		} else {
			entityManager.merge(student);
		}
		return student; 
	}

	public void delete(Integer id) {
		entityManager.remove(findByStudentId(id)); 
	}

	public Student findByStudentId(Integer id) { 
		Student student = entityManager.find(Student.class, id);
		return student; 
	}

	public Passport findByPassportId(Integer id) { 
		Passport passport =	entityManager.find(Passport.class, id); 
		System.out.println(passport);
		System.out.println(passport.getStudent());
		return passport; 
	}

	public Student saveWithPassport(Student student) {
		entityManager.persist(student.getPassport());
		entityManager.persist(student);

		entityManager.flush();
		return student; 
	}
	
	public Student saveWithCourseDetails(Student student, List<Course> courses) {
		entityManager.persist(student);
		
		for (Course course : courses) {
			course.getStudents().add(student);
			entityManager.persist(course);
			student.getCourses().add(course);
		}
		
		entityManager.flush(); 
		return student; 
	} 
}
