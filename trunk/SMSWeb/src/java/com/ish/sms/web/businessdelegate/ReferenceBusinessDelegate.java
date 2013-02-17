package com.ish.sms.web.businessdelegate;

/**
 * Reference Business Delegate which is used to lookup the reference rest service and call the same.
 * 
 * @author Naren
 * 
 */
public class ReferenceBusinessDelegate extends BaseBusinessDelegate {

	/**
	 * Method to get all the reference entities
	 * 
	 * @return referenceListXML
	 */
	public String retrieveAllReferenceList() {
		return smsServiceLocator.getSmsReferenceServiceInterface().retrieveAllReferenceList();
	}
}
