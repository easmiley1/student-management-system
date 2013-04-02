package com.ish.sms.web.businessdelegate;

/**
 * Reference Business Delegate which is used to lookup the reference rest service and call the same.
 * 
 * @author Naren
 * 
 */
public class UserBusinessDelegate extends BaseBusinessDelegate {

	/**
	 * Method to return the user for a specific userName
	 * 
	 * @return userDetailsDTOXML
	 */
	public String retrieveUser(String userName) {
		return smsServiceLocator.getSmsUserServiceInterface().retrieveUser(userName);
	}
}
