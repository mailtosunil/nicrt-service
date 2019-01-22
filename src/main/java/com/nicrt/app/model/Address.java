package com.nicrt.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UMED_STUDENT_ADDRESS")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UMED_STUD_ADDR_SEQ")
	@Column(name = "ADDR_ID")
	private Integer addrId;
	@Column(name = "ADDR_AREA")
	private String addrArea;
	@Column(name = "ADDR_CITY")
	private String addrCity;
	@Column(name = "ADDR_STATE")
	private String addrState;
	@Column(name = "ADDR_LANDMARK")
	private String addrLandMark;
	@Column(name = "CELL_NO")
	private String cellNo;
	@ManyToOne
	@JoinColumn(name = "studentId")
	private Student student;
	@Column(name = "ADDR_TYPE")
	private String addrType;

	public Address() {
		super();
	}

	public Address(String addrArea, String addrCity, String addrState, String addrLandMark, String cellNo,
			Student student, String addrType) {
		super();
		this.addrArea = addrArea;
		this.addrCity = addrCity;
		this.addrState = addrState;
		this.addrLandMark = addrLandMark;
		this.cellNo = cellNo;
		this.student = student;
		this.addrType = addrType;
	}

	public Integer getAddrId() {
		return addrId;
	}

	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}

	public String getAddrArea() {
		return addrArea;
	}

	public void setAddrArea(String addrArea) {
		this.addrArea = addrArea;
	}

	public String getAddrCity() {
		return addrCity;
	}

	public void setAddrCity(String addrCity) {
		this.addrCity = addrCity;
	}

	public String getAddrState() {
		return addrState;
	}

	public void setAddrState(String addrState) {
		this.addrState = addrState;
	}

	public String getAddrLandMark() {
		return addrLandMark;
	}

	public void setAddrLandMark(String addrLandMark) {
		this.addrLandMark = addrLandMark;
	}

	public String getCellNo() {
		return cellNo;
	}

	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getAddrType() {
		return addrType;
	}

	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}

	public String toString() {
		return "[" + getAddrArea() + ", " + getAddrCity() + ", " + getAddrState() + "," + getAddrLandMark()
				+ getCellNo() + "]";
	}
}
