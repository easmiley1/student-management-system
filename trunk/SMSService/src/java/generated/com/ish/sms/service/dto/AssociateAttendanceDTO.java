//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3354 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.21 at 07:35:53 PM EST 
//


package com.ish.sms.service.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for associateAttendanceDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="associateAttendanceDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="attendanceMap" type="{http://www.ish.com/soa/sms}attendances" minOccurs="0"/>
 *         &lt;element name="studentDTO" type="{http://www.ish.com/soa/sms}studentDTO"/>
 *         &lt;element name="classAttendanceDefDTO" type="{http://www.ish.com/soa/sms}classAttendanceDefDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "associateAttendanceDTO", propOrder = {
    "id",
    "attendanceMap",
    "studentDTO",
    "classAttendanceDefDTO"
})
public class AssociateAttendanceDTO
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected Integer id;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", type = Attendances.class)
    protected AttendanceMap<String, Boolean> attendanceMap;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected StudentDTO studentDTO;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected ClassAttendanceDefDTO classAttendanceDefDTO;

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
     * Gets the value of the attendanceMap property.
     * 
     * @return
     *     possible object is
     *     {@link Attendances }
     *     
     */
    public AttendanceMap<String, Boolean> getAttendanceMap() {
        return attendanceMap;
    }

    /**
     * Sets the value of the attendanceMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link Attendances }
     *     
     */
    public void setAttendanceMap(AttendanceMap<String, Boolean> value) {
        this.attendanceMap = value;
    }

    /**
     * Gets the value of the studentDTO property.
     * 
     * @return
     *     possible object is
     *     {@link StudentDTO }
     *     
     */
    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    /**
     * Sets the value of the studentDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudentDTO }
     *     
     */
    public void setStudentDTO(StudentDTO value) {
        this.studentDTO = value;
    }

    /**
     * Gets the value of the classAttendanceDefDTO property.
     * 
     * @return
     *     possible object is
     *     {@link ClassAttendanceDefDTO }
     *     
     */
    public ClassAttendanceDefDTO getClassAttendanceDefDTO() {
        return classAttendanceDefDTO;
    }

    /**
     * Sets the value of the classAttendanceDefDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassAttendanceDefDTO }
     *     
     */
    public void setClassAttendanceDefDTO(ClassAttendanceDefDTO value) {
        this.classAttendanceDefDTO = value;
    }

}
