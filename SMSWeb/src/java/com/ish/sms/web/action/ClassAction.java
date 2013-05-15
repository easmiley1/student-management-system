package com.ish.sms.web.action;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FlowEvent;
import org.primefaces.model.DualListModel;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ReferenceDataDTO;
import com.ish.sms.web.bean.ClassBean;
import com.ish.sms.web.bean.UserBean;
import com.ish.sms.web.util.WebUtils;

/**
 * Action Bean class which is in request scope for all the associate related actions.
 * 
 * @author Naren
 */
@ManagedBean(name = "classAction")
@ViewScoped
public class ClassAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{classBean}")
	private ClassBean classBean;

	@ManagedProperty(value = "#{userBean}")
	private UserBean userBean;

	/**
	 * @return the userBean
	 */
	public UserBean getUserBean() {
		return userBean;
	}

	/**
	 * @param userBean
	 *            the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

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

	public String initAddClassDetails() {
		classBean.createDefaultClass();
		return SAVE_CLASS_PAGE;
	}

	/**
	 * Method to get the list of all classes to be displayed in the grid
	 * 
	 * @return
	 */
	public String initEditSearchClass() {
		List<ClassDTO> classDTOList = userBean.getUserDetailsDTO().getClassListDTO().getClassDTOList();
		classBean.setClassDTOList(classDTOList);
		return MODIFY_CLASS_LIST_PAGE;
	}

	/**
	 * Method to apply the selected class details in the grids
	 */
	public void applySelectedClassDetails() {
		classBean.populateClassDetailGrids();
	}

	/**
	 * Get the details of the selected class to be displayed and modified
	 * 
	 * @param classId
	 * @return saveClassDetails.xhtml
	 */
	public String openClassDetails(Integer classId) {
		try {
			ClassDTO classDTO = classBusiness.retrieveClassForId(classId);
			classBean.setClassDTO(classDTO);
			classBean.populateClassDetailGrids();
		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}
		return SAVE_CLASS_PAGE;
	}

	/**
	 * Get the details of the selected class to be displayed and modified and populate the timetable grid
	 * 
	 * @param classId
	 * @return saveClassDetails.xhtml
	 */
	public String openClassTimeTable(Integer classId) {
		try {
			ClassDTO classDTO = classBusiness.retrieveClassForId(classId);
			classBean.setClassDTO(classDTO);
			classBean.populateClassDetailGrids();
			if (classDTO.getClassTimeTableDTOList() == null || classDTO.getClassTimeTableDTOList().size() == 0) {
				classBean.createDefaultTimeTable();
			} else {
				classBean.populateTimeTableGrid();
			}
		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}
		return MODIFY_CLASS_TIME_TABLE;
	}

	/**
	 * Save the class details
	 */
	public void saveClassDetails() {
		try {
			if (classBean.getSelectedClassSubjectReferenceDataDTOList() == null || classBean.getSelectedClassSubjectReferenceDataDTOList().size() == 0) {
				WebUtils.registerMessage(FacesMessage.SEVERITY_ERROR, CANNOT_SAVE, "Please select atleast one subject");
				return;
			}
			DualListModel<ReferenceDataDTO> examDTODualListModel = classBean.getExamDTODualListModel();
			classBean.getClassDTO().setClassExamReferenceDataDTOList(
					classBean.getModifiedClassExamReferenceDataList(examDTODualListModel, classBean.getClassDTO().getClassExamReferenceDataDTOList()));
			classBean.getClassDTO().setClassSubjectReferenceDataDTOList(classBean.getSelectedClassSubjectReferenceDataDTOList());
			ClassDTO classDTO = classBusiness.saveClass(classBean.getClassDTO());
			classBean.setClassDTO(classDTO);
			classBean.populateClassDetailGrids();
			classBean.populateTimeTableGrid();
			WebUtils.registerMessage(FacesMessage.SEVERITY_INFO, SAVE_SUCCESSFULL, CLASS_SAVED_SUCCESSFULLY);
		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}
	}

	public String onFlowProcess(FlowEvent event) {
		return "confirm";
	}
}
