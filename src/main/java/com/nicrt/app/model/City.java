package com.nicrt.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UMED_CITY_MSTR")
public class City implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CITY_CODE")
	private Integer cityCode;
	@Column(name = "CITY_NAME")
	private String cityName;
	@ManyToOne
	@JoinColumn(name = "stateCode")
	private State stateId;

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public State getStateId() {
		return stateId;
	}

	public void setStateId(State stateId) {
		this.stateId = stateId;
	}

	public String toString() {
		return "[" + getCityCode() + ", " + getCityName() + ", " + getStateId() + "]";
	}
}
