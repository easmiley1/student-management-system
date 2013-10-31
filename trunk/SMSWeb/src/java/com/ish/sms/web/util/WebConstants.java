package com.ish.sms.web.util;

/**
 * Interface that contains all the web constants.
 * 
 * @author Naren
 * 
 */
public interface WebConstants {

	public final static String DEFAULT_GENDER = "Male";
	public final static String PERIOD = "Period ";
	public final static String ACTIVE = "active";
	public final static String FROM_CLASS = "#fromClass";
	public final static String TO_CLASS = "#toClass";

	/* DTO Name related constants */
	public final static String STUDENT_DTO = "studentDTO";
	public final static String TEACHER_DTO = "teacherDTO";
	public final static String STUDENTLIST_DTO = "studentListDTO";
	public final static String CLASS_PROMOTION_DTO = "classPromotionDTO";
	public final static String CLASS_STUDENT_DTO = "classStudentDTO";
	public final static String CLASS_DTO = "classDTO";
	public final static String STUDENTGRADEDETAILS_DTO = "studentGradeListDTO";
	public final static String CLASSGRADEDETAILS_DTO = "classGradeDetailsDTO";
	public final static String STRING_LIST_DTO = "stringListDTO";
	public final static String CLASSATTENDANCEDEFLIST_DTO = "classAttendanceDefListDTO";
	public final static String ASSOCIATEATTENDANCELIST_DTO = "associateAttendanceListDTO";

	/* XHTML page navigation related constants */
	public final static String SAVE_STUDENT_PAGE = "/pages/content/associate/details/add-modify/saveStudentDetails.xhtml";
	public final static String SAVE_TEACHER_PAGE = "/pages/content/associate/details/add-modify/saveTeacherDetails.xhtml";
	public final static String MODIFY_STUDENT_LIST_PAGE = "/pages/content/associate/details/search/modifyStudentDetailsGridPage.xhtml";
	public final static String VIEW_STUDENT_LIST_PAGE = "/pages/content/associate/details/search/viewStudentDetailsGridPage.xhtml";
	public final static String MODIFY_TEACHER_LIST_PAGE = "/pages/content/associate/details/search/modifyTeacherDetailsGridPage.xhtml";
	public final static String VIEW_TEACHER_LIST_PAGE = "/pages/content/associate/details/search/viewTeacherDetailsGridPage.xhtml";
	public final static String MODIFY_CLASS_ATTENDANCE_PAGE = "/pages/content/class/attendance/saveClassMonthAttendance.xhtml";
	public final static String SAVE_CLASS_PAGE = "/pages/content/class/details/add-modify/saveClassDetailsContainer.xhtml";
	public final static String SAVE_CLASS_GRADE_PAGE = "/pages/content/class/grade/saveClassGrade.xhtml";
	public final static String MODIFY_CLASS_LIST_PAGE = "/pages/content/class/details/search/modifyClassDetailsGridPage.xhtml";
	public final static String REPORT_CARD_PAGE = "/pages/content/class/reportcard/reportCard.xhtml";
	public final static String MODIFY_CLASS_TIME_TABLE = "/pages/content/class/details/timetable/saveClassTimeTable.xhtml";
	public final static String ATTENDANCE_REPORT_PAGE = "/pages/content/reports/student/attendanceReport.xhtml";
	public final static String CLASS_PROMOTION_PAGE = "/pages/content/class/promotion/classPromotionPage.xhtml";

