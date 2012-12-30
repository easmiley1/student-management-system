//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3354 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.29 at 11:18:43 PM EST 
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
 * <p>Java class for referenceListDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="referenceListDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stateDTOList" type="{http://www.ish.com/soa/sms}stateDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="extraCurricularDTOList" type="{http://www.ish.com/soa/sms}extraCurricularDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bloodGroupDTOList" type="{http://www.ish.com/soa/sms}bloodGroupDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="modeofTransportDTOList" type="{http://www.ish.com/soa/sms}modeofTransportDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="classDTOList" type="{http://www.ish.com/soa/sms}classDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "referenceListDTO", propOrder = {
    "stateDTOList",
    "extraCurricularDTOList",
    "bloodGroupDTOList",
    "modeofTransportDTOList",
    "classDTOList"
})
public class ReferenceListDTO
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected List<StateDTO> stateDTOList;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected List<ExtraCurricularDTO> extraCurricularDTOList;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected List<BloodGroupDTO> bloodGroupDTOList;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected List<ModeofTransportDTO> modeofTransportDTOList;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected List<ClassDTO> classDTOList;

    /**
     * Gets the value of the stateDTOList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stateDTOList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStateDTOList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StateDTO }
     * 
     * 
     */
    public List<StateDTO> getStateDTOList() {
        if (stateDTOList == null) {
            stateDTOList = new ArrayList<StateDTO>();
        }
        return this.stateDTOList;
    }

    /**
     * Gets the value of the extraCurricularDTOList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extraCurricularDTOList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtraCurricularDTOList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtraCurricularDTO }
     * 
     * 
     */
    public List<ExtraCurricularDTO> getExtraCurricularDTOList() {
        if (extraCurricularDTOList == null) {
            extraCurricularDTOList = new ArrayList<ExtraCurricularDTO>();
        }
        return this.extraCurricularDTOList;
    }

    /**
     * Gets the value of the bloodGroupDTOList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bloodGroupDTOList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBloodGroupDTOList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BloodGroupDTO }
     * 
     * 
     */
    public List<BloodGroupDTO> getBloodGroupDTOList() {
        if (bloodGroupDTOList == null) {
            bloodGroupDTOList = new ArrayList<BloodGroupDTO>();
        }
        return this.bloodGroupDTOList;
    }

    /**
     * Gets the value of the modeofTransportDTOList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modeofTransportDTOList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModeofTransportDTOList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModeofTransportDTO }
     * 
     * 
     */
    public List<ModeofTransportDTO> getModeofTransportDTOList() {
        if (modeofTransportDTOList == null) {
            modeofTransportDTOList = new ArrayList<ModeofTransportDTO>();
        }
        return this.modeofTransportDTOList;
    }

    /**
     * Gets the value of the classDTOList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classDTOList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassDTOList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClassDTO }
     * 
     * 
     */
    public List<ClassDTO> getClassDTOList() {
        if (classDTOList == null) {
            classDTOList = new ArrayList<ClassDTO>();
        }
        return this.classDTOList;
    }

    /**
     * Sets the value of the stateDTOList property.
     * 
     * @param stateDTOList
     *     allowed object is
     *     {@link StateDTO }
     *     
     */
    public void setStateDTOList(List<StateDTO> stateDTOList) {
        this.stateDTOList = stateDTOList;
    }

    /**
     * Sets the value of the extraCurricularDTOList property.
     * 
     * @param extraCurricularDTOList
     *     allowed object is
     *     {@link ExtraCurricularDTO }
     *     
     */
    public void setExtraCurricularDTOList(List<ExtraCurricularDTO> extraCurricularDTOList) {
        this.extraCurricularDTOList = extraCurricularDTOList;
    }

    /**
     * Sets the value of the bloodGroupDTOList property.
     * 
     * @param bloodGroupDTOList
     *     allowed object is
     *     {@link BloodGroupDTO }
     *     
     */
    public void setBloodGroupDTOList(List<BloodGroupDTO> bloodGroupDTOList) {
        this.bloodGroupDTOList = bloodGroupDTOList;
    }

    /**
     * Sets the value of the modeofTransportDTOList property.
     * 
     * @param modeofTransportDTOList
     *     allowed object is
     *     {@link ModeofTransportDTO }
     *     
     */
    public void setModeofTransportDTOList(List<ModeofTransportDTO> modeofTransportDTOList) {
        this.modeofTransportDTOList = modeofTransportDTOList;
    }

    /**
     * Sets the value of the classDTOList property.
     * 
     * @param classDTOList
     *     allowed object is
     *     {@link ClassDTO }
     *     
     */
    public void setClassDTOList(List<ClassDTO> classDTOList) {
        this.classDTOList = classDTOList;
    }

}