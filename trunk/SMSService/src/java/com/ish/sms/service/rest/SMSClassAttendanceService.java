package com.ish.sms.service.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;

import com.ish.sms.service.dto.AssociateAttendanceListDTO;
import com.ish.sms.service.dto.ClassAttendanceDefListDTO;

/**
 * Restful service class to handle all Class Attendance related operations.
 * 
 * @author Naren
 * 
 */
@Service
@Path("/smsClassAttendanceService")
public class SMSClassAttendanceService extends SMSBaseService {

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
			ClassAttendanceDefListDTO classAttendanceDefListDTO = classAttendanceOperations.retrieveClassAttendanceDefList(classId);
			classAttendanceDefListDTOXML = serviceTransformer.transformToXML(classAttendanceDefListDTO, "classAttendanceDefListDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classAttendanceDefListDTOXML;
	}

	/**
	 * Method to remove or delete the given ClassAttendanceDefDTO List and return the updated one wrapped in classAttendanceDefListDTO
	 * 
	 * @return classAttendanceDefListDTOXML
	 */
	@POST
	@Path("/updateClassAttendanceDefList/")
	@Produces("text/xml")
	@Consumes("text/xml")
	public String updateClassAttendanceDefList(String classAttendanceDefListDTOXML) {

		ClassAttendanceDefListDTO classAttendanceDefListDTO = null;
		try {
			classAttendanceDefListDTO = serviceTransformer.tryParseXml(classAttendanceDefListDTOXML);
			classAttendanceDefListDTO = classAttendanceOperations.updateClassAttendanceDefList(classAttendanceDefListDTO);
			classAttendanceDefListDTOXML = serviceTransformer.transformToXML(classAttendanceDefListDTO, "classAttendanceDefListDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classAttendanceDefListDTOXML;
	}


	/**
	 * Method to return the class attendance data for the specified month
	 * 
	 * @return associateAttendanceListDTOXML
	 */
	@GET
	@Path("/retrieveClassAttendanceForMonth/{monthId}")
	@Produces("text/xml")
	public String retrieveClassAttendanceForMonth(@PathParam("monthId") Integer monthId) {

		String associateAttendanceListDTOXML = null;
		try {
			AssociateAttendanceListDTO associateAttendanceListDTO = classAttendanceOperations.retrieveClassAttendanceForMonth(monthId);
			associateAttendanceListDTOXML = serviceTransformer.transformToXML(associateAttendanceListDTO, "associateAttendanceListDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return associateAttendanceListDTOXML;
	}

	/**
	 * Method to persist all the students in the attendance month
	 * 
	 * @return associateAttendanceListDTOXML
	 */
	@POST
	@Path("/updateAssociateAttendanceList/")
	@Produces("text/xml")
	@Consumes("text/xml")
	public String updateAssociateAttendanceList(String associateAttendanceListDTOXML) {

		AssociateAttendanceListDTO associateAttendanceListDTO = null;
		try {
			associateAttendanceListDTO = serviceTransformer.tryParseXml(associateAttendanceListDTOXML);
			associateAttendanceListDTO = classAttendanceOperations.updateAssociateAttendanceList(associateAttendanceListDTO);
			associateAttendanceListDTOXML = serviceTransformer.transformToXML(associateAttendanceListDTO, "associateAttendanceListDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return associateAttendanceListDTOXML;
	}

	
}
