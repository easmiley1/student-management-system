//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3354 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.21 at 09:30:21 PM EST 
//


package com.ish.sms.service.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for classAttendanceDefDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="classAttendanceDefDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="monthYear" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="classDTO" type="{http://www.ish.com/soa/sms}classDTO" minOccurs="0"/>
 *         &lt;element name="modification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "classAttendanceDefDTO", propOrder = {
    "id",
    "monthYear",
    "classDTO",
    "modification"
})
public class ClassAttendanceDefDTO
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected Integer id;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected String monthYear;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected ClassDTO classDTO;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected String modification;

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
     * Gets the value of the monthYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonthYear() {
        return monthYear;
    }

    /**
     * Sets the value of the monthYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonthYear(String value) {
        this.monthYear = value;
    }

    /**
     * Gets the value of the classDTO property.
     * 
     * @return
     *     possible object is
     *     {@link ClassDTO }
     *     
     */
    public ClassDTO getClassDTO() {
        return classDTO;
    }

    /**
     * Sets the value of the classDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassDTO }
     *     
     */
    public void setClassDTO(ClassDTO value) {
        this.classDTO = value;
    }

    /**
     * Gets the value of the modification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModification() {
        return modification;
    }

    /**
     * Sets the value of the modification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModification(String value) {
        this.modification = value;
    }

}
