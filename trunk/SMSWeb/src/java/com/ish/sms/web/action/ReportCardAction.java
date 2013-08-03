package com.ish.sms.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ReportCardDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.web.bean.ReportCardBean;
import com.ish.sms.web.util.WebUtils;

/**
 * Action Bean class which is in request scope for all the report card related actions.
 * 
 * @author Naren
 */

@ManagedBean(name = "reportCardAction")
@ViewScoped
public class ReportCardAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{reportCardBean}")
	private ReportCardBean reportCardBean;

	/**
	 * @return the reportCardBean
	 */
	public ReportCardBean getReportCardBean() {
		return reportCardBean;
	}

	/**
	 * @param reportCardBean
	 *            the reportCardBean to set
	 */
	public void setReportCardBean(ReportCardBean reportCardBean) {
		this.reportCardBean = reportCardBean;
	}

	/**
	 * Method to populate the student list and populate the report card for the first student.
	 * 
	 * @param classId
	 * @return reportCard.xhtml
	 */
	public String openReportCardRegister(Integer classId) {

		try {
			ClassDTO classDTO = classBusiness.retrieveClassForId(classId);
			if (!reportCardBean.setClassDetails(classDTO)) {
				return REPORT_CARD_PAGE;
			} else {
				setStudentDetails();
				List<ReportCardDTO> reportCardDTOList = classBusiness.retrieveClassGradeDetailsForStudent(classId, reportCardBean.getSelectedStudentDTO()
						.getId());
				reportCardBean.setReportCardDTOList(reportCardDTOList);
			}

		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}
		return REPORT_CARD_PAGE;
	}

	/**
	 * Method to retrieve the student details for the specified class and set them in the bean
	 * 
	 * @throws Exception
	 */
	private void setStudentDetails() throws Exception {

		List<String> classIdList = new ArrayList<String>();
		classIdList.add("" + reportCardBean.getClassDTO().getId());
		List<StudentDTO> studentDTOList = associateBusiness.retrieveAllStudents(classIdList);
		reportCardBean.setStudentDTOList(studentDTOList);
		if (studentDTOList != null && studentDTOList.size() > 0) {
			reportCardBean.setSelectedStudentDTO(studentDTOList.get(0));
		}
	}

}