	/* Jboss cache related constants */
	public static final String BLOOD_GROUP_KEY = "BLOOD_GROUP_KEY";
	public static final String EXTRA_CURRICULAR_KEY = "EXTRA_CURRICULAR_KEY";
	public static final String CLASS_KEY = "CLASS_CURRICULAR_KEY";
	public static final String CLASS_NAME_KEY = "CLASS_NAME_CURRICULAR_KEY";
	public static final String STATE_KEY = "STATE_KEY";
	public static final String SUBJECT_KEY = "SUBJECT_KEY";
	public static final String MODE_OF_TRANSPORT_KEY = "MODE_OF_TRANSPORT_KEY";
	public static final String TEACHER_KEY = "TEACHER_KEY";
	public static final String DAYS_OF_WEEK_KEY = "DAYS_OF_WEEK_KEY";
	public static final String EXAM_KEY = "EXAM_KEY";
	public static final String BLOOD_GROUP_FQN = "cache/reference/bloodgroup";
	public static final String STATE_FQN = "cache/reference/state";
	public static final String MODE_OF_TRANSPORT_FQN = "cache/reference/modeoftranport";
	public static final String EXTRA_CURRICULAR_FQN = "cache/reference/extracurricular";
	public static final String CLASS_FQN = "cache/reference/class";
	public static final String SUBJECT_FQN = "cache/reference/subject";
	public static final String TEACHER_FQN = "cache/reference/teacher";
	public static final String DAYS_OF_WEEK_FQN = "cache/reference/daysOfWeek";
	public static final String EXAM_FQN = "cache/reference/exam";
	public static final String CLASS_NAME_FQN = "cache/reference/className";
	public static final String REPL_SYNC_FILE = "replSync-eviction-service.xml";
	public static final String TREECACHE_MBEAN_SERVICE = "jboss.cache:service=TreeCache";

	/* Bean name related constants */
	public static final String JBOSS_CACHE_PROVIDER = "jbossCacheProvider";
	public static final String CLASS_ATTENDANCE_BEAN = "classAttendanceBean";
	public static final String REFERENCE_BEAN = "referenceBean";
	public static final String CLASS_GRADE_BEAN = "classGradeBean";
	public static final String ATTENDANCE_REPORT_BEAN = "attendanceReportBean";
	public static final String REPORT_CARD_BEAN = "reportCardBean";
	public static final String ASSOCIATE_BUSINESS_BEAN = "associateBusiness";
	public static final String CLASS_PROMOTION_BEAN = "classPromotionBean";
	public static final String CLASS_ATTENDANCE_BUSINESS_BEAN = "classAttendanceBusiness";
	public static final String CLASS_BUSINESS_BEAN = "classBusiness";
	public static final String REPORT_BUSINESS_BEAN = "reportBusiness";
	public static final String CLASS_BEAN = "classBean";
	public static final String REFERENCE_DATA_CONVERTER = "referenceDataConverter";
	public static final String CLASS_ATTENDANCE_DEF_CONVERTER = "classAttendanceDefConverter";
	public static final String CLASS_CONVERTER = "classConverter";
	public static final String ASSOCIATE_CONVERTER = "associateConverter";
	public static final String STUDENT_CONVERTER = "studentConverter";

	/* Message related constants */
	public static final String SAVE_FAILED = "Save Failed @ ";
	public static final String CONTACT_TECHNICAL_TEAM = "Server Error. Please contact Technical Support";
	public static final String SAVE_SUCCESSFULL = "Save Successful";
	public static final String STUDENT_SAVED_SUCCESSFULLY = "Student Succcessfully Saved";
	public static final String TEACHER_SAVED_SUCCESSFULLY = "Teacher Succcessfully Saved";
	public static final String CLASS_SAVED_SUCCESSFULLY = "Class Succcessfully Saved";
	public static final String COMMENTS_SAVED_SUCCESSFULLY = "Comments Succcessfully Saved";
	public static final String REGISTER_DEF_SAVED = "Register definition changes saved successfully";
	public static final String REGISTER_SAVED = "Register changes saved successfully for : ";
	public static final String GRADE_DETAILS_SAVED = "Grade Details saved successfully for exam : ";
	public static final String NO_CHANGES = "No changes Found to save";
	public static final String NO_CHANGE_IN_REGISTER = "Register Months are unmodified.";
	public static final String CANNOT_SAVE = "Cannot save changes : ";
	public static final String REGISTER_DEF_CANNOT_SAVE_DETAIL = "You are trying to remove a month, that is currently displayed in Attendance Register, "
			+ "Please change the selected month in the register and then delete the month. ";
	public static final String CANNOT_MODIFY_GRADE_DETAILS = "Cannot modify grade details : ";
	public static final String EXAM_DETAIL_NOT_FOUND = "No exams are associated to this class, hence create/modify grade details for this class ";
	public static final String AUTH_ERROR = "Authorization error : ";
	public static final String CLASS_DETAILS_NOT_FOUND = "No class associated to this user";
	public static final String SUBJECT_DETAIL_NOT_FOUND = "No subjects are associated to this class and hence create/modify grade details for this class ";
	public static final String CLASS_PROMOTION = "Class Promoted Successfully";
	public static final String CLASS_PROMOTION_DETAILS = "Class #fromClass is successfuly promoted to #toClass";

