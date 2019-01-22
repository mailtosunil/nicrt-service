package com.nicrt.app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author sunil
 *
 */
@Entity
@Table(name = "UMED_STUDENTS")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="UMED_STUDENT_SEQ")
	@Column(name = "STUDENT_ID")
	private Integer studentId;
	@Column(name = "STUDENT_NAME")
	private String studentName;
	@Column(name = "STUDENT_MOBILE")
	private String studMobile;
	@Lob
	@Column(name = "STUDENT_IMG", nullable = false)
	private byte[] studentImg;
	@Column(name = "STUDENT_FORM_NO")
	private Long formNo;
	@Column(name = "STUDENT_FTHR_NAME")
	private String studFthrName;
	@Column(name = "STUDENT_DOB")
	private Date studDob;
	@Column(name = "STUDENT_GENDR")
	private String gender;
	@Column(name = "STUDENT_CAT")
	private String category;
	@Column(name = "STUDENT_MARTL_STS")
	private String martialSts;
	@Column(name = "STUDENT_NATNLITY")
	private String nationality;
	@Column(name = "STUDENT_TMNGS")
	private String timings;
	@Column(name = "STUDENT_LANG")
	private String language;
	@Column(name = "STUDENT_EMAIL")
	private String email;

	@ManyToMany
	@JoinTable(name = "UMED_STUD_COURSE", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "COURSE_ID") })
	private Set<Course> studCourse;

	@OneToMany(mappedBy = "student")
	private Set<Address> studAddr;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudMobile() {
		return studMobile;
	}

	public void setStudMobile(String studMobile) {
		this.studMobile = studMobile;
	}

	public byte[] getStudentImg() {
		return studentImg;
	}

	public void setStudentImg(byte[] studentImg) {
		this.studentImg = studentImg;
	}

	public Long getFormNo() {
		return formNo;
	}

	public void setFormNo(Long formNo) {
		this.formNo = formNo;
	}

	public String getStudFthrName() {
		return studFthrName;
	}

	public void setStudFthrName(String studFthrName) {
		this.studFthrName = studFthrName;
	}

	public Date getStudDob() {
		return studDob;
	}

	public void setStudDob(Date studDob) {
		this.studDob = studDob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMartialSts() {
		return martialSts;
	}

	public void setMartialSts(String martialSts) {
		this.martialSts = martialSts;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Course> getStudCourse() {
		return studCourse;
	}

	public void setStudCourse(Set<Course> studCourse) {
		this.studCourse = studCourse;
	}

	public Set<Address> getStudAddr() {
		return studAddr;
	}

	public void setStudAddr(Set<Address> studAddr) {
		this.studAddr = studAddr;
	}

	public String toString() {
		return "[" + getStudentId() + ", " + getStudentName() + ", " + getStudMobile() + "]";
	}
}
