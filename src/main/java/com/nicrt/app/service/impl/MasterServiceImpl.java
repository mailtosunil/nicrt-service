package com.nicrt.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.nicrt.app.model.City;
import com.nicrt.app.model.Country;
import com.nicrt.app.model.State;
import com.nicrt.app.repository.CityRepository;
import com.nicrt.app.repository.CountryRepository;
import com.nicrt.app.repository.StateRepository;
import com.nicrt.app.service.MasterService;

@Service
public class MasterServiceImpl implements MasterService {

	public static final Logger LOG = LoggerFactory.getLogger(MasterServiceImpl.class);
	public static final String CLASSNAME = MasterServiceImpl.class.getName();

	@Autowired
	private CountryRepository countryRepo;

	@Autowired
	private StateRepository stateRepo;

	@Autowired
	private CityRepository cityRepo;

	@Override
	public List<State> getStates(String countryCode) {
		LOG.info(String.format("Entered: Execution starts getStates method %s", CLASSNAME));
		List<State> states = new ArrayList<>();
		try {
			states = stateRepo.getStatesByCountryCode(countryCode);
		} catch (DataAccessException dae) {
			LOG.error(String.format("Error occurred while fetching State master data %s", dae.getMessage()));
		}
		LOG.info(String.format("Exit: Executing ends getStates method %s", CLASSNAME));
		return states;
	}

	@Override
	public List<Country> getCountries() {
		LOG.info(String.format("Entered: Execution starts getCountries method %s", CLASSNAME));
		List<Country> countries = new ArrayList<>();
		try {
			countryRepo.findAll().forEach(countries::add);
		} catch (DataAccessException dae) {
			LOG.error(String.format("Error occurred while fetching country master data %s", dae.getMessage()));
		}
		LOG.info(String.format("Exit: Executing ends getCountries %s ", CLASSNAME));
		return countries;
	}

	@Override
	public List<City> getCities(String stateCode) {
		LOG.info(String.format("Entered: Execution starts getCities method %s", CLASSNAME));
		List<City> cities = new ArrayList<>();
		try {
			cities = cityRepo.getCitiesByStateCode(stateCode);
		} catch (DataAccessException dae) {
			LOG.error(String.format("Error occurred while fetching City master data %s", dae.getMessage()));
		}
		LOG.info(String.format("Exit: Executing ends getCities method %s", CLASSNAME));
		return cities;
	}

}