	/* PDF Related Constants */
	public static final String TIMES_NEW_ROMAN = "Times-Roman";
	public static final String BLUE_COLOR = "#E1ECF5";
	public static final String STUDENT = "Student : ";
	public static final String CLASS = "Class : ";
	public static final String COMMENTS = "Comments:";
	public static final String RESPONSE_HEADER_CONTENT = "Content-Disposition";
	public static final String RESPONSE_HEADER_ATTACHEMENT = "attachment; filename=\"";
	public static final String PDF_EXTENSION = "_Reportcard.pdf";
	public static final String NEW_LINE = " \n";
	public static final String CONTENT_TYPE = "application/pdf";
	public static final String SUBJECT = "Subject";
	public static final String BLANK = " ";

	/* Role name enum */
	public static enum ROLE_NAME {
		ADMIN_ROLE, OFFICE_ROLE, PARENT_ROLE, TEACHER_ROLE
	}

	/* Menu related constants */
	public static final String TOOLBAR_ID = "toolbarId";
	public static final String TOOLBAR_GROUP_ID = "tooolbargroupId";
	public static final String TOOLBAR_THEME_GROUP_ID = "tooolbarThemegroupId";
	public static final String LEFT_ALIGN = "left";
	public static final String RIGHT_ALIGN = "right";
	public static final String ZERO_PADDING = "padding:0px;";
	public static final String MENUBAR_ID = "menuBarId";
	public static final String CLOSE_BRACES = ")}";
	public static final String REPORT_CARD = "Report Card";
	public static final String REPORT_CARD_MENU_ID = "reportCardMenuId";
	// Parent Portal
	public static final String PARENT_PORTAL = "Parent Portal";
	public static final String PARENT_PORTAL_SUBMENU_ID = "parentPortalSubmenuId";
	public static final String STUDENT_DETAILS = "Student Details";
	public static final String STUDENT_DETAILS_MENU_ID = "studentDetailsMenuId";
	public static final String STUDENT_DETAILS_ACTION_EXPR = "#{associateAction.initStudentDetails(";
	public static final String ATTENDANCE_DETAILS = "Attendance Details";
	public static final String ATTENDANCE_DETAILS_MENU_ID = "attendanceDetailsMenuId";
	public static final String ATTENDANCE_DETAILS_ACTION_EXPR = "#{attendanceReportAction.initStudentAttendanceReport(";
	public static final String REPORT_CARD_ACTION_EXPR = "#{reportCardAction.openReportCardRegisterForStudent(";
	// Student Management
	public static final String STUDENT_MANAGEMENT = "Student Management";
	public static final String STUDENT_MANAGEMENT_SUBMENU_ID = "studentManagementSubmenuId";
	public static final String ADD_STUDENT_DETAILS = "Add Student Details";
	public static final String ADD_STUDENT_DETAILS_ACTION = "#{associateAction.initAddStudentPersonalDetails}";
	public static final String ADD_STUDENT_DETAILS_MENU_ID = "addStudentDetailsMenuId";
	public static final String MODIFY_STUDENT = "Modify Student";
	public static final String MODIFY_STUDENT_ACTION = "#{associateAction.initModifySearchAllStudents}";
	public static final String MODIFY_STUDENT_MENU_ID = "modifyStudentMenuId";
	public static final String VIEW_STUDENT = "View Student";
	public static final String VIEW_STUDENT_ACTION = "#{associateAction.initViewSearchAllStudents}";
	public static final String VIEW_STUDENT_MENU_ID = "viewStudentMenuId";
	// Teacher Management
	public static final String TEACHER_MANAGEMENT = "Teacher Management";
	public static final String TEACHER_MANAGEMENT_SUBMENU_ID = "teacherManagementSubmenuId";
	public static final String ADD_TEACHER_DETAILS = "Add Teacher Details";
	public static final String ADD_TEACHER_DETAILS_ACTION = "#{associateAction.initAddTeacherPersonalDetails}";
	public static final String ADD_TEACHER_DETAILS_MENU_ID = "addTeacherDetailsMenuId";
	public static final String MODIFY_TEACHER = "Modify Teacher";
	public static final String MODIFY_TEACHER_ACTION = "#{associateAction.initModifySearchAllTeachers}";
	public static final String MODIFY_TEACHER_MENU_ID = "modifyTeacherMenuId";
	public static final String VIEW_TEACHER = "View Teacher";
	public static final String VIEW_TEACHER_ACTION = "#{associateAction.initViewSearchAllTeachers}";
	public static final String VIEW_TEACHER_MENU_ID = "viewTeacherMenuId";
	// Class Management
	public static final String CLASS_MANAGEMENT = "Class Management";
	public static final String CLASS_MANAGEMENT_SUBMENU_ID = "classManagementSubmenuId";
	public static final String CLASS_MAINTENANCE = "Class Maintenance";
	public static final String CLASS_MAINTENANCE_SUBMENU_ID = "classMaintenanceSubmenuId";
	public static final String ADD_CLASS_DETAILS = "Add Class Details";
	public static final String ADD_CLASS_DETAILS_MENU_ID = "addClassDetailsMenuId";
	public static final String ADD_CLASS_DETAILS_ACTION = "#{classAction.initAddClassDetails}";
	public static final String MODIFY_CLASS_DETAILS = "Modify Class Details";
	public static final String MODIFY_CLASS_DETAILS_MENU_ID = "modifyClassDetailsMenuId";
	public static final String MODIFY_CLASS_DETAILS_ACTION = "#{classAction.initEditSearchClass}";
	public static final String ATTENDANCE_REGISTER = "Attendance Register";
	public static final String ATTENDANCE_REGISTER_SUBMENU_ID = "attendanceRegisterSubmenuId";
	public static final String OPEN_REGISTER_ID = "openRegisterId_";
	public static final String OPEN_REGISTER_ACTION = "#{attendanceRegisterAction.openAttendanceRegister(";
	public static final String TIME_TABLE = "Time Table";
	public static final String TIME_TABLE_SUBMENU_ID = "timeTableSubmenuId";
	public static final String OPEN_TIMETABLE_ACTION = "#{classAction.openClassTimeTable(";
	public static final String OPEN_TIMETABLE_ID = "openTimeTableMenuId";
	public static final String GRADE_BOOK = "Grade Book";
	public static final String GRADE_BOOK_SUBMENU_ID = "gradeBookSubmenuId";
	public static final String GRADE_BOOK_ACTION = "#{classGradeAction.openClassGradePage(";
	public static final String GRADE_BOOK_ID = "gradeBookMenuId";
	public static final String CLASS_PROMOTIONS = "Class Promotions";
	public static final String CLASS_PROMOTIONS_MENU_ID = "classPromotionsMenuId";
	public static final String CLASS_PROMOTIONS_ACTION = "#{classPromotionAction.initClassPromotion()}";
	public static final String REPORT_CARD_CLASS_ACTION = "#{reportCardAction.openReportCardRegister(";
	// Reports
	public static final String REPORTS = "Reports";
	public static final String REPORTS_SUBMENU_ID = "reportsSubmenuId";
	public static final String ATTENDANCE_REPORTS = "Attendance Reports";
	public static final String ATTENDANCE_REPORTS_MENU_ID = "attendanceReportsSubmenuId";
	public static final String ATTENDANCE_REPORTS_ACTION = "#{attendanceReportAction.initAttendanceReport()}";
	

}
