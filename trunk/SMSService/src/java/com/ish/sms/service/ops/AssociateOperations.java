package com.ish.sms.service.ops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.transaction.annotation.Transactional;

import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.service.dto.StudentListDTO;
import com.ish.sms.service.dto.TeacherDTO;
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
	
	/**
	 * Method to return the list of all the students for the given classIds.
	 * 
	 * @return studentList
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public StudentListDTO retrieveStudentsForClass(List<String> classIdList) throws Exception {

		Map<String, Object> queryParametersMap = new HashMap<String, Object>();
		List<Integer> classIdIntList = new ArrayList<Integer>();
		for(String classId :classIdList){
			classIdIntList.add(new Integer(classId));
		}
		queryParametersMap.put(ID_LIST, classIdIntList);
		StudentListDTO studentList = new StudentListDTO();
		List<Student> studentsList = (List<Student>) associateOperationsDAO.retrieveResultListForQueryWithParameters(
				FIND_ALL_STUDENTS_BY_CLASS_LIST, queryParametersMap);;
		for (Student student : studentsList) {
			StudentDTO studentDTO = associateOperationsUtil.convertStudentEntitytoDTO(student);
			studentList.getStudentDTOList().add(studentDTO);
		}
		return studentList;
	}
}
