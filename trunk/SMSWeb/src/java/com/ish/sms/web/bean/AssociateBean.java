package com.ish.sms.web.bean;

import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.beanutils.BeanUtils;
import org.jboss.cache.CacheException;

import com.ish.sms.service.dto.AssociateDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.web.util.WebConstants;

@ManagedBean(name = "associateBean")
@SessionScoped
public class AssociateBean extends BaseBean implements WebConstants {

	private static final long serialVersionUID = 1L;
	private AssociateDTO associateDTO;
	private StudentDTO studentDTO;
	private List<StudentDTO> studentDTOList;
	private Collection<Object> selectedStudent;
	private boolean readOnlyMode;

	/**
	 * @return the readOnlyMode
	 */
	public boolean isReadOnlyMode() {
		return readOnlyMode;
	}

	/**
	 * @param readOnlyMode the readOnlyMode to set
	 */
	public void setReadOnlyMode(boolean readOnlyMode) {
		this.readOnlyMode = readOnlyMode;
	}

	/**
	 * @return the selectedStudent
	 */
	public Collection<Object> getSelectedStudent() {
		return selectedStudent;
	}

	/**
	 * @param selectedStudent
	 *            the selectedStudent to set
	 */
	public void setSelectedStudent(Collection<Object> selectedStudent) {
		this.selectedStudent = selectedStudent;
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
	 * @return studentDTOList
	 */
	public List<StudentDTO> getStudentDTOList() {
		return studentDTOList;
	}

	/**
	 * @param studentDTOList
	 */
	public void setStudentDTOList(List<StudentDTO> studentDTOList) {
		this.studentDTOList = studentDTOList;
	}

	/**
	 * Method to initialize the DTO's for new student Action
	 * 
	 * @return student.xhtml
	 * @throws CacheException 
	 */
	public void initAddStudentPersonalDetails() throws CacheException {
		setReadOnlyMode(false);
		setAssociateDTO(objfactory.createAssociateDTO());
		associateDTO.setGender(DEFAULT_GENDER);
		setStudentDTO(objfactory.createStudentDTO());
	}

	/**
	 * Set the selected student in the grid to the selection model
	 * 
	 * @throws Exception
	 */
	public void applyStudentSelection() throws Exception {
		
		Integer selectedStudentPos = (Integer) selectedStudent.toArray()[0];
		setStudentDTO(studentDTOList.get(selectedStudentPos));
		setAssociateDTO(objfactory.createAssociateDTO());
		BeanUtils.copyProperties(associateDTO, studentDTO);
	}

	/**
	 * Method to initialize the DTO's for Grid display
	 * 
	 * @param studentDTOList
	 */
	public void initModifySearchAllStudents(List<StudentDTO> studentDTOList){
		setStudentDTO(new StudentDTO());
		setStudentDTOList(studentDTOList);

	}

}
