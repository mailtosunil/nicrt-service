package com.nicrt.app.service;

import java.util.List;

import com.nicrt.app.model.City;
import com.nicrt.app.model.Country;
import com.nicrt.app.model.State;

public interface MasterService {
	
	List<State> getStates(String countryCode);
	List<Country> getCountries();
	List<City> getCities(String stateCode);
}
