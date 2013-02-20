package com.ish.sms.service.ops;

import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.transaction.annotation.Transactional;

import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.service.dto.StudentListDTO;
import com.ish.sms.service.dto.TeacherDTO;
import com.ish.sms.service.dto.TeacherListDTO;
import com.ish.sms.service.entity.Student;
import com.ish.sms.service.entity.Teacher;

/**
 * Class to handle all business logic for associate related entity database operations
 * 
 * @author Naren
 * 
 */
public class AssociateOperations extends BaseOperations {

	/**
	 * Method to create or update a student.
	 * 
	 * @param studentDTO
	 * @return studentDTO
	 * @throws Exception
	 */
	@Transactional
	public StudentDTO createOrUpdateStudent(StudentDTO studentDTO) throws Exception {

		Student student = associateOperationsUtil.convertStudentDTOToEntity(studentDTO);
		student = (Student) associateOperationsDAO.createOrUpdateEntity(student);
		PropertyUtils.copyProperties(studentDTO, student);
		return studentDTO;
	}

	/**
	 * Method to create or update a teacher.
	 * 
	 * @param studentDTO
	 * @return studentDTO
	 * @throws Exception
	 */
	@Transactional
	public TeacherDTO createOrUpdateTeacher(TeacherDTO teacherDTO) throws Exception {

		Teacher teacher = associateOperationsUtil.convertTeacherDTOToEntity(teacherDTO);
		teacher = (Teacher) associateOperationsDAO.createOrUpdateEntity(teacher);
		PropertyUtils.copyProperties(teacherDTO, teacher);
		return teacherDTO;
	}

	/**
	 * Method to return the list of all the teachers in the school.
	 * 
	 * @return teacherList
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public TeacherListDTO retrieveAllTeachers() throws Exception {

		TeacherListDTO teacherListDTO = new TeacherListDTO();
		List<Teacher> teachersList = (List<Teacher>) associateOperationsDAO.retrieveResultsForquery(FIND_ALL_TEACHERS);
		for (Teacher teacher : teachersList) {
			TeacherDTO teacherDTO = associateOperationsUtil.convertTeacherEntityToDTO(teacher);
			teacherListDTO.getTeacherDTOList().add(teacherDTO);
		}
		return teacherListDTO;
	}

	/**
	 * Method to return the list of all the students in the school.
	 * 
	 * @return studentList
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public StudentListDTO retrieveAllStudents() throws Exception {

		StudentListDTO studentList = new StudentListDTO();
		List<Student> studentsList = (List<Student>) associateOperationsDAO.retrieveResultsForquery(FIND_ALL_STUDENTS);
		for (Student student : studentsList) {
			StudentDTO studentDTO = associateOperationsUtil.convertStudentEntitytoDTO(student);
			studentList.getStudentDTOList().add(studentDTO);
		}
		return studentList;
	}
}