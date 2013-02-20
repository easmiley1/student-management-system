package com.ish.sms.service.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ish.sms.service.dto.AttendanceMap;
import com.ish.sms.service.entity.AssociateAttendance;
import com.ish.sms.service.entity.Class;
import com.ish.sms.service.entity.ClassAttendanceDef;
import com.ish.sms.service.entity.Student;

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
	@SuppressWarnings("unchecked")
	public List<ClassAttendanceDef> updateClassAttendanceDefList(List<ClassAttendanceDef> classAttendanceDefList) {
		List<ClassAttendanceDef> updatedClassAttendanceDefList = new ArrayList<ClassAttendanceDef>();

		for (ClassAttendanceDef classAttendanceDef : classAttendanceDefList) {
			if (classAttendanceDef.getModification().equals(CLASS_DEF_MODIFICATION.Added.name())) {

				ClassAttendanceDef updatedAttendanceDef = (ClassAttendanceDef) createOrUpdateEntity(classAttendanceDef);
				createAssociateAttendanceForMonthDef(updatedAttendanceDef);

				updatedClassAttendanceDefList.add(updatedAttendanceDef);
			} else if (classAttendanceDef.getModification().equals(CLASS_DEF_MODIFICATION.Deleted.name())) {
				Map<String, Object> queryParametersMap = new HashMap<String, Object>();
				queryParametersMap.put(ID, classAttendanceDef.getId());
				List<AssociateAttendance> associateAttendanceList = (List<AssociateAttendance>) retrieveResultListForQueryWithParameters(
						FIND_ASSOCIATE_ATTENDANCE_DATA, queryParametersMap);
				for(AssociateAttendance associateAttendance: associateAttendanceList){
					removeEntityByID(AssociateAttendance.class, associateAttendance.getId());
				}
				removeEntityByID(ClassAttendanceDef.class, classAttendanceDef.getId());
			}
		}

		return updatedClassAttendanceDefList;
	}

	/**
	 * Create default Attendance data for the given month definition
	 * 
	 * @param updatedAttendanceDef
	 */
	@SuppressWarnings("unchecked")
	public void createAssociateAttendanceForMonthDef(ClassAttendanceDef updatedAttendanceDef) {
		String monthYear = updatedAttendanceDef.getMonthYear();
		int noOfDays = classOperationsDAOUtil.getNoofDaysforMonth(monthYear);
		Class classObj = updatedAttendanceDef.getClassRef();
		Map<String, Object> queryParametersMap = new HashMap<String, Object>();
		queryParametersMap.put(ID, classObj.getId());
		List<Student> studentList = (List<Student>) retrieveResultListForQueryWithParameters(FIND_ALL_STUDENTS_BY_CLASS, queryParametersMap);

		for (Student student : studentList) {
			AssociateAttendance associateAttendance = new AssociateAttendance();
			associateAttendance.setClassAttendanceDef(updatedAttendanceDef);
			associateAttendance.setStudent(student);
			AttendanceMap<String, Boolean> attendanceMap = new AttendanceMap<String, Boolean>();
			for (int i = 1; i <= noOfDays; i++) {
				String day = "" + i;
				attendanceMap.put(day, false);
			}
			associateAttendance.setAttendanceMap(attendanceMap);
			createOrUpdateEntity(associateAttendance);
		}
	}

	/**
	 * Method to create the default classAttendanceDef if nothing is found in database. (First Time user)
	 * 
	 * @param classId
	 * @return classAttendanceDef
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public ClassAttendanceDef createDefaultClassAttendanceDef(Integer classId) throws Exception {

		Map<String, Object> queryParametersMap = new HashMap<String, Object>();
		queryParametersMap.put(ID, classId);
		Class classObj = (Class) retrieveSingleResultForQueryWithParameters(FIND_CLASS_BY_ID, Class.class, queryParametersMap);

		ClassAttendanceDef classAttendanceDef = new ClassAttendanceDef();
		classAttendanceDef.setClassRef(classObj);
		String monthYear = classOperationsDAOUtil.getCurrentMonthYear();
		classAttendanceDef.setMonthYear(monthYear);
		classAttendanceDef.setModification(CLASS_DEF_MODIFICATION.Added.name());

		List<ClassAttendanceDef> newClassAttendanceDefList = new ArrayList<ClassAttendanceDef>();
		newClassAttendanceDefList.add(classAttendanceDef);
		return updateClassAttendanceDefList(newClassAttendanceDefList).get(0);
	}

}
