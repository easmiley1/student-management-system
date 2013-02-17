//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3354 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.17 at 12:49:17 AM EST 
//


package com.ish.sms.service.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for associateDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="associateDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fatherName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="motherName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gender">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Male"/>
 *               &lt;enumeration value="Female"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stateDTO" type="{http://www.ish.com/soa/sms}stateDTO"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zipCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="contactNo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="contactEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="emergencyContactNo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="otherContactInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bloodGroupDTO" type="{http://www.ish.com/soa/sms}bloodGroupDTO"/>
 *         &lt;element name="dateofJoining" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateofBirth" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="previousSchool" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "associateDTO", propOrder = {
    "id",
    "firstName",
    "fatherName",
    "motherName",
    "gender",
    "address",
    "stateDTO",
    "city",
    "zipCode",
    "contactNo",
    "contactEmail",
    "emergencyContactNo",
    "otherContactInfo",
    "bloodGroupDTO",
    "dateofJoining",
    "dateofBirth",
    "age",
    "comments",
    "previousSchool"
})
public class AssociateDTO
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected Integer id;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected String firstName;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected String fatherName;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected String motherName;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true, defaultValue = "Male")
    protected String gender;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected String address;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected StateDTO stateDTO;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected String city;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected Integer zipCode;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected Integer contactNo;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected String contactEmail;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected Integer emergencyContactNo;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected String otherContactInfo;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected BloodGroupDTO bloodGroupDTO;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected String dateofJoining;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected String dateofBirth;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected Integer age;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected String comments;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected String previousSchool;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
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
     * Gets the value of the stateDTO property.
     * 
     * @return
     *     possible object is
     *     {@link StateDTO }
     *     
     */
    public StateDTO getStateDTO() {
        return stateDTO;
    }

    /**
     * Sets the value of the stateDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link StateDTO }
     *     
     */
    public void setStateDTO(StateDTO value) {
        this.stateDTO = value;
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
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getZipCode() {
        return zipCode;
    }

    /**
     * Sets the value of the zipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setZipCode(Integer value) {
        this.zipCode = value;
    }

    /**
     * Gets the value of the contactNo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getContactNo() {
        return contactNo;
    }

    /**
     * Sets the value of the contactNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setContactNo(Integer value) {
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
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEmergencyContactNo() {
        return emergencyContactNo;
    }

    /**
     * Sets the value of the emergencyContactNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEmergencyContactNo(Integer value) {
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
     * Gets the value of the bloodGroupDTO property.
     * 
     * @return
     *     possible object is
     *     {@link BloodGroupDTO }
     *     
     */
    public BloodGroupDTO getBloodGroupDTO() {
        return bloodGroupDTO;
    }

    /**
     * Sets the value of the bloodGroupDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link BloodGroupDTO }
     *     
     */
    public void setBloodGroupDTO(BloodGroupDTO value) {
        this.bloodGroupDTO = value;
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
     * Gets the value of the dateofBirth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateofBirth() {
        return dateofBirth;
    }

    /**
     * Sets the value of the dateofBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateofBirth(String value) {
        this.dateofBirth = value;
    }

    /**
     * Gets the value of the age property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAge(Integer value) {
        this.age = value;
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

}
