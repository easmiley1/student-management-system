package com.ish.sms.web.action;

import com.ish.sms.service.dto.ReferenceDataDTO;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DualListModel;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.web.bean.ClassBean;
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

	public void saveClassDetails() {
		try {
			DualListModel<ReferenceDataDTO> examDTODualListModel = classBean.getExamDTODualListModel();
			DualListModel<ReferenceDataDTO> subjectDTODualListModel = classBean.getSubjectDTODualListModel();
			classBean.getClassDTO().setClassExamReferenceDataDTOList(
					classBean.getModifiedClassReferenceDataList(examDTODualListModel, classBean.getClassDTO().getClassExamReferenceDataDTOList()));

			classBean.getClassDTO().setClassSubjectReferenceDataDTOList(
					classBean.getModifiedClassReferenceDataList(subjectDTODualListModel, classBean.getClassDTO().getClassSubjectReferenceDataDTOList()));
			ClassDTO classDTO = classBusiness.saveClass(classBean.getClassDTO());
			classBean.setClassDTO(classDTO);
			classBean.populateClassDetailGrids();
			WebUtils.registerMessage(FacesMessage.SEVERITY_INFO, SAVE_SUCCESSFULL, CLASS_SAVED_SUCCESSFULLY);
		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}
	}
}
