package com.ish.sms.web.business;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.ish.sms.service.dto.AssociateDTO;
import com.ish.sms.service.dto.StringListDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.service.dto.StudentListDTO;
import com.ish.sms.service.dto.TeacherDTO;
import com.ish.sms.service.dto.TeacherListDTO;

/**
 * Business class for all associate related actions. This is called from the Action bean/class. The methods in the class also converts the
 * DTO to xml and vice-versa the response from the rest service.
 * 
 * @author Naren
 * 
 */
public class AssociateBusiness extends BaseBusiness {

	/**
	 * Method to update/insert Students.
	 * 
	 * @param studentDTO
	 * @param associateDTO
	 * @return studentDTO
	 * @throws Exception
	 */
	public StudentDTO saveStudent(StudentDTO studentDTO, AssociateDTO associateDTO) throws Exception {

		Integer studentId = studentDTO.getId();
		BeanUtils.copyProperties(studentDTO, associateDTO);
		studentDTO.setId(studentId);
		String studentXml = serviceTransformer.transformToXML(studentDTO, STUDENT_DTO);
		studentXml = associateBusinessDelegate.saveStudent(studentXml);
		return serviceTransformer.parseXml(studentXml);
	}

	/**
	 * Method to update/insert Teachers.
	 * 
	 * @param teacherDTO
	 * @param associateDTO
	 * @return teacherDTO
	 * @throws Exception
	 */
	public TeacherDTO saveTeacher(TeacherDTO teacherDTO, AssociateDTO associateDTO) throws Exception {

		Integer teacherId = teacherDTO.getId();
		BeanUtils.copyProperties(teacherDTO, associateDTO);
		teacherDTO.setId(teacherId);
		String teacherXML = serviceTransformer.transformToXML(teacherDTO, TEACHER_DTO);
		teacherXML = associateBusinessDelegate.saveTeacher(teacherXML);
		return serviceTransformer.parseXml(teacherXML);
	}

	/**
	 * Method to return the list of all the students in the school.
	 * 
	 * @return studentList
	 * @throws Exception
	 */
	public List<StudentDTO> retrieveAllStudents() throws Exception {

		String studentListXML = associateBusinessDelegate.retrieveAllStudents();
		StudentListDTO studentList = serviceTransformer.parseXml(studentListXML);
		return studentList.getStudentDTOList();
	}

	/**
	 * Method to return the list of all the students in the school.
	 * 
	 * @return studentList
	 * @throws Exception
	 */
	public List<StudentDTO> retrieveAllStudents(List<String> classIdList) throws Exception {

		StringListDTO stringListDTO = new StringListDTO();
		stringListDTO.setStringListDTO(classIdList);
		String classIdXML = serviceTransformer.transformToXML(stringListDTO, STRING_LIST_DTO);
		String studentListXML = associateBusinessDelegate.retrieveStudentsForClass(classIdXML);
		StudentListDTO studentList = serviceTransformer.parseXml(studentListXML);
		return studentList.getStudentDTOList();
	}

	/**
	 * Method to return the list of all the teachers in the school.
	 * 
	 * @return studentList
	 * @throws Exception
	 */
	public List<TeacherDTO> retrieveAllTeachers() throws Exception {

		String teacherListXML = associateBusinessDelegate.retrieveAllTeachers();
		TeacherListDTO teacherList = serviceTransformer.parseXml(teacherListXML);
		return teacherList.getTeacherDTOList();
	}

}
