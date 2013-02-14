package com.ish.sms.service.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;

import com.ish.sms.service.dto.ClassAttendanceDefDTO;
import com.ish.sms.service.dto.ClassAttendanceDefListDTO;
import com.ish.sms.service.dto.ClassDTO;

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
	 * Method to get all the classAttendanceDefintion for a particular class by wrapping them in the ClassAttendanceDefListDTO.
	 * 
	 * @return classAttendanceDefListDTOXML
	 */
	@GET
	@Path("/retrieveClassAttendanceDefList/{classId}")
	@Produces("text/xml")
	public String retrieveClassAttendanceDefList(@PathParam("classId") Integer classId) {

		String classAttendanceDefListDTOXML = null;
		try {
			ClassAttendanceDefListDTO classAttendanceDefListDTO = classOperations.retrieveClassAttendanceDefList(classId);
			classAttendanceDefListDTOXML = serviceTransformer.transformToXML(classAttendanceDefListDTO, "classAttendanceDefListDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classAttendanceDefListDTOXML;
	}


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
	 * Method to create or update a ClassAttendanceDef and return the persisted studentXML.
	 * 
	 * @param studentXml
	 * @return studentXML
	 */
	@POST
	@Path("/saveClassAttendanceDef/")
	@Produces("text/xml")
	@Consumes("text/xml")
	public String saveClassAttendanceDef(String xml) {

		ClassAttendanceDefDTO classAttendanceDefDTO = null;
		String classAttendanceDefDTOXML = null;
		try {
			classAttendanceDefDTO = serviceTransformer.tryParseXml(xml);
			classAttendanceDefDTO = classOperations.createOrUpdateClassAttendanceDef(classAttendanceDefDTO);
			classAttendanceDefDTOXML = serviceTransformer.transformToXML(classAttendanceDefDTO, "classAttendanceDefDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classAttendanceDefDTOXML;
	}	

}
