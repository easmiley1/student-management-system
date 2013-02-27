package com.ish.sms.service.ops.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassReferenceDataDTO;
import com.ish.sms.service.dto.ClassTimeTableDTO;
import com.ish.sms.service.dto.ClassTimeTableListDTO;
import com.ish.sms.service.dto.ReferenceDataDTO;
import com.ish.sms.service.dto.TeacherDTO;
import com.ish.sms.service.entity.Class;
import com.ish.sms.service.entity.ClassExamReferenceData;
import com.ish.sms.service.entity.ClassSubjectReferenceData;
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
			List<ClassTimeTableDTO> classTimeTableDTOList = convertClassTimeTableListEntitytoDTO(classTimeTables).getClassTimeTableDTOList();
			classDTO.setClassTimeTableDTOList(classTimeTableDTOList);
		}
		Collection<ClassSubjectReferenceData> classSubjectReferenceDataList = classObj.getClassSubjectReferenceData();
		if (classSubjectReferenceDataList != null && classSubjectReferenceDataList.size() > 0) {
			List<ClassReferenceDataDTO> classSubjectClassReferenceDataDTOList = convertClassSubjectReferenceDataEntityToDTO(classSubjectReferenceDataList);
			classDTO.setClassSubjectReferenceDataDTOList(classSubjectClassReferenceDataDTOList);
		}
		Collection<ClassExamReferenceData> classExamReferenceDataList = classObj.getClassExamReferenceData();
		if (classExamReferenceDataList != null && classExamReferenceDataList.size() > 0) {
			List<ClassReferenceDataDTO> classExamClassReferenceDataDTOList = convertClassExamReferenceDataEntityToDTO(classExamReferenceDataList);
			classDTO.setClassExamReferenceDataDTOList(classExamClassReferenceDataDTOList);
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
		List<ClassTimeTableDTO> classTimeTableDTOList = classDTO.getClassTimeTableDTOList();
		List<ClassTimeTable> classTimeTableList = null;
		if (classTimeTableDTOList != null && classTimeTableDTOList.size() > 0) {
			classTimeTableList = convertClassTimeTableListDTOToEntity(classDTO.getClassTimeTableDTOList(), classObj);
		}
		List<ClassReferenceDataDTO> classExamReferenceDataDTOList = classDTO.getClassExamReferenceDataDTOList();
		List<ClassExamReferenceData> classExamReferenceDataList = null;
		if (classExamReferenceDataDTOList != null && classExamReferenceDataDTOList.size() > 0) {
			classExamReferenceDataList = convertClassExamReferenceDataDTOtoEntity(classExamReferenceDataDTOList, classObj);
		}
		List<ClassReferenceDataDTO> classSubjectReferenceDataDTOList = classDTO.getClassSubjectReferenceDataDTOList();
		List<ClassSubjectReferenceData> classSubjectReferenceDataList = null;
		if (classSubjectReferenceDataDTOList != null && classSubjectReferenceDataDTOList.size() > 0) {
			classSubjectReferenceDataList = convertClassSubjectReferenceDataDTOtoEntity(classSubjectReferenceDataDTOList,
					classObj);
		}

		classObj.setClassExamReferenceData(classExamReferenceDataList);
		classObj.setClassSubjectReferenceData(classSubjectReferenceDataList);
		classObj.setClassTimeTable(classTimeTableList);
	
		return classObj;
	}

	/**
	 * Utility method to convert classTimetablelist entity to DTO
	 * 
	 * @param classTimeTableListDTO
	 *            {@link ClassTimeTableListDTO}
	 * @return classTimeTable
	 * @throws Exception
	 */
	public ClassTimeTableListDTO convertClassTimeTableListEntitytoDTO(Collection<ClassTimeTable> classTimeTableList) throws Exception {

		ClassTimeTableListDTO classTimeTableListDTO = new ClassTimeTableListDTO();
		for (ClassTimeTable classTimeTable : classTimeTableList) {

			ClassTimeTableDTO classTimeTableDTO = new ClassTimeTableDTO();
			TeacherDTO teacherDTO = convertTeacherEntityToDTO(classTimeTable.getTeacher());
			classTimeTableDTO.setTeacherDTO(teacherDTO);
			ReferenceDataDTO subjectDTO = new ReferenceDataDTO();
			PropertyUtils.copyProperties(subjectDTO, classTimeTable.getSubject());
			classTimeTableDTO.setSubjectDTO(subjectDTO);
			ReferenceDataDTO dayOfWeekDTO = new ReferenceDataDTO();
			PropertyUtils.copyProperties(dayOfWeekDTO, classTimeTable.getDayofWeek());
			classTimeTableDTO.setDayOfWeekDTO(dayOfWeekDTO);
			PropertyUtils.copyProperties(classTimeTableDTO, classTimeTable);
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
			PropertyUtils.copyProperties(subject, classTimeTableDTO.getSubjectDTO());
			classTimeTable.setSubject(subject);
			ReferenceData dayOfWeek = new ReferenceData();
			PropertyUtils.copyProperties(dayOfWeek, classTimeTableDTO.getDayOfWeekDTO());
			classTimeTable.setDayofWeek(dayOfWeek);
			PropertyUtils.copyProperties(classTimeTable, classTimeTableDTO);
			if (classTimeTable.getId() != null && classTimeTable.getId().equals(0)) {
				classTimeTable.setId(null);
			}
			classTimeTableList.add(classTimeTable);
		}
		return classTimeTableList;
	}

	/**
	 * Utility method to convert classExamReferenceDataDTOList to Entity List
	 * 
	 * @param classExamReferenceDataDTOList
	 * @param classObj
	 * @return classExamReferenceDataList
	 * @throws Exception
	 */
	public List<ClassExamReferenceData> convertClassExamReferenceDataDTOtoEntity(List<ClassReferenceDataDTO> classExamReferenceDataDTOList,
			Class classObj) throws Exception {

		List<ClassExamReferenceData> classExamReferenceDataList = new ArrayList<ClassExamReferenceData>();

		for (ClassReferenceDataDTO classExamReferenceDataDTO : classExamReferenceDataDTOList) {
			ClassExamReferenceData classExamReferenceData = new ClassExamReferenceData();
			classExamReferenceData.setClassRef(classObj);
			ReferenceData examReferenceData = new ReferenceData();
			PropertyUtils.copyProperties(examReferenceData, classExamReferenceDataDTO.getReferenceDataDTO());
			classExamReferenceData.setExamReferenceData(examReferenceData);
			classExamReferenceDataList.add(classExamReferenceData);
		}
		return classExamReferenceDataList;
	}

	/**
	 * Utility method to convert classSubjectReferenceDataDTOList to Entity List
	 * 
	 * @param classSubjectReferenceDataDTOList
	 * @param classObj
	 * @return classSubjectReferenceDataList
	 * @throws Exception
	 */
	public List<ClassSubjectReferenceData> convertClassSubjectReferenceDataDTOtoEntity(List<ClassReferenceDataDTO> classSubjectReferenceDataDTOList,
			Class classObj) throws Exception {

		List<ClassSubjectReferenceData> classSubjectReferenceDataList = new ArrayList<ClassSubjectReferenceData>();

		for (ClassReferenceDataDTO classSubjectReferenceDataDTO : classSubjectReferenceDataDTOList) {
			ClassSubjectReferenceData classSubjectReferenceData = new ClassSubjectReferenceData();
			classSubjectReferenceData.setClassRef(classObj);
			ReferenceData subjectReferenceData = new ReferenceData();
			PropertyUtils.copyProperties(subjectReferenceData, classSubjectReferenceDataDTO.getReferenceDataDTO());
			classSubjectReferenceData.setSubjectReferenceData(subjectReferenceData);
			classSubjectReferenceDataList.add(classSubjectReferenceData);
		}
		return classSubjectReferenceDataList;
	}

	/**
	 * Utility method to convert classSubjectReferenceDataEntity List to DTO List
	 * 
	 * @param classSubjectReferenceDataList
	 * @param classObj
	 * @return classReferenceDataDTOList
	 * @throws Exception
	 */
	public List<ClassReferenceDataDTO> convertClassSubjectReferenceDataEntityToDTO(Collection<ClassSubjectReferenceData> classSubjectReferenceDataList)
			throws Exception {

		List<ClassReferenceDataDTO> classReferenceDataDTOList = new ArrayList<ClassReferenceDataDTO>();

		for (ClassSubjectReferenceData classSubjectReferenceData : classSubjectReferenceDataList) {
			ClassReferenceDataDTO classReferenceDataDTO = new ClassReferenceDataDTO();
			ReferenceDataDTO subjectReferenceDataDTO = new ReferenceDataDTO();
			PropertyUtils.copyProperties(subjectReferenceDataDTO, classSubjectReferenceData.getSubjectReferenceData());
			classReferenceDataDTO.setReferenceDataDTO(subjectReferenceDataDTO);
			classReferenceDataDTOList.add(classReferenceDataDTO);
		}
		return classReferenceDataDTOList;
	}

	/**
	 * Utility method to convert classExamReferenceDataEntity List to DTO List
	 * 
	 * @param classExamReferenceDataList
	 * @param classObj
	 * @return classReferenceDataDTOList
	 * @throws Exception
	 */
	public List<ClassReferenceDataDTO> convertClassExamReferenceDataEntityToDTO(Collection<ClassExamReferenceData> classExamReferenceDataList)
			throws Exception {

		List<ClassReferenceDataDTO> classReferenceDataDTOList = new ArrayList<ClassReferenceDataDTO>();

		for (ClassExamReferenceData classExamReferenceData : classExamReferenceDataList) {
			ClassReferenceDataDTO classReferenceDataDTO = new ClassReferenceDataDTO();
			ReferenceDataDTO examReferenceDataDTO = new ReferenceDataDTO();
			PropertyUtils.copyProperties(examReferenceDataDTO, classExamReferenceData.getExamReferenceData());
			classReferenceDataDTO.setReferenceDataDTO(examReferenceDataDTO);
			classReferenceDataDTOList.add(classReferenceDataDTO);
		}
		return classReferenceDataDTOList;
	}

}
