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
    @Path("/saveStudent/")
    @Produces("text/xml")
    @Consumes( "text/xml" )
	public String saveStudent(String studentXml) ;

	/**
	 * Method to create or update a teacher and return the persisted teacherXML.
	 * 
	 * @param teacherXML
	 * @return teacherXML
	 */
    @POST
    @Path("/saveTeacher/")
    @Produces("text/xml")
    @Consumes( "text/xml" )
	public String saveTeacher(String teacherXML) ;

	/**
	 * Method to return the list of all the students in the school.
	 * 
	 * @return studentListXML
	 */
	@POST
	@Path("/retrieveAllStudents/")
	@Produces("text/xml")
	public String retrieveAllStudents() ;

	/**
	 * Method to return the list of all the teachers in the school.
	 * 
	 * @return teacherListXML
	 */
	@POST
	@Path("/retrieveAllTeachers/")
	@Produces("text/xml")
	public String retrieveAllTeachers() ;
	
}
