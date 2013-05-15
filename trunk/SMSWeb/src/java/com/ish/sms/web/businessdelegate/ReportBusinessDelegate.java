package com.ish.sms.web.businessdelegate;

/**
 * Report Business Delegate which is used to lookup the Report rest service and call the same.
 * 
 * @author Naren
 * 
 */
public class ReportBusinessDelegate extends BaseBusinessDelegate {

	/**
	 * Method to delegate to the rest service to get the student attendance leave report
	 * 
	 * @return chartSeriesListDTOXML
	 */
	public String retrieveStudentAttendanceReport(Integer classId, Integer studentId) {
		return smsServiceLocator.getSmsReportServiceInterface().retrieveStudentAttendanceReport(classId, studentId);
	}
}
