package com.ish.sms.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ReportCardListDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.web.bean.ReportCardBean;
import com.ish.sms.web.util.PDFUtil;
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
				ReportCardListDTO reportCardListDTO = classBusiness
						.retrieveClassGradeDetailsForStudent(classId, reportCardBean.getSelectedStudentDTO().getId());
				reportCardBean.setReportCardDTOList(reportCardListDTO.getReportCardDTOList());
				reportCardBean.setClassStudentDTO(reportCardListDTO.getClassStudentDTO());
			}

		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}
		return REPORT_CARD_PAGE;
	}

	/**
	 * Method to listen the student change event and set the appropriate student report card.
	 * 
	 * @param ajaxBehaviorEvent
	 */
	public void changeStudent(AjaxBehaviorEvent ajaxBehaviorEvent) {
		try {
			ReportCardListDTO reportCardListDTO = classBusiness.retrieveClassGradeDetailsForStudent(reportCardBean.getClassDTO().getId(), reportCardBean
					.getSelectedStudentDTO().getId());
			reportCardBean.setReportCardDTOList(reportCardListDTO.getReportCardDTOList());
			reportCardBean.setClassStudentDTO(reportCardListDTO.getClassStudentDTO());
		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}
	}

	/**
	 * Generate report card PDF
	 * 
	 * @throws Exception
	 */
	public void generatePDF() throws Exception {

		PDFUtil.generateReportCardPDF(reportCardBean);
		WebUtils.registerMessage(FacesMessage.SEVERITY_INFO, SAVE_SUCCESSFULL, COMMENTS_SAVED_SUCCESSFULLY);

	}

	/**
	 * Method to save the student comments
	 */
	public void saveClassStudentDetails() {
		try {
			classBusiness.saveClassStudentDetails(reportCardBean.getClassStudentDTO());
			WebUtils.registerMessage(FacesMessage.SEVERITY_INFO, SAVE_SUCCESSFULL, COMMENTS_SAVED_SUCCESSFULLY);

		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}
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
