package com.ish.sms.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.ish.sms.service.util.QueryConstants;

/**
 * This entity represents the teacher table in the database
 * 
 * @author Naren
 * 
 */
@NamedQueries({ @NamedQuery(name = QueryConstants.FIND_ALL_TEACHERS, query = QueryConstants.FIND_ALL_TEACHERS_QUERY) })
@Entity
@Table(name = "Teacher_Details")
public class Teacher {

	@Id
	@Column(name = "teacher_id")
	private Integer id;
	@Column(nullable = false, name = "first_name")
	private String firstName;
	@Column(nullable = false, name = "father_name")
	private String fatherName;
	@Column(nullable = false, name = "mother_name")
	private String motherName;
	@Column(nullable = false, name = "gender")
	private String gender;
	@Column(nullable = false, name = "address")
	private String address;
	@ManyToOne
	@JoinColumn( name = "state")
	private State state;
	@Column(nullable = false, name = "city")
	private String city;
	@Column(nullable = false, name = "zip_code")
	private int zipCode;
	@Column(nullable = false, name = "contact_no")
	private int contactNo;
	@Column(nullable = true, name = "contact_email")
	private String contactEmail;
	@Column(nullable = false, name = "emergency_contact_no")
	private int emergencyContactNo;
	@Column(nullable = true, name = "other_contact_info")
	private String otherContactInfo;
	@ManyToOne
	@JoinColumn( name = "blood_group")
	private BloodGroup bloodGroup;
	@Column(nullable = false, name = "date_of_joining")
	private String dateofJoining;
	@Column(nullable = true, name = "comments")
	private String comments;
	@Column(nullable = true, name = "previous_school")
	private String previousSchool;
	@Column(nullable = false, name = "age")
	private Integer age;
	@Column(nullable = true, name = "date_of_birth")
	private String dateofBirth;
	@Column(nullable = true, name = "previous_occupation")
	private String previousOccupation;
	@Column(nullable = true, name = "education")
	private String education;
	@Column(nullable = true, name = "experience")
	private Integer experience;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}
	/**
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	/**
	 * @return the motherName
	 */
	public String getMotherName() {
		return motherName;
	}
	/**
	 * @param motherName the motherName to set
	 */
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * @return the contactNo
	 */
	public int getContactNo() {
		return contactNo;
	}
	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	/**
	 * @return the contactEmail
	 */
	public String getContactEmail() {
		return contactEmail;
	}
	/**
	 * @param contactEmail the contactEmail to set
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	/**
	 * @return the emergencyContactNo
	 */
	public int getEmergencyContactNo() {
		return emergencyContactNo;
	}
	/**
	 * @param emergencyContactNo the emergencyContactNo to set
	 */
	public void setEmergencyContactNo(int emergencyContactNo) {
		this.emergencyContactNo = emergencyContactNo;
	}
	/**
	 * @return the otherContactInfo
	 */
	public String getOtherContactInfo() {
		return otherContactInfo;
	}
	/**
	 * @param otherContactInfo the otherContactInfo to set
	 */
	public void setOtherContactInfo(String otherContactInfo) {
		this.otherContactInfo = otherContactInfo;
	}
	/**
	 * @return the bloodGroup
	 */
	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}
	/**
	 * @param bloodGroup the bloodGroup to set
	 */
	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	/**
	 * @return the dateofJoining
	 */
	public String getDateofJoining() {
		return dateofJoining;
	}
	/**
	 * @param dateofJoining the dateofJoining to set
	 */
	public void setDateofJoining(String dateofJoining) {
		this.dateofJoining = dateofJoining;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return the previousSchool
	 */
	public String getPreviousSchool() {
		return previousSchool;
	}
	/**
	 * @param previousSchool the previousSchool to set
	 */
	public void setPreviousSchool(String previousSchool) {
		this.previousSchool = previousSchool;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the dateofBirth
	 */
	public String getDateofBirth() {
		return dateofBirth;
	}
	/**
	 * @param dateofBirth the dateofBirth to set
	 */
	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	/**
	 * @return the previousOccupation
	 */
	public String getPreviousOccupation() {
		return previousOccupation;
	}
	/**
	 * @param previousOccupation the previousOccupation to set
	 */
	public void setPreviousOccupation(String previousOccupation) {
		this.previousOccupation = previousOccupation;
	}
	/**
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * @return the experience
	 */
	public Integer getExperience() {
		return experience;
	}
	/**
	 * @param experience the experience to set
	 */
	public void setExperience(Integer experience) {
		this.experience = experience;
	}

}