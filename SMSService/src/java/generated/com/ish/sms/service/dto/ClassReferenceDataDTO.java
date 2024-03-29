//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3354 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.27 at 10:53:37 AM EST 
//


package com.ish.sms.service.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for classReferenceDataDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="classReferenceDataDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="referenceDataDTO" type="{http://www.ish.com/soa/sms}referenceDataDTO"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "classReferenceDataDTO", propOrder = {
    "id",
    "referenceDataDTO"
})
public class ClassReferenceDataDTO
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected Integer id;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected ReferenceDataDTO referenceDataDTO;

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
     * Gets the value of the referenceDataDTO property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataDTO }
     *     
     */
    public ReferenceDataDTO getReferenceDataDTO() {
        return referenceDataDTO;
    }

    /**
     * Sets the value of the referenceDataDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataDTO }
     *     
     */
    public void setReferenceDataDTO(ReferenceDataDTO value) {
        this.referenceDataDTO = value;
    }
    
	public int hashCode() {

		return id.hashCode()  + referenceDataDTO.getName().hashCode();
	}

	public boolean equals(Object object) {
		if (object == null)
			return false;
		ClassReferenceDataDTO otherClassDTO = (ClassReferenceDataDTO) object;
		if (otherClassDTO.getId().equals(this.getId())) {
			return true;
		}
		return false;
	}
    
}
