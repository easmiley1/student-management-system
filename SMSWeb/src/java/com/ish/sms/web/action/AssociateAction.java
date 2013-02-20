package com.ish.sms.web.action;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

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
	 */
	public String initAddStudentPersonalDetails() {
		associateBean.initAddStudentPersonalDetails();

		return SAVE_STUDENT_PAGE;
	}

	/**
	 * Method to initialize the DTO's and redirect the page to student.xhtml
	 * 
	 * @return student.xhtml
	 */
	public String initAddTeacherPersonalDetails()  {
		associateBean.initAddTeacherPersonalDetails();
		return SAVE_TEACHER_PAGE;
	}

	/**
	 * Method to return the list of all the students in the school for modification and redirect to the appropriate xhtml page
	 * 
	 * @return modifyStudentDetailsGridPage.xhtml
	 */
	public String initModifySearchAllStudents() {
		try {
			associateBean.initModifySearchAllStudents(associateBusiness.retrieveAllStudents());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			registerErrorMessage();
		}
		return MODIFY_STUDENT_LIST_PAGE;
	}

	/**
	 * Method to return the list of all the students in the school for viewing and redirect to the appropriate page
	 * 
	 * @return viewStudentDetailsGridPage.xhtml
	 */
	public String initViewSearchAllStudents()  {
		try {
			associateBean.initModifySearchAllStudents(associateBusiness.retrieveAllStudents());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			registerErrorMessage();
		}
		return VIEW_STUDENT_LIST_PAGE;
	}

	/**
	 * Method to return the list of all the teachers in the school for modification and redirect to the appropriate xhtml page
	 * 
	 * @return modifyTeacherDetailsGridPage.xhtml
	 */
	public String initModifySearchAllTeachers()  {
		try {
			associateBean.initModifySearchAllTeacers(associateBusiness.retrieveAllTeachers());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			registerErrorMessage();
		}
		return MODIFY_TEACHER_LIST_PAGE;
	}

	/**
	 * Method to return the list of all the teachers in the school for viewing and redirect to the appropriate page
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initViewSearchAllTeachers()  {
		try {
			associateBean.initModifySearchAllTeacers(associateBusiness.retrieveAllTeachers());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			registerErrorMessage();
		}
		return VIEW_TEACHER_LIST_PAGE;
	}

	/**
	 * Method to save the student object
	 * 
	 */
	public void saveStudent() {
		try {
			associateBusiness.saveStudent(associateBean.getStudentDTO(), associateBean.getAssociateDTO());
			registerMessage(FacesMessage.SEVERITY_INFO, "Success", "Student Succcessfully Saved");
		} catch (Exception e) {
			e.printStackTrace();
			registerErrorMessage();

		}
	}

	/**
	 * Method to save the student object
	 * 
	 */
	public void saveTeacher()  {
		try {
			associateBusiness.saveTeacher(associateBean.getTeacherDTO(), associateBean.getAssociateDTO());
			registerMessage(FacesMessage.SEVERITY_INFO, "Success", "Teacher Succcessfully Saved");
		} catch (Exception e) {
			e.printStackTrace();			
			registerErrorMessage();
		}
	}

	/**
	 * Set the selected student in the grid to the selection model for editing by setting readonlymode to false
	 * 
	 */
	public void applyStudentSelectionForEdit()  {
		associateBean.setReadOnlyMode(false);
		try {
			associateBean.applyStudentSelection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			registerErrorMessage();
		}
	}

	/**
	 * Set the selected student in the grid to the selection model for viewing by setting readonlymode to true
	 * 
	 */
	public void applyStudentSelectionForView() {
		associateBean.setReadOnlyMode(true);
		try {
			associateBean.applyStudentSelection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			registerErrorMessage();
		}
	}

	/**
	 * Set the selected teacher in the grid to the selection model for editing by setting readonlymode to false
	 * 
	 */
	public void applyTeacherSelectionForEdit()  {
		associateBean.setReadOnlyMode(false);
		try {
			associateBean.applyTeacherSelection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			registerErrorMessage();
		}
	}

	/**
	 * Set the selected teacher in the grid to the selection model for viewing by setting readonlymode to true
	 * 
	 */
	public void applyTeacherSelectionForView() {
		associateBean.setReadOnlyMode(true);
		try {
			associateBean.applyTeacherSelection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			registerErrorMessage();
		}
	}

}
