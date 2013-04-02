package com.ish.sms.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;

import com.ish.sms.service.dto.UserDetailsDTO;

/**
 * Restful service class to handle all User related operations.
 * 
 * @author Naren
 * 
 */
@Service
@Path("/smsUserService")
public class SMSUserService extends SMSBaseService {

	/**
	 * Method to return the user for a specific userName
	 * 
	 * @return userDetailsDTOXML
	 */
	@GET
	@Path("/retrieveUser/{userName}")
	@Produces("text/xml")
	public String retrieveUser(@PathParam("userName") String userName) {

		String userDetailsDTOXML = null;
		try {
			UserDetailsDTO userDetailsDTO = userOperations.retrieveUser(userName);
			userDetailsDTOXML = serviceTransformer.transformToXML(userDetailsDTO, "userDetailsDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDetailsDTOXML;
	}

}
