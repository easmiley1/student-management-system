package com.ish.sms.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassExamReferenceDataDTO;
import com.ish.sms.service.dto.ClassGradeDetailsDTO;
import com.ish.sms.service.dto.ClassSubjectReferenceDataDTO;
import com.ish.sms.service.dto.GradeDetailsDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.service.dto.StudentGradeDTO;
import com.ish.sms.service.dto.StudentGradeListDTO;
import com.ish.sms.web.service.dto.GradeDetailsMap;
import com.ish.sms.web.util.WebConstants;
import com.ish.sms.web.util.WebUtils;

/**
 * Bean class to hold all the class grade details in session scope.
 * 
 * @author Naren
 * 
 */
@ManagedBean(name = WebConstants.CLASS_GRADE_BEAN)
@SessionScoped
public class ClassGradeBean extends BaseBean {

	private static final long serialVersionUID = 1L;
	private ClassDTO selectedClassDTO = new ClassDTO();
	private List<ClassExamReferenceDataDTO> classExamReferenceDataDTOList = new ArrayList<ClassExamReferenceDataDTO>();
	private List<StudentGradeDTO> studentGradeDTOList = new ArrayList<StudentGradeDTO>();
	private ClassExamReferenceDataDTO selectedClassExamReferenceDataDTO = new ClassExamReferenceDataDTO();
	private List<ClassSubjectReferenceDataDTO> classSubjectReferenceDataDTOList = new ArrayList<ClassSubjectReferenceDataDTO>();
	private ClassExamReferenceDataDTO previousClassExamReferenceDataDTO = new ClassExamReferenceDataDTO();

	private boolean dataSaved = true;

	/**
	 * @return the dataSaved
	 */
	public boolean isDataSaved() {
		return dataSaved;
	}

	/**
	 * @param dataSaved
	 *            the dataSaved to set
	 */
	public void setDataSaved(boolean dataSaved) {
		this.dataSaved = dataSaved;
	}

	/**
	 * @return the previousClassExamReferenceDataDTO
	 */
	public ClassExamReferenceDataDTO getPreviousClassExamReferenceDataDTO() {
		return previousClassExamReferenceDataDTO;
	}

	/**
	 * @param previousClassExamReferenceDataDTO
	 *            the previousClassExamReferenceDataDTO to set
	 */
	public void setPreviousClassExamReferenceDataDTO(ClassExamReferenceDataDTO previousClassExamReferenceDataDTO) {
		this.previousClassExamReferenceDataDTO = previousClassExamReferenceDataDTO;
	}

	/**
	 * @return the studentGradeDTOList
	 */
	public List<StudentGradeDTO> getStudentGradeDTOList() {
		return studentGradeDTOList;
	}

	/**
	 * @param studentGradeDTOList
	 *            the studentGradeDTOList to set
	 */
	public void setStudentGradeDTOList(List<StudentGradeDTO> studentGradeDTOList) {
		this.studentGradeDTOList = studentGradeDTOList;
	}

	/**
	 * @return the classSubjectReferenceDataDTOList
	 */
	public List<ClassSubjectReferenceDataDTO> getClassSubjectReferenceDataDTOList() {
		return classSubjectReferenceDataDTOList;
	}

	/**
	 * @param classSubjectReferenceDataDTOList
	 *            the classSubjectReferenceDataDTOList to set
	 */
	public void setClassSubjectReferenceDataDTOList(List<ClassSubjectReferenceDataDTO> classSubjectReferenceDataDTOList) {
		this.classSubjectReferenceDataDTOList = classSubjectReferenceDataDTOList;
	}

	/**
	 * @return the selectedClassDTO
	 */
	public ClassDTO getSelectedClassDTO() {
		return selectedClassDTO;
	}

	/**
	 * @param selectedClassDTO
	 *            the selectedClassDTO to set
	 */
	public void setSelectedClassDTO(ClassDTO selectedClassDTO) {
		this.selectedClassDTO = selectedClassDTO;
	}

	/**
	 * @return the classExamReferenceDataDTOList
	 */
	public List<ClassExamReferenceDataDTO> getClassExamReferenceDataDTOList() {
		return classExamReferenceDataDTOList;
	}

	/**
	 * @param classExamReferenceDataDTOList
	 *            the classExamReferenceDataDTOList to set
	 */
	public void setClassExamReferenceDataDTOList(List<ClassExamReferenceDataDTO> classExamReferenceDataDTOList) {
		this.classExamReferenceDataDTOList = classExamReferenceDataDTOList;
	}

