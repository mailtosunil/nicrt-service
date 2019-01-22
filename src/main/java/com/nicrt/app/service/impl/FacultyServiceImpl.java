package com.nicrt.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.nicrt.app.model.Faculty;
import com.nicrt.app.repository.FacultyRepository;
import com.nicrt.app.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	private FacultyRepository facultyRepo;

	public static final Logger LOG = LoggerFactory.getLogger(FacultyServiceImpl.class);
	public static final String CLASSNAME = FacultyServiceImpl.class.getName();

	@Override
	public Faculty saveFaculty(Faculty faculty) {
		LOG.info(String.format("Entered: Execution starts saveFaculty method %s", CLASSNAME));
		try {
			facultyRepo.save(faculty);
		} catch (DataAccessException dae) {
			LOG.error(String.format("Error occurred in saveFaculty method %s", dae.getMessage()));
		}
		LOG.info(String.format("Exit: Execution ends saveFaculty method %s", CLASSNAME));
		return faculty;
	}

	@Override
	public List<Faculty> findAllFaculties() {
		LOG.info(String.format("Entered: Execution starts findAllFaculties method %s", CLASSNAME));
		List<Faculty> faculties = new ArrayList<Faculty>();
		try {
			facultyRepo.findAll().forEach(faculties::add);
		} catch (DataAccessException dae) {
			LOG.error(String.format("Error occurred in findAllFaculties method %s", dae.getMessage()));
		}
		LOG.info(String.format("Exit: Execution ends findAllFaculties method %s", CLASSNAME));
		return faculties;
	}

	@Override
	public Faculty findFacultyById(Integer facultyId) {
		LOG.info(String.format("Entered: Execution starts findFacultyById method %s", CLASSNAME));
		Faculty faculty = null;
		try {
			faculty = facultyRepo.findById(facultyId).orElse(null);
		} catch (DataAccessException de) {
			LOG.error(String.format("Error occurred in findFacultyById method %s", de.getMessage()));
		}
		LOG.info(String.format("Exit: Execution ends findFacultyById method %s", CLASSNAME));
		return faculty;
	}

	@Override
	public Faculty updateFaculty(Faculty faculty) {
		LOG.info(String.format("Entered: Execution starts updateFaculty method %s", CLASSNAME));
		try {

			Faculty facultyEntity = facultyRepo.findById(faculty.getFacultyId()).orElse(null);
			if (facultyEntity != null && facultyEntity.getFacultyId() != null) {
				BeanUtils.copyProperties(faculty, facultyEntity);
				facultyRepo.save(facultyEntity);
			}
		} catch (DataAccessException de) {
			LOG.error(String.format("Error occurred in updateFaculty method %s", de.getMessage()));
		}
		LOG.info(String.format("Exit: Execution ends updateFaculty method %s", CLASSNAME));
		return faculty;
	}

	@Override
	public void deleteFacultyById(Integer facultyId) {
		LOG.info(String.format("Entered: Execution starts deleteFacultyById method %s", CLASSNAME));
		try {
			facultyRepo.deleteById(facultyId);
		} catch (DataAccessException de) {
			LOG.error(String.format("Error occurred in deleteFacultyById method %s", de.getMessage()));
		}
		LOG.info(String.format("Exit: Execution ends deleteFacultyById method %s", CLASSNAME));
	}

}
