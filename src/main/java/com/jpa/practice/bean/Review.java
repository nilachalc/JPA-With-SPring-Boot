package com.jpa.practice.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.jpa.practice.utility.ReviewRating;

@Entity
@Table(name = "reviewdetails")
@SQLDelete(sql = "UPDATE reviewdetails SET deletedflag = 1 WHERE reviewid = ?")
@Where(clause = "deletedflag = 0")
public class Review {
	@Id
	@GeneratedValue
	@Column(name = "reviewid")
	private Integer Id;
	
	@Column(name = "reviewdescription", length = 300, nullable = false)
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "reviewrating", nullable = false)
	private ReviewRating rating;
	
	@CreationTimestamp
	@Column(name = "creationtime")
	private Timestamp creationTime;
	
	@Column(name = "deletedflag")
	private Boolean isDeleted; 
	
	@UpdateTimestamp
	@Column(name = "lastupdatedtime")
	private Timestamp lastUpdatedTime;

	@ManyToOne(targetEntity = Course.class, optional = false)
	private Course course;
	
	public Review() {}
	
	public Review(String description, ReviewRating rating) {
		this.description = description;
		this.rating = rating;
	}
	
	public Integer getId() {
		return Id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ReviewRating getRating() {
		return rating;
	}

	public void setRating(ReviewRating rating) {
		this.rating = rating;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public Timestamp getLastUpdatedTime() {
		return lastUpdatedTime;
	}
	
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Review [Id=" + Id + ", description=" + description + ", rating=" + rating + ", creationTime="
				+ creationTime + ", lastUpdatedTime=" + lastUpdatedTime + ", course=" + course + "]";
	}
	
	@PrePersist
	private void performBeforePersist() {
		this.isDeleted = false;
		System.out.println("The Entity isDeleted is set to --> false");
	}
	
	@PreRemove
	private void performBeforeRemove() {
		this.isDeleted = true;
		System.out.println("The Entity isDeleted is set to --> true");
	}
}
