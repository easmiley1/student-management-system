//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3354 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.17 at 10:04:49 PM EST 
//


package com.ish.sms.service.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for studentDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="studentDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ish.com/soa/sms}associateDTO">
 *       &lt;sequence>
 *         &lt;element name="joiningClassDTO" type="{http://www.ish.com/soa/sms}classDTO"/>
 *         &lt;element name="currentClassDTO" type="{http://www.ish.com/soa/sms}classDTO"/>
 *         &lt;element name="extraCurricularInterestDTO" type="{http://www.ish.com/soa/sms}extraCurricularDTO"/>
 *         &lt;element name="modeofTransportDTO" type="{http://www.ish.com/soa/sms}modeofTransportDTO"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "studentDTO", propOrder = {
    "joiningClassDTO",
    "currentClassDTO",
    "extraCurricularInterestDTO",
    "modeofTransportDTO"
})
public class StudentDTO
    extends AssociateDTO
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected ClassDTO joiningClassDTO;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected ClassDTO currentClassDTO;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected ExtraCurricularDTO extraCurricularInterestDTO;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected ModeofTransportDTO modeofTransportDTO;

    /**
     * Gets the value of the joiningClassDTO property.
     * 
     * @return
     *     possible object is
     *     {@link ClassDTO }
     *     
     */
    public ClassDTO getJoiningClassDTO() {
        return joiningClassDTO;
    }

    /**
     * Sets the value of the joiningClassDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassDTO }
     *     
     */
    public void setJoiningClassDTO(ClassDTO value) {
        this.joiningClassDTO = value;
    }

    /**
     * Gets the value of the currentClassDTO property.
     * 
     * @return
     *     possible object is
     *     {@link ClassDTO }
     *     
     */
    public ClassDTO getCurrentClassDTO() {
        return currentClassDTO;
    }

    /**
     * Sets the value of the currentClassDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassDTO }
     *     
     */
    public void setCurrentClassDTO(ClassDTO value) {
        this.currentClassDTO = value;
    }

    /**
     * Gets the value of the extraCurricularInterestDTO property.
     * 
     * @return
     *     possible object is
     *     {@link ExtraCurricularDTO }
     *     
     */
    public ExtraCurricularDTO getExtraCurricularInterestDTO() {
        return extraCurricularInterestDTO;
    }

    /**
     * Sets the value of the extraCurricularInterestDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtraCurricularDTO }
     *     
     */
    public void setExtraCurricularInterestDTO(ExtraCurricularDTO value) {
        this.extraCurricularInterestDTO = value;
    }

    /**
     * Gets the value of the modeofTransportDTO property.
     * 
     * @return
     *     possible object is
     *     {@link ModeofTransportDTO }
     *     
     */
    public ModeofTransportDTO getModeofTransportDTO() {
        return modeofTransportDTO;
    }

    /**
     * Sets the value of the modeofTransportDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModeofTransportDTO }
     *     
     */
    public void setModeofTransportDTO(ModeofTransportDTO value) {
        this.modeofTransportDTO = value;
    }

}
