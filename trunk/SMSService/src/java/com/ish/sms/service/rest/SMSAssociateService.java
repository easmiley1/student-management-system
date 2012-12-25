package com.ish.sms.service.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.service.dto.StudentListDTO;
import com.ish.sms.service.ops.AssociateOperations;
import com.ish.sms.service.util.ServiceTransformer;

/**
 * Restful service class to handle all Associate related operations.
 * 
 * @author Naren
 * 
 */
@Service
@Path("/smsAssociateService")
public class SMSAssociateService {

	@Autowired
	private ServiceTransformer serviceTransformer;

	@Autowired
	private AssociateOperations associateOperations;

	/**
	 * Method to create or update a student and return the persisted studentXML.
	 * 
	 * @param studentXml
	 * @return studentXML
	 */
	@POST
	@Path("/createStudent/")
	@Produces("text/xml")
	@Consumes("text/xml")
	public String createStudent(String xml) {

		StudentDTO studentDTO = null;
		String studentXML = null;
		try {
			studentDTO = serviceTransformer.tryParseXml(xml);
			studentDTO = associateOperations.createOrUpdateStudent(studentDTO);
			studentXML = serviceTransformer.transformToXML(studentDTO, "studentDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentXML;
	}

	/**
	 * Method to return the list of all the students in the school.
	 * 
	 * @return studentListXML
	 */
	@POST
	@Path("/retrieveAllStudents/")
	@Produces("text/xml")
	public String retrieveAllStudents() {

		String studentListXML = null;
		try {
			StudentListDTO studentList = associateOperations.retrieveAllStudents();
			studentListXML = serviceTransformer.transformToXML(studentList, "studentListDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentListXML;
	}
}
