//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3354 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.27 at 10:55:59 AM EDT 
//


package com.ish.sms.service.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userDetailsDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userDetailsDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="userRoleDTO" type="{http://www.ish.com/soa/sms}userRoleDTO"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="classListDTO" type="{http://www.ish.com/soa/sms}classListDTO" minOccurs="0"/>
 *         &lt;element name="studentListDTO" type="{http://www.ish.com/soa/sms}studentListDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userDetailsDTO", propOrder = {
    "id",
    "userRoleDTO",
    "name",
    "password",
    "classListDTO",
    "studentListDTO"
})
public class UserDetailsDTO
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected Integer id;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected UserRoleDTO userRoleDTO;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected String name;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected String password;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected ClassListDTO classListDTO;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected StudentListDTO studentListDTO;

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
     * Gets the value of the userRoleDTO property.
     * 
     * @return
     *     possible object is
     *     {@link UserRoleDTO }
     *     
     */
    public UserRoleDTO getUserRoleDTO() {
        return userRoleDTO;
    }

    /**
     * Sets the value of the userRoleDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserRoleDTO }
     *     
     */
    public void setUserRoleDTO(UserRoleDTO value) {
        this.userRoleDTO = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the classListDTO property.
     * 
     * @return
     *     possible object is
     *     {@link ClassListDTO }
     *     
     */
    public ClassListDTO getClassListDTO() {
        return classListDTO;
    }

    /**
     * Sets the value of the classListDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassListDTO }
     *     
     */
    public void setClassListDTO(ClassListDTO value) {
        this.classListDTO = value;
    }

    /**
     * Gets the value of the studentListDTO property.
     * 
     * @return
     *     possible object is
     *     {@link StudentListDTO }
     *     
     */
    public StudentListDTO getStudentListDTO() {
        return studentListDTO;
    }

    /**
     * Sets the value of the studentListDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudentListDTO }
     *     
     */
    public void setStudentListDTO(StudentListDTO value) {
        this.studentListDTO = value;
    }

}
