package com.nicrt.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicrt.app.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
