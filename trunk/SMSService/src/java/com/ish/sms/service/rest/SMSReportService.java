package com.ish.sms.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;

import com.ish.sms.service.dto.ChartSeriesListDTO;

/**
 * Restful service class to handle all Report related operations.
 * 
 * @author Naren
 * 
 */
@Service
@Path("/smsReportService")
public class SMSReportService extends SMSBaseService {

	/**
	 * Method to retrieve the student attendance details for current year.
	 * 
	 * @return classAttendanceDefListDTOXML
	 */
	@GET
	@Path("/retrieveStudentAttendanceReport/{classId}/{studentId}")
	@Produces("text/xml")
	public String retrieveStudentAttendanceReport(@PathParam("classId") Integer classId, @PathParam("studentId") Integer studentId) {

		String chartSeriesListDTOXML = null;
		try {
			ChartSeriesListDTO chartSeriesListDTO = reportOperations.generateStudentAttendanceReport(classId, studentId);
			chartSeriesListDTOXML = serviceTransformer.transformToXML(chartSeriesListDTO, "chartSeriesListDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chartSeriesListDTOXML;
	}
}
