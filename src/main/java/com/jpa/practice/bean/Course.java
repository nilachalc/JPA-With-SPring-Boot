package com.jpa.practice.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "coursedetails")
//@NamedQuery(name = "findCourses", query = "SELECT c FROM Course c")
@NamedQueries( {
		@NamedQuery(name = "findCourses", query = "SELECT c FROM Course c"),
		@NamedQuery(name = "findCourseByIdOrdinal", query = "SELECT c FROM Course c WHERE c.id = ?1"),
		@NamedQuery(name = "findCourseByIdNamed", query = "SELECT c FROM Course c WHERE c.id = :id"),
		@NamedQuery(name = "findLikeCoursesForSpringDataJPA", query = "SELECT c FROM Course c WHERE c.description like '%Spring%'"),
		@NamedQuery(name = "findCoursesViaJoinFetch", query = "SELECT c FROM Course c JOIN FETCH c.reviews r")
})
@Cacheable
public class Course {
	@Id
	@GeneratedValue
	@Column(name = "courseid")
	private Integer Id;
	
	@Column(name = "coursename", nullable = false)
	private String name;
	
	@Column(name = "coursedescription", length = 300)
	private String description;
	
	@Column(name = "durationinweek", nullable = false, precision = 2)
	private Double durationInWeek;
	
	@CreationTimestamp
	@Column(name = "creationtime")
	private Timestamp creationTime;
	
	@UpdateTimestamp
	@Column(name = "lastupdatedtime")
	private Timestamp lastUpdatedTime;
	
	@OneToMany(targetEntity = Review.class,  mappedBy = "course")
	private List<Review> reviews = new ArrayList<Review>();
	
	@ManyToMany(targetEntity = Student.class, mappedBy = "courses")
	private List<Student> students= new ArrayList<Student>();
	
	public Course() {}
	
	public Course(String name, String description, Double durationInWeek) {
		this.name = name;
		this.description = description;
		this.durationInWeek = durationInWeek;
	}

	public Integer getId() {
		return Id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getDurationInWeek() {
		return durationInWeek;
	}

	public void setDurationInWeek(Double durationInWeek) {
		this.durationInWeek = durationInWeek;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public Timestamp getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public List<Review> getReviews() {
		return reviews;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	@Override
	public String toString() {
		return "Course [Id=" + Id + ", name=" + name + ", description=" + description + ", durationInWeek="
				+ durationInWeek + ", creationTime=" + creationTime + ", lastUpdatedTime=" + lastUpdatedTime
				+ ", riviews=" + reviews + "]";
	}
}
