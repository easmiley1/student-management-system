package com.ish.sms.web.util;

public interface WebConstants {

	public final static String DEFAULT_GENDER = "Male";
	public final static String PERIOD = "Period ";
	
	/* DTO Name related constants */
	public final static String STUDENT_DTO = "studentDTO";
	public final static String TEACHER_DTO = "teacherDTO";
	public final static String CLASS_DTO = "classDTO";
	public final static String CLASSATTENDANCEDEFLIST_DTO = "classAttendanceDefListDTO";
	public final static String ASSOCIATEATTENDANCELIST_DTO = "associateAttendanceListDTO";

	/* XHTML page navigation related contants */
	public final static String SAVE_STUDENT_PAGE = "/pages/content/associate/details/add-modify/addStudentDetails.xhtml";
	public final static String SAVE_TEACHER_PAGE = "/pages/content/associate/details/add-modify/addTeacherDetails.xhtml";
	public final static String MODIFY_STUDENT_LIST_PAGE = "/pages/content/associate/details/search/modifyStudentDetailsGridPage.xhtml";
	public final static String VIEW_STUDENT_LIST_PAGE = "/pages/content/associate/details/search/viewStudentDetailsGridPage.xhtml";
	public final static String MODIFY_TEACHER_LIST_PAGE = "/pages/content/associate/details/search/modifyTeacherDetailsGridPage.xhtml";
	public final static String VIEW_TEACHER_LIST_PAGE = "/pages/content/associate/details/search/viewTeacherDetailsGridPage.xhtml";
	public final static String MODIFY_CLASS_ATTENDANCE_PAGE = "/pages/content/class/attendance/modifyClassMonthAttendance.xhtml";
	public final static String SAVE_CLASS_PAGE = "/pages/content/class/details/add-modify/addClassDetails.xhtml";

	/* Jboss cache related constants */
	public static final String BLOOD_GROUP_KEY = "BLOOD_GROUP_KEY";
	public static final String EXTRA_CURRICULAR_KEY = "EXTRA_CURRICULAR_KEY";
	public static final String CLASS_KEY = "CLASS_CURRICULAR_KEY";
	public static final String STATE_KEY = "STATE_KEY";
	public static final String SUBJECT_KEY = "SUBJECT_KEY";	
	public static final String MODE_OF_TRANSPORT_KEY = "MODE_OF_TRANSPORT_KEY";
	public static final String TEACHER_KEY = "TEACHER_KEY";
	public static final String DAYS_OF_WEEK_KEY = "DAYS_OF_WEEK_KEY";
	public static final String BLOOD_GROUP_FQN = "cache/reference/bloodgroup";
	public static final String STATE_FQN = "cache/reference/state";
	public static final String MODE_OF_TRANSPORT_FQN = "cache/reference/modeoftranport";
	public static final String EXTRA_CURRICULAR_FQN = "cache/reference/extracurricular";
	public static final String CLASS_FQN = "cache/reference/class";
	public static final String SUBJECT_FQN = "cache/reference/subject";
	public static final String TEACHER_FQN = "cache/reference/teacher";
	public static final String DAYS_OF_WEEK_FQN = "cache/reference/daysOfWeek";
	public static final String REPL_SYNC_FILE = "replSync-eviction-service.xml";
	public static final String TREECACHE_MBEAN_SERVICE = "jboss.cache:service=TreeCache";

	/* Bean name related constants */
	public static final String CLASS_ATTENDANCE_BEAN = "classAttendanceBean";
	public static final String REFERENCE_BEAN = "referenceBean";
	public static final String ASSOCIATE_BUSINESS_BEAN = "associateBusiness";
	public static final String CLASS_ATTENDANCE_BUSINESS_BEAN = "classAttendanceBusiness";
	public static final String CLASS_BUSINESS_BEAN = "classBusiness";
	public static final String REFERENCE_DATA_CONVERTER = "referenceDataConverter";
	public static final String CLASS_ATTENDANCE_DEF_CONVERTER = "classAttendanceDefConverter";
	public static final String CLASS_CONVERTER = "classConverter";
	public static final String ASSOCIATE_CONVERTER = "associateConverter";

	/* Message related constants */
	public static final String SAVE_FAILED = "Save Failed @ "; 
	public static final String CONTACT_TECHNICAL_TEAM = "Server Error. Please contact Technical Support";
	public static final String SAVE_SUCCESSFULL = "Save Successful";
	public static final String STUDENT_SAVED_SUCCESSFULLY =  "Student Succcessfully Saved";
	public static final String TEACHER_SAVED_SUCCESSFULLY =  "Teacher Succcessfully Saved";
	public static final String CLASS_SAVED_SUCCESSFULLY =  "Class Succcessfully Saved";
	public static final String REGISTER_DEF_SAVED = "Register definition changes saved successfully";
	public static final String REGISTER_SAVED = "Register changes saved successfully saved for : ";
	public static final String NO_CHANGES = "No changes Found to save";
	public static final String NO_CHANGE_IN_REGISTER = "Register Months are unmodified.";
	public static final String CANNOT_SAVE = "Cannot save changes : ";
	public static final String REGISTER_DEF_CANNOT_SAVE_DETAIL = "You are trying to remove a month, that is currently displayed in Attendance Register, " +
			"Please change the selected month in the register and then delete the month. ";
	
}
