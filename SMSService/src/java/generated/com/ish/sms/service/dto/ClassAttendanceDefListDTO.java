//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3354 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.23 at 03:46:21 PM EST 
//


package com.ish.sms.service.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for classAttendanceDefListDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="classAttendanceDefListDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="classAttendanceDefDTOList" type="{http://www.ish.com/soa/sms}classAttendanceDefDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "classAttendanceDefListDTO", propOrder = {
    "classAttendanceDefDTOList"
})
public class ClassAttendanceDefListDTO
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected List<ClassAttendanceDefDTO> classAttendanceDefDTOList;

    /**
     * Gets the value of the classAttendanceDefDTOList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classAttendanceDefDTOList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassAttendanceDefDTOList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClassAttendanceDefDTO }
     * 
     * 
     */
    public List<ClassAttendanceDefDTO> getClassAttendanceDefDTOList() {
        if (classAttendanceDefDTOList == null) {
            classAttendanceDefDTOList = new ArrayList<ClassAttendanceDefDTO>();
        }
        return this.classAttendanceDefDTOList;
    }

    /**
     * Sets the value of the classAttendanceDefDTOList property.
     * 
     * @param classAttendanceDefDTOList
     *     allowed object is
     *     {@link ClassAttendanceDefDTO }
     *     
     */
    public void setClassAttendanceDefDTOList(List<ClassAttendanceDefDTO> classAttendanceDefDTOList) {
        this.classAttendanceDefDTOList = classAttendanceDefDTOList;
    }

}
