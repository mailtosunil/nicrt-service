package com.nicrt.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UMED_COUNTRY_MSTR")
public class Country implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "COUNTRY_CODE")
	private Integer countryId;
	@Column(name = "COUNTRY_NAME")
	private String countryName;

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String toString() {
		return "[" + getCountryId() + ", " + getCountryName() + "]";
	}
}
