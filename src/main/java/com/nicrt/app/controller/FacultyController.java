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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nicrt.app.model.Faculty;
import com.nicrt.app.service.FacultyService;

@RestController
@RequestMapping("/api/udem")
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	public static final Logger LOG = LoggerFactory.getLogger(FacultyController.class);
	public static final String CLASSNAME = FacultyController.class.getName();

	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@GetMapping("/faculties")
	@ResponseBody
	public ResponseEntity fetchAllFaculties() {
		LOG.info(String.format("Entered: Execution starts fetchAllFaculties method %s", CLASSNAME));
		ResponseEntity response = null;
		List<Faculty> faculties = facultyService.findAllFaculties();
		if(faculties != null && !faculties.isEmpty()) {
			response = new ResponseEntity<List<Faculty>>(faculties, HttpStatus.OK);
		}else {
			response = new ResponseEntity<String>("No data Found", HttpStatus.NO_CONTENT);
		}
		LOG.info(String.format("Exit: Execution ends fetchAllFaculties method %s", CLASSNAME));
		return response;
	}

	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@GetMapping("/{facultyId}")
	@ResponseBody
	public ResponseEntity fetchFacultyById(@PathVariable("facultyId") String facultyId) {
		LOG.info(String.format("Entered: Execution starts fetchFacultyById method %s", CLASSNAME));
		ResponseEntity response = null;
		Faculty faculty = facultyService.findFacultyById(Integer.valueOf(facultyId));
		if(faculty != null) {
			response = new ResponseEntity<Faculty>(faculty, HttpStatus.OK);
		}else {
			response = new ResponseEntity<String>("No Data Found", HttpStatus.NOT_FOUND);
		}
		LOG.info(String.format("Exit: Execution ends fetchFacultyById method %s", CLASSNAME));
		return response;
	}

	@CrossOrigin
	@PostMapping("/{faculty}")
	@ResponseBody
	public ResponseEntity<String> saveFaculty(@PathVariable("student") Faculty faculty) {
		LOG.info(String.format("Entered: Execution starts saveFaculty method %s", CLASSNAME));
		ResponseEntity<String> response = null;
		Faculty facultyRes = facultyService.saveFaculty(faculty);
		if(facultyRes != null) {
			response = new ResponseEntity<String>("Faculty saved successfully", HttpStatus.OK);
		}else {
			response = new ResponseEntity<String>("Unable to save Faculty ", HttpStatus.NOT_MODIFIED);
		}
		LOG.info(String.format("Exit: Execution ends saveFaculty method %s", CLASSNAME));
		return response;
	}

	@CrossOrigin
	@PostMapping("/deleteFaculty/{facultyId}")
	@ResponseBody
	public ResponseEntity<String> deleteFaculty(@PathVariable("facultyId") Integer facultyId) {
		LOG.info(String.format("Entered: Execution starts deleteFaculty method %s", CLASSNAME));
		facultyService.deleteFacultyById(facultyId);
		LOG.info(String.format("Exit: Execution ends deleteFaculty method %s", CLASSNAME));
		return new ResponseEntity<String>("FAculty deleted successfully", HttpStatus.OK);
	}

}
