//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3354 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.31 at 07:06:09 PM EST 
//


package com.ish.sms.service.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stateDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stateDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ish.com/soa/sms}baseReferenceDTO">
 *       &lt;sequence>
 *         &lt;element name="abbrevation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stateDTO", propOrder = {
    "abbrevation"
})
public class StateDTO
    extends BaseReferenceDTO
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://www.ish.com/soa/sms")
    protected String abbrevation;

    /**
     * Gets the value of the abbrevation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbbrevation() {
        return abbrevation;
    }

    /**
     * Sets the value of the abbrevation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbbrevation(String value) {
        this.abbrevation = value;
    }

}
