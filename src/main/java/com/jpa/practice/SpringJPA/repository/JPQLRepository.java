package com.jpa.practice.SpringJPA.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.practice.bean.Course;
import com.jpa.practice.bean.Review;

@Repository
@Transactional
public class JPQLRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Course> findCourses() {
		//Query query = entityManager.createQuery("SELECT c FROM Course c");// Simple query
		//TypedQuery<Course> query= entityManager.createQuery("SELECT c FROM Course c", Course.class);// Typed Query
		//Query query = entityManager.createNamedQuery("findCourses");// Simple Named query
		TypedQuery<Course> query = entityManager.createNamedQuery("findCourses", Course.class);
		return query.getResultList();
	}
	
	public Course findCourseById(Integer id) {
		//TypedQuery<Course> query = entityManager.createNamedQuery("findCourseByIdOrdinal", Course.class).setParameter(1, id);
		TypedQuery<Course> query = entityManager.createNamedQuery("findCourseByIdNamed", Course.class)
				.setParameter("id", id);
		return query.getSingleResult();
	}
	
	public List<Course> findCoursesWithNativeQuery() {
		Query query = entityManager.createNativeQuery("SELECT * FROM coursedetails", Course.class);
		return query.getResultList();
	}
	
	public Course findCourseByIdWithNativeQuery(Integer id) {
		//Query query = entityManager.createNativeQuery("SELECT * FROM coursedetails WHERE courseid = ?1", Course.class).setParameter(1, id);
		Query query = entityManager.createNativeQuery("SELECT * FROM coursedetails WHERE courseid = :id", Course.class).setParameter("id", id);
		return (Course)query.getSingleResult();
	}
	
	public List<Course> jpqlQueryCourseWithOutReviews() {
		TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c WHERE c.reviews IS EMPTY", Course.class);
		return query.getResultList();
	}
	
	public List<Course> jpqlQueryCourseWithStudentsWithPassport() {
		TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c JOIN c.students s WHERE s.passport IS NOT NULL", Course.class);
		return query.getResultList();
	}
	
	public List<Review> jpqlQueryAllReviewsForCourseTakenByStudentsOfAgeBetween0_20() {
		TypedQuery<Review> query = entityManager.createQuery("SELECT r FROM Review r "
				+ "JOIN r.course c LEFT JOIN c.students s "
				+ "WHERE s.age BETWEEN 0 AND 20", Review.class);
		return query.getResultList();
	}
	
	public List<Review> findReviewsWithNativeQuery() {
		Query query = entityManager.createNativeQuery("SELECT * FROM reviewdetails WHERE deletedflag = 0", Review.class);
		return query.getResultList();
	}
}
