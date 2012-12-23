//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3354 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.22 at 08:48:37 PM EST 
//


package com.ish.sms.service.dto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ish.sms.service.dto package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _StudentDTO_QNAME = new QName("http://www.ish.com/soa/sms", "studentDTO");
    private final static QName _AssociateDTO_QNAME = new QName("http://www.ish.com/soa/sms", "associateDTO");
    private final static QName _StudentList_QNAME = new QName("http://www.ish.com/soa/sms", "studentList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ish.sms.service.dto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StudentDTO }
     * 
     */
    public StudentDTO createStudentDTO() {
        return new StudentDTO();
    }

    /**
     * Create an instance of {@link AssociateDTO }
     * 
     */
    public AssociateDTO createAssociateDTO() {
        return new AssociateDTO();
    }

    /**
     * Create an instance of {@link StudentList }
     * 
     */
    public StudentList createStudentList() {
        return new StudentList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ish.com/soa/sms", name = "studentDTO")
    public JAXBElement<StudentDTO> createStudentDTO(StudentDTO value) {
        return new JAXBElement<StudentDTO>(_StudentDTO_QNAME, StudentDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssociateDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ish.com/soa/sms", name = "associateDTO")
    public JAXBElement<AssociateDTO> createAssociateDTO(AssociateDTO value) {
        return new JAXBElement<AssociateDTO>(_AssociateDTO_QNAME, AssociateDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ish.com/soa/sms", name = "studentList")
    public JAXBElement<StudentList> createStudentList(StudentList value) {
        return new JAXBElement<StudentList>(_StudentList_QNAME, StudentList.class, null, value);
    }

}
