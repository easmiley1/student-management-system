package com.ish.sms.service.ops.util;

import java.util.ArrayList;
import java.util.List;

import com.ish.sms.service.dto.AttendanceMap;
import com.ish.sms.service.dto.ChartSeriesDTO;
import com.ish.sms.service.dto.ChartSeriesListDTO;
import com.ish.sms.service.dto.ChartValueDTO;
import com.ish.sms.service.entity.AssociateAttendance;
import com.ish.sms.service.entity.Student;

/**
 * Utility class for performing DTO/Entity conversions for Report related entities
 * 
 * @author enselv
 *
 */
public class ReportOperationsUtil {

	/**
	 * @param associateAttendanceList
	 * @return {@link ChartSeriesListDTO}
	 */
	public ChartSeriesListDTO createChartSeries(List<AssociateAttendance> associateAttendanceList) {
		
		String seriesLabel = "Leave Report";
		if (associateAttendanceList != null & associateAttendanceList.size() > 0) {
			Student student = associateAttendanceList.get(0).getStudent();
			seriesLabel  = seriesLabel + " - " + student.getFirstName() + " " + student.getFatherName();
		}
		ChartSeriesListDTO chartSeriesListDTO = new ChartSeriesListDTO();
		ChartSeriesDTO chartSeriesDTO = new ChartSeriesDTO();
		List<ChartValueDTO> chartValueListDTO = new ArrayList<ChartValueDTO>();

		for (AssociateAttendance associateAttendance : associateAttendanceList) {
			AttendanceMap<String, Boolean> attendanceMap = associateAttendance.getAttendanceMap();
			int leaveCount = 0;
			ChartValueDTO chartValueDTO = new ChartValueDTO();
			for (String day : attendanceMap.keySet()) {
				if (!attendanceMap.get(day)) {
					leaveCount++;
				}
			}
			chartValueDTO.setXLabel(associateAttendance.getClassAttendanceDef().getMonthYear());
			chartValueDTO.setYValue("" + leaveCount);
			chartValueListDTO.add(chartValueDTO);
		}
		chartSeriesDTO.setChartValueListDTO(chartValueListDTO);
		chartSeriesDTO.setSeriesLabel(seriesLabel);
		chartSeriesListDTO.getChartSeriesListDTO().add(chartSeriesDTO);

		return chartSeriesListDTO;
	}

}
