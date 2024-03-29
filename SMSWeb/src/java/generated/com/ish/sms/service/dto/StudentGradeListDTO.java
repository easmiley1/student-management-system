//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3354 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.22 at 12:41:09 PM EDT 
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
 * <p>Java class for studentGradeListDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="studentGradeListDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="studentGradeDTOList" type="{http://www.ish.com/soa/sms}studentGradeDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "studentGradeListDTO", propOrder = {
    "studentGradeDTOList"
})
public class StudentGradeListDTO
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected List<StudentGradeDTO> studentGradeDTOList;

    /**
     * Gets the value of the studentGradeDTOList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the studentGradeDTOList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStudentGradeDTOList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StudentGradeDTO }
     * 
     * 
     */
    public List<StudentGradeDTO> getStudentGradeDTOList() {
        if (studentGradeDTOList == null) {
            studentGradeDTOList = new ArrayList<StudentGradeDTO>();
        }
        return this.studentGradeDTOList;
    }

    /**
     * Sets the value of the studentGradeDTOList property.
     * 
     * @param studentGradeDTOList
     *     allowed object is
     *     {@link StudentGradeDTO }
     *     
     */
    public void setStudentGradeDTOList(List<StudentGradeDTO> studentGradeDTOList) {
        this.studentGradeDTOList = studentGradeDTOList;
    }

}
