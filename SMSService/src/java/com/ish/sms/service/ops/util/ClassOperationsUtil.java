package com.ish.sms.service.ops.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import com.ish.sms.service.dto.AssociateAttendanceDTO;
import com.ish.sms.service.dto.ClassAttendanceDefDTO;
import com.ish.sms.service.dto.ClassAttendanceDefListDTO;
import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassTimeTableDTO;
import com.ish.sms.service.dto.ClassTimeTableListDTO;
import com.ish.sms.service.dto.ReferenceDataDTO;
import com.ish.sms.service.dto.TeacherDTO;
import com.ish.sms.service.entity.AssociateAttendance;
import com.ish.sms.service.entity.Class;
import com.ish.sms.service.entity.ClassAttendanceDef;
import com.ish.sms.service.entity.ClassTimeTable;
import com.ish.sms.service.entity.ReferenceData;
import com.ish.sms.service.entity.Teacher;

/**
 * Utility class for all class related operations
 * 
 * @author Naren
 * 
 */
public class ClassOperationsUtil extends BaseCommonOperationsUtil {
	/**
	 * Utility method to convert the class JPA entity to classDTO object
	 * 
	 * @param classObj
	 * @return classDTO
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public ClassDTO convertClassEntityToDTO(Class classObj) throws Exception {
		ClassDTO classDTO = new ClassDTO();
		PropertyUtils.copyProperties(classDTO, classObj);
		TeacherDTO teacherDTO = convertTeacherEntityToDTO(classObj.getTeacher());
		Collection<ClassTimeTable> classTimeTables = classObj.getClassTimeTable();
		if (classTimeTables != null && classTimeTables.size() > 0) {
			List<ClassTimeTable> classTimeTableList = new ArrayList<ClassTimeTable>();
			classTimeTableList.addAll(classTimeTables);
			List<ClassTimeTableDTO> classTimeTableDTOList = convertClassTimeTableListEntitytoDTO(classTimeTableList).getClassTimeTableDTOList();
			classDTO.setClassTimeTableDTOList(classTimeTableDTOList);
		}
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
	public Class convertClassDTOToEntity(ClassDTO classDTO) throws Exception {
		Class classObj = new Class();
		PropertyUtils.copyProperties(classObj, classDTO);
		Teacher teacher = convertTeacherDTOToEntity(classDTO.getTeacherDTO());
		
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
		Class classObj = convertClassDTOToEntity(classAttendanceDefDTO.getClassDTO());
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
		associateAttendance.setStudent(convertStudentDTOToEntity(associateAttendanceDTO.getStudentDTO()));
		associateAttendance.setClassAttendanceDef(convertClassAttendanceDTOToEntity(associateAttendanceDTO.getClassAttendanceDefDTO()));
		return associateAttendance;
	}

	/**
	 * Utility method to convert the associateAttendance entity object to DTO
	 * 
	 * @param associateAttendance
	 * @link {@link AssociateAttendance}
	 * @return associateAttendanceDTO {@link AssociateAttendanceDTO}
	 * @throws Exception
	 */
	public AssociateAttendanceDTO convertAssociateAttendanceEntityToDTO(AssociateAttendance associateAttendance) throws Exception {
		AssociateAttendanceDTO associateAttendanceDTO = new AssociateAttendanceDTO();
		BeanUtils.copyProperties(associateAttendanceDTO, associateAttendance);
		associateAttendanceDTO.setStudentDTO(convertStudentEntitytoDTO((associateAttendance.getStudent())));
		ClassAttendanceDefDTO classAttendanceDefDTO = new ClassAttendanceDefDTO();
		PropertyUtils.copyProperties(classAttendanceDefDTO, associateAttendance.getClassAttendanceDef());
		associateAttendanceDTO.setClassAttendanceDefDTO(classAttendanceDefDTO);

		return associateAttendanceDTO;
	}

	/**
	 * Utility method to convert classTimetablelist entity to DTO
	 * 
	 * @param classTimeTableListDTO
	 *            {@link ClassTimeTableListDTO}
	 * @return classTimeTable
	 * @throws Exception
	 */
	public ClassTimeTableListDTO convertClassTimeTableListEntitytoDTO(List<ClassTimeTable> classTimeTableList) throws Exception {

		ClassTimeTableListDTO classTimeTableListDTO = new ClassTimeTableListDTO();
		for (ClassTimeTable classTimeTable : classTimeTableList) {

			ClassTimeTableDTO classTimeTableDTO = new ClassTimeTableDTO();
			TeacherDTO teacherDTO = convertTeacherEntityToDTO(classTimeTable.getTeacher());
			classTimeTableDTO.setTeacherDTO(teacherDTO);
			ReferenceDataDTO subjectDTO = new ReferenceDataDTO();
			BeanUtils.copyProperties(subjectDTO, classTimeTable.getSubject());
			classTimeTableDTO.setSubjectDTO(subjectDTO);
			ReferenceDataDTO dayOfWeekDTO = new ReferenceDataDTO();
			BeanUtils.copyProperties(dayOfWeekDTO, classTimeTable.getDayofWeek());
			classTimeTableDTO.setDayOfWeekDTO(dayOfWeekDTO);
			BeanUtils.copyProperties(classTimeTableDTO, classTimeTable);
			classTimeTableListDTO.getClassTimeTableDTOList().add(classTimeTableDTO);
		}
		return classTimeTableListDTO;
	}
	
	/**
	 * Utility method to convert ClassTimeTablelist DTO to entity
	 * 
	 * @param classTimeTableDTOList
	 * @param classObj
	 * @return classTimeTableList
	 * @throws Exception
	 */
	public List<ClassTimeTable> convertClassTimeTableListDTOToEntity(List<ClassTimeTableDTO> classTimeTableDTOList, Class classObj) throws Exception {

		List<ClassTimeTable> classTimeTableList = new ArrayList<ClassTimeTable>();

		for (ClassTimeTableDTO classTimeTableDTO : classTimeTableDTOList) {

			ClassTimeTable classTimeTable = new ClassTimeTable();
			Teacher teacher = convertTeacherDTOToEntity(classTimeTableDTO.getTeacherDTO());
			classTimeTable.setClassRef(classObj);
			classTimeTable.setTeacher(teacher);
			ReferenceData subject = new ReferenceData();
			BeanUtils.copyProperties(subject, classTimeTableDTO.getSubjectDTO());
			classTimeTable.setSubject(subject);
			ReferenceData dayOfWeek = new ReferenceData();
			BeanUtils.copyProperties(dayOfWeek, classTimeTableDTO.getDayOfWeekDTO());
			classTimeTable.setDayofWeek(dayOfWeek);
			BeanUtils.copyProperties(classTimeTable, classTimeTableDTO);
			if(classTimeTable.getId()!= null && classTimeTable.getId().equals(0)){
				classTimeTable.setId(null);
			}
			classTimeTableList.add(classTimeTable);
		}
		return classTimeTableList;
	}	
}
