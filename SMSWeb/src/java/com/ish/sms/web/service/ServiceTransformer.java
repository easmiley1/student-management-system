package com.ish.sms.web.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.springframework.stereotype.Component;

/**
 * Service class to transform xml to DTO and vice-versa.
 * 
 * @author Naren
 *
 */
@Component
public class ServiceTransformer {

	private Schema schema;

	public ServiceTransformer() {

		try {
			InputStream inptstream = Thread.currentThread().getContextClassLoader().getResourceAsStream("SMSService.xsd");
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			if (inptstream != null) {
				schema = sf.newSchema(new StreamSource(inptstream));
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param xml
	 * @return DTO
	 * @throws JAXBException
	 */
	@SuppressWarnings("unchecked")
	public <T> T parseXml(final String xml) throws JAXBException {

		return (T) transformToDto(xml, "com.ish.sms.service.dto");
	} 

	/**
	 * @param xml
	 * @param instanceName
	 * @return DTO
	 * @throws JAXBException
	 */
	@SuppressWarnings("unchecked")
	public <E> E transformToDto(String xml, String instanceName) throws JAXBException {

		JAXBContext jc = JAXBContext.newInstance(instanceName);
		Unmarshaller m = jc.createUnmarshaller();
		m.setSchema(schema);
		JAXBElement<E> msg = (JAXBElement<E>) m.unmarshal(new StreamSource(new StringReader(xml)));
		return msg.getValue();
	}
	
    /**
     * @param type
     * @param qNameLocal
     * @return DTO
     * @throws JAXBException
     */
    public <T> String transformToXML(T type, String qNameLocal) throws JAXBException {
    	return transformToXML(type, "com.ish.sms.service.dto", "http://www.ish.com/soa/sms", qNameLocal);
    }	
	
	/**
	 * 
	 * Method to convert a DTO object to XML String
	 * 
	 * @param type is the object to be marshalled
	 * @param namespaceUrl is the Name space url
	 * @param qnameLocalPart is the QName of DTO
	 * @return a XML String
	 * @throws JAXBException - thrown during XML Parsing
	 */    
	@SuppressWarnings("unchecked")
	public <T> String transformToXML(T type, String instanceName, String namespaceUrl, String qnameLocalPart) throws JAXBException {
		
		JAXBContext jc = JAXBContext.newInstance(instanceName);
        QName qname = new QName(namespaceUrl, qnameLocalPart);
        JAXBElement<T> jaxbElement = new JAXBElement<T>(qname, (Class<T>) type.getClass(), type);
        Marshaller m = jc.createMarshaller();
        m.setSchema(schema);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        m.marshal(jaxbElement, baos);
        return baos.toString();
	}

}
