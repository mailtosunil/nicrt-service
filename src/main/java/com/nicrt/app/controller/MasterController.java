package com.nicrt.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicrt.app.model.City;
import com.nicrt.app.model.Country;
import com.nicrt.app.model.State;
import com.nicrt.app.service.MasterService;

@RestController
@RequestMapping("/api/udem")
public class MasterController {

	@Autowired
	private MasterService masterService;

	public static final Logger LOG = LoggerFactory.getLogger(CourseController.class);
	public static final String CLASSNAME = CourseController.class.getName();

	@SuppressWarnings("rawtypes")
	@GetMapping("/cities/{stateCode}")
	public ResponseEntity cities(@PathVariable String stateCode) {
		ResponseEntity response = null;
		List<City> cities = masterService.getCities(stateCode);
		if (cities != null && !cities.isEmpty()) {
			response = new ResponseEntity<List<City>>(cities, HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("No Data Found", HttpStatus.NOT_FOUND);
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/countries")
	public ResponseEntity countries() {
		ResponseEntity response = null;
		List<Country> countries = masterService.getCountries();
		if (countries != null && !countries.isEmpty()) {
			response = new ResponseEntity<List<Country>>(countries, HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("No Data Found", HttpStatus.NOT_FOUND);
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/states/{countryCode}")
	public ResponseEntity states(@PathVariable String countryCode) {
		ResponseEntity response = null;
		List<State> states = masterService.getStates(countryCode);
		if (states != null && !states.isEmpty()) {
			response = new ResponseEntity<List<State>>(states, HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("No Data Found", HttpStatus.NOT_FOUND);
		}
		return response;
	}
}
