package com.ish.sms.service.dao;

import java.util.List;

import com.ish.sms.service.entity.Class;
import com.ish.sms.service.entity.ClassAttendanceDef;

/**
 * DAO class for all the class related operations
 * 
 * @author Naren
 * 
 */
public class ClassOperationsDAO extends BaseOperationsDAO {

	/**
	 * Method to return the attendance definition list for particular class.
	 * 
	 * @return bloodGroupsList
	 */ 
	@SuppressWarnings("unchecked")
	public List<ClassAttendanceDef> retrieveClassAttendanceDefList(Integer classId) {

		List<ClassAttendanceDef> classAttendanceDefList = (List<ClassAttendanceDef>) entityManager
				.createNamedQuery(FIND_CLASS_ATTENDANCE_DEF).setParameter(ID, classId).getResultList();
		return classAttendanceDefList;
	}

	/**
	 * Method to return the class for a specific classid
	 * 
	 * @param classId
	 * @return class
	 */
	public com.ish.sms.service.entity.Class retrieveClassForId(Integer classId) {

		com.ish.sms.service.entity.Class classObj = (Class) entityManager.createNamedQuery(FIND_CLASS_BY_ID, Class.class)
				.setParameter(ID, classId).getSingleResult();
		return classObj;
	}

	/**
	 * Method to create or update classAttendanceDef entity
	 * 
	 * @param classAttendanceDef
	 * @return classAttendanceDef
	 */
	public ClassAttendanceDef createOrUpdateClassAttendanceDef(ClassAttendanceDef classAttendanceDef){
		return entityManager.merge(classAttendanceDef);
		
	}
	
}
