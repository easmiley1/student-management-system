//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3354 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.17 at 10:04:56 PM EST 
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
 * <p>Java class for associateAttendanceListDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="associateAttendanceListDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="associateAttendanceListDTO" type="{http://www.ish.com/soa/sms}associateAttendanceDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "associateAttendanceListDTO", propOrder = {
    "associateAttendanceListDTO"
})
public class AssociateAttendanceListDTO
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected List<AssociateAttendanceDTO> associateAttendanceListDTO;

    /**
     * Gets the value of the associateAttendanceListDTO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the associateAttendanceListDTO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssociateAttendanceListDTO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AssociateAttendanceDTO }
     * 
     * 
     */
    public List<AssociateAttendanceDTO> getAssociateAttendanceListDTO() {
        if (associateAttendanceListDTO == null) {
            associateAttendanceListDTO = new ArrayList<AssociateAttendanceDTO>();
        }
        return this.associateAttendanceListDTO;
    }

    /**
     * Sets the value of the associateAttendanceListDTO property.
     * 
     * @param associateAttendanceListDTO
     *     allowed object is
     *     {@link AssociateAttendanceDTO }
     *     
     */
    public void setAssociateAttendanceListDTO(List<AssociateAttendanceDTO> associateAttendanceListDTO) {
        this.associateAttendanceListDTO = associateAttendanceListDTO;
    }

}
