package com.ish.sms.service.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassListDTO;

/**
 * Restful service class to handle all Class related operations.
 * 
 * @author Naren
 * 
 */
@Service
@Path("/smsClassService")
public class SMSClassService extends SMSBaseService {

	/**
	 * Method to get the Class Entity for the given classid.
	 * 
	 * @return classAttendanceDefListDTOXML
	 */
	@GET
	@Path("/retrieveClassForId/{classId}")
	@Produces("text/xml")
	public String retrieveClassForId(@PathParam("classId") Integer classId) {

		String classDTOXML = null;
		try {
			ClassDTO classDTO = classOperations.retrieveClassForId(classId);
			classDTOXML = serviceTransformer.transformToXML(classDTO, "classDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classDTOXML;
	}
	
	/**
	 * Method to create or update a class and return the persisted classXML.
	 * 
	 * @param classXML
	 * @return persistedClassXML
	 */
	@POST
	@Path("/saveClass/")
	@Produces("text/xml")
	@Consumes("text/xml")
	public String saveClass(String xml) {

		ClassDTO classDTO = null;
		String classXML = null;
		try {
			classDTO = serviceTransformer.tryParseXml(xml);
			classDTO = classOperations.saveClassDetails(classDTO);
			classXML = serviceTransformer.transformToXML(classDTO, "classDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classXML;
	}
	
	/**
	 * Method to return the list of all active classes
	 * 
	 * @return classListXML
	 */
	@POST
	@Path("/retrieveAllClasses/")
	@Produces("text/xml")
	public String retrieveAllClasses() {

		String classListXML = null;
		try {
			ClassListDTO classListDTO = classOperations.retrieveAllClasses();
			classListXML = serviceTransformer.transformToXML(classListDTO, "classListDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classListXML;
	}	
}
