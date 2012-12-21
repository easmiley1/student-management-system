package com.ish.sms.web.action;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ish.sms.service.dto.AssociateDTO;
import com.ish.sms.service.dto.ObjectFactory;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.web.business.AssociateBusiness;
import com.ish.sms.web.util.SMSSpringFactory;

/**
 * Managed bean class for all the associate related actions.
 * 
 */
@ManagedBean(name = "associateAction")
@RequestScoped
public class AssociateAction extends BaseAction {
 
	private AssociateDTO associateDTO = new AssociateDTO();
	private StudentDTO studentDTO = new StudentDTO();
	private ObjectFactory objfactory = new ObjectFactory();
	private AssociateBusiness saveBusiness;

	/**
	 * Constructor to initialize the business class.
	 */
	public AssociateAction() {
		saveBusiness = (AssociateBusiness) SMSSpringFactory.getInstance().getBean("associateBusiness");
	}

	/**
	 * @return studentDTO
	 */
	public StudentDTO getStudentDTO() {
		return studentDTO;
	}

	/**
	 * @return associateDTO
	 */
	public AssociateDTO getAssociateDTO() {
		return associateDTO;
	}

	/**
	 * @param associateDTO
	 */
	public void setAssociateDTO(AssociateDTO associateDTO) {
		this.associateDTO = associateDTO;
	}

	/**
	 * @param studentDTO
	 */
	public void setStudentDTO(StudentDTO studentDTO) {
		this.studentDTO = studentDTO;
	}

	/**
	 * Method to initialize the DTO's and redirect the page to student.xhtml
	 * 
	 * @return student.xhtml
	 */
	public String initAddStudentAction() {
		associateDTO = objfactory.createAssociateDTO();
		associateDTO.setGender(DEFAULT_GENDER);
		return SAVE_STUDENT_PAGE;
	}

	/**
	 * Method to save the student object
	 * 
	 * @throws Exception
	 */
	public void saveStudent() throws Exception {
		saveBusiness.saveStudent(studentDTO, associateDTO);
	}

}
