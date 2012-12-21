
package com.ish.sms.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This entity represents the student table in the database
 * 
 * @author Naren
 *
 */
@Entity
@Table(name="Student")
public class Student {

    @Id
    @Column(name="student_id")
    protected Integer id;
    @Column(nullable=false, name="first_name")
    protected String firstName;
    @Column(nullable=false, name="father_name")
    protected String fatherName;
    @Column(nullable=false, name="mother_name")
    protected String motherName;
    @Column(nullable=false, name="gender")
    protected String gender;
    @Column(nullable=false, name="address")
    protected String address;
    @Column(nullable=false, name="state")
    protected String state;
    @Column(nullable=false, name="city")
    protected String city;
    @Column(nullable=false, name="zip_code")
    protected int zipCode;
    @Column(nullable=false, name="contact_no")
    protected int contactNo;
    @Column(nullable=true, name="contact_email")
    protected String contactEmail;
    @Column(nullable=false, name="emergency_contact_no")
    protected int emergencyContactNo;
    @Column(nullable=true, name="other_contact_info")
    protected String otherContactInfo;
    @Column(nullable=false, name="blood_group")
    protected String bloodGroup;
    @Column(nullable=false, name="date_of_joining")
    protected String dateofJoining;
    @Column(nullable=true, name="comments")
    protected String comments;
    @Column(nullable=true, name="previous_school")
    protected String previousSchool;
    @Column(nullable=false, name="joining_class")
    protected String joiningClass;
    @Column(nullable=true, name="extra_curr_interest")
    protected String extraCurricularInterest;
    @Column(nullable=false, name="mode_of_transport")
    protected String modeOfTransport;

    /**
     * Gets the value of the id property.
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the fatherName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * Sets the value of the fatherName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFatherName(String value) {
        this.fatherName = value;
    }

    /**
     * Gets the value of the motherName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotherName() {
        return motherName;
    }

    /**
     * Sets the value of the motherName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotherName(String value) {
        this.motherName = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the zipCode property.
     * 
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     * Sets the value of the zipCode property.
     * 
     */
    public void setZipCode(int value) {
        this.zipCode = value;
    }

    /**
     * Gets the value of the contactNo property.
     * 
     */
    public int getContactNo() {
        return contactNo;
    }

    /**
     * Sets the value of the contactNo property.
     * 
     */
    public void setContactNo(int value) {
        this.contactNo = value;
    }

    /**
     * Gets the value of the contactEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * Sets the value of the contactEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactEmail(String value) {
        this.contactEmail = value;
    }

    /**
     * Gets the value of the emergencyContactNo property.
     * 
     */
    public int getEmergencyContactNo() {
        return emergencyContactNo;
    }

    /**
     * Sets the value of the emergencyContactNo property.
     * 
     */
    public void setEmergencyContactNo(int value) {
        this.emergencyContactNo = value;
    }

    /**
     * Gets the value of the otherContactInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherContactInfo() {
        return otherContactInfo;
    }

    /**
     * Sets the value of the otherContactInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherContactInfo(String value) {
        this.otherContactInfo = value;
    }

    /**
     * Gets the value of the bloodGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBloodGroup() {
        return bloodGroup;
    }

    /**
     * Sets the value of the bloodGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBloodGroup(String value) {
        this.bloodGroup = value;
    }

    /**
     * Gets the value of the dateofJoining property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateofJoining() {
        return dateofJoining;
    }

    /**
     * Sets the value of the dateofJoining property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateofJoining(String value) {
        this.dateofJoining = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the previousSchool property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviousSchool() {
        return previousSchool;
    }

    /**
     * Sets the value of the previousSchool property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviousSchool(String value) {
        this.previousSchool = value;
    }

    /**
     * Gets the value of the joiningClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJoiningClass() {
        return joiningClass;
    }

    /**
     * Sets the value of the joiningClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJoiningClass(String value) {
        this.joiningClass = value;
    }

    /**
     * Gets the value of the extraCurricularInterest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtraCurricularInterest() {
        return extraCurricularInterest;
    }

    /**
     * Sets the value of the extraCurricularInterest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtraCurricularInterest(String value) {
        this.extraCurricularInterest = value;
    }

    /**
     * Gets the value of the modeOfTransport property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModeOfTransport() {
        return modeOfTransport;
    }

    /**
     * Sets the value of the modeOfTransport property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModeOfTransport(String value) {
        this.modeOfTransport = value;
    }

}
