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
	public String saveClass(String xml);

	/**
	 * Method to return the list of all active classes for the previous year for promotion
	 * 
	 * @return classListXML
	 */
	@GET
	@Path("/retrieveAllClassesForPromotion/{userName}")
	@Produces("text/xml")
	public String retrieveAllClassesForPromotion(@PathParam("userName") String userName );

	/**
	 * Method to retrieve the student grade details for a particular class id and classExamId
	 * 
	 * @param classId
	 * @param classExamId
	 * @return studentGradeListDTOXml
	 */
	@GET
	@Path("/retrieveClassGradeDetails/{classId}/{classExamId}")
	@Produces("text/xml")
	public String retrieveClassGradeDetails(@PathParam("classId") Integer classId, @PathParam("classExamId") Integer classExamId);

	/**
	 * Method to create or update a class grade details and return the persisted XML.
	 * 
	 * @param saveClassGradeDetailsXML
	 * @return persistedsaveClassGradeDetailsXML
	 */
	@POST
	@Path("/saveClassGradeDetails/")
	@Produces("text/xml")
	@Consumes("text/xml")
	public String saveClassGradeDetails(String xml);
	
	/**
	 * Method to promote/demote students and also create new classes if required.
	 * 
	 * @param String classPromotionDTOXML
	 * @return promotionEligibleClassList
	 */
	@POST
	@Path("/promoteClass/")
	@Produces("text/xml")
	@Consumes("text/xml")
	public String promoteClass(String classPromotionDTOXML) ;	
}
