package com.jpa.practice.SpringJPA.repository;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.practice.bean.Course;
import com.jpa.practice.bean.Passport;
import com.jpa.practice.bean.Review;
import com.jpa.practice.bean.Student;

@Repository
@Transactional
public class CourseRepository {
	@Autowired
	private EntityManager entityManager;
	
	public Course save(Course course) {
		if (course.getId() == null) {
			entityManager.persist(course);
			entityManager.flush();
		} else {
			entityManager.merge(course);
		}
		return course;
	}
	
	public Course saveCourseWithReviews(Course course, List<Review> reviews) {
		entityManager.persist(course);
		
		for (Review review : reviews) {
			course.getReviews().add(review);
			review.setCourse(course);
			entityManager.persist(review);
		}
		entityManager.flush();
		return course;
	}

	public Course saveWithStudentDetails(Course course, List<Student> students) {
		entityManager.persist(course);
		
		for (Student student : students) {
			Passport passport = student.getPassport();
			student.getCourses().add(course);
			if (passport != null) {
				entityManager.persist(passport);
			}
			entityManager.persist(student);
			course.getStudents().add(student);
		}
		
		entityManager.flush(); 
		return course; 
	} 
	
	public void delete(Integer id) {
		entityManager.remove(findById(id));
	}
	
	public Course findById(Integer id) {
		return entityManager.find(Course.class, id);
	}
	
	public List<Course> solvingNPlusOneProblemViaGraph() {
		EntityGraph<Course> entityGraph = entityManager.createEntityGraph(Course.class);
		entityGraph.addSubgraph("reviews",Review.class);
		List<Course> courses = entityManager.createNamedQuery("findCourses", Course.class)
								.setHint("javax.persistence.loadgraph", entityGraph)
								.getResultList();
		return courses;
	}
	
	public List<Course> solvingNPlusOneProblemViaJoinFetch() {
		List<Course> courses = entityManager.createNamedQuery("findCoursesViaJoinFetch", Course.class).getResultList();
		return courses;
	}
	
	public void testingEntityManager() {
		//persist-D (Adds the new object to the persistence context and update the DB after flush, Void method)
		//merge-D (return the reference of the object added to the persistence context)
		//flush-D (works like commit, Void method)
		//detach-D (detaches object from the persistence context, Void method)
		//clear-D (detaches all the objects from the persistence context, Void method)
		//refresh-D (refresh the object with DB value, Void method)
		
		Course course1 = new Course("Spring4", "4th Spring lession", 2.0);
		entityManager.persist(course1);
		Course course2 = new Course("Spring5", "5th Spring lession", 2.456);
		entityManager.persist(course2);
		
		entityManager.flush();
		
		//entityManager.detach(course2);
		//entityManager.clear();
		
		course1.setDescription("New 4th Spring lession");
		course2.setDescription("New 5th Spring lession");
		
		//Course course3 = entityManager.merge(course2);
		//entityManager.flush();
		entityManager.refresh(course1);
	}
}
