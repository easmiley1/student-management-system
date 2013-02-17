package com.ish.sms.web.businessdelegate;


/**
 * Class Business Delegate which is used to lookup the class rest service and call the same.
 * 
 * @author Naren
 * 
 */
public class ClassBusinessDelegate extends BaseBusinessDelegate {

	/**
	 * Method to get the classDTO for the corresponding class
	 * 
	 * @return classDTOXML
	 */
	public String retrieveClassForId(Integer classId) {
		return smsServiceLocator.getSmsClassServiceInterface().retrieveClassForId(classId);
	}

	/**
	 * Method to get all the classAttendanceDefintion list for a particular class .
	 * 
	 * @param classId
	 * @return classAttendanceDefListDTOXML
	 */
	public String retrieveClassAttendanceDefList(Integer classId) {
		return smsServiceLocator.getSmsClassServiceInterface().retrieveClassAttendanceDefList(classId);
	}

	/**
	 * Method to remove or delete the given ClassAttendanceDefDTO List and return the updated one wrapped in classAttendanceDefListDTO 
	 * 
	 * @return classAttendanceDefListDTOXML
	 */

	public String updateClassAttendanceDefList(String classAttendanceDefListDTOXML)  {
		return smsServiceLocator.getSmsClassServiceInterface().updateClassAttendanceDefList(classAttendanceDefListDTOXML);
	}
}
