//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3354 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.21 at 07:36:10 PM EST 
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
 *         &lt;element name="stateDTOList" type="{http://www.ish.com/soa/sms}referenceDataDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="extraCurricularDTOList" type="{http://www.ish.com/soa/sms}referenceDataDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bloodGroupDTOList" type="{http://www.ish.com/soa/sms}referenceDataDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="modeofTransportDTOList" type="{http://www.ish.com/soa/sms}referenceDataDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="classDTOList" type="{http://www.ish.com/soa/sms}classDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subjectDTOList" type="{http://www.ish.com/soa/sms}referenceDataDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="teacherDTOList" type="{http://www.ish.com/soa/sms}teacherDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dayOfWeekDTOList" type="{http://www.ish.com/soa/sms}referenceDataDTO" maxOccurs="unbounded" minOccurs="0"/>
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
    "classDTOList",
    "subjectDTOList",
    "teacherDTOList",
    "dayOfWeekDTOList"
})
public class ReferenceListDTO
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected List<ReferenceDataDTO> stateDTOList;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected List<ReferenceDataDTO> extraCurricularDTOList;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected List<ReferenceDataDTO> bloodGroupDTOList;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected List<ReferenceDataDTO> modeofTransportDTOList;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected List<ClassDTO> classDTOList;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected List<ReferenceDataDTO> subjectDTOList;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected List<TeacherDTO> teacherDTOList;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected List<ReferenceDataDTO> dayOfWeekDTOList;

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
     * {@link ReferenceDataDTO }
     * 
     * 
     */
    public List<ReferenceDataDTO> getStateDTOList() {
        if (stateDTOList == null) {
            stateDTOList = new ArrayList<ReferenceDataDTO>();
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
     * {@link ReferenceDataDTO }
     * 
     * 
     */
    public List<ReferenceDataDTO> getExtraCurricularDTOList() {
        if (extraCurricularDTOList == null) {
            extraCurricularDTOList = new ArrayList<ReferenceDataDTO>();
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
     * {@link ReferenceDataDTO }
     * 
     * 
     */
    public List<ReferenceDataDTO> getBloodGroupDTOList() {
        if (bloodGroupDTOList == null) {
            bloodGroupDTOList = new ArrayList<ReferenceDataDTO>();
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
     * {@link ReferenceDataDTO }
     * 
     * 
     */
    public List<ReferenceDataDTO> getModeofTransportDTOList() {
        if (modeofTransportDTOList == null) {
            modeofTransportDTOList = new ArrayList<ReferenceDataDTO>();
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
     * Gets the value of the subjectDTOList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subjectDTOList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubjectDTOList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceDataDTO }
     * 
     * 
     */
    public List<ReferenceDataDTO> getSubjectDTOList() {
        if (subjectDTOList == null) {
            subjectDTOList = new ArrayList<ReferenceDataDTO>();
        }
        return this.subjectDTOList;
    }

    /**
     * Gets the value of the teacherDTOList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the teacherDTOList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTeacherDTOList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TeacherDTO }
     * 
     * 
     */
    public List<TeacherDTO> getTeacherDTOList() {
        if (teacherDTOList == null) {
            teacherDTOList = new ArrayList<TeacherDTO>();
        }
        return this.teacherDTOList;
    }

    /**
     * Gets the value of the dayOfWeekDTOList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dayOfWeekDTOList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDayOfWeekDTOList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceDataDTO }
     * 
     * 
     */
    public List<ReferenceDataDTO> getDayOfWeekDTOList() {
        if (dayOfWeekDTOList == null) {
            dayOfWeekDTOList = new ArrayList<ReferenceDataDTO>();
        }
        return this.dayOfWeekDTOList;
    }

    /**
     * Sets the value of the stateDTOList property.
     * 
     * @param stateDTOList
     *     allowed object is
     *     {@link ReferenceDataDTO }
     *     
     */
    public void setStateDTOList(List<ReferenceDataDTO> stateDTOList) {
        this.stateDTOList = stateDTOList;
    }

    /**
     * Sets the value of the extraCurricularDTOList property.
     * 
     * @param extraCurricularDTOList
     *     allowed object is
     *     {@link ReferenceDataDTO }
     *     
     */
    public void setExtraCurricularDTOList(List<ReferenceDataDTO> extraCurricularDTOList) {
        this.extraCurricularDTOList = extraCurricularDTOList;
    }

    /**
     * Sets the value of the bloodGroupDTOList property.
     * 
     * @param bloodGroupDTOList
     *     allowed object is
     *     {@link ReferenceDataDTO }
     *     
     */
    public void setBloodGroupDTOList(List<ReferenceDataDTO> bloodGroupDTOList) {
        this.bloodGroupDTOList = bloodGroupDTOList;
    }

    /**
     * Sets the value of the modeofTransportDTOList property.
     * 
     * @param modeofTransportDTOList
     *     allowed object is
     *     {@link ReferenceDataDTO }
     *     
     */
    public void setModeofTransportDTOList(List<ReferenceDataDTO> modeofTransportDTOList) {
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

    /**
     * Sets the value of the subjectDTOList property.
     * 
     * @param subjectDTOList
     *     allowed object is
     *     {@link ReferenceDataDTO }
     *     
     */
    public void setSubjectDTOList(List<ReferenceDataDTO> subjectDTOList) {
        this.subjectDTOList = subjectDTOList;
    }

    /**
     * Sets the value of the teacherDTOList property.
     * 
     * @param teacherDTOList
     *     allowed object is
     *     {@link TeacherDTO }
     *     
     */
    public void setTeacherDTOList(List<TeacherDTO> teacherDTOList) {
        this.teacherDTOList = teacherDTOList;
    }

    /**
     * Sets the value of the dayOfWeekDTOList property.
     * 
     * @param dayOfWeekDTOList
     *     allowed object is
     *     {@link ReferenceDataDTO }
     *     
     */
    public void setDayOfWeekDTOList(List<ReferenceDataDTO> dayOfWeekDTOList) {
        this.dayOfWeekDTOList = dayOfWeekDTOList;
    }

}
