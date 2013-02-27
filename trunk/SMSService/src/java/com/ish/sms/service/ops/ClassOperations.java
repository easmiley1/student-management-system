package com.ish.sms.service.ops;

import org.springframework.transaction.annotation.Transactional;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.entity.Class;

/**
 * Class to handle all business logic for class related database operations
 * 
 * @author Naren
 * 
 */
public class ClassOperations extends BaseOperations {

	/**
	 * Method to return the class for a specific classid
	 * 
	 * @param classId
	 * @return class {@link ClassDTO}
	 */
	@Transactional(readOnly = true)
	public ClassDTO retrieveClassForId(Integer classId) throws Exception {

		Class classObj = classOperationsDAO.retrieveClassForId(classId);
		ClassDTO classDTO = classOperationsUtil.convertClassEntityToDTO(classObj);
		return classDTO;
	}

	/**
	 * Method to save class details in the database including the class timetable
	 * 
	 * @param classDTO {@link ClassDTO}
	 * @return persistedClassDTO {@link ClassDTO}
	 * @throws Exception
	 */
	@Transactional
	public ClassDTO saveClassDetails(ClassDTO classDTO) throws Exception {
		Class classObj = classOperationsUtil.convertClassDTOToEntity(classDTO);
		classObj = (Class) classOperationsDAO.createOrUpdateEntity(classObj);
		classDTO = classOperationsUtil.convertClassEntityToDTO(classObj);
		return classDTO;
	}
}
