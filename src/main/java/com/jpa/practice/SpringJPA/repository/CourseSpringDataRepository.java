package com.jpa.practice.SpringJPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jpa.practice.bean.Course;

public interface CourseSpringDataRepository extends JpaRepository<Course, Integer> {
	@Query(name = "findLikeCoursesForSpringDataJPA")
	List<Course> findCoursesWithLikeKeyNamed();
	
	@Query("SELECT c FROM Course c WHERE c.description like '%Spring%'")
	List<Course> findCoursesWithLikeKey();
	
	@Query(value = "SELECT * FROM coursedetails WHERE coursedescription like '%Spring%'", nativeQuery = true)
	List<Course> findCoursesWithLikeKeyNative();
	
	@Query(name = "findCourseByIdNamed")
	List<Course> findCoursesWithNamed(Integer id);
}
