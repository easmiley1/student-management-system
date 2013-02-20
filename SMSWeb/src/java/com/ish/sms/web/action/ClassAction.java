package com.ish.sms.web.action;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;

import com.ish.sms.service.dto.AssociateAttendanceDTO;
import com.ish.sms.service.dto.ClassAttendanceDefDTO;
import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.web.bean.ClassBean;

/**
 * This class performs all the actions related to the class management pages.
 * 
 * @author Naren
 * 
 */
@ManagedBean(name = "classAction")
@RequestScoped
public class ClassAction extends BaseAction {

	private static final long serialVersionUID = 917148070535856940L;
	@ManagedProperty(value = "#{classBean}")
	private ClassBean classBean = new ClassBean();

	/**
	 * @return the classBean
	 */
	public ClassBean getClassBean() {
		return classBean;
	}

	/**
	 * @param classBean
	 *            the classBean to set
	 */
	public void setClassBean(ClassBean classBean) {
		this.classBean = classBean;
	}

	/**
	 * method to market the attendance register to dirty so that we can enable the save register button
	 */
	public void markDirty() {
		classBean.setDataSaved(false);
	}

	public void changeAttendanceMonth(AjaxBehaviorEvent ajaxBehaviorEvent) {

		try {
			if (!classBean.isDataSaved())
				saveAttendanceRegister();
			classBean.getAttendanceRegisterBean().setPreviousClassAttendanceDefDTO(classBean.getAttendanceRegisterBean().getSelectedAttendanceDefDTO());
			Integer monthId = classBean.getAttendanceRegisterBean().getSelectedAttendanceDefDTO().getId();
			List<AssociateAttendanceDTO> associateAttendanceDTOList = classBusiness.retrieveClassAttendanceForMonth(monthId);
			classBean.populateAttendanceRegisterGrid(associateAttendanceDTOList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			registerErrorMessage();
		}

	}

	/**
	 * Method to instantiate the attendance register by getting the class month list and student attendance data
	 * 
	 * @param classId
	 * @return attendancePageNavigation
	 */
	public String openAttendanceRegister(Integer classId) {

		try {
			ClassDTO classDTO = classBusiness.retrieveClassForId(classId);
			classBean.setCurrentClass(classDTO);
			List<ClassAttendanceDefDTO> targetClassAttendanceDefDTOList = classBusiness.retrieveClassAttenDefStringList(classBean.getCurrentClass().getId());
			classBean.initMaintainClassAttendanceDef(targetClassAttendanceDefDTOList);

			/* Get the month id for which we need to retrieve the associate attendance list */
			Integer monthId = classBean.getAttendanceRegisterBean().getSelectedAttendanceDefDTO().getId();
			List<AssociateAttendanceDTO> associateAttendanceDTOList = classBusiness.retrieveClassAttendanceForMonth(monthId);
			classBean.populateAttendanceRegisterGrid(associateAttendanceDTOList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			registerErrorMessage();
		}

		return MODIFY_CLASS_ATTENDANCE_PAGE;
	}

	/**
	 * Method to save the class attendance definition changes
	 */
	public void submitMaintainClassAttendanceDef() {

		try {
			List<ClassAttendanceDefDTO> modifiedClassAttendanceDefDTOList = classBean.getModifiedClassAttedanceDefList();
			if(modifiedClassAttendanceDefDTOList == null){
				registerMessage(FacesMessage.SEVERITY_WARN, CANNOT_SAVE, REGISTER_DEF_CANNOT_SAVE_DETAIL);
			}
			else if (modifiedClassAttendanceDefDTOList.size() > 0) {
				modifiedClassAttendanceDefDTOList = classBusiness.updateClassAttendanceDefList(modifiedClassAttendanceDefDTOList);
				classBean.getAttendanceRegisterBean().setClassAttendanceDefDTOList(modifiedClassAttendanceDefDTOList);
				registerMessage(FacesMessage.SEVERITY_INFO, SAVE_SUCCESSFULL, REGISTER_DEF_SAVED);
			} else {
				registerMessage(FacesMessage.SEVERITY_INFO, NO_CHANGES, NO_CHANGE_IN_REGISTER);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			registerErrorMessage();
		}
	}

	/**
	 * Method to save the attendance register for the current selected month
	 */
	public void saveAttendanceRegister() {

		try {
			List<AssociateAttendanceDTO> associateAttendanceDTOList = classBean.retrieveAssociateAttendanceList();
			associateAttendanceDTOList = classBusiness.updateAssociateAttendanceList(associateAttendanceDTOList);
			classBean.getAttendanceRegisterBean().setAssociateAttendanceList(associateAttendanceDTOList);
			String monthYear = classBean.getAttendanceRegisterBean().getPreviousClassAttendanceDefDTO().getMonthYear();
			registerMessage(FacesMessage.SEVERITY_INFO, SAVE_SUCCESSFULL, REGISTER_SAVED + monthYear);
			classBean.setDataSaved(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			registerErrorMessage();
		}
	}
}