	/**
	 * @return the selectedClassExamReferenceDataDTO
	 */
	public ClassExamReferenceDataDTO getSelectedClassExamReferenceDataDTO() {
		return selectedClassExamReferenceDataDTO;
	}

	/**
	 * @param selectedClassExamReferenceDataDTO
	 *            the selectedClassExamReferenceDataDTO to set
	 */
	public void setSelectedClassExamReferenceDataDTO(ClassExamReferenceDataDTO selectedClassExamReferenceDataDTO) {
		this.selectedClassExamReferenceDataDTO = selectedClassExamReferenceDataDTO;
	}

	/**
	 * Get the class details and if the class does not have any exams, subjects added just return to the grade details page and do nothing,
	 * else set the class details and exam details in the classGradeBean
	 * 
	 * @param classDTO
	 * @return validationResult
	 */
	public boolean setExamAndSubjectClassDetails(ClassDTO classDTO) {

		List<ClassExamReferenceDataDTO> classExamReferenceDataDTOList = classDTO.getClassExamReferenceDataDTOList();
		if (classExamReferenceDataDTOList == null || classExamReferenceDataDTOList.size() == 0) {
			WebUtils.registerMessage(FacesMessage.SEVERITY_WARN, CANNOT_MODIFY_GRADE_DETAILS, EXAM_DETAIL_NOT_FOUND);
			return false;
		} else {
			setSelectedClassDTO(classDTO);
			setClassExamReferenceDataDTOList(classExamReferenceDataDTOList);
			setSelectedClassExamReferenceDataDTO(classExamReferenceDataDTOList.get(0));
			setPreviousClassExamReferenceDataDTO(classExamReferenceDataDTOList.get(0));
		}
		List<ClassSubjectReferenceDataDTO> classSubjectReferenceDataDTOList = classDTO.getClassSubjectReferenceDataDTOList();
		if (classSubjectReferenceDataDTOList == null || classSubjectReferenceDataDTOList.size() == 0) {
			WebUtils.registerMessage(FacesMessage.SEVERITY_WARN, CANNOT_MODIFY_GRADE_DETAILS, SUBJECT_DETAIL_NOT_FOUND);
			return false;
		} else {
			setClassSubjectReferenceDataDTOList(classSubjectReferenceDataDTOList);
		}
		return true;
	}

	/**
	 * Method to create the default student Grade Grid when the exam is selected for the first time.
	 * 
	 * @param studentDTOList
	 */
	public void populateDefaultClassGradeDetailsGrid(List<StudentDTO> studentDTOList) {

		studentGradeDTOList.clear();
		for (StudentDTO studentDTO : studentDTOList) {
			StudentGradeDTO studentGradeDTO = new StudentGradeDTO();

			for (ClassSubjectReferenceDataDTO classSubjectReferenceDTO : getClassSubjectReferenceDataDTOList()) {
				GradeDetailsDTO gradeDetailsDTO = new GradeDetailsDTO();
				gradeDetailsDTO.setMark(0);
				if (studentGradeDTO.getGradeDetailsMap() == null)
					studentGradeDTO.setGradeDetailsMap(new GradeDetailsMap<ClassSubjectReferenceDataDTO, GradeDetailsDTO>());
				studentGradeDTO.getGradeDetailsMap().put(classSubjectReferenceDTO, gradeDetailsDTO);
			}
			studentGradeDTO.setStudentDTO(studentDTO);
			studentGradeDTOList.add(studentGradeDTO);
		}
	}

	/**
	 * Method to create the classGradeDetails for persistence
	 * 
	 * @return {@link ClassGradeDetailsDTO}
	 */
	public ClassGradeDetailsDTO prepareToSaveGradeBook() {
		ClassGradeDetailsDTO classGradeDetailsDTO = new ClassGradeDetailsDTO();
		StudentGradeListDTO studentGradeListDTO = new StudentGradeListDTO();
		studentGradeListDTO.setStudentGradeDTOList(getStudentGradeDTOList());
		classGradeDetailsDTO.setStudentGradeListDTO(studentGradeListDTO);
		classGradeDetailsDTO.setClassDTO(getSelectedClassDTO());
		classGradeDetailsDTO.setClassExamReferenceDataDTO(getPreviousClassExamReferenceDataDTO());
		return classGradeDetailsDTO;
	}
}
