package com.ish.sms.web.action;

import com.ish.sms.service.dto.ClassSubjectReferenceDataDTO;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassReferenceDataDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.web.bean.ClassGradeBean;
import com.ish.sms.web.bean.StudentGradeBean;
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
	 * method to market the grade book to dirty so that we can enable the save register button
	 */
	public void markDirty() {
		classGradeBean.setDataSaved(false);
	}

	public String openClassGradePage(Integer classId) {

		try {
			ClassDTO classDTO = classBusiness.retrieveClassForId(classId);
			classGradeBean.setSelectedClassDTO(classDTO);
			classGradeBean.setClassExamReferenceDataDTOList(classDTO.getClassExamReferenceDataDTOList());
			classGradeBean.setSelectedClassExamReferenceDataDTO(classDTO.getClassExamReferenceDataDTOList().get(0));
			
			
			List<String> classIdList = new ArrayList<String>();
			classIdList.add("" + classGradeBean.getSelectedClassDTO().getId());
			List<StudentDTO> studentDTOList = associateBusiness.retrieveAllStudents(classIdList);
			List<StudentGradeBean> studentGradeList = new ArrayList<StudentGradeBean>();

			for (StudentDTO studentDTO : studentDTOList) {
				StudentGradeBean studentGradeBean = new StudentGradeBean();
				studentGradeBean.setStudentDTO(studentDTO);
				for (ClassSubjectReferenceDataDTO classSubjectReferenceDTO : classGradeBean.getSelectedClassDTO().getClassSubjectReferenceDataDTOList()) {
					studentGradeBean.getStudentGradeMap().put(classSubjectReferenceDTO, null);
				}
				studentGradeList.add(studentGradeBean);
			}

			classGradeBean.setStudentGradeList(studentGradeList);
			classGradeBean.getColumnNames().clear();

			for (ClassReferenceDataDTO classSubjectReferenceDTO : classGradeBean.getStudentGradeList().get(0).getStudentGradeMap().keySet()) {
				classGradeBean.getColumnNames().add(classSubjectReferenceDTO.getReferenceDataDTO().getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}
		return SAVE_CLASS_GRADE_PAGE;
	}

	public void saveGradeBook() {
		System.out.println("save grade book");
	}

	public void changeExam(AjaxBehaviorEvent ajaxBehaviorEvent) {
		System.out.println("change Exam");
	}
}
