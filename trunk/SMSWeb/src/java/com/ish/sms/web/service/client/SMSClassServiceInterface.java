package com.ish.sms.web.service.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Restful service class to handle all Reference data related operations.
 * 
 * @author Naren
 * 
 */
public interface SMSClassServiceInterface {

	/**
	 * Method to get all the classAttendanceDefintion for a particular class by wrapping them in the ClassAttendanceDefListDTO.
	 * 
	 * @return classAttendanceDefListDTOXML
	 */
	@GET
	@Path("/retrieveClassAttendanceDefList/{classId}")
	@Produces("text/xml")
	public String retrieveClassAttendanceDefList(@PathParam("classId") Integer classId);

	/**
	 * Method to get the Class Entity for the given classid.
	 * 
	 * @return classAttendanceDefListDTOXML
	 */
	@GET
	@Path("/retrieveClassForId/{classId}")
	@Produces("text/xml")
	public String retrieveClassForId(@PathParam("classId") Integer classId);

	/**
	 * Method to remove or delete the given ClassAttendanceDefDTO List and return the updated one wrapped in classAttendanceDefListDTO
	 * 
	 * @return classAttendanceDefListDTOXML
	 */
	@POST
	@Path("/updateClassAttendanceDefList/")
	@Produces("text/xml")
	@Consumes("text/xml")
	public String updateClassAttendanceDefList(String classAttendanceDefListDTOXML);

	/**
	 * Method to return the class attendance data for the specified month
	 * 
	 * @return associateAttendanceListDTOXML
	 */
	@GET
	@Path("/retrieveClassAttendanceForMonth/{monthId}")
	@Produces("text/xml")
	public String retrieveClassAttendanceForMonth(@PathParam("monthId") Integer monthId);

	/**
	 * Method to persist all the students in the attendance month
	 * 
	 * @return associateAttendanceListDTOXML
	 */
	@POST
	@Path("/updateAssociateAttendanceList/")
	@Produces("text/xml")
	@Consumes("text/xml")
	public String updateAssociateAttendanceList(String associateAttendanceListDTOXML);

}
