package com.nicrt.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicrt.app.model.Faculty;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Integer> {
}
