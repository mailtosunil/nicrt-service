package com.nicrt.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicrt.app.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer>,CustomCityRepository {

}
