package com.nicrt.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author SunilKumar
 *
 */
@Entity
@Table(name = "UMED_COURSE")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="UMED_COURSE_SEQ")
	@Column(name = "COURSE_ID")
	private Integer courseId;
	@Column(name = "COURSE_NAME", nullable = false)
	private String courseName;
	@Column(name = "COURSE_DURATION", nullable = false)
	private String courseDur;
	@Column(name = "COURSE_FEE", nullable = false)
	private Double courseFee;
	@ManyToOne
	@JoinColumn(name="facultyId")
	private Faculty faculty;

	public Course() {
		super();
	}

	public Course(String courseName, String courseDur, Double courseFee) {
		super();
		this.courseName = courseName;
		this.courseDur = courseDur;
		this.courseFee = courseFee;
	}



	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Double getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(Double courseFee) {
		this.courseFee = courseFee;
	}

	public String getCourseDur() {
		return courseDur;
	}

	public void setCourseDur(String courseDur) {
		this.courseDur = courseDur;
	}
	
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public String toString() {
		return "[" + getCourseId() + " ," + getCourseName() + " ," + getCourseFee() + "," + getCourseDur() + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Course))
			return false;
		Course other = (Course) obj;
		if (courseId != other.courseId)
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		return result;
	}
}
