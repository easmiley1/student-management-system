package com.ish.sms.service.ops;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.transaction.annotation.Transactional;

import com.ish.sms.service.dto.ClassAttendanceDefDTO;
import com.ish.sms.service.dto.ClassAttendanceDefListDTO;
import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.TeacherDTO;
import com.ish.sms.service.entity.Class;
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
		return retrieveClassAttendanceDefListForClass(classId);
		
	}
	
	@SuppressWarnings("unchecked")
	private ClassAttendanceDefListDTO retrieveClassAttendanceDefListForClass(Integer classId) throws Exception {
		Map<String, Object> queryParametersMap = new HashMap<String, Object>();
		queryParametersMap.put(ID, classId);
		List<ClassAttendanceDef> classAttendanceList = (List<ClassAttendanceDef>) classOperationsDAO.retrieveResultListForQueryWithParameters(
				FIND_CLASS_ATTENDANCE_DEF, queryParametersMap);
		return classOperationsUtil.convertClassAttendanceListToDTO(classAttendanceList);
	}

	/**
	 * Method to remove and delete the classAttendanceDefListDTO and return the updated one
	 * 
	 * @param classAttendanceDefListDTO {@link ClassAttendanceDefListDTO} 
	 * @return updatedClassAttendanceDefListDTO {@link ClassAttendanceDefListDTO} 
	 * @throws Exception
	 */
	@Transactional
	public ClassAttendanceDefListDTO updateClassAttendanceDefList(ClassAttendanceDefListDTO classAttendanceDefListDTO) throws Exception {

		List<ClassAttendanceDef> classAttendanceDefList = classOperationsUtil.convertClassAttendanceDefListDTOToEntity(classAttendanceDefListDTO);
		classOperationsDAO.updateClassAttendanceDefList(classAttendanceDefList);
		return retrieveClassAttendanceDefListForClass(classAttendanceDefList.get(0).getClassRef().getId());
	}

	/**
	 * Method to return the class for a specific classid
	 * 
	 * @param classId
	 * @return class
	 */
	@Transactional(readOnly = true)
	public ClassDTO retrieveClassForId(Integer classId) throws Exception {

		Map<String, Object> queryParametersMap = new HashMap<String, Object>();
		queryParametersMap.put(ID, classId);
		com.ish.sms.service.entity.Class classObj = (Class) classOperationsDAO.retrieveSingleResultForQueryWithParameters(FIND_CLASS_BY_ID,
				Class.class, queryParametersMap);
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
		classAttendanceDef = (ClassAttendanceDef) classOperationsDAO.createOrUpdateEntity(classAttendanceDef);
		PropertyUtils.copyProperties(classAttendanceDefDTO, classAttendanceDef);
		return classAttendanceDefDTO;
	}

}
