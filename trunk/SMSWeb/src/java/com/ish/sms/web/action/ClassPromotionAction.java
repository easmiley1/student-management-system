package com.ish.sms.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.web.bean.ClassPromotionBean;
import com.ish.sms.web.bean.StudentDataModel;
import com.ish.sms.web.bean.UserBean;
import com.ish.sms.web.util.WebUtils;

/**
 * Action Bean class which is in view scope for all the class promotion related actions.
 * 
 * @author Naren
 */

@ManagedBean(name = "classPromotionAction")
@ViewScoped
public class ClassPromotionAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{classPromotionBean}")
	private ClassPromotionBean classPromotionBean;

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
	 * @return the classPromotionBean
	 */
	public ClassPromotionBean getClassPromotionBean() {
		return classPromotionBean;
	}

	/**
	 * @param classPromotionBean the classPromotionBean to set
	 */
	public void setClassPromotionBean(ClassPromotionBean classPromotionBean) {
		this.classPromotionBean = classPromotionBean;
	}

	/**
	 * Method to set the class details and student details combo boxes
	 * 
	 * @return attendanceReport.xhtml
	 */
	public String initClassPromotion() {

		try {

			if (!classPromotionBean.setClassDetails(userBean)) {
				return CLASS_PROMOTION_PAGE;
			} else {
				setStudentDetails();
			}

		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}

		return CLASS_PROMOTION_PAGE;
	}

	
	/**
	 * Method to retrieve the student details for the specified class and set them in the bean
	 * 
	 * @throws Exception
	 */
	private void setStudentDetails() throws Exception {

		List<String> classIdList = new ArrayList<String>();
		classIdList.add("" + classPromotionBean.getSelectedClassDTO().getId());
		List<StudentDTO> studentDTOList = associateBusiness.retrieveAllStudents(classIdList);
		StudentDataModel studentDataModel = new StudentDataModel(studentDTOList);
		classPromotionBean.setStudentDataModel(studentDataModel);
		classPromotionBean.setSelectedstudentDTOList(new ArrayList<StudentDTO>());
	}

	/**
	 * Method to handle class change and set the student list for the new class
	 * 
	 * @param ajaxBehaviorEvent
	 */
	public void changeClass(AjaxBehaviorEvent ajaxBehaviorEvent) {

		try {
			setStudentDetails();
		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}
	}

}
