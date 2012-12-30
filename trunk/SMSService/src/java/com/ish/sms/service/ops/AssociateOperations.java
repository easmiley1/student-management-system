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
import com.ish.sms.service.entity.BloodGroup;
import com.ish.sms.service.entity.ExtraCurricular;
import com.ish.sms.service.entity.ModeofTransport;
import com.ish.sms.service.entity.State;
import com.ish.sms.service.entity.Student;

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
		
		// Populate all the attributes in the above created DTO's
		BeanUtils.copyProperties(studentDTO, student);
		BeanUtils.copyProperties(state, studentDTO.getStateDTO());
		BeanUtils.copyProperties(bloodGroup, studentDTO.getBloodGroupDTO());
		BeanUtils.copyProperties(joiningClass, studentDTO.getJoiningClassDTO());
		BeanUtils.copyProperties(currentClass, studentDTO.getCurrentClassDTO());
		BeanUtils.copyProperties(modeofTransport, studentDTO.getModeofTransportDTO());
		BeanUtils.copyProperties(extraCurricular, studentDTO.getExtraCurricularInterestDTO());
		
		// Set the DTO's in the studentDTO
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
