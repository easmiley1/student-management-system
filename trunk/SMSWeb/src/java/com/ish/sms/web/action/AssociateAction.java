package com.ish.sms.web.action;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.ish.sms.web.bean.AssociateBean;
import com.ish.sms.web.business.AssociateBusiness;
import com.ish.sms.web.util.SMSSpringFactory;

/**
 * Managed bean class for all the associate related actions.
 * 
 */
@ManagedBean(name = "associateAction")
@RequestScoped
public class AssociateAction extends BaseAction {
 
	private AssociateBusiness associateBusiness;
	@ManagedProperty(value="#{associateBean}")
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
	 * Constructor to initialize the business class.
	 */
	public AssociateAction() {
		associateBusiness = (AssociateBusiness) SMSSpringFactory.getInstance().getBean("associateBusiness");
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
	public String initViewSearchAllStudents() throws Exception{
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
	public String initViewSearchAllTeachers() throws Exception{
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
	 * @throws Exception
	 */
	public void saveTeacher() throws Exception {
		associateBusiness.saveTeacher(associateBean.getTeacherDTO(), associateBean.getAssociateDTO());
	}

	/**
	 * Set the selected student in the grid to the selection model for editing by setting readonlymode to false
	 * 
	 * @throws Exception
	 */
	public void applyStudentSelectionForEdit() throws Exception{
		associateBean.setReadOnlyMode(false);
		associateBean.applyStudentSelection();
	}

	/**
	 * Set the selected student in the grid to the selection model for viewing by setting readonlymode to true
	 * 
	 * @throws Exception
	 */
	public void applyStudentSelectionForView() throws Exception{
		associateBean.setReadOnlyMode(true);
		associateBean.applyStudentSelection();
	}

	/**
	 * Set the selected teacher in the grid to the selection model for editing by setting readonlymode to false
	 * 
	 * @throws Exception
	 */
	public void applyTeacherSelectionForEdit() throws Exception{
		associateBean.setReadOnlyMode(false);
		associateBean.applyStudentSelection();
	}

	/**
	 * Set the selected teacher in the grid to the selection model for viewing by setting readonlymode to true
	 * 
	 * @throws Exception
	 */
	public void applyTeacherSelectionForView() throws Exception{
		associateBean.setReadOnlyMode(true);
		associateBean.applyStudentSelection();
	}

}
