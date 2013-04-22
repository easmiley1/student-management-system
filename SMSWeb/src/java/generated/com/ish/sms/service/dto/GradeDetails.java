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
import com.ish.sms.service.dto.GradeDetails.Entry;


/**
 * <p>Java class for gradeDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="gradeDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="entry" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="key" type="{http://www.ish.com/soa/sms}classSubjectReferenceDataDTO"/>
 *                   &lt;element name="value" type="{http://www.ish.com/soa/sms}gradeDetailsDTO"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gradeDetails", propOrder = {
    "entry"
})
public class GradeDetails
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
    protected List<Entry> entry;

    /**
     * Gets the value of the entry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Entry }
     * 
     * 
     */
    public List<Entry> getEntry() {
        if (entry == null) {
            entry = new ArrayList<Entry>();
        }
        return this.entry;
    }

    /**
     * Sets the value of the entry property.
     * 
     * @param entry
     *     allowed object is
     *     {@link Entry }
     *     
     */
    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="key" type="{http://www.ish.com/soa/sms}classSubjectReferenceDataDTO"/>
     *         &lt;element name="value" type="{http://www.ish.com/soa/sms}gradeDetailsDTO"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "key",
        "value"
    })
    public static class Entry
        implements Serializable
    {

        private final static long serialVersionUID = 1L;
        @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
        protected ClassSubjectReferenceDataDTO key;
        @XmlElement(namespace = "http://www.ish.com/soa/sms", required = true)
        protected GradeDetailsDTO value;

        /**
         * Gets the value of the key property.
         * 
         * @return
         *     possible object is
         *     {@link ClassSubjectReferenceDataDTO }
         *     
         */
        public ClassSubjectReferenceDataDTO getKey() {
            return key;
        }

        /**
         * Sets the value of the key property.
         * 
         * @param value
         *     allowed object is
         *     {@link ClassSubjectReferenceDataDTO }
         *     
         */
        public void setKey(ClassSubjectReferenceDataDTO value) {
            this.key = value;
        }

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link GradeDetailsDTO }
         *     
         */
        public GradeDetailsDTO getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link GradeDetailsDTO }
         *     
         */
        public void setValue(GradeDetailsDTO value) {
            this.value = value;
        }

    }

}
