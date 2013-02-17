package com.ish.sms.service.dao;

import java.util.ArrayList;
import java.util.List;

import com.ish.sms.service.entity.ClassAttendanceDef;

/**
 * DAO class for all the class related operations
 * 
 * @author Naren
 * 
 */
public class ClassOperationsDAO extends BaseOperationsDAO {

	/**
	 * Method to perform DAO operations related to removing and deleting the classAttendanceDefList
	 * 
	 * @param classAttendanceDefList
	 * @return updateClassAttendanceDefList
	 */
	public List<ClassAttendanceDef> updateClassAttendanceDefList(List<ClassAttendanceDef> classAttendanceDefList) {
		List<ClassAttendanceDef> updatedClassAttendanceDefList = new ArrayList<ClassAttendanceDef>();

		for (ClassAttendanceDef classAttendanceDef : classAttendanceDefList) {
			if (classAttendanceDef.getModification().equals(CLASS_DEF_MODIFICATION.Added.name())) {
				ClassAttendanceDef updatedAttendanceDef = (ClassAttendanceDef) createOrUpdateEntity(classAttendanceDef);
				updatedClassAttendanceDefList.add(updatedAttendanceDef);
			} else if (classAttendanceDef.getModification().equals(CLASS_DEF_MODIFICATION.Deleted.name())) {
				removeEntityByID(ClassAttendanceDef.class, classAttendanceDef.getId());
			}
		}

		return updatedClassAttendanceDefList;
	}

}
