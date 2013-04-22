//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3354 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.22 at 12:41:09 PM EDT 
//


package com.ish.sms.service.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.ish.sms.web.service.dto.GradeDetailsMap;


/**
 * <p>Java class for studentGradeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="studentGradeDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="studentDTO" type="{http://www.ish.com/soa/sms}studentDTO"/>
 *         &lt;element name="gradeDetailsMap" type="{http://www.ish.com/soa/sms}gradeDetails" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "studentGradeDTO", propOrder = {
    "studentDTO",
    "gradeDetailsMap"
})
public class StudentGradeDTO
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected StudentDTO studentDTO;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", type = GradeDetails.class)
    protected GradeDetailsMap<ClassSubjectReferenceDataDTO, GradeDetailsDTO> gradeDetailsMap;

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
     * Gets the value of the gradeDetailsMap property.
     * 
     * @return
     *     possible object is
     *     {@link GradeDetails }
     *     
     */
    public GradeDetailsMap<ClassSubjectReferenceDataDTO, GradeDetailsDTO> getGradeDetailsMap() {
        return gradeDetailsMap;
    }

    /**
     * Sets the value of the gradeDetailsMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link GradeDetails }
     *     
     */
    public void setGradeDetailsMap(GradeDetailsMap<ClassSubjectReferenceDataDTO, GradeDetailsDTO> value) {
        this.gradeDetailsMap = value;
    }
	public int hashCode() {

		return studentDTO.getId().hashCode()  + studentDTO.getFirstName().hashCode() + studentDTO.getFatherName().hashCode();
	}

	public boolean equals(Object object) {
		if (object == null)
			return false;
		StudentGradeDTO studentGradeDTO = (StudentGradeDTO) object;
		if (studentGradeDTO.getStudentDTO().getId().equals(this.getStudentDTO().getId())) {
			return true;
		}
		return false;
	}

}
