package com.ish.sms.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.web.util.WebConstants;
import com.ish.sms.web.util.WebUtils;

/**
 * Bean class to hold all the class promotion details in session scope.
 * 
 * @author Naren
 * 
 */

@ManagedBean(name = WebConstants.CLASS_PROMOTION_BEAN)
@SessionScoped
public class ClassPromotionBean extends BaseBean {

	private static final long serialVersionUID = 1L;
	private List<StudentDTO> selectedstudentDTOList = new ArrayList<StudentDTO>();
	private StudentDataModel studentDataModel = new StudentDataModel();
	private List<ClassDTO> classDTOList = new ArrayList<ClassDTO>();
	private ClassDTO selectedClassDTO = new ClassDTO();
	private String toClass = new String();
	private String promotionYear = new String();
	
	
	/**
	 * @return the promotionYear
	 */
	public String getPromotionYear() {
		return promotionYear;
	}

	/**
	 * @param promotionYear the promotionYear to set
	 */
	public void setPromotionYear(String promotionYear) {
		this.promotionYear = promotionYear;
	}

	/**
	 * @return the toClass
	 */
	public String getToClass() {
		return toClass;
	}

	/**
	 * @param toClass the toClass to set
	 */
	public void setToClass(String toClass) {
		this.toClass = toClass;
	}

	/**
	 * @param classDTOList
	 *            the classDTOList to set
	 */
	public void setClassDTOList(List<ClassDTO> classDTOList) {
		this.classDTOList = classDTOList;
	}

	/**
	 * @return the selectedClassDTO
	 */
	public ClassDTO getSelectedClassDTO() {
		return selectedClassDTO;
	}
	/**
	 * @return the classDTOList
	 */
	public List<ClassDTO> getClassDTOList() {
		return classDTOList;
	}


	/**
	 * @param selectedClassDTO
	 *            the selectedClassDTO to set
	 */
	public void setSelectedClassDTO(ClassDTO selectedClassDTO) {
		this.selectedClassDTO = selectedClassDTO;
	}	

	/**
	 * @return the studentDataModel
	 */
	public StudentDataModel getStudentDataModel() {
		return studentDataModel;
	}

	/**
	 * @param studentDataModel the studentDataModel to set
	 */
	public void setStudentDataModel(StudentDataModel studentDataModel) {
		this.studentDataModel = studentDataModel;
	}

	/**
	 * @return the selectedstudentDTOList
	 */
	public List<StudentDTO> getSelectedstudentDTOList() {
		return selectedstudentDTOList;
	}

	/**
	 * @param selectedstudentDTOList the selectedstudentDTOList to set
	 */
	public void setSelectedstudentDTOList(List<StudentDTO> selectedstudentDTOList) {
		this.selectedstudentDTOList = selectedstudentDTOList;
	}
	
	/**
	 * Method to set the selected class details
	 * 
	 * @param userBean
	 * @return validation
	 */
	public boolean setClassDetails(List<ClassDTO> classDTOList) {

		if (classDTOList == null || classDTOList.size() == 0) {
			WebUtils.registerMessage(FacesMessage.SEVERITY_WARN, AUTH_ERROR, CLASS_DETAILS_NOT_FOUND);
			return false;
		} else {
			setClassDTOList(classDTOList);
			setSelectedClassDTO(classDTOList.get(0));
			return true;
		}
	}	
}
