//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3354 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.21 at 03:40:59 PM EST 
//


package com.ish.sms.service.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.ish.sms.web.service.dto.AttendanceYearMap;


/**
 * <p>Java class for attendanceDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="attendanceDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attendanceYearMap" type="{http://www.ish.com/soa/sms}attendanceYears" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attendanceDTO", propOrder = {
    "attendanceYearMap"
})
public class AttendanceDTO
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", type = AttendanceYears.class)
    protected AttendanceYearMap<String, AttendanceYearsList> attendanceYearMap;

    /**
     * Gets the value of the attendanceYearMap property.
     * 
     * @return
     *     possible object is
     *     {@link AttendanceYears }
     *     
     */
    public AttendanceYearMap<String, AttendanceYearsList> getAttendanceYearMap() {
        return attendanceYearMap;
    }

    /**
     * Sets the value of the attendanceYearMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttendanceYears }
     *     
     */
    public void setAttendanceYearMap(AttendanceYearMap<String, AttendanceYearsList> value) {
        this.attendanceYearMap = value;
    }

}
