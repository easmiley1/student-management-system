package com.ish.sms.web.businessdelegate;


/**
 * Associate Business Delegate which is used to lookup the rest service and call
 * the same.
 * 
 * @author Naren
 * 
 */
public class AssociateBusinessDelegate extends BaseBusinessDelegate {

	/**
	 * Method to create or update a student.
	 * 
	 * @param studentXml
	 * @return persistedstudentXML
	 */
	public String saveStudent(String studentXml) {
		return smsServiceLocator.getSmsAssociateServiceInterface().createStudent(studentXml);
	}

	/**
	 * Method to return the list of all the students in the school.
	 * 
	 * @return studentList
	 */
	public String retrieveAllStudents() {

		return smsServiceLocator.getSmsAssociateServiceInterface().retrieveAllStudents();
	}

}
