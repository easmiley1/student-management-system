package com.ish.sms.web.bean;

import java.util.ArrayList;
import java.util.List;

import com.ish.sms.service.dto.AssociateAttendanceDTO;
import com.ish.sms.service.dto.ClassAttendanceDefDTO;

/**
 * Attendance Register Bean which represents the attendance register for a month
 * 
 * @author Naren
 *
 */
public class AttendanceRegisterBean {

	private List<ClassAttendanceDefDTO> classAttendanceDefDTOList = new ArrayList<ClassAttendanceDefDTO>();
	
	private ClassAttendanceDefDTO selectedAttendanceDefDTO = null;
	
	private ClassAttendanceDefDTO previousClassAttendanceDefDTO = null;

	private List<AssociateAttendanceDTO> associateAttendanceList = new ArrayList<AssociateAttendanceDTO>();

	private List<String> columnNames = new ArrayList<String>();
	
	

	/**
	 * @return the previousClassAttendanceDefDTO
	 */
	public ClassAttendanceDefDTO getPreviousClassAttendanceDefDTO() {
		return previousClassAttendanceDefDTO;
	}

	/**
	 * @param previousClassAttendanceDefDTO the previousClassAttendanceDefDTO to set
	 */
	public void setPreviousClassAttendanceDefDTO(ClassAttendanceDefDTO previousClassAttendanceDefDTO) {
		this.previousClassAttendanceDefDTO = previousClassAttendanceDefDTO;
	}

	/**
	 * @return the associateAttendanceList
	 */
	public List<AssociateAttendanceDTO> getAssociateAttendanceList() {
		return associateAttendanceList;
	}

	/**
	 * @param associateAttendanceList the associateAttendanceList to set
	 */
	public void setAssociateAttendanceList(List<AssociateAttendanceDTO> associateAttendanceList) {
		this.associateAttendanceList = associateAttendanceList;
	}

	/**
	 * @return the selectedAttendanceDefDTO
	 */
	public ClassAttendanceDefDTO getSelectedAttendanceDefDTO() {
		return selectedAttendanceDefDTO;
	}

	/**
	 * @param selectedAttendanceDefDTO the selectedAttendanceDefDTO to set
	 */
	public void setSelectedAttendanceDefDTO(ClassAttendanceDefDTO selectedAttendanceDefDTO) {
		this.selectedAttendanceDefDTO = selectedAttendanceDefDTO;
	}

	/**
	 * @return the classAttendanceDefDTOList
	 */
	public List<ClassAttendanceDefDTO> getClassAttendanceDefDTOList() {
		return classAttendanceDefDTOList;
	}

	/**
	 * @param classAttendanceDefDTOList the classAttendanceDefDTOList to set
	 */
	public void setClassAttendanceDefDTOList(List<ClassAttendanceDefDTO> classAttendanceDefDTOList) {
		this.classAttendanceDefDTOList = classAttendanceDefDTOList;
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


}
