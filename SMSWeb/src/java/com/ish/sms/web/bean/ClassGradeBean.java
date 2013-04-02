package com.ish.sms.web.bean;

import com.ish.sms.service.dto.ClassExamReferenceDataDTO;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassReferenceDataDTO;
import com.ish.sms.web.util.WebConstants;

/**
 * Bean class to hold all the class grade details in session scope.
 * 
 * @author Naren
 * 
 */
@ManagedBean(name = WebConstants.CLASS_GRADE_BEAN)
@SessionScoped
public class ClassGradeBean extends BaseBean{

	private static final long serialVersionUID = 1L;
	private ClassDTO selectedClassDTO = new ClassDTO();
	private List<ClassExamReferenceDataDTO> classExamReferenceDataDTOList = new ArrayList<ClassExamReferenceDataDTO>();
	private ClassReferenceDataDTO selectedClassExamReferenceDataDTO = new ClassReferenceDataDTO();
	private List<StudentGradeBean> studentGradeList = new ArrayList<StudentGradeBean>();
	private List<String> columnNames = new ArrayList<String>();
	private boolean dataSaved = true;
	
	/**
	 * @return the dataSaved
	 */
	public boolean isDataSaved() {
		return dataSaved;
	}
	/**
	 * @param dataSaved the dataSaved to set
	 */
	public void setDataSaved(boolean dataSaved) {
		this.dataSaved = dataSaved;
	}
	/**
	 * @return the columnNames
	 */
	public List<String> getColumnNames() {
		return columnNames;
	}
	/**
	 * @param columnNames the columnNames to set
	 */
	public void setColumnNames(List<String> columnNames) {
		this.columnNames = columnNames;
	}
	/**
	 * @return the studentGradeList
	 */
	public List<StudentGradeBean> getStudentGradeList() {
		return studentGradeList;
	}
	/**
	 * @param studentGradeList the studentGradeList to set
	 */
	public void setStudentGradeList(List<StudentGradeBean> studentGradeList) {
		this.studentGradeList = studentGradeList;
	}
	/**
	 * @return the selectedClassDTO
	 */
	public ClassDTO getSelectedClassDTO() {
		return selectedClassDTO;
	}
	/**
	 * @param selectedClassDTO the selectedClassDTO to set
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
	 * @param classExamReferenceDataDTOList the classExamReferenceDataDTOList to set
	 */
	public void setClassExamReferenceDataDTOList(List<ClassExamReferenceDataDTO> classExamReferenceDataDTOList) {
		this.classExamReferenceDataDTOList = classExamReferenceDataDTOList;
	}
	/**
	 * @return the selectedClassExamReferenceDataDTO
	 */
	public ClassReferenceDataDTO getSelectedClassExamReferenceDataDTO() {
		return selectedClassExamReferenceDataDTO;
	}
	/**
	 * @param selectedClassExamReferenceDataDTO the selectedClassExamReferenceDataDTO to set
	 */
	public void setSelectedClassExamReferenceDataDTO(ClassReferenceDataDTO selectedClassExamReferenceDataDTO) {
		this.selectedClassExamReferenceDataDTO = selectedClassExamReferenceDataDTO;
	}
	
	
}
