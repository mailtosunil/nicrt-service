package com.nicrt.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UMED_STATE_MSTR")
public class State implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "STATE_CODE")
	private Integer stateCode;
	@Column(name = "STATE_NAME")
	private String stateName;
	@ManyToOne
	@JoinColumn(name = "countryId")
	private Country countryId;

	public Integer getStateCode() {
		return stateCode;
	}

	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Country getCountryId() {
		return countryId;
	}

	public void setCountryId(Country countryId) {
		this.countryId = countryId;
	}

	public String toString() {
		return "[" + getStateCode() + ", " + getStateName() + "," + getCountryId() + "]";
	}
}
