package com.nicrt.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.nicrt.app.model.Course;
import com.nicrt.app.repository.CourseRepository;
import com.nicrt.app.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public static final Logger LOG = LoggerFactory.getLogger(CourseServiceImpl.class);
	public static final String CLASSNAME = CourseServiceImpl.class.getName();

	@Override
	public Course saveCourse(Course course) {
		LOG.info(String.format("Entered: Execution starts saveCourse method %s", CLASSNAME));
		try {
			courseRepository.save(course);
		} catch (DataAccessException dae) {
			LOG.error(String.format("Error occurred in saveCourse method %s", dae.getMessage()));
		}
		LOG.info(String.format("Exit: Execution ends saveCourse method %s", CLASSNAME));

		return course;
	}

	@Override
	public List<Course> findAllCourses() {
		LOG.info(String.format("Entered: Execution starts findAllCourses method %s", CLASSNAME));
		List<Course> courses = new ArrayList<>();
		try {
			courseRepository.findAll().forEach(courses::add);
		} catch (DataAccessException dae) {
			LOG.error(String.format("Error occurred in findAllCourses method %s", dae.getMessage()));
		}
		LOG.info(String.format("Exit: Execution ends findAllCourses method %s", CLASSNAME));
		return courses;
	}

	@Override
	public Course findCourseById(Integer courseId) {
		LOG.info(String.format("Entered: Execution starts findCourseById method %s", CLASSNAME));
		Course course = null;
		try {
			course = courseRepository.findById(courseId).orElse(null);
		} catch (DataAccessException dae) {
			LOG.error(String.format("Error occurred in findCourseById method %s", dae.getMessage()));
		}
		LOG.info(String.format("Exit: Execution ends findCourseById method %s", CLASSNAME));
		return course;
	}

	@Override
	public void updateCourse(Course course) {
		LOG.info(String.format("Entered: Execution starts updateCourse method %s", CLASSNAME));
		try {
			Course courseEntity = courseRepository.findById(course.getCourseId()).orElse(null);
			if(courseEntity != null && courseEntity.getCourseId() != null) {
				BeanUtils.copyProperties(course, courseEntity);
				courseRepository.save(courseEntity);				
			}
		} catch (DataAccessException dae) {
			LOG.error(String.format("Error occurred in updateCourse method %s", dae.getMessage()));
		}
		LOG.info(String.format("Exit: Execution ends updateCourse method %s", CLASSNAME));
	}

	@Override
	public void deleteCourseById(Integer courseId) {
		LOG.info(String.format("Entered: Execution starts deleteCourseById method %s", CLASSNAME));
		try {
			courseRepository.deleteById(courseId);
		} catch (DataAccessException dae) {
			LOG.error(String.format("Error occurred in deleteCourseById method %s", dae.getMessage()));
		}
		LOG.info(String.format("Exit: Execution ends deleteCourseById method %s", CLASSNAME));
	}

}
