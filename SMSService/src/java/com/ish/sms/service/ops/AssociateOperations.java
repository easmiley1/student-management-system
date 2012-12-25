package com.ish.sms.service.ops;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ish.sms.service.dao.AssociateOperationsDAO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.service.dto.StudentListDTO;
import com.ish.sms.service.entity.Student;

/**
 * Class to handle all business logic for associate related entity database operations
 * 
 * @author Naren
 *
 */
public class AssociateOperations extends EntityOperations {

	@Autowired
	private AssociateOperationsDAO associateOperationsDAO;

	/**
	 * Method to create or update a student.
	 * 
	 * @param studentDTO
	 * @return studentDTO
	 * @throws Exception
	 */
	@Transactional
	public StudentDTO createOrUpdateStudent(StudentDTO studentDTO) throws Exception {

		Student student = new Student();
		BeanUtils.copyProperties(student, studentDTO);
		student = associateOperationsDAO.createOrUpdateStudent(student);
		BeanUtils.copyProperties(studentDTO, student);
		return studentDTO;
	}

	/**
	 * Method to return the list of all the students in the school.
	 * 
	 * @return studentList
	 * @throws Exception
	 */
	@Transactional(readOnly=true)
	public StudentListDTO retrieveAllStudents() throws Exception {

		StudentListDTO studentList = new StudentListDTO();
		List<Student> studentsList = associateOperationsDAO.retrieveAllStudents();
		for (Student student : studentsList) {
			StudentDTO studentDTO = new StudentDTO();
			BeanUtils.copyProperties(studentDTO, student);
			studentList.getStudentDTOList().add(studentDTO);
		}
		return studentList;
	}
}
