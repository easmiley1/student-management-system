package com.ish.sms.service.ops.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ReferenceDataDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.service.dto.TeacherDTO;
import com.ish.sms.service.entity.Class;
import com.ish.sms.service.entity.ReferenceData;
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
	public TeacherDTO convertTeacherEntityToDTO(Teacher teacher) throws Exception {
		// Create all the DTO's required to construct the TeacherDTO
		TeacherDTO teacherDTO = new TeacherDTO();
		ReferenceDataDTO bloodGroupDTO = new ReferenceDataDTO();
		ReferenceDataDTO stateDTO = new ReferenceDataDTO();

		// Populate all the attributes in the above created DTO's
		PropertyUtils.copyProperties(teacherDTO, teacher);
		PropertyUtils.copyProperties(stateDTO, teacher.getState());
		PropertyUtils.copyProperties(bloodGroupDTO, teacher.getBloodGroup());

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
	public Teacher convertTeacherDTOToEntity(TeacherDTO teacherDTO) throws Exception {
		Teacher teacher = new Teacher();
		PropertyUtils.copyProperties(teacher, teacherDTO);
		ReferenceData bloodGroup = new ReferenceData();
		ReferenceData state = new ReferenceData();

		// Populate all the attributes in the above created entities for persisting in the database.
		PropertyUtils.copyProperties(teacherDTO, teacher);
		PropertyUtils.copyProperties(state, teacherDTO.getStateDTO());
		PropertyUtils.copyProperties(bloodGroup, teacherDTO.getBloodGroupDTO());

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
	public StudentDTO convertStudentEntitytoDTO(Student student) throws Exception {
		// Create all the DTO's required to construct the StudentDTO
		StudentDTO studentDTO = new StudentDTO();
		ReferenceDataDTO bloodGroupDTO = new ReferenceDataDTO();
		ReferenceDataDTO stateDTO = new ReferenceDataDTO();
		ClassDTO joiningClassDTO = new ClassDTO();
		ClassDTO currentClassDTO = new ClassDTO();
		ReferenceDataDTO modeofTransportDTO = new ReferenceDataDTO();
		ReferenceDataDTO extraCurricularDTO = new ReferenceDataDTO();

		// Populate all the attributes in the above created DTO's
		PropertyUtils.copyProperties(studentDTO, student);
		PropertyUtils.copyProperties(stateDTO, student.getState());
		PropertyUtils.copyProperties(bloodGroupDTO, student.getBloodGroup());
		PropertyUtils.copyProperties(joiningClassDTO, student.getJoiningClass());
		PropertyUtils.copyProperties(currentClassDTO, student.getCurrentClass());
		PropertyUtils.copyProperties(modeofTransportDTO, student.getModeOfTransport());
		PropertyUtils.copyProperties(extraCurricularDTO, student.getExtraCurricularInterest());

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
	public Student convertStudentDTOToEntity(StudentDTO studentDTO) throws Exception {
		Student student = new Student();
		PropertyUtils.copyProperties(student, studentDTO);
		ReferenceData bloodGroup = new ReferenceData();
		ReferenceData state = new ReferenceData();
		Class joiningClass = new Class();
		Class currentClass = new Class();
		ReferenceData modeofTransport = new ReferenceData();
		ReferenceData extraCurricular = new ReferenceData();

		// Populate all the attributes in the above created entities for persisting in database.
		PropertyUtils.copyProperties(studentDTO, student);
		PropertyUtils.copyProperties(state, studentDTO.getStateDTO());
		PropertyUtils.copyProperties(bloodGroup, studentDTO.getBloodGroupDTO());
		PropertyUtils.copyProperties(joiningClass, studentDTO.getJoiningClassDTO());
		PropertyUtils.copyProperties(currentClass, studentDTO.getCurrentClassDTO());
		PropertyUtils.copyProperties(modeofTransport, studentDTO.getModeofTransportDTO());
		PropertyUtils.copyProperties(extraCurricular, studentDTO.getExtraCurricularInterestDTO());

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
