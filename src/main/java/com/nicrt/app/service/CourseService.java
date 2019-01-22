package com.nicrt.app.service;

import java.util.List;

import com.nicrt.app.model.Course;

public interface CourseService {

	Course saveCourse(Course course);

	List<Course> findAllCourses();

	void deleteCourseById(Integer courseId);

	Course findCourseById(Integer courseId);

	void updateCourse(Course course);

}
