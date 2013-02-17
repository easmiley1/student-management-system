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

	private List<String> columnNames = new ArrayList<String>();
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

	private List<AssociateAttendanceDTO> attendanceList = new ArrayList<AssociateAttendanceDTO>();

	/**
	 * @return the attendanceList
	 */
	public List<AssociateAttendanceDTO> getAttendanceList() {
		return attendanceList;
	}

	/**
	 * @param attendanceList the attendanceList to set
	 */
	public void setAttendanceList(List<AssociateAttendanceDTO> attendanceList) {
		this.attendanceList = attendanceList;
	}

}
