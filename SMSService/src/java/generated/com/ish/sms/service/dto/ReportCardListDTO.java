//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3354 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.23 at 12:40:33 PM EDT 
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
 * <p>Java class for reportCardListDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reportCardListDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reportCardDTOList" type="{http://www.ish.com/soa/sms}reportCardDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="classStudentDTO" type="{http://www.ish.com/soa/sms}classStudentDTO"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reportCardListDTO", propOrder = {
    "reportCardDTOList",
    "classStudentDTO"
})
public class ReportCardListDTO
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected List<ReportCardDTO> reportCardDTOList;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected ClassStudentDTO classStudentDTO;

    /**
     * Gets the value of the reportCardDTOList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reportCardDTOList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReportCardDTOList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReportCardDTO }
     * 
     * 
     */
    public List<ReportCardDTO> getReportCardDTOList() {
        if (reportCardDTOList == null) {
            reportCardDTOList = new ArrayList<ReportCardDTO>();
        }
        return this.reportCardDTOList;
    }

    /**
     * Gets the value of the classStudentDTO property.
     * 
     * @return
     *     possible object is
     *     {@link ClassStudentDTO }
     *     
     */
    public ClassStudentDTO getClassStudentDTO() {
        return classStudentDTO;
    }

    /**
     * Sets the value of the classStudentDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassStudentDTO }
     *     
     */
    public void setClassStudentDTO(ClassStudentDTO value) {
        this.classStudentDTO = value;
    }

    /**
     * Sets the value of the reportCardDTOList property.
     * 
     * @param reportCardDTOList
     *     allowed object is
     *     {@link ReportCardDTO }
     *     
     */
    public void setReportCardDTOList(List<ReportCardDTO> reportCardDTOList) {
        this.reportCardDTOList = reportCardDTOList;
    }

}
