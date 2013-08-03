package com.ish.sms.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import com.ish.sms.service.dto.ChartSeriesListDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.web.bean.AttendanceReportBean;
import com.ish.sms.web.bean.UserBean;
import com.ish.sms.web.util.WebUtils;

/**
 * Action Bean class which is in view scope for all the attendance report related actions.
 * 
 * @author Naren
 */

@ManagedBean(name = "attendanceReportAction")
@ViewScoped
public class AttendanceReportAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{attendanceReportBean}")
	private AttendanceReportBean attendanceReportBean;

	@ManagedProperty(value = "#{userBean}")
	private UserBean userBean;

	/**
	 * @return the userBean
	 */
	public UserBean getUserBean() {
		return userBean;
	}

	/**
	 * @param userBean
	 *            the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * @return the attendanceReportBean
	 */
	public AttendanceReportBean getAttendanceReportBean() {
		return attendanceReportBean;
	}

	/**
	 * @param attendanceReportBean
	 *            the attendanceReportBean to set
	 */
	public void setAttendanceReportBean(AttendanceReportBean attendanceReportBean) {
		this.attendanceReportBean = attendanceReportBean;
	}

	/**
	 * Method to set the class details and student details combo boxes
	 * 
	 * @return attendanceReport.xhtml
	 */
	public String initAttendanceReport() {

		try {

			if (!attendanceReportBean.setClassDetails(userBean)) {
				return ATTENDANCE_REPORT_PAGE;
			} else {
				setStudentDetails();
				attendanceReportBean.createDefaultChart();
			}
			attendanceReportBean.setReadOnly(false);
			
		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}

		return ATTENDANCE_REPORT_PAGE;
	}

	/**
	 * Method to initialize the student details and attendance data for the given student.
	 * 
	 * @return attendanceReport.xhtml
	 */
	public String initStudentAttendanceReport(Integer studentId){
		
		try {
			StudentDTO studentDTO  = associateBusiness.retrieveStudentDetails(studentId);
			attendanceReportBean.populateStudentAttendanceDetails(studentDTO);
			generateAttendanceReport();
		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}
		
		return ATTENDANCE_REPORT_PAGE;
	}
	
	
	/**
	 * Method to retrieve the student details for the specified class and set them in the bean
	 * 
	 * @throws Exception
	 */
	private void setStudentDetails() throws Exception {

		List<String> classIdList = new ArrayList<String>();
		classIdList.add("" + attendanceReportBean.getSelectedClassDTO().getId());
		List<StudentDTO> studentDTOList = associateBusiness.retrieveAllStudents(classIdList);
		attendanceReportBean.setStudentDTOList(studentDTOList);
		if (studentDTOList != null && studentDTOList.size() > 0) {
			attendanceReportBean.setSelectedStudentDTO(studentDTOList.get(0));
		}
	}

	/**
	 * Method to handle class change and set the student list for the new class
	 * 
	 * @param ajaxBehaviorEvent
	 */
	public void changeClass(AjaxBehaviorEvent ajaxBehaviorEvent) {

		try {
			setStudentDetails();
		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}
	}

	/**
	 * Method to generate the attendance leave report 
	 */
	public void generateAttendanceReport() {
		try {
			ChartSeriesListDTO chartSeriesListDTO = reportBusiness.retrieveStudentAttendanceReport(attendanceReportBean.getSelectedClassDTO().getId(),
					attendanceReportBean.getSelectedStudentDTO().getId());
			attendanceReportBean.populateChartModel(chartSeriesListDTO);
		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}
	}

}
