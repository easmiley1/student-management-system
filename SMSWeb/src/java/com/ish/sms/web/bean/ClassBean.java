package com.ish.sms.web.bean;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.beanutils.BeanUtils;

import com.ish.sms.service.dto.AssociateAttendanceDTO;
import com.ish.sms.service.dto.ClassAttendanceDefDTO;
import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.web.util.WebConstants;
import com.ish.sms.web.util.WebUtils;

/**
 * Bean class to hold all class related entities at session scope
 * 
 * @author Naren 
 *
 */
@ManagedBean(name = WebConstants.CLASS_BEAN)
@SessionScoped
public class ClassBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean dataSaved = true;

	private ClassDTO currentClass = new ClassDTO();

	private AttendanceRegisterBean attendanceRegisterBean = new AttendanceRegisterBean();

	private MaintainRegisterMonthBean maintainRegisterMonthBean = new MaintainRegisterMonthBean();

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
	 * @return the currentClass
	 */
	public ClassDTO getCurrentClass() {
		return currentClass;
	}

	/**
	 * @param currentClass
	 *            the currentClass to set
	 */
	public void setCurrentClass(ClassDTO currentClass) {
		this.currentClass = currentClass;
	}

	/**
	 * @return the maintainRegisterMonthBean
	 */
	public MaintainRegisterMonthBean getMaintainRegisterMonthBean() {
		return maintainRegisterMonthBean;
	}

	/**
	 * @param maintainRegisterMonthBean
	 *            the maintainRegisterMonthBean to set
	 */
	public void setMaintainRegisterMonthBean(MaintainRegisterMonthBean maintainRegisterMonthBean) {
		this.maintainRegisterMonthBean = maintainRegisterMonthBean;
	}

	/**
	 * @return the attendanceRegisterBean
	 */
	public AttendanceRegisterBean getAttendanceRegisterBean() {
		return attendanceRegisterBean;
	}

	/**
	 * @param attendanceRegisterBean
	 *            the attendanceRegisterBean to set
	 */
	public void setAttendanceRegisterBean(AttendanceRegisterBean attendanceRegisterBean) {
		this.attendanceRegisterBean = attendanceRegisterBean;
	}

	/**
	 * Method to load the Attendance Register maintenance Dialog.
	 * 
	 * @param targetClassAttendanceDefDTOList
	 */
	public void initMaintainClassAttendanceDef(List<ClassAttendanceDefDTO> targetClassAttendanceDefDTOList, boolean initialize) {
		getAttendanceRegisterBean().setClassAttendanceDefDTOList(targetClassAttendanceDefDTOList);
		List<String> sourceList = WebUtils.getAttendanceMonthDefinition();
		List<String> targetList = new ArrayList<String>();

		String currentMonthYear = WebUtils.getCurrentMonthYear();
		boolean foundCurrentMonth = false;
		for (ClassAttendanceDefDTO classAttendanceDefDTO : targetClassAttendanceDefDTOList) {
			String monthYear = classAttendanceDefDTO.getMonthYear();
			targetList.add(monthYear);
			if (initialize) {
				if (monthYear.equals(currentMonthYear)) {
					foundCurrentMonth = true;
					getAttendanceRegisterBean().setSelectedAttendanceDefDTO(classAttendanceDefDTO);
					getAttendanceRegisterBean().setPreviousClassAttendanceDefDTO(classAttendanceDefDTO);
				}
			}

		}
		if (initialize && !foundCurrentMonth){
			getAttendanceRegisterBean().setSelectedAttendanceDefDTO(targetClassAttendanceDefDTOList.get(0));
			getAttendanceRegisterBean().setPreviousClassAttendanceDefDTO(targetClassAttendanceDefDTOList.get(0));
		}

		sourceList.removeAll(targetList);
		getMaintainRegisterMonthBean().getClassAttendanceDTOModel().setSource(sourceList);
		getMaintainRegisterMonthBean().getClassAttendanceDTOModel().setTarget(targetList);
	}

	/**
	 * Method to populate associate attendance grid and set up the columns
	 * 
	 * @param associateAttendanceDTOList
	 */
	public void populateAttendanceRegisterGrid(List<AssociateAttendanceDTO> associateAttendanceDTOList) {
		getAttendanceRegisterBean().setAssociateAttendanceList(associateAttendanceDTOList);
		AssociateAttendanceDTO associateAttendanceDTO = associateAttendanceDTOList.get(0);
		List<Integer> sortedcolumnNames = new ArrayList<Integer>();
		for (String month : associateAttendanceDTO.getAttendanceMap().keySet()) {
			sortedcolumnNames.add(new Integer(month));
		}
		Collections.sort(sortedcolumnNames);
		List<String> columnNames = new ArrayList<String>();
		for (Integer columnName : sortedcolumnNames) {
			columnNames.add("" + columnName);
		}
		getAttendanceRegisterBean().setColumnNames(columnNames);
	}

	/**
	 * Method to get the ModifiedClassAttedanceDefList to persist in database by looking into the target, source list of
	 * ClassAttendanceDTOModel
	 * 
	 * @param modifiedClassAttendanceDefDTOList
	 * @return modifiedClassAttendanceDefDTOList
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public List<ClassAttendanceDefDTO> getModifiedClassAttedanceDefList() throws IllegalAccessException, InvocationTargetException {

		List<ClassAttendanceDefDTO> modifiedClassAttendanceDefDTOList = new ArrayList<ClassAttendanceDefDTO>();
		for (String monthYear : getMaintainRegisterMonthBean().getClassAttendanceDTOModel().getTarget()) {

			boolean foundMonthYear = false;
			for (ClassAttendanceDefDTO classAttendanceDefDTO : getAttendanceRegisterBean().getClassAttendanceDefDTOList()) {
				if (monthYear.equals(classAttendanceDefDTO.getMonthYear())) {
					foundMonthYear = true;
					break;
				}
			}
			if (!foundMonthYear) {
				ClassAttendanceDefDTO classAttendanceDefDTO = new ClassAttendanceDefDTO();
				classAttendanceDefDTO.setClassDTO(getCurrentClass());
				classAttendanceDefDTO.setModification(WebUtils.CLASS_DEF_MODIFICATION.Added.name());
				classAttendanceDefDTO.setMonthYear(monthYear);
				modifiedClassAttendanceDefDTOList.add(classAttendanceDefDTO);
			}
		}

		for (ClassAttendanceDefDTO classAttendanceDefDTO : getAttendanceRegisterBean().getClassAttendanceDefDTOList()) {

			boolean foundClassAttendanceDef = false;
			for (String monthYear : getMaintainRegisterMonthBean().getClassAttendanceDTOModel().getTarget()) {
				if (classAttendanceDefDTO.getMonthYear().equals(monthYear)) {
					foundClassAttendanceDef = true;
					break;
				}
			}
			if (!foundClassAttendanceDef) {
				if (getAttendanceRegisterBean().getSelectedAttendanceDefDTO().getMonthYear().equals(classAttendanceDefDTO.getMonthYear())){
					return null;
				}
				ClassAttendanceDefDTO delClassAttendanceDefDTO = new ClassAttendanceDefDTO();
				BeanUtils.copyProperties(delClassAttendanceDefDTO, classAttendanceDefDTO);
				delClassAttendanceDefDTO.setClassDTO(getCurrentClass());
				delClassAttendanceDefDTO.setModification(WebUtils.CLASS_DEF_MODIFICATION.Deleted.name());
				modifiedClassAttendanceDefDTOList.add(delClassAttendanceDefDTO);
			}
		}

		return modifiedClassAttendanceDefDTOList;
	}

	/**
	 * Method to return the associateList for persistence and it also updates the reference data like classattendancedef and teacher
	 * 
	 * @return associateAttendanceList
	 */
	public List<AssociateAttendanceDTO> retrieveAssociateAttendanceList() {
		List<AssociateAttendanceDTO> associateAttendanceDTOList = getAttendanceRegisterBean().getAssociateAttendanceList();
		for (AssociateAttendanceDTO associateAttendanceDTO : associateAttendanceDTOList) {
			ClassAttendanceDefDTO classAttendanceDefDTO = getAttendanceRegisterBean().getPreviousClassAttendanceDefDTO();
			classAttendanceDefDTO.setClassDTO(getCurrentClass());
			associateAttendanceDTO.setClassAttendanceDefDTO(classAttendanceDefDTO);
		}
		return associateAttendanceDTOList;
	}

}
