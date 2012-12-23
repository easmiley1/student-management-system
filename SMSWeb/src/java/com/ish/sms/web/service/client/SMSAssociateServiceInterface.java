package com.ish.sms.web.service.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

public interface SMSAssociateServiceInterface {


	/**
	 * Method to create or update a student and return the persisted studentXML.
	 * 
	 * @param studentXml
	 * @return studentXML
	 */
    @POST
    @Path("/createStudent/")
    @Produces("text/xml")
    @Consumes( "text/xml" )
	public String createStudent(String xml) ;
    
	/**
	 * Method to return the list of all the students in the school.
	 * 
	 * @return studentListXML
	 */
	@POST
	@Path("/retrieveAllStudents/")
	@Produces("text/xml")
	public String retrieveAllStudents() ;

}
