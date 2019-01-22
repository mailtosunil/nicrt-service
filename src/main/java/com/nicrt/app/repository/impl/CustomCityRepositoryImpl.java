/**
 * 
 */
package com.nicrt.app.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nicrt.app.model.City;
import com.nicrt.app.repository.CustomCityRepository;

/**
 * @author bsunil
 *
 */
@Repository
@Transactional
public class CustomCityRepositoryImpl implements CustomCityRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.nicrt.app.repository.CustomCityRepository#getCitiesByStateCode()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<City> getCitiesByStateCode(String stateCode) {
		Query query = entityManager.createNativeQuery("SELECT * FROM UMED_CITY_MSTR WHERE STATE_CODE=?");
		query.setParameter(1, stateCode);
		return query.getResultList();
	}

}
