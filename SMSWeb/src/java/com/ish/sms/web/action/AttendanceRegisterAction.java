package com.ish.sms.web.action;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import com.ish.sms.service.dto.AssociateAttendanceDTO;
import com.ish.sms.service.dto.ClassAttendanceDefDTO;
import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.web.bean.ClassAttendanceBean;
import com.ish.sms.web.util.WebUtils;

/**
 * This class performs all the actions related to the class management pages.
 * 
 * @author Naren
 * 
 */
@ManagedBean(name = "attendanceRegisterAction")
@ViewScoped
public class AttendanceRegisterAction extends BaseAction {

	private static final long serialVersionUID = 917148070535856940L;
	@ManagedProperty(value = "#{classAttendanceBean}")
	private ClassAttendanceBean classAttendanceBean = new ClassAttendanceBean();

	/**
	 * @return the classAttendanceBean
	 */
	public ClassAttendanceBean getClassAttendanceBean() {
		return classAttendanceBean;
	}

	/**
	 * @param classAttendanceBean
	 *            the classAttendanceBean to set
	 */
	public void setClassAttendanceBean(ClassAttendanceBean classAttendanceBean) {
		this.classAttendanceBean = classAttendanceBean;
	}

	/**
	 * method to market the attendance register to dirty so that we can enable the save register button
	 */
	public void markDirty() {
		classAttendanceBean.getAttendanceRegisterBean().setDataSaved(false);
	}

	public void changeAttendanceMonth(AjaxBehaviorEvent ajaxBehaviorEvent) {

		try {
			if (!classAttendanceBean.getAttendanceRegisterBean().isDataSaved())
				saveAttendanceRegister();
			classAttendanceBean.getAttendanceRegisterBean().setPreviousClassAttendanceDefDTO(
					classAttendanceBean.getAttendanceRegisterBean().getSelectedAttendanceDefDTO());
			Integer monthId = classAttendanceBean.getAttendanceRegisterBean().getSelectedAttendanceDefDTO().getId();
			List<AssociateAttendanceDTO> associateAttendanceDTOList = classAttendanceBusiness.retrieveClassAttendanceForMonth(monthId);
			classAttendanceBean.populateAttendanceRegisterGrid(associateAttendanceDTOList);
		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
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
			classAttendanceBean.setCurrentClass(classDTO);
			List<ClassAttendanceDefDTO> targetClassAttendanceDefDTOList = classAttendanceBusiness.retrieveClassAttenDefStringList(classAttendanceBean
					.getCurrentClass().getId());
			classAttendanceBean.initMaintainClassAttendanceDef(targetClassAttendanceDefDTOList, true);

			/* Get the month id for which we need to retrieve the associate attendance list */
			Integer monthId = classAttendanceBean.getAttendanceRegisterBean().getSelectedAttendanceDefDTO().getId();
			List<AssociateAttendanceDTO> associateAttendanceDTOList = classAttendanceBusiness.retrieveClassAttendanceForMonth(monthId);
			classAttendanceBean.populateAttendanceRegisterGrid(associateAttendanceDTOList);
		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}

		return MODIFY_CLASS_ATTENDANCE_PAGE;
	}

	/**
	 * Method to save the class attendance definition changes
	 */
	public void submitMaintainClassAttendanceDef() {

		try {
			List<ClassAttendanceDefDTO> modifiedClassAttendanceDefDTOList = classAttendanceBean.getModifiedClassAttedanceDefList();
			if (modifiedClassAttendanceDefDTOList == null) {
				WebUtils.registerMessage(FacesMessage.SEVERITY_WARN, CANNOT_SAVE, REGISTER_DEF_CANNOT_SAVE_DETAIL);
				classAttendanceBean.initMaintainClassAttendanceDef(classAttendanceBean.getAttendanceRegisterBean().getClassAttendanceDefDTOList(), false);
			} else if (modifiedClassAttendanceDefDTOList.size() > 0) {
				modifiedClassAttendanceDefDTOList = classAttendanceBusiness.updateClassAttendanceDefList(modifiedClassAttendanceDefDTOList);
				classAttendanceBean.getAttendanceRegisterBean().setClassAttendanceDefDTOList(modifiedClassAttendanceDefDTOList);
				WebUtils.registerMessage(FacesMessage.SEVERITY_INFO, SAVE_SUCCESSFULL, REGISTER_DEF_SAVED);
			} else {
				WebUtils.registerMessage(FacesMessage.SEVERITY_INFO, NO_CHANGES, NO_CHANGE_IN_REGISTER);
			}
		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}
	}

	/**
	 * Method to save the attendance register for the current selected month
	 */
	public void saveAttendanceRegister() {

		try {
			List<AssociateAttendanceDTO> associateAttendanceDTOList = classAttendanceBean.retrieveAssociateAttendanceList();
			associateAttendanceDTOList = classAttendanceBusiness.updateAssociateAttendanceList(associateAttendanceDTOList);
			classAttendanceBean.populatePersistedParamInBeanAndSendMessage(associateAttendanceDTOList);
		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}
	}
}
