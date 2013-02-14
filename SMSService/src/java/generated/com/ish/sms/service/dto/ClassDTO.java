//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3354 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.14 at 04:12:16 PM EST 
//


package com.ish.sms.service.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for classDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="classDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ish.com/soa/sms}baseReferenceDTO">
 *       &lt;sequence>
 *         &lt;element name="section" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="teacherDTO" type="{http://www.ish.com/soa/sms}teacherDTO" minOccurs="0"/>
 *         &lt;element name="studentCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "classDTO", propOrder = {
    "section",
    "teacherDTO",
    "studentCount"
})
public class ClassDTO
    extends BaseReferenceDTO
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected String section;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected TeacherDTO teacherDTO;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected Integer studentCount;

    /**
     * Gets the value of the section property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSection() {
        return section;
    }

    /**
     * Sets the value of the section property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSection(String value) {
        this.section = value;
    }

    /**
     * Gets the value of the teacherDTO property.
     * 
     * @return
     *     possible object is
     *     {@link TeacherDTO }
     *     
     */
    public TeacherDTO getTeacherDTO() {
        return teacherDTO;
    }

    /**
     * Sets the value of the teacherDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link TeacherDTO }
     *     
     */
    public void setTeacherDTO(TeacherDTO value) {
        this.teacherDTO = value;
    }

    /**
     * Gets the value of the studentCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStudentCount() {
        return studentCount;
    }

    /**
     * Sets the value of the studentCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStudentCount(Integer value) {
        this.studentCount = value;
    }

}
