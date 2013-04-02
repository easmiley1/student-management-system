package com.ish.sms.web.service.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface SMSAssociateServiceInterface {

	/**
	 * Method to create or update a student and return the persisted studentXML.
	 * 
	 * @param studentXml
	 * @return studentXML
	 */
	@POST
	@Path("/saveStudent/")
	@Produces(MediaType.TEXT_XML)
	@Consumes(MediaType.TEXT_XML)
	public String saveStudent(String studentXml);

	/**
	 * Method to create or update a teacher and return the persisted teacherXML.
	 * 
	 * @param teacherXML
	 * @return teacherXML
	 */
	@POST
	@Path("/saveTeacher/")
	@Produces(MediaType.TEXT_XML)
	@Consumes(MediaType.TEXT_XML)
	public String saveTeacher(String teacherXML);

	/**
	 * Method to return the list of all the students in the school.
	 * 
	 * @return studentListXML
	 */
	@POST
	@Path("/retrieveAllStudents/")
	@Produces(MediaType.TEXT_XML)
	public String retrieveAllStudents();

	/**
	 * Method to return the list of all the teachers in the school.
	 * 
	 * @return teacherListXML
	 */
	@POST
	@Path("/retrieveAllTeachers/")
	@Produces(MediaType.TEXT_XML)
	public String retrieveAllTeachers();

	/**
	 * Method to return the list of all the students for the given classIds.
	 * 
	 * @return studentListXML
	 */
	@POST
	@Path("/retrieveStudentsForClass/")
	@Produces(MediaType.TEXT_XML)
	@Consumes(MediaType.TEXT_XML)
	public String retrieveStudentsForClass(String classIdXML);

}
