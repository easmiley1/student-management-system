package com.ish.sms.service.ops;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ish.sms.service.dto.ChartSeriesListDTO;
import com.ish.sms.service.entity.AssociateAttendance;

/**
 * Class to handle all business logic for report related entity database operations
 * 
 * @author Naren
 * 
 */
public class ReportOperations extends BaseOperations {

	/**
	 * @param classId
	 * @param studentId
	 * @return {@link ChartSeriesListDTO}
	 */
	@SuppressWarnings("unchecked")
	public ChartSeriesListDTO generateStudentAttendanceReport(Integer classId, Integer studentId) {

		Map<String, Object> queryParametersMap = new HashMap<String, Object>();
		queryParametersMap.put(CLASS_ID, classId);
		queryParametersMap.put(STUDENT_ID, studentId);

		List<AssociateAttendance> associateAttendanceList = (List<AssociateAttendance>) reportOperationsDAO.retrieveResultListForQueryWithParameters(
				FIND_ASSOCIATE_CURR_YEAR_ATT_DATA, queryParametersMap);

		return reportOperationsUtil.createChartSeries(associateAttendanceList);
	}

}
