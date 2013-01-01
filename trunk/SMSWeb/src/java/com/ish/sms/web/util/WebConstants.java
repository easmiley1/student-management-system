package com.ish.sms.web.util;

public interface WebConstants {

	public final static String DEFAULT_GENDER = "Male";
	public final static String STUDENT_DTO = "studentDTO";
	public final static String TEACHER_DTO = "teacherDTO";
	public final static String DEFAULT_MOD_OF_TRSPRT = "School";
	public final static String SAVE_STUDENT_PAGE = "/pages/content/associate/details/add-modify/addStudentDetails.xhtml";
	public final static String SAVE_TEACHER_PAGE = "/pages/content/associate/details/add-modify/addTeacherDetails.xhtml";
	public final static String MODIFY_STUDENT_LIST_PAGE = "/pages/content/associate/details/search/modifyStudentDetailsGridPage.xhtml";
	public final static String VIEW_STUDENT_LIST_PAGE = "/pages/content/associate/details/search/viewStudentDetailsGridPage.xhtml";
	public final static String MODIFY_TEACHER_LIST_PAGE = "/pages/content/associate/details/search/modifyTeacherDetailsGridPage.xhtml";
	public final static String VIEW_TEACHER_LIST_PAGE = "/pages/content/associate/details/search/viewTeacherDetailsGridPage.xhtml";
	/* Jboss cache related constants*/
	public static final String BLOOD_GROUP_KEY = "BLOOD_GROUP_KEY";
	public static final String EXTRA_CURRICULAR_KEY = "EXTRA_CURRICULAR_KEY";
	public static final String CLASS_KEY = "CLASS_CURRICULAR_KEY";
	public static final String STATE_KEY = "STATE_KEY";
	public static final String MODE_OF_TRANSPORT_KEY = "MODE_OF_TRANSPORT_KEY";
	public static final String BLOOD_GROUP_FQN = "cache/reference/bloodgroup";
	public static final String STATE_FQN = "cache/reference/state";
	public static final String MODE_OF_TRANSPORT_FQN = "cache/reference/modeoftranport";
	public static final String EXTRA_CURRICULAR_FQN = "cache/reference/extracurricular";
	public static final String CLASS_FQN = "cache/reference/class";
	public static final String REPL_SYNC_FILE = "replSync-eviction-service.xml"; 
	public static final String TREECACHE_MBEAN_SERVICE = "jboss.cache:service=TreeCache";

}
