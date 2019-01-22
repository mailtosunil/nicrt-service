package com.nicrt.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nicrt.app.model.Student;
import com.nicrt.app.service.StudentService;

@RestController
@RequestMapping("/api/udem")
public class StudentController {

	@Autowired
	private StudentService studentService;

	public static final Logger LOG = LoggerFactory.getLogger(StudentController.class);
	public static final String CLASSNAME = StudentController.class.getName();

	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@GetMapping("/students")
	@ResponseBody
	public ResponseEntity fetchAllStudents() {
		LOG.info(String.format("Entered: Execution starts fetchAllStudents method %s", CLASSNAME));
		ResponseEntity response = null;
		List<Student> students = studentService.findAllStudents();
		if (students != null && !students.isEmpty()) {
			response = new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("No data found", HttpStatus.NO_CONTENT);
		}
		LOG.info(String.format("Exit: Execution ends fetchAllStudents method %s", CLASSNAME));
		return response;
	}

	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@GetMapping("/student/{studentId}")
	@ResponseBody
	public ResponseEntity fetchStudentById(@PathVariable("studentId") String studentId) {
		LOG.info(String.format("Entered: Execution starts fetchStudentById method %s", CLASSNAME));
		ResponseEntity response = null;
		Student student = studentService.findStudentById(Integer.valueOf(studentId));
		if (student != null) {
			response = new ResponseEntity<Student>(student, HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("No data found", HttpStatus.NOT_FOUND);
		}
		LOG.info(String.format("Exit: Execution ends fetchStudentById method %s", CLASSNAME));
		return response;
	}

	@CrossOrigin
	@PostMapping("student/add")
	@ResponseBody
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {
		LOG.info(String.format("Entered: Execution starts saveStudent method %s", CLASSNAME));
		ResponseEntity<String> response = null;
		Student studentRes = studentService.saveStudent(student);
		if (studentRes != null) {
			response = new ResponseEntity<>("Student saved successfully", HttpStatus.OK);
		} else {
			response = new ResponseEntity<>("Unable to save Student", HttpStatus.NOT_MODIFIED);
		}
		LOG.info(String.format("Exit: Execution ends saveStudent method %s", CLASSNAME));
		return response;
	}

	@CrossOrigin
	@PostMapping("/deleteStudent/{studentId}")
	@ResponseBody
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") Integer studentId) {
		LOG.info(String.format("Entered: Execution starts deleteStudent method %s", CLASSNAME));
		studentService.deleteStudentById(studentId);

		LOG.info(String.format("Exit: Execution ends deleteStudent method %s", CLASSNAME));
		return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
	}

}
