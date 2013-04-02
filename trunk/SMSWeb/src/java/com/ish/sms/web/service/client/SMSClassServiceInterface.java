package com.ish.sms.web.service.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Restful service class to handle all Class related operations.
 * 
 * @author Naren
 * 
 */

public interface SMSClassServiceInterface {

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
	 * Method to create or update a class and return the persisted classXML.
	 * 
	 * @param classXML
	 * @return persistedClassXML
	 */
	@POST
	@Path("/saveClass/")
	@Produces("text/xml")
	@Consumes("text/xml")
	public String saveClass(String xml) ;
	
	/**
	 * Method to return the list of all active classes
	 * 
	 * @return classListXML
	 */
	@POST
	@Path("/retrieveAllClasses/")
	@Produces("text/xml")
	public String retrieveAllClasses();	
}
