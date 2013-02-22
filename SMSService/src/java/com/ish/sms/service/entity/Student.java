package com.ish.sms.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.ish.sms.service.util.QueryConstants;

/**
 * This entity represents the student table in the database
 * 
 * @author Naren
 * 
 */
@NamedQueries({ @NamedQuery(name = QueryConstants.FIND_ALL_STUDENTS, query = QueryConstants.FIND_ALL_STUDENTS_QUERY),
		@NamedQuery(name = QueryConstants.FIND_ALL_STUDENTS_BY_CLASS, query = QueryConstants.FIND_ALL_STUDENTS_BY_CLASS_QUERY) })
@Entity
@Table(name = "Student_Details")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
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
	@JoinColumn(nullable = false, name = "state")
	private ReferenceData state;
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
	@JoinColumn(nullable = false, name = "blood_group")
	private ReferenceData bloodGroup;
	@Column(nullable = false, name = "date_of_joining")
	private String dateofJoining;
	@Column(nullable = true, name = "comments")
	private String comments;
	@Column(nullable = true, name = "previous_school")
	private String previousSchool;
	@ManyToOne
	@JoinColumn(nullable = false, name = "joining_class")
	private Class joiningClass;
	@ManyToOne
	@JoinColumn(nullable = false, name = "current_class")
	private Class currentClass;
	@ManyToOne
	@JoinColumn(name = "extra_curr_interest")
	private ReferenceData extraCurricularInterest;
	@ManyToOne
	@JoinColumn(name = "mode_of_transport")
	private ReferenceData modeOfTransport;
	@Column(nullable = false, name = "age")
	private Integer age;
	@Column(nullable = true, name = "date_of_birth")
	private String dateofBirth;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param firstName
	 *            the firstName to set
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
	 * @param fatherName
	 *            the fatherName to set
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
	 * @param motherName
	 *            the motherName to set
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
	 * @param gender
	 *            the gender to set
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
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the state
	 */
	public ReferenceData getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(ReferenceData state) {
		this.state = state;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
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
	 * @param zipCode
	 *            the zipCode to set
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
	 * @param contactNo
	 *            the contactNo to set
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
	 * @param contactEmail
	 *            the contactEmail to set
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
	 * @param emergencyContactNo
	 *            the emergencyContactNo to set
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
	 * @param otherContactInfo
	 *            the otherContactInfo to set
	 */
	public void setOtherContactInfo(String otherContactInfo) {
		this.otherContactInfo = otherContactInfo;
	}

	/**
	 * @return the bloodGroup
	 */
	public ReferenceData getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * @param bloodGroup
	 *            the bloodGroup to set
	 */
	public void setBloodGroup(ReferenceData bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	/**
	 * @return the dateofJoining
	 */
	public String getDateofJoining() {
		return dateofJoining;
	}

	/**
	 * @param dateofJoining
	 *            the dateofJoining to set
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
	 * @param comments
	 *            the comments to set
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
	 * @param previousSchool
	 *            the previousSchool to set
	 */
	public void setPreviousSchool(String previousSchool) {
		this.previousSchool = previousSchool;
	}

	/**
	 * @return the joiningClass
	 */
	public Class getJoiningClass() {
		return joiningClass;
	}

	/**
	 * @param joiningClass
	 *            the joiningClass to set
	 */
	public void setJoiningClass(Class joiningClass) {
		this.joiningClass = joiningClass;
	}

	/**
	 * @return the extraCurricularInterest
	 */
	public ReferenceData getExtraCurricularInterest() {
		return extraCurricularInterest;
	}

	/**
	 * @param extraCurricularInterest
	 *            the extraCurricularInterest to set
	 */
	public void setExtraCurricularInterest(ReferenceData extraCurricularInterest) {
		this.extraCurricularInterest = extraCurricularInterest;
	}

	/**
	 * @return the modeOfTransport
	 */
	public ReferenceData getModeOfTransport() {
		return modeOfTransport;
	}

	/**
	 * @param modeOfTransport
	 *            the modeOfTransport to set
	 */
	public void setModeOfTransport(ReferenceData modeOfTransport) {
		this.modeOfTransport = modeOfTransport;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
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
	 * @param dateofBirth
	 *            the dateofBirth to set
	 */
	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	/**
	 * @return the currentClass
	 */
	public Class getCurrentClass() {
		return currentClass;
	}

	/**
	 * @param currentClass
	 *            the currentClass to set
	 */
	public void setCurrentClass(Class currentClass) {
		this.currentClass = currentClass;
	}
}
