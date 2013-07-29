package com.ish.sms.web.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.beanutils.BeanUtils;

import com.ish.sms.service.dto.AssociateDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.service.dto.TeacherDTO;
import com.ish.sms.web.util.WebConstants;

/**
 * Bean class which is in session scope and holds the state of all associate related screens
 * 
 * @author Naren
 *
 */
@ManagedBean(name = "associateBean")
@SessionScoped
public class AssociateBean extends BaseBean implements WebConstants {

	private static final long serialVersionUID = 1L;
	private AssociateDTO associateDTO = new AssociateDTO();
	private StudentDTO studentDTO = new StudentDTO();
	private TeacherDTO teacherDTO = new TeacherDTO();
	private List<StudentDTO> studentDTOList;
	private List<TeacherDTO> teacherDTOList;	
	private List<StudentDTO> filteredStudentList;
	private List<TeacherDTO> filteredTeacherList;	

	private boolean readOnlyMode;

	/**
	 * @return the filteredStudentList
	 */
	public List<StudentDTO> getFilteredStudentList() {
		return filteredStudentList;
	}

	/**
	 * @param filteredStudentList the filteredStudentList to set
	 */
	public void setFilteredStudentList(List<StudentDTO> filteredStudentList) {
		this.filteredStudentList = filteredStudentList;
	}

	/**
	 * @return the filteredTeacherList
	 */
	public List<TeacherDTO> getFilteredTeacherList() {
		return filteredTeacherList;
	}

	/**
	 * @param filteredTeacherList the filteredTeacherList to set
	 */
	public void setFilteredTeacherList(List<TeacherDTO> filteredTeacherList) {
		this.filteredTeacherList = filteredTeacherList;
	}

	/**
	 * @return the teacherDTOList
	 */
	public List<TeacherDTO> getTeacherDTOList() {
		return teacherDTOList;
	}

	/**
	 * @param teacherDTOList the teacherDTOList to set
	 */
	public void setTeacherDTOList(List<TeacherDTO> teacherDTOList) {
		this.teacherDTOList = teacherDTOList;
	}	
	/**
	 * @return the teacherDTO
	 */
	public TeacherDTO getTeacherDTO() {
		return teacherDTO;
	}

	/**
	 * @param teacherDTO the teacherDTO to set
	 */
	public void setTeacherDTO(TeacherDTO teacherDTO) {
		this.teacherDTO = teacherDTO;
	}

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
	 * 
	 */
	public void initAddTeacherPersonalDetails() {
		setReadOnlyMode(false);
		setAssociateDTO(objfactory.createAssociateDTO());
		associateDTO.setGender(DEFAULT_GENDER);
		setTeacherDTO(objfactory.createTeacherDTO());
	}
	
	/**
	 * Method to initialize the DTO's for new student Action
	 * 
	 * @return student.xhtml
	 * 
	 */
	public void initAddStudentPersonalDetails() {
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
		
		setAssociateDTO(objfactory.createAssociateDTO());
		BeanUtils.copyProperties(associateDTO, studentDTO);
	}

	/**
	 * Set the selected teacher in the grid to the selection model
	 * 
	 * @throws Exception
	 */
	public void applyTeacherSelection() throws Exception {
		
		setAssociateDTO(objfactory.createAssociateDTO());
		BeanUtils.copyProperties(associateDTO, teacherDTO);
	}
	
	
	/**
	 * Method to initialize the DTO's for student Grid display
	 * 
	 * @param studentDTOList
	 */
	public void initModifySearchAllStudents(List<StudentDTO> studentDTOList){
		setStudentDTO(new StudentDTO());
		setStudentDTOList(studentDTOList);

	}

	/**
	 * Method to initialize the DTO's for teacher Grid display
	 * 
	 * @param teacherDTOList
	 */
	public void initModifySearchAllTeacers(List<TeacherDTO> teacherDTOList){
		setTeacherDTO(new TeacherDTO());
		setTeacherDTOList(teacherDTOList);

	}
}
