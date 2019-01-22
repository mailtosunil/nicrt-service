package com.nicrt.app.service;

import java.util.List;

import com.nicrt.app.model.Faculty;

public interface FacultyService {

	Faculty saveFaculty(Faculty faculty);

	List<Faculty> findAllFaculties();

	void deleteFacultyById(Integer facultyId);

	Faculty findFacultyById(Integer facultyId);

	Faculty updateFaculty(Faculty faculty);

}
