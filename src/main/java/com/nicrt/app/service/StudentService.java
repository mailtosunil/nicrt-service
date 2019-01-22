package com.nicrt.app.service;

import java.util.List;

import com.nicrt.app.model.Student;

public interface StudentService {

	Student saveStudent(Student student);

	List<Student> findAllStudents();

	void deleteStudentById(Integer studentId);

	Student findStudentById(Integer studentId);

	Student updateStudent(Student student);

}
