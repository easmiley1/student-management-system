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

	private Map<ClassSubjectReferenceDataDTO, Integer> studentGradeMap = new HashMap<ClassSubjectReferenceDataDTO, Integer>();

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

	/**
	 * @return the studentGradeMap
	 */
	public Map<ClassSubjectReferenceDataDTO, Integer> getStudentGradeMap() {
		return studentGradeMap;
	}

	/**
	 * @param studentGradeMap
	 *            the studentGradeMap to set
	 */
	public void setStudentGradeMap(Map<ClassSubjectReferenceDataDTO, Integer> studentGradeMap) {
		this.studentGradeMap = studentGradeMap;
	}

}
