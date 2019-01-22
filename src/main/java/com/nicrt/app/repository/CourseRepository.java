package com.nicrt.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicrt.app.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer>{
}
