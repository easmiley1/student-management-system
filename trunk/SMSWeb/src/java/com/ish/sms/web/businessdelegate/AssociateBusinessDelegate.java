package com.ish.sms.web.businessdelegate;

/**
 * Associate Business Delegate which is used to lookup the associate rest service and call the same.
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
		return smsServiceLocator.getSmsAssociateServiceInterface().saveStudent(studentXml);
	}

	/**
	 * Method to create or update a Teacher.
	 * 
	 * @param teacherXml
	 * @return persistedTeacherXml
	 */
	public String saveTeacher(String teacherXml) {
		return smsServiceLocator.getSmsAssociateServiceInterface().saveTeacher(teacherXml);
	}

	/**
	 * Method to return the list of all the students in the school.
	 * 
	 * @return studentList
	 */
	public String retrieveAllStudents() {

		return smsServiceLocator.getSmsAssociateServiceInterface().retrieveAllStudents();
	}

	/**
	 * Method to return the list of all the students for the given classIds.
	 * 
	 * @return studentList
	 */
	public String retrieveStudentsForClass(String classIdXML) {

		return smsServiceLocator.getSmsAssociateServiceInterface().retrieveStudentsForClass(classIdXML);
	}

	/**
	 * Method to return the list of all the teachers in the school.
	 * 
	 * @return studentList
	 */
	public String retrieveAllTeachers() {

		return smsServiceLocator.getSmsAssociateServiceInterface().retrieveAllTeachers();
	}

	/**
	 * Method to return the student details for the given id.
	 * 
	 * @param studentId
	 * @return student
	 */
	public String retrieveStudentDetails(Integer studentId) {

		return smsServiceLocator.getSmsAssociateServiceInterface().retrieveStudentDetails(studentId);
	}

}
