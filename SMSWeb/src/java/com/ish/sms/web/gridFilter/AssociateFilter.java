package com.ish.sms.web.gridFilter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Filter class to map the common filter inputs in the student and teacher grids.
 * 
 * @author Naren
 *
 */
@ManagedBean(name = "associateFilter")
@ViewScoped
public class AssociateFilter implements Serializable {

	private static final long serialVersionUID = 1L;
	private String firstNameFilter;
	private String fatherNameFilter;
	private String motherNameFilter;
	private String genderFilter;
	private String addressFilter;
	private String stateFilter;
	private String cityFilter;
	private Integer zipCodeFilter;
	private Integer contactNoFilter;
	private String contactEmailFilter;
	private Integer emergencyContactNoFilter;
	private String bloodGroupFilter;
	private String dateofJoiningFilter;
	private String dateofBirthFilter;
	private Integer ageFilter;
	/**
	 * @return the firstNameFilter
	 */
	public String getFirstNameFilter() {
		return firstNameFilter;
	}
	/**
	 * @param firstNameFilter the firstNameFilter to set
	 */
	public void setFirstNameFilter(String firstNameFilter) {
		this.firstNameFilter = firstNameFilter;
	}
	/**
	 * @return the fatherNameFilter
	 */
	public String getFatherNameFilter() {
		return fatherNameFilter;
	}
	/**
	 * @param fatherNameFilter the fatherNameFilter to set
	 */
	public void setFatherNameFilter(String fatherNameFilter) {
		this.fatherNameFilter = fatherNameFilter;
	}
	/**
	 * @return the motherNameFilter
	 */
	public String getMotherNameFilter() {
		return motherNameFilter;
	}
	/**
	 * @param motherNameFilter the motherNameFilter to set
	 */
	public void setMotherNameFilter(String motherNameFilter) {
		this.motherNameFilter = motherNameFilter;
	}
	/**
	 * @return the genderFilter
	 */
	public String getGenderFilter() {
		return genderFilter;
	}
	/**
	 * @param genderFilter the genderFilter to set
	 */
	public void setGenderFilter(String genderFilter) {
		this.genderFilter = genderFilter;
	}
	/**
	 * @return the addressFilter
	 */
	public String getAddressFilter() {
		return addressFilter;
	}
	/**
	 * @param addressFilter the addressFilter to set
	 */
	public void setAddressFilter(String addressFilter) {
		this.addressFilter = addressFilter;
	}
	/**
	 * @return the stateFilter
	 */
	public String getStateFilter() {
		return stateFilter;
	}
	/**
	 * @param stateFilter the stateFilter to set
	 */
	public void setStateFilter(String stateFilter) {
		this.stateFilter = stateFilter;
	}
	/**
	 * @return the cityFilter
	 */
	public String getCityFilter() {
		return cityFilter;
	}
	/**
	 * @param cityFilter the cityFilter to set
	 */
	public void setCityFilter(String cityFilter) {
		this.cityFilter = cityFilter;
	}
	/**
	 * @return the zipCodeFilter
	 */
	public Integer getZipCodeFilter() {
		return zipCodeFilter;
	}
	/**
	 * @param zipCodeFilter the zipCodeFilter to set
	 */
	public void setZipCodeFilter(Integer zipCodeFilter) {
		this.zipCodeFilter = zipCodeFilter;
	}
	/**
	 * @return the contactNoFilter
	 */
	public Integer getContactNoFilter() {
		return contactNoFilter;
	}
	/**
	 * @param contactNoFilter the contactNoFilter to set
	 */
	public void setContactNoFilter(Integer contactNoFilter) {
		this.contactNoFilter = contactNoFilter;
	}
	/**
	 * @return the contactEmailFilter
	 */
	public String getContactEmailFilter() {
		return contactEmailFilter;
	}
	/**
	 * @param contactEmailFilter the contactEmailFilter to set
	 */
	public void setContactEmailFilter(String contactEmailFilter) {
		this.contactEmailFilter = contactEmailFilter;
	}
	/**
	 * @return the emergencyContactNoFilter
	 */
	public Integer getEmergencyContactNoFilter() {
		return emergencyContactNoFilter;
	}
	/**
	 * @param emergencyContactNoFilter the emergencyContactNoFilter to set
	 */
	public void setEmergencyContactNoFilter(Integer emergencyContactNoFilter) {
		this.emergencyContactNoFilter = emergencyContactNoFilter;
	}
	/**
	 * @return the bloodGroupFilter
	 */
	public String getBloodGroupFilter() {
		return bloodGroupFilter;
	}
	/**
	 * @param bloodGroupFilter the bloodGroupFilter to set
	 */
	public void setBloodGroupFilter(String bloodGroupFilter) {
		this.bloodGroupFilter = bloodGroupFilter;
	}
	/**
	 * @return the dateofJoiningFilter
	 */
	public String getDateofJoiningFilter() {
		return dateofJoiningFilter;
	}
	/**
	 * @param dateofJoiningFilter the dateofJoiningFilter to set
	 */
	public void setDateofJoiningFilter(String dateofJoiningFilter) {
		this.dateofJoiningFilter = dateofJoiningFilter;
	}
	/**
	 * @return the dateofBirthFilter
	 */
	public String getDateofBirthFilter() {
		return dateofBirthFilter;
	}
	/**
	 * @param dateofBirthFilter the dateofBirthFilter to set
	 */
	public void setDateofBirthFilter(String dateofBirthFilter) {
		this.dateofBirthFilter = dateofBirthFilter;
	}
	/**
	 * @return the ageFilter
	 */
	public Integer getAgeFilter() {
		return ageFilter;
	}
	/**
	 * @param ageFilter the ageFilter to set
	 */
	public void setAgeFilter(Integer ageFilter) {
		this.ageFilter = ageFilter;
	}


}
