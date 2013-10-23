package com.ish.sms.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassExamReferenceDataDTO;
import com.ish.sms.service.dto.ClassStudentDTO;
import com.ish.sms.service.dto.ReportCardDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.web.util.WebConstants;
import com.ish.sms.web.util.WebUtils;

/**
 * Bean class to hold all the report card details in session scope.
 * 
 * @author Naren
 * 
 */

@ManagedBean(name = WebConstants.REPORT_CARD_BEAN)
@SessionScoped
public class ReportCardBean extends BaseBean {

	private static final long serialVersionUID = 1L;
	private ClassDTO classDTO = new ClassDTO();
	private List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
	private StudentDTO selectedStudentDTO = new StudentDTO();
	private List<ClassExamReferenceDataDTO> classExamReferenceDataDTOList = new ArrayList<ClassExamReferenceDataDTO>();
	private List<ReportCardDTO> reportCardDTOList = new ArrayList<ReportCardDTO>();
	private ClassStudentDTO classStudentDTO = new ClassStudentDTO();
	
	/**
	 * @return the classStudentDTO
	 */
	public ClassStudentDTO getClassStudentDTO() {
		return classStudentDTO;
	}

	/**
	 * @param classStudentDTO the classStudentDTO to set
	 */
	public void setClassStudentDTO(ClassStudentDTO classStudentDTO) {
		this.classStudentDTO = classStudentDTO;
	}

	/**
	 * @return the reportCardDTOList
	 */
	public List<ReportCardDTO> getReportCardDTOList() {
		return reportCardDTOList;
	}

	/**
	 * @param reportCardDTOList the reportCardDTOList to set
	 */
	public void setReportCardDTOList(List<ReportCardDTO> reportCardDTOList) {
		this.reportCardDTOList = reportCardDTOList;
	}

	/**
	 * @return the classExamReferenceDataDTOList
	 */
	public List<ClassExamReferenceDataDTO> getClassExamReferenceDataDTOList() {
		return classExamReferenceDataDTOList;
	}

	/**
	 * @param classExamReferenceDataDTOList the classExamReferenceDataDTOList to set
	 */
	public void setClassExamReferenceDataDTOList(List<ClassExamReferenceDataDTO> classExamReferenceDataDTOList) {
		this.classExamReferenceDataDTOList = classExamReferenceDataDTOList;
	}

	/**
	 * @return the classDTO
	 */
	public ClassDTO getClassDTO() {
		return classDTO;
	}

	/**
	 * @param classDTO the classDTO to set
	 */
	public void setClassDTO(ClassDTO classDTO) {
		this.classDTO = classDTO;
	}


	/**
	 * @return the studentDTOList
	 */
	public List<StudentDTO> getStudentDTOList() {
		return studentDTOList;
	}

	/**
	 * @param studentDTOList
	 *            the studentDTOList to set
	 */
	public void setStudentDTOList(List<StudentDTO> studentDTOList) {
		this.studentDTOList = studentDTOList;
	}

	/**
	 * @return the selectedStudentDTO
	 */
	public StudentDTO getSelectedStudentDTO() {
		return selectedStudentDTO;
	}

	/**
	 * @param selectedStudentDTO
	 *            the selectedStudentDTO to set
	 */
	public void setSelectedStudentDTO(StudentDTO selectedStudentDTO) {
		this.selectedStudentDTO = selectedStudentDTO;
	}

	public boolean setClassDetails(ClassDTO classDTO) {

		List<ClassExamReferenceDataDTO> classExamReferenceDataDTOList = classDTO.getClassExamReferenceDataDTOList();
		if (classExamReferenceDataDTOList == null || classExamReferenceDataDTOList.size() == 0) {
			WebUtils.registerMessage(FacesMessage.SEVERITY_WARN, CANNOT_MODIFY_GRADE_DETAILS, EXAM_DETAIL_NOT_FOUND);
			return false;
		} else {
			setClassDTO(classDTO);
			setClassExamReferenceDataDTOList(classExamReferenceDataDTOList);
		}
		return true;
	}

}
