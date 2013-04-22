package com.ish.sms.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassGradeDetailsDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.service.dto.StudentGradeDTO;
import com.ish.sms.service.dto.StudentGradeListDTO;
import com.ish.sms.web.bean.ClassGradeBean;
import com.ish.sms.web.util.WebUtils;

/**
 * Action Bean class which is in request scope for all the class grade related actions.
 * 
 * @author Naren
 */

@ManagedBean(name = "classGradeAction")
@ViewScoped
public class ClassGradeAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{classGradeBean}")
	private ClassGradeBean classGradeBean;

	/**
	 * @return the classGradeBean
	 */
	public ClassGradeBean getClassGradeBean() {
		return classGradeBean;
	}

	/**
	 * @param classGradeBean
	 *            the classGradeBean to set
	 */
	public void setClassGradeBean(ClassGradeBean classGradeBean) {
		this.classGradeBean = classGradeBean;
	}

	/**
	 * method to market the attendance register to dirty so that we can enable the save register button
	 */
	public void markDirty() {
		classGradeBean.setDataSaved(false);
	}

	/**
	 * Method to populate the student Grade details grid from database and if it is empty create
	 * 
	 * @param classId
	 * @return saveClassGrade.xhtml
	 */
	public String openClassGradePage(Integer classId) {

		try {
			classGradeBean.setDataSaved(true);
			ClassDTO classDTO = classBusiness.retrieveClassForId(classId);
			if (!classGradeBean.setExamAndSubjectClassDetails(classDTO)) {
				return SAVE_CLASS_GRADE_PAGE;
			} else {
				getClassGradeDetails();
			}
		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}
		return SAVE_CLASS_GRADE_PAGE;
	}

	/**
	 * Method to call the smsclass Service get the class grade details else create default grade details
	 * 
	 * @param classId
	 * @throws Exception
	 */
	private void getClassGradeDetails() throws Exception {
		
		List<StudentGradeDTO> studentGradeDTOList = classBusiness.retrieveClassGradeDetails(classGradeBean.getSelectedClassDTO().getId(), classGradeBean
				.getSelectedClassExamReferenceDataDTO().getId());
		/* If the student grade list is null for the selected exam that means there is no data for the exam, create default data */
		if (studentGradeDTOList == null || studentGradeDTOList.size() == 0)
			populateDefaultClassGradeDetailsGrid();
		else
			classGradeBean.setStudentGradeDTOList(studentGradeDTOList);
	}

	/**
	 * Save the grade details and update the persisted data in the grid
	 */
	public void saveGradeBook() {

		StudentGradeListDTO studentGradeListDTO;
		ClassGradeDetailsDTO classGradeDetailsDTO = classGradeBean.prepareToSaveGradeBook();
		try {
			studentGradeListDTO = classBusiness.saveClassGradeDetails(classGradeDetailsDTO);
			classGradeBean.setStudentGradeDTOList(studentGradeListDTO.getStudentGradeDTOList());
			WebUtils.registerMessage(FacesMessage.SEVERITY_INFO, SAVE_SUCCESSFULL, GRADE_DETAILS_SAVED
					+ classGradeBean.getPreviousClassExamReferenceDataDTO().getReferenceDataDTO().getName());
			classGradeBean.setPreviousClassExamReferenceDataDTO(classGradeBean.getSelectedClassExamReferenceDataDTO());
			classGradeBean.setDataSaved(true);
		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}

	}

	/**
	 * Method to listen the exam change event and set the appropriate student grade list.
	 * 
	 * @param ajaxBehaviorEvent
	 */
	public void changeExam(AjaxBehaviorEvent ajaxBehaviorEvent) {
		try {
			if (!classGradeBean.isDataSaved())
				saveGradeBook();
			getClassGradeDetails();
		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}
	}

	/**
	 * Method to get the appropriate student list for the selected exam and if student list is empty, create default student grade list
	 * 
	 * @throws Exception
	 */
	private void populateDefaultClassGradeDetailsGrid() throws Exception {

		List<String> classIdList = new ArrayList<String>();
		classIdList.add("" + classGradeBean.getSelectedClassDTO().getId());
		List<StudentDTO> studentDTOList = associateBusiness.retrieveAllStudents(classIdList);
		classGradeBean.populateDefaultClassGradeDetailsGrid(studentDTOList);
	}
}
