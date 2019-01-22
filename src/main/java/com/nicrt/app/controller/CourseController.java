package com.nicrt.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nicrt.app.model.Course;
import com.nicrt.app.service.CourseService;

@RestController
@RequestMapping("/api/udem")
public class CourseController {

	@Autowired
	private CourseService courseService;

	public static final Logger LOG = LoggerFactory.getLogger(CourseController.class);
	public static final String CLASSNAME = CourseController.class.getName();

	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@GetMapping("/courses")
	public ResponseEntity fetchAllCourses() {
		LOG.info(String.format("Entered: Execution starts fetchAllCourses method %s", CLASSNAME));
		ResponseEntity response;
		List<Course> courses = courseService.findAllCourses();
		if (courses != null && !courses.isEmpty()) {
			response = new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("No data found", HttpStatus.OK);
		}
		LOG.info(String.format("Exit: Execution ends fetchAllCourses method %s", CLASSNAME));
		return response;
	}

	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@GetMapping("/course/{courseId}")
	@ResponseBody
	public ResponseEntity fetchCourseById(@PathVariable("courseId") String courseId) {
		LOG.info(String.format("Entered: Execution starts fetchCourseById method %s", CLASSNAME));
		ResponseEntity response = null;
		Course course = courseService.findCourseById(Integer.valueOf(courseId));
		if (course != null) {
			response = new ResponseEntity<Course>(course, HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("Unable to fetch Course", HttpStatus.NOT_MODIFIED);
		}
		LOG.info(String.format("Exit: Execution ends fetchCourseById method %s", CLASSNAME));
		return response;
	}

	@CrossOrigin
	@PostMapping("/course/add")
	@ResponseBody
	public ResponseEntity<String> saveCourse(@RequestBody Course course) {
		LOG.info(String.format("Entered: Execution starts saveCourse method %s", CLASSNAME));
		ResponseEntity<String> response = null;
		Course courseRes = courseService.saveCourse(course);
		if (courseRes != null) {
			response = new ResponseEntity<>("Course saved successfully", HttpStatus.OK);
		} else {
			response = new ResponseEntity<>("Unable to save course", HttpStatus.NOT_MODIFIED);
		}
		LOG.info(String.format("Exit: Execution ends saveCourse method %s", CLASSNAME));
		return response;
	}

	@CrossOrigin
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<String> deleteCourse(@PathVariable("courseId") Integer courseId) {
		LOG.info(String.format("Entered: Execution starts deleteCourse method %s", CLASSNAME));
		courseService.deleteCourseById(courseId);
		LOG.info(String.format("Exit: Execution ends deleteCourse method %s", CLASSNAME));
		return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
	}
}
