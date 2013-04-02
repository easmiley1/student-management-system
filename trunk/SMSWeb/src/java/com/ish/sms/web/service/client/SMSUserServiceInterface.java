package com.ish.sms.web.service.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Restful service class to handle all User related operations.
 * 
 * @author Naren
 * 
 */
public interface SMSUserServiceInterface  {

	/**
	 * Method to return the user for a specific userName
	 * 
	 * @return userDetailsDTOXML
	 */
	@GET
	@Path("/retrieveUser/{userName}")
	@Produces("text/xml")
	public String retrieveUser(@PathParam("userName") String userName ) ;
}
