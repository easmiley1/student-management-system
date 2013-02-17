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
import com.ish.sms.web.service.dto.AttendanceMap;


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
 *         &lt;element name="attendanceMap" type="{http://www.ish.com/soa/sms}attendances" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "attendanceMap",
    "name"
})
public class AssociateAttendanceDTO
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", type = Attendances.class)
    protected AttendanceMap<String, Boolean> attendanceMap;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected java.lang.String name;

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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setName(java.lang.String value) {
        this.name = value;
    }

}
