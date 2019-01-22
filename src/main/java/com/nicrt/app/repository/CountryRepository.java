package com.nicrt.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicrt.app.model.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
}
