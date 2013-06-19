package com.ish.sms.service.util;

/**
 * Interface that contain all the entity related constants.
 * 
 * @author Naren
 *
 */
public interface EntityConstants {

	public static final String ID = "id";
	public static final String ID_LIST = "idList";
	public static final String EXAM_ID = "examId";
	public static final String NAME = "name";
	public static final String START_YEAR = "startYear";
	public static final String SEMI_COLON = ";";
	public static final String STUDENT_ID = "studentid";
	public static final String CLASS_ID = "classid";
	public final static String ACTIVE = "active";
	

	public static enum CLASS_DEF_MODIFICATION {
		Deleted, Added
	};

	public static enum REFERENCE_TYPE {
		BloodGroup, DayofWeek, ExtraCurricularInterest, Transportation, StateName, SubjectName, Exam, ClassName
	};

	public static enum ROLE_NAME {
		ADMIN_ROLE, OFFICE_ROLE, PARENT_ROLE, TEACHER_ROLE
	}

}
