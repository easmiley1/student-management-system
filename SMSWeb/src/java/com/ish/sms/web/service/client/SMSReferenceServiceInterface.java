package com.ish.sms.web.service.client;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Restful service interface for reference related operations
 * 
 * @author Naren
 * 
 */
public interface SMSReferenceServiceInterface {

	/**
	 * Method to get all the reference entities by wrapping them in the
	 * referenceListDTO.
	 * 
	 * @return studentListXML
	 */
	@POST
	@Path("/retrieveAllReferenceList/")
	@Produces("text/xml")
	public String retrieveAllReferenceList();
}
