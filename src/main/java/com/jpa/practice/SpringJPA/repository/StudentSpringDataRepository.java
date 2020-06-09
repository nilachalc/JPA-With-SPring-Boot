package com.jpa.practice.SpringJPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jpa.practice.bean.Course;
import com.jpa.practice.bean.Student;

@RepositoryRestResource(path = "MyStudents")
public interface StudentSpringDataRepository extends JpaRepository<Student, Integer> {
	public Student queryByName(String studentName);
	
	public Student queryByAge(Integer age);
	
	public Integer countByName(String name);
	
	public List<Student> queryByCoursesOrderByAgeDesc(Course course);
	
}
