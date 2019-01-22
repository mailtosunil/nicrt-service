package com.nicrt.app.repository;

import java.util.List;

import com.nicrt.app.model.City;

public interface CustomCityRepository {
	public List<City> getCitiesByStateCode(String stateCode);
}
