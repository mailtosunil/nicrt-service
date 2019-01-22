package com.nicrt.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.nicrt.app.model.Student;
import com.nicrt.app.repository.StudentRepository;
import com.nicrt.app.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	public static final Logger LOG = LoggerFactory.getLogger(StudentServiceImpl.class);
	public static final String CLASSNAME = StudentServiceImpl.class.getName();

	@Override
	public Student saveStudent(Student student) {
		LOG.info(String.format("Entered: Execution starts saveStudent method %s", CLASSNAME));
		try {
			studentRepo.save(student);
		} catch (DataAccessException dae) {
			LOG.error(String.format("Error occurred in saveStudent method %s", dae.getMessage()));
		}
		LOG.info(String.format("Exit: Execution ends saveStudent method %s", CLASSNAME));
		return student;
	}

	@Override
	public List<Student> findAllStudents() {
		LOG.info(String.format("Entered: Execution starts findAllStudents method %s", CLASSNAME));
		List<Student> students = new ArrayList<>();
		try {
			studentRepo.findAll().forEach(students::add);
		} catch (DataAccessException de) {
			LOG.error(String.format("Error occurred in findAllStudents method %s", de.getMessage()));
		}
		LOG.info(String.format("Exit: Execution ends findAllStudents method %s", CLASSNAME));
		return students;
	}

	@Override
	public Student findStudentById(Integer studentId) {
		LOG.info(String.format("Entered: Execution starts findStudentById method %s", CLASSNAME));
		Student student = null;
		try {
			student = studentRepo.findById(studentId).orElse(null);
		} catch (DataAccessException dae) {
			LOG.error(String.format("Error occurred in findStudentById method %s", dae.getMessage()));
		}
		LOG.info(String.format("Exit: Execution ends findStudentById method %s", CLASSNAME));
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
		LOG.info(String.format("Entered: Execution starts updateStudent method %s", CLASSNAME));
		try {
			Student studentEntity = studentRepo.findById(student.getStudentId()).orElse(null);
			if (studentEntity != null && studentEntity.getStudentId() != null) {
				BeanUtils.copyProperties(student, studentEntity);
				studentRepo.save(studentEntity);
			}
		} catch (DataAccessException dae) {
			LOG.error(String.format("Error occurred in updateStudent method %s", dae.getMessage()));
		}
		LOG.info(String.format("Exit: Execution ends updateStudent method %s", CLASSNAME));
		return student;
	}

	@Override
	public void deleteStudentById(Integer studentId) {
		LOG.info(String.format("Entered: Execution starts deleteStudentById method %s", CLASSNAME));
		try {
			studentRepo.deleteById(studentId);
		} catch (DataAccessException de) {
			LOG.error(String.format("Error occurred in deleteStudentById method %s", de.getMessage()));
		}
		LOG.info(String.format("Exit: Execution ends deleteStudentById method %s", CLASSNAME));
	}

}
