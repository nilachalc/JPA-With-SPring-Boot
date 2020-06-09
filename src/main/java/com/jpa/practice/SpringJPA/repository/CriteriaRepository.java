package com.jpa.practice.SpringJPA.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.practice.bean.Course;
import com.jpa.practice.bean.Passport;
import com.jpa.practice.bean.Student;

@Repository
@Transactional
public class CriteriaRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Course> findCourses() {
		//TypedQuery<Course> query = entityManager.createNamedQuery("findCourses", Course.class);
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
		criteriaQuery.from(Course.class);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
	public Course findCourseById(Integer id) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
		Root<Course> root = criteriaQuery.from(Course.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("Id"), id));
		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}
	
	public List<Course> findCoursesContaningSpring() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
		Root<Course> root = criteriaQuery.from(Course.class);
		criteriaQuery.where(criteriaBuilder.like(root.get("name"), "%Spring%"));
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}


	public List<Course> findCourseWithStudents() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
		Root<Course> root = criteriaQuery.from(Course.class);
		root.join("students");
		criteriaQuery.where(criteriaBuilder.isNotEmpty(root.get("students")));
		return entityManager.createQuery(criteriaQuery.select(root)).getResultList();
	}
}
