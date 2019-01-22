package com.nicrt.app.repository;

import java.util.List;

import com.nicrt.app.model.State;

public interface CustomStateRepository {
	
	public List<State> getStatesByCountryCode(String countryCode);
}
