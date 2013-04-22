package com.ish.sms.web.bean;

import java.util.HashMap;
import java.util.Map;

import com.ish.sms.service.dto.ClassSubjectReferenceDataDTO;
import com.ish.sms.service.dto.StudentDTO;

/**
 * Bean Class To hold the student details and their grades.
 * 
 * @author Naren
 * 
 */
public class StudentGradeBean {

	private StudentDTO studentDTO = new StudentDTO();

	private Map<ClassSubjectReferenceDataDTO, GradeDetailsBean> studentGradeMap = new HashMap<ClassSubjectReferenceDataDTO, GradeDetailsBean>();

	/**
	 * @return the studentGradeMap
	 */
	public Map<ClassSubjectReferenceDataDTO, GradeDetailsBean> getStudentGradeMap() {
		return studentGradeMap;
	}

	/**
	 * @param studentGradeMap
	 *            the studentGradeMap to set
	 */
	public void setStudentGradeMap(Map<ClassSubjectReferenceDataDTO, GradeDetailsBean> studentGradeMap) {
		this.studentGradeMap = studentGradeMap;
	}

	/**
	 * @return the studentDTO
	 */
	public StudentDTO getStudentDTO() {
		return studentDTO;
	}

	/**
	 * @param studentDTO
	 *            the studentDTO to set
	 */
	public void setStudentDTO(StudentDTO studentDTO) {
		this.studentDTO = studentDTO;
	}

	public int hashCode() {
		return studentDTO.getId().hashCode() + studentDTO.getFirstName().hashCode() + studentDTO.getFatherName().hashCode();
	}

	public boolean equals(Object other) {

		StudentGradeBean otherStudentGradeBean = (StudentGradeBean) other;
		if (studentDTO != null && studentDTO.getId() != null && otherStudentGradeBean.getStudentDTO() != null
				&& otherStudentGradeBean.getStudentDTO().getId() != null) {
			if (studentDTO.getId().equals(otherStudentGradeBean.getStudentDTO().getId())) {
				return true;
			}
		}
		return false;
	}
}
