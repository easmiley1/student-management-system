package com.ish.sms.web.bean;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.ish.sms.service.dto.ClassAttendanceDefDTO;
import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.web.util.WebUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.beanutils.BeanUtils;

@ManagedBean(name = "classBean")
@SessionScoped
public class ClassBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ClassDTO currentClass = new ClassDTO();

	private AttendanceRegisterBean attendanceRegisterBean = new AttendanceRegisterBean();

	private MaintainRegisterMonthBean maintainRegisterMonthBean = new MaintainRegisterMonthBean();

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
	public void initMaintainClassAttendanceDef(List<ClassAttendanceDefDTO> targetClassAttendanceDefDTOList) {
		getAttendanceRegisterBean().setClassAttendanceDefDTOList(targetClassAttendanceDefDTOList);
		List<String> sourceList = WebUtils.getAttendanceMonthDefinition();
		List<String> targetList = new ArrayList<String>();

		for (ClassAttendanceDefDTO classAttendanceDefDTO : targetClassAttendanceDefDTOList) {
			targetList.add(classAttendanceDefDTO.getMonthYear());
		}

		sourceList.removeAll(targetList);
		getMaintainRegisterMonthBean().getClassAttendanceDTOModel().setSource(sourceList);
		getMaintainRegisterMonthBean().getClassAttendanceDTOModel().setTarget(targetList);
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
				ClassAttendanceDefDTO delClassAttendanceDefDTO = new ClassAttendanceDefDTO();
				BeanUtils.copyProperties(delClassAttendanceDefDTO, classAttendanceDefDTO);
				delClassAttendanceDefDTO.setClassDTO(getCurrentClass());
				delClassAttendanceDefDTO.setModification(WebUtils.CLASS_DEF_MODIFICATION.Deleted.name());
				modifiedClassAttendanceDefDTOList.add(delClassAttendanceDefDTO);
			}
		}
		
		return modifiedClassAttendanceDefDTOList;
	}
}
