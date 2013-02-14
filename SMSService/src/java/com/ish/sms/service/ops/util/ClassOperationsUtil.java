package com.ish.sms.service.ops.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.ish.sms.service.dto.ClassAttendanceDefDTO;
import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.TeacherDTO;
import com.ish.sms.service.entity.ClassAttendanceDef;

/**
 * Utility class for all class related operations
 * 
 * @author Naren
 * 
 */
public class ClassOperationsUtil {
	/**
	 * Utility method to convert the class JPA entity to classDTO object
	 * 
	 * @param classObj
	 * @return classDTO
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public ClassDTO convertClassEntityToDTO(com.ish.sms.service.entity.Class classObj, TeacherDTO teacherDTO) throws IllegalAccessException,
			InvocationTargetException {
		ClassDTO classDTO = new ClassDTO();
		BeanUtils.copyProperties(classDTO, classObj);
		classDTO.setTeacherDTO(teacherDTO);
		return classDTO;
	}

	/**
	 * Utility method to convert the classAttendanceDefDTO to JPA entity object
	 * 
	 * @param classAttendanceDefDTO
	 * @return classAttendanceDef
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public ClassAttendanceDef convertClassAttendanceDTOToEntity(ClassAttendanceDefDTO classAttendanceDefDTO) throws IllegalAccessException,
			InvocationTargetException {
		ClassAttendanceDef classAttendanceDef = new ClassAttendanceDef();
		BeanUtils.copyProperties(classAttendanceDef, classAttendanceDefDTO);
		com.ish.sms.service.entity.Class classObj = new com.ish.sms.service.entity.Class();
		BeanUtils.copyProperties(classObj, classAttendanceDefDTO.getClassDTO());
		classAttendanceDef.setClassRef(classObj);
		
		return classAttendanceDef;
	}
}
