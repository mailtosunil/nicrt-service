package com.nicrt.app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UMED_FACULTY")
public class Faculty implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="UMED_FACULTY_SEQ")
	@Column(name = "FACULTY_ID")
	private Integer facultyId;
	@Column(name = "FACULTY_NAME")
	private String facultyName;
	@Column(name = "FACULTY_QUAL")
	private String facultyQual;
	@Column(name = "FACULTY_SAL")
	private Double facultySal;
	@Lob
	@Column(name = "FACULTY_IMG")
	private byte[] facultyImg;
	@Column(name="FACULTY_DOB")
	private Date facultyDob;
	@Column(name="GENDER")
	private String gender;
	@Column(name="MARITAL_STS")
	private String maritalSts;
	@Column(name="NATIONALITY")
	private String nationality;
	@Column(name="MOBILE")
	private String cell;
	@OneToMany(mappedBy="faculty")
	private Set<Course> course;

	public Integer getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getFacultyQual() {
		return facultyQual;
	}

	public void setFacultyQual(String facultyQual) {
		this.facultyQual = facultyQual;
	}

	public Double getFacultySal() {
		return facultySal;
	}

	public void setFacultySal(Double facultySal) {
		this.facultySal = facultySal;
	}

	public byte[] getFacultyImg() {
		return facultyImg;
	}

	public void setFacultyImg(byte[] facultyImg) {
		this.facultyImg = facultyImg;
	}

	public Date getFacultyDob() {
		return facultyDob;
	}

	public void setFacultyDob(Date facultyDob) {
		this.facultyDob = facultyDob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalSts() {
		return maritalSts;
	}

	public void setMaritalSts(String maritalSts) {
		this.maritalSts = maritalSts;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}

	@Override
	public boolean equals(Object obj) {
		boolean flag = Boolean.FALSE;

		if (this == obj)
			flag = Boolean.TRUE;
		if (obj instanceof Faculty) {
			Faculty fac = (Faculty) obj;
			if (this.getFacultyId().equals(fac.getFacultyId())
					&& this.getFacultyName().equalsIgnoreCase(fac.getFacultyName())
					&& this.getFacultyQual().equals(fac.getFacultyQual())
					&& this.getFacultySal().equals(fac.getFacultySal())) {
				flag = Boolean.TRUE;
			}
		}
		return flag;
	}
}
