package com.ish.sms.web.action;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ish.sms.web.bean.AssociateBean;

/**
 * Action Bean class which is in request scope for all the associate related actions.
 *
 * @author Naren
 */
@ManagedBean(name = "associateAction")
@ViewScoped
public class AssociateAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{associateBean}")
	private AssociateBean associateBean;

	/**
	 * @return associateBean
	 */
	public AssociateBean getAssociateBean() {
		return associateBean;
	}

	/**
	 * @param associateBean
	 */
	public void setAssociateBean(AssociateBean associateBean) {
		this.associateBean = associateBean;
	}

	/**
	 * Method to initialize the DTO's and redirect the page to student.xhtml
	 * 
	 * @return student.xhtml
	 * @throws Exception
	 */
	public String initAddStudentPersonalDetails() throws Exception {
		associateBean.initAddStudentPersonalDetails();

		return SAVE_STUDENT_PAGE;
	}

	/**
	 * Method to initialize the DTO's and redirect the page to student.xhtml
	 * 
	 * @return student.xhtml
	 * @throws Exception
	 */
	public String initAddTeacherPersonalDetails() throws Exception {
		associateBean.initAddTeacherPersonalDetails();
		return SAVE_TEACHER_PAGE;
	}

	/**
	 * Method to return the list of all the students in the school for modification and redirect to the appropriate xhtml page
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initModifySearchAllStudents() throws Exception {
		associateBean.initModifySearchAllStudents(associateBusiness.retrieveAllStudents());
		return MODIFY_STUDENT_LIST_PAGE;
	}

	/**
	 * Method to return the list of all the students in the school for viewing and redirect to the appropriate page
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initViewSearchAllStudents() throws Exception {
		associateBean.initModifySearchAllStudents(associateBusiness.retrieveAllStudents());
		return VIEW_STUDENT_LIST_PAGE;
	}

	/**
	 * Method to return the list of all the teachers in the school for modification and redirect to the appropriate xhtml page
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initModifySearchAllTeachers() throws Exception {
		associateBean.initModifySearchAllTeacers(associateBusiness.retrieveAllTeachers());
		return MODIFY_TEACHER_LIST_PAGE;
	}

	/**
	 * Method to return the list of all the teachers in the school for viewing and redirect to the appropriate page
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initViewSearchAllTeachers() throws Exception {
		associateBean.initModifySearchAllTeacers(associateBusiness.retrieveAllTeachers());
		return VIEW_TEACHER_LIST_PAGE;
	}

	/**
	 * Method to save the student object
	 * 
	 * @throws Exception
	 */
	public void saveStudent() throws Exception {
		associateBusiness.saveStudent(associateBean.getStudentDTO(), associateBean.getAssociateDTO());
	}

	/**
	 * Method to save the student object
	 * 
	 */
	public void saveTeacher()  {
		try {
			associateBusiness.saveTeacher(associateBean.getTeacherDTO(), associateBean.getAssociateDTO());
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Save Failed", "Server Error. Please contact Technical Support"));

		}
	}

	/**
	 * Set the selected student in the grid to the selection model for editing by setting readonlymode to false
	 * 
	 * @throws Exception
	 */
	public void applyStudentSelectionForEdit() throws Exception {
		associateBean.setReadOnlyMode(false);
		associateBean.applyStudentSelection();
	}

	/**
	 * Set the selected student in the grid to the selection model for viewing by setting readonlymode to true
	 * 
	 * @throws Exception
	 */
	public void applyStudentSelectionForView() throws Exception {
		associateBean.setReadOnlyMode(true);
		associateBean.applyStudentSelection();
	}

	/**
	 * Set the selected teacher in the grid to the selection model for editing by setting readonlymode to false
	 * 
	 * @throws Exception
	 */
	public void applyTeacherSelectionForEdit() throws Exception {
		associateBean.setReadOnlyMode(false);
		associateBean.applyTeacherSelection();
	}

	/**
	 * Set the selected teacher in the grid to the selection model for viewing by setting readonlymode to true
	 * 
	 * @throws Exception
	 */
	public void applyTeacherSelectionForView() throws Exception {
		associateBean.setReadOnlyMode(true);
		associateBean.applyTeacherSelection();
	}

}
