package com.ish.sms.web.business;

import com.ish.sms.service.dto.ChartSeriesListDTO;

/**
 * Business class for all report related actions. This is called from the Action bean/class. The methods in the class also converts the
 * DTO to xml and vice-versa the response from the rest service.
 * 
 * @author Naren
 * 
 */
public class ReportBusiness extends BaseBusiness {

	/**
	 * Method to generate the student attendance leave report
	 * 
	 * @return {@link ChartSeriesListDTO}
	 * @throws Exception
	 */
	public ChartSeriesListDTO retrieveStudentAttendanceReport(Integer classId, Integer studentId) throws Exception {
		String chartSeriesListDTOXML = reportBusinessDelegate.retrieveStudentAttendanceReport(classId, studentId);
		ChartSeriesListDTO chartSeriesListDTO = serviceTransformer.parseXml(chartSeriesListDTOXML);
		return chartSeriesListDTO;
	}
}
