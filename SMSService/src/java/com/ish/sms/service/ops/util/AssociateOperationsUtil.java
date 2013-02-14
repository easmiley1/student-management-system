package com.ish.sms.service.ops.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.ish.sms.service.dto.BloodGroupDTO;
import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ExtraCurricularDTO;
import com.ish.sms.service.dto.ModeofTransportDTO;
import com.ish.sms.service.dto.StateDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.service.dto.TeacherDTO;
import com.ish.sms.service.entity.BloodGroup;
import com.ish.sms.service.entity.ExtraCurricular;
import com.ish.sms.service.entity.ModeofTransport;
import com.ish.sms.service.entity.State;
import com.ish.sms.service.entity.Student;
import com.ish.sms.service.entity.Teacher;

/**
 * Utility class for all associate related operations
 * 
 * @author Naren
 * 
 */
public class AssociateOperationsUtil {

	/**
	 * Utility method to convert the teacher JPA entity to teacherDTO object
	 * 
	 * @param teacher
	 * @return teacherDTO
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public TeacherDTO convertTeacherEntityToDTO(Teacher teacher) throws IllegalAccessException, InvocationTargetException {
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
		return teacherDTO;
	}

	/**
	 * Utility method to convert the teacherDTO to teacher JPA entity
	 * 
	 * @param teacherDTO
	 * @return teacher
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Teacher convertTeacherDTOToEntity(TeacherDTO teacherDTO) throws IllegalAccessException, InvocationTargetException {
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
		return teacher;
	}

	/**
	 * Utility method to convert the student JPA entity to studentDTO object
	 * 
	 * @param student
	 * @return studentDTO
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public StudentDTO convertStudentEntitytoDTO(Student student) throws IllegalAccessException, InvocationTargetException {
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
		return studentDTO;
	}

	/**
	 * Utility method to convert the studentDTO to student JPA entity
	 * 
	 * @param studentDTO
	 * @return student
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Student convertStudentDTOToEntity(StudentDTO studentDTO) throws IllegalAccessException, InvocationTargetException {
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
		return student;
	}

	

}
