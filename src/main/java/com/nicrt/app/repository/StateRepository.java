package com.nicrt.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicrt.app.model.State;

@Repository
public interface StateRepository extends CrudRepository<State, Integer>, CustomStateRepository{
	
}
