package com.ish.sms.web.business;




import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ish.sms.service.dto.AssociateDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.service.dto.StudentListDTO;
import com.ish.sms.web.businessdelegate.AssociateBusinessDelegate;
import com.ish.sms.web.util.WebConstants;

/**
 * Business class for all associate related actions. This is called from the
 * Action bean/class. The methods in the class also converts the DTO to xml and
 * vice-versa the response from the rest service.
 * 
 * @author Naren
 * 
 */
public class AssociateBusiness extends BaseBusiness implements WebConstants {

	@Autowired
	private AssociateBusinessDelegate saveBusinessDelegate;

	/**
	 * Method to update/insert Students.
	 * 
	 * @param studentDTO
	 * @param associateDTO
	 * @return studentDTO
	 * @throws Exception
	 */
	public StudentDTO saveStudent(StudentDTO studentDTO, AssociateDTO associateDTO) throws Exception {

		BeanUtils.copyProperties(studentDTO, associateDTO);
		String studentXml = serviceTransformer.transformToXML(studentDTO, STUDENT_DTO);
		studentXml = saveBusinessDelegate.saveStudent(studentXml);
		return serviceTransformer.parseXml(studentXml);
	}

	/**
	 * Method to return the list of all the students in the school.
	 * 
	 * @return studentList
	 * @throws Exception
	 */
	public List<StudentDTO> retrieveAllStudents() throws Exception {

		String studentListXML = saveBusinessDelegate.retrieveAllStudents();
		StudentListDTO studentList = serviceTransformer.parseXml(studentListXML);
		return studentList.getStudentDTOList();
	}

}
