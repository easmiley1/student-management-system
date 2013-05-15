package com.ish.sms.web.service.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Restful service class to handle all Report related operations.
 * 
 * @author Naren
 * 
 */

public interface SMSReportServiceInterface  {

	/**
	 * Method to retrieve the student attendance details for current year.
	 * 
	 * @return classAttendanceDefListDTOXML
	 */
	@GET
	@Path("/retrieveStudentAttendanceReport/{classId}/{studentId}")
	@Produces("text/xml")
	public String retrieveStudentAttendanceReport(@PathParam("classId") Integer classId, @PathParam("studentId") Integer studentId) ;
}
