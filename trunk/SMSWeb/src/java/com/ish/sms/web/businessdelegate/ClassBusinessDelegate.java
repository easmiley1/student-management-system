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
	 * Method to create or update a class and return the persisted classXML.
	 * 
	 * @param classXML
	 * @return persistedClassXML
	 */

	public String saveClass(String classXml) {
		return smsServiceLocator.getSmsClassServiceInterface().saveClass(classXml);
	}

	/**
	 * Method to return the list of all active classes
	 * 
	 * @return classListXML
	 */

	public String retrieveAllClasses() {
		return smsServiceLocator.getSmsClassServiceInterface().retrieveAllClasses();
	}

	/**
	 * Method to retrieve the student grade details for a particular class id.
	 * 
	 * @param classId
	 * @param classExamId
	 * 
	 * @return studentGradeListDTOXml
	 */
	public String retrieveClassGradeDetails(Integer classId, Integer classExamId) {
		return smsServiceLocator.getSmsClassServiceInterface().retrieveClassGradeDetails(classId, classExamId);
	}

	/**
	 * Method to create or update a class grade details and return the persisted XML.
	 * 
	 * @param saveClassGradeDetailsXML
	 * @return persistedsaveClassGradeDetailsXML
	 */

	public String saveClassGradeDetails(String xml) {
		return smsServiceLocator.getSmsClassServiceInterface().saveClassGradeDetails(xml);
	}

}
