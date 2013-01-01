package com.ish.sms.service.ops;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.ish.sms.service.dto.BloodGroupDTO;
import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ExtraCurricularDTO;
import com.ish.sms.service.dto.ModeofTransportDTO;
import com.ish.sms.service.dto.StateDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.service.dto.StudentListDTO;
import com.ish.sms.service.dto.TeacherDTO;
import com.ish.sms.service.dto.TeacherListDTO;
import com.ish.sms.service.entity.BloodGroup;
import com.ish.sms.service.entity.ExtraCurricular;
import com.ish.sms.service.entity.ModeofTransport;
import com.ish.sms.service.entity.State;
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

		Student student = new Student();
		BeanUtils.copyProperties(student, studentDTO);
		BloodGroup bloodGroup = new BloodGroup();
		State state = new State();
		com.ish.sms.service.entity.Class joiningClass = new com.ish.sms.service.entity.Class();
		com.ish.sms.service.entity.Class currentClass = new com.ish.sms.service.entity.Class();
		ModeofTransport modeofTransport = new ModeofTransport();
		ExtraCurricular extraCurricular = new ExtraCurricular();
		
		// Populate all the attributes in the above created entities for persisting in database.
		BeanUtils.copyProperties(studentDTO, student);
		BeanUtils.copyProperties(state, studentDTO.getStateDTO());
		BeanUtils.copyProperties(bloodGroup, studentDTO.getBloodGroupDTO());
		BeanUtils.copyProperties(joiningClass, studentDTO.getJoiningClassDTO());
		BeanUtils.copyProperties(currentClass, studentDTO.getCurrentClassDTO());
		BeanUtils.copyProperties(modeofTransport, studentDTO.getModeofTransportDTO());
		BeanUtils.copyProperties(extraCurricular, studentDTO.getExtraCurricularInterestDTO());
		
		// Set the relational entities in the student
		student.setBloodGroup(bloodGroup);
		student.setState(state);
		student.setCurrentClass(currentClass);
		student.setJoiningClass(joiningClass);
		student.setModeOfTransport(modeofTransport);
		student.setExtraCurricularInterest(extraCurricular);

		student = associateOperationsDAO.createOrUpdateStudent(student);
		BeanUtils.copyProperties(studentDTO, student);
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

		Teacher teacher = new Teacher();
		BeanUtils.copyProperties(teacher, teacherDTO);
		BloodGroup bloodGroup = new BloodGroup();
		State state = new State();
		
		// Populate all the attributes in the above created entities for persisting in the database.
		BeanUtils.copyProperties(teacherDTO, teacher);
		BeanUtils.copyProperties(state, teacherDTO.getStateDTO());
		BeanUtils.copyProperties(bloodGroup, teacherDTO.getBloodGroupDTO());
		
		// Set the relational entities in the teacher
		teacher.setBloodGroup(bloodGroup);
		teacher.setState(state);

		teacher = associateOperationsDAO.createOrUpdateTeacher(teacher);
		BeanUtils.copyProperties(teacherDTO, teacher);
		return teacherDTO;
	}

	
	/**
	 * Method to return the list of all the teachers in the school.
	 * 
	 * @return teacherList
	 * @throws Exception
	 */
	@Transactional(readOnly=true)
	public TeacherListDTO retrieveAllTeachers() throws Exception {

		TeacherListDTO teacherListDTO = new TeacherListDTO();
		List<Teacher> teachersList = associateOperationsDAO.retrieveAllTeachers();
		for (Teacher teacher : teachersList) {
		
			// Create all the DTO's required to construct the TeacherDTO
			TeacherDTO teacherDTO = new TeacherDTO();
			BloodGroupDTO bloodGroupDTO = new BloodGroupDTO();
			StateDTO stateDTO = new StateDTO();
			
			// Populate all the attributes in the above created DTO's
			BeanUtils.copyProperties(teacherDTO, teacher);
			BeanUtils.copyProperties(stateDTO, teacher.getState());
			BeanUtils.copyProperties(bloodGroupDTO, teacher.getBloodGroup());
			
			// Set the DTO's in the teacherDTO
			teacherDTO.setBloodGroupDTO(bloodGroupDTO);
			teacherDTO.setStateDTO(stateDTO);
			
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
	@Transactional(readOnly=true)
	public StudentListDTO retrieveAllStudents() throws Exception {

		StudentListDTO studentList = new StudentListDTO();
		List<Student> studentsList = associateOperationsDAO.retrieveAllStudents();
		for (Student student : studentsList) {
		
			// Create all the DTO's required to construct the StudentDTO
			StudentDTO studentDTO = new StudentDTO();
			BloodGroupDTO bloodGroupDTO = new BloodGroupDTO();
			StateDTO stateDTO = new StateDTO();
			ClassDTO joiningClassDTO = new ClassDTO();
			ClassDTO currentClassDTO = new ClassDTO();
			ModeofTransportDTO modeofTransportDTO = new ModeofTransportDTO();
			ExtraCurricularDTO extraCurricularDTO = new ExtraCurricularDTO();
			
			// Populate all the attributes in the above created DTO's
			BeanUtils.copyProperties(studentDTO, student);
			BeanUtils.copyProperties(stateDTO, student.getState());
			BeanUtils.copyProperties(bloodGroupDTO, student.getBloodGroup());
			BeanUtils.copyProperties(joiningClassDTO, student.getJoiningClass());
			BeanUtils.copyProperties(currentClassDTO, student.getCurrentClass());
			BeanUtils.copyProperties(modeofTransportDTO, student.getModeOfTransport());
			BeanUtils.copyProperties(extraCurricularDTO, student.getExtraCurricularInterest());
			
			// Set the DTO's in the studentDTO
			studentDTO.setBloodGroupDTO(bloodGroupDTO);
			studentDTO.setStateDTO(stateDTO);
			studentDTO.setCurrentClassDTO(currentClassDTO);
			studentDTO.setJoiningClassDTO(joiningClassDTO);
			studentDTO.setModeofTransportDTO(modeofTransportDTO);
			studentDTO.setExtraCurricularInterestDTO(extraCurricularDTO);
			
			studentList.getStudentDTOList().add(studentDTO);
		}
		return studentList;
	}
}
