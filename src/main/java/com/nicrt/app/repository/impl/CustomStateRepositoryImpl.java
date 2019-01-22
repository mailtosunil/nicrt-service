package com.nicrt.app.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nicrt.app.model.State;
import com.nicrt.app.repository.CustomStateRepository;

@Repository
@Transactional
public class CustomStateRepositoryImpl implements CustomStateRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<State> getStatesByCountryCode(String countryCode) {
		Query query = entityManager.createNativeQuery("SELECT * FROM UMED_STATE_MSTR WHERE COUNTRY_CODE=?");
		query.setParameter(1, countryCode);
		return query.getResultList();
	}

}
