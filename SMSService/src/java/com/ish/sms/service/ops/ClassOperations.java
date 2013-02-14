package com.ish.sms.service.ops;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.ish.sms.service.dto.ClassAttendanceDefDTO;
import com.ish.sms.service.dto.ClassAttendanceDefListDTO;
import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.TeacherDTO;
import com.ish.sms.service.entity.ClassAttendanceDef;

/**
 * Class to handle all business logic for class related database operations
 * 
 * @author Naren
 * 
 */
public class ClassOperations extends BaseOperations {

	/**
	 * Method to call classOperationsDAO and get all the classAttendanceDefintion for a particular class
	 * 
	 * @return ClassAttendanceDefDTOList
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public ClassAttendanceDefListDTO retrieveClassAttendanceDefList(Integer classId) throws Exception {
		List<ClassAttendanceDef> classAttendanceList = classOperationsDAO.retrieveClassAttendanceDefList(classId);
		ClassAttendanceDefListDTO classAttendanceDefDTOList = new ClassAttendanceDefListDTO();

		for (ClassAttendanceDef classAttendanceDef : classAttendanceList) {
			ClassAttendanceDefDTO classAttendanceDefDTO = new ClassAttendanceDefDTO();
			BeanUtils.copyProperties(classAttendanceDefDTO, classAttendanceDef);
			classAttendanceDefDTOList.getClassAttendanceDefDTOList().add(classAttendanceDefDTO);
		}
		return classAttendanceDefDTOList;
	}

	/**
	 * Method to return the class for a specific classid
	 * 
	 * @param classId
	 * @return class
	 */
	@Transactional(readOnly = true)
	public ClassDTO retrieveClassForId(Integer classId) throws Exception {

		com.ish.sms.service.entity.Class classObj = classOperationsDAO.retrieveClassForId(classId);
		TeacherDTO teacherDTO = associateOperationsUtil.convertTeacherEntityToDTO(classObj.getTeacher());
		ClassDTO classDTO = classOperationsUtil.convertClassEntityToDTO(classObj, teacherDTO);
		return classDTO;
	}

	/**
	 * Method to create or update ClassAttendance Definition
	 * 
	 * @param ClassAttendanceDefDTO
	 * @return ClassAttendanceDefDTO
	 * @throws Exception
	 */
	@Transactional
	public ClassAttendanceDefDTO createOrUpdateClassAttendanceDef(ClassAttendanceDefDTO classAttendanceDefDTO) throws Exception {

		ClassAttendanceDef classAttendanceDef = classOperationsUtil.convertClassAttendanceDTOToEntity(classAttendanceDefDTO);
		classAttendanceDef = classOperationsDAO.createOrUpdateClassAttendanceDef(classAttendanceDef);
		BeanUtils.copyProperties(classAttendanceDefDTO, classAttendanceDef);
		return classAttendanceDefDTO;
	}

	
}
