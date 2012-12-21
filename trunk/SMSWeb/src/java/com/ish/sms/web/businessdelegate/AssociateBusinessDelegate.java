package com.ish.sms.web.businessdelegate;


/**
 * Associate Business Delegate which is used to lookup the rest service and call the same.
 * 
 * @author Naren
 *
 */
public class AssociateBusinessDelegate extends BaseBusinessDelegate{
	
	/**
	 * @param studentXml
	 * @return persistedstudentXML
	 */
	public String saveStudent(String studentXml){
		return smsServiceLocator.getSmsAssociateServiceInterface().createStudent(studentXml);
	}
}
