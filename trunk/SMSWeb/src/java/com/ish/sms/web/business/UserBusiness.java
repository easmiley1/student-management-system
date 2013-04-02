package com.ish.sms.web.business;

import com.ish.sms.service.dto.UserDetailsDTO;

/**
 * Business class for all user related actions. This is called from the Action bean/class. The methods in the class also converts the
 * DTO to xml and vice-versa the response from the rest service.
 * 
 * @author Naren
 * 
 */
public class UserBusiness extends BaseBusiness {

	/**
	 * Method to return the user for a specific userName
	 * 
	 * @return userDetailsDTO {@link UserDetailsDTO}
	 * @throws Exception
	 */
	public UserDetailsDTO retrieveUser(String userName) throws Exception {
		String userDetailsDTOXML = userBusinessDelegate.retrieveUser(userName);
		UserDetailsDTO userDetailsDTO = serviceTransformer.parseXml(userDetailsDTOXML);
		return userDetailsDTO;
	}
}
