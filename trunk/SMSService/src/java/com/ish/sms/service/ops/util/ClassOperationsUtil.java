package com.ish.sms.service.ops.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import com.ish.sms.service.dto.AssociateAttendanceDTO;
import com.ish.sms.service.dto.ClassAttendanceDefDTO;
import com.ish.sms.service.dto.ClassAttendanceDefListDTO;
import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.TeacherDTO;
import com.ish.sms.service.entity.AssociateAttendance;
import com.ish.sms.service.entity.Class;
import com.ish.sms.service.entity.ClassAttendanceDef;
import com.ish.sms.service.entity.Teacher;

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
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public ClassDTO convertClassEntityToDTO(Class classObj, TeacherDTO teacherDTO) throws Exception {
		ClassDTO classDTO = new ClassDTO();
		PropertyUtils.copyProperties(classDTO, classObj);
		classDTO.setTeacherDTO(teacherDTO);
		return classDTO;
	}

	/**
	 * Utility method to convert the class JPA entity to classDTO object
	 * 
	 * @param classDTO
	 * @return classObj
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Class convertClassDTOToEntity(ClassDTO classDTO, Teacher teacher) throws Exception {
		Class classObj = new Class();
		PropertyUtils.copyProperties(classObj, classDTO);
		classObj.setTeacher(teacher);
		return classObj;
	}

	/**
	 * Utility method to convert ClassAttendanceDefListDTO List to ClassAttendanceDef Entity List
	 * 
	 * @param classAttendanceDefListDTO
	 * @return ClassAttendanceDefList
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public List<ClassAttendanceDef> convertClassAttendanceDefListDTOToEntity(ClassAttendanceDefListDTO classAttendanceDefListDTO) throws Exception {
		List<ClassAttendanceDef> classAttendanceList = new ArrayList<ClassAttendanceDef>();

		for (ClassAttendanceDefDTO classAttendanceDefDTO : classAttendanceDefListDTO.getClassAttendanceDefDTOList()) {
			classAttendanceList.add(convertClassAttendanceDTOToEntity(classAttendanceDefDTO));
		}
		return classAttendanceList;
	}

	/**
	 * Utility method to convert ClassAttendanceDef entity List to ClassAttendanceDefListDTO
	 * 
	 * @param classAttendanceList
	 * @return {@link ClassAttendanceDefListDTO}
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public ClassAttendanceDefListDTO convertClassAttendanceListToDTO(List<ClassAttendanceDef> classAttendanceList) throws Exception {
		ClassAttendanceDefListDTO classAttendanceDefDTOList = new ClassAttendanceDefListDTO();

		for (ClassAttendanceDef classAttendanceDef : classAttendanceList) {
			ClassAttendanceDefDTO classAttendanceDefDTO = new ClassAttendanceDefDTO();
			PropertyUtils.copyProperties(classAttendanceDefDTO, classAttendanceDef);
			classAttendanceDefDTOList.getClassAttendanceDefDTOList().add(classAttendanceDefDTO);
		}
		return classAttendanceDefDTOList;
	}

	/**
	 * Utility method to convert the classAttendanceDefDTO to JPA entity object
	 * 
	 * @param classAttendanceDefDTO
	 * @return classAttendanceDef
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public ClassAttendanceDef convertClassAttendanceDTOToEntity(ClassAttendanceDefDTO classAttendanceDefDTO) throws Exception {
		ClassAttendanceDef classAttendanceDef = new ClassAttendanceDef();
		PropertyUtils.copyProperties(classAttendanceDef, classAttendanceDefDTO);
		Teacher teacher = new AssociateOperationsUtil().convertTeacherDTOToEntity(classAttendanceDefDTO.getClassDTO().getTeacherDTO());
		Class classObj = convertClassDTOToEntity(classAttendanceDefDTO.getClassDTO(), teacher);
		classAttendanceDef.setClassRef(classObj);

		return classAttendanceDef;
	}

	/**
	 * Utility method to convert the associateAttendanceDTO to JPA entity object
	 * 
	 * @param associateAttendanceDTO
	 *            {@link AssociateAttendanceDTO}
	 * @return associateAttendance {@link AssociateAttendance}
	 * @throws Exception
	 */
	public AssociateAttendance convertAssociateAttendanceDTOToEntity(AssociateAttendanceDTO associateAttendanceDTO) throws Exception {
		AssociateAttendance associateAttendance = new AssociateAttendance();
		BeanUtils.copyProperties(associateAttendance, associateAttendanceDTO);
		associateAttendance.setStudent(new AssociateOperationsUtil().convertStudentDTOToEntity(associateAttendanceDTO.getStudentDTO()));
		associateAttendance.setClassAttendanceDef(convertClassAttendanceDTOToEntity(associateAttendanceDTO.getClassAttendanceDefDTO()));
		return associateAttendance;
	}

	/**
	 * Utility method to convert the associateAttendance entity object to DTO
	 * 
	 * @param associateAttendance
	 *            @link {@link AssociateAttendance}
	 * @return associateAttendanceDTO {@link AssociateAttendanceDTO}
	 * @throws Exception
	 */
	public AssociateAttendanceDTO convertAssociateAttendanceEntityToDTO(AssociateAttendance associateAttendance) throws Exception {
		AssociateAttendanceDTO associateAttendanceDTO = new AssociateAttendanceDTO();
		BeanUtils.copyProperties(associateAttendanceDTO, associateAttendance);
		associateAttendanceDTO.setStudentDTO(new AssociateOperationsUtil().convertStudentEntitytoDTO((associateAttendance.getStudent())));
		ClassAttendanceDefDTO classAttendanceDefDTO = new ClassAttendanceDefDTO();
		PropertyUtils.copyProperties(classAttendanceDefDTO, associateAttendance.getClassAttendanceDef());
		associateAttendanceDTO.setClassAttendanceDefDTO(classAttendanceDefDTO);

		return associateAttendanceDTO;
	}
}
