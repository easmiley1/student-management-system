package com.ish.sms.service.util;

/**
 * 
 * This interface has all the query related constants
 * 
 * @author Naren
 * 
 */
public interface QueryConstants {

	/* Associate Operations related queries*/
	public static final String FIND_ALL_STUDENTS = "FIND_ALL_STUDENTS";
	public static final String FIND_ALL_STUDENTS_QUERY = "select st from com.ish.sms.service.entity.Student st";
	public static final String FIND_STUDENT = "FIND_STUDENT";
	public static final String FIND_STUDENT_QUERY = "select st from com.ish.sms.service.entity.Student st where st.id=:id";
	public static final String FIND_ALL_TEACHERS = "FIND_ALL_TEACHERS";
	public static final String FIND_ALL_TEACHERS_QUERY = "select teacher from com.ish.sms.service.entity.Teacher teacher";
	public static final String FIND_ALL_STUDENTS_BY_CLASS = "FIND_ALL_STUDENTS_BY_CLASS";
	public static final String FIND_ALL_STUDENTS_BY_CLASS_QUERY = "select st from com.ish.sms.service.entity.Student st where st.currentClass.id =:id";
	public static final String FIND_ALL_STUDENTS_BY_CLASS_LIST = "FIND_ALL_STUDENTS_BY_CLASS_LIST";
	public static final String FIND_ALL_STUDENTS_BY_CLASS_LIST_QUERY = "select st from com.ish.sms.service.entity.Student st where st.currentClass.id in :idList";

	/* Reference Data Operations related queries*/
	public static final String FIND_ALL_REFERENCE_DATA = "FIND_ALL_REFERENCE_DATA";
	public static final String FIND_ALL_REFERENCE_DATA_QUERY = "select ref from com.ish.sms.service.entity.ReferenceData ref";

	/*Class Operations related queries*/
	public static final String FIND_ALL_CLASS_FOR_ID_LIST = "FIND_ALL_CLASS_FOR_ID_LIST";
	public static final String FIND_ALL_CLASS_FOR_ID_LIST_QUERY = "select cl from com.ish.sms.service.entity.Class cl where cl.id in :idList";
	public static final String FIND_NEW_CLASS = "FIND_NEW_CLASS";
	public static final String FIND_NEW_CLASS_QUERY = "select cl from com.ish.sms.service.entity.Class cl where cl.name = :name and cl.startYear = :startYear" +
			" and cl.active='active'";
	public static final String FIND_CLASS_BY_ID = "FIND_CLASS_BY_ID";
	public static final String FIND_CLASS_BY_ID_QUERY = "select cl from com.ish.sms.service.entity.Class cl where cl.id= :id";
	public static final String FIND_ALL_CLASSES = "FIND_ALL_CLASSES";
	public static final String FIND_ALL_CLASSES_QUERY = "select cl from com.ish.sms.service.entity.Class cl where cl.active='active'";
	public static final String FIND_ALL_CLASSES_FOR_PRMTN = "FIND_ALL_CLASSES_FOR_PRMTN";
	public static final String FIND_ALL_CLASSES_FOR_PRMTN_QUERY = "select cl from com.ish.sms.service.entity.Class cl where cl.active='active' and cl.startYear=:startYear";
	public static final String FIND_CLASS_ATTENDANCE_DEF = "FIND_CLASS_ATTENDANCE_DEF";
	public static final String FIND_ASSOCIATE_CURR_YEAR_ATT_DATA = "FIND_ASSOCIATE_CURR_YEAR_ATT_DATA";
	public static final String FIND_ASSOCIATE_CURR_YEAR_ATT_DATA_QUERY = "select aa from com.ish.sms.service.entity.ClassAttendanceDef cad," +
			" com.ish.sms.service.entity.AssociateAttendance aa where cad.id = aa.classAttendanceDef.id and cad.classRef.id = :classid and aa.student.id = :studentid";	
	public static final String FIND_CLASS_ATTENDANCE_DEF_QUERY = "select cad from com.ish.sms.service.entity.ClassAttendanceDef cad where cad.classRef.id=:id";
	public static final String FIND_CLASS_EXAM_REFERENCE_DATA = "FIND_CLASS_EXAM_REFERENCE_DATA";
	public static final String FIND_CLASS_EXAM_REFERENCE_DATA_QUERY = "select cerd from com.ish.sms.service.entity.ClassExamReferenceData cerd where cerd.classRef.id=:id";
	public static final String FIND_CLASS_SUBJECT_REFERENCE_DATA = "FIND_CLASS_SUBJECT_REFERENCE_DATA";
	public static final String FIND_CLASS_SUBJECT_REFERENCE_DATA_QUERY = "select csrd from com.ish.sms.service.entity.ClassSubjectReferenceData csrd where csrd.classRef.id=:id";
	public static final String FIND_ASSOCIATE_ATTENDANCE_DATA = "FIND_ASSOCIATE_ATTENDANCE_DATA";
	public static final String FIND_ASSOCIATE_ATTENDANCE_DATA_QUERY = "select aa from com.ish.sms.service.entity.AssociateAttendance aa where aa.classAttendanceDef.id=:id";
	public static final String FIND_CLASS_TIME_TABLE = "FIND_CLASS_TIME_TABLE";
	public static final String FIND_CLASS_TIME_TABLE_QUERY = "select ctt from com.ish.sms.service.entity.ClassTimeTable ctt where ctt.classRef.id=:id";
	public static final String FIND_CLASS_GRADE_DETAILS = "FIND_CLASS_GRADE_DETAILS";
	public static final String FIND_CLASS_GRADE_DETAILS_QUERY = "select sg from com.ish.sms.service.entity.StudentGrade sg where sg.classRef.id=:id and sg.classExamReferenceData.id=:examId";
	public static final String FIND_CLASS_GRADE_DETAILS_FOR_STUDENT = "FIND_CLASS_GRADE_DETAILS_FOR_STUDENT";
	public static final String FIND_CLASS_GRADE_DETAILS_FOR_STUDENT_QUERY = "select sg from com.ish.sms.service.entity.StudentGrade sg where sg.classRef.id=:id and sg.student.id=:studentid";
	public static final String FIND_CLASS_STUDENT_DETAILS = "FIND_CLASS_STUDENT_DETAILS";
	public static final String FIND_CLASS_STUDENT_DETAILS_QUERY = "select cs from com.ish.sms.service.entity.ClassStudent cs where cs.classObj.id=:id and cs.student.id=:studentid";
	
	
	/*User Details related queries*/
	public static final String FIND_ALL_ROLES_QUERY = "select ur from com.ish.sms.service.entity.UserRole ur";
	public static final String FIND_ALL_ROLES = "FIND_ALL_ROLES";	
	public static final String FIND_ALL_USERS_QUERY = "select user from com.ish.sms.service.entity.User user";
	public static final String FIND_ALL_USERS = "FIND_ALL_USERS";	
	public static final String FIND_USER_FOR_NAME = "FIND_USER_FOR_NAME";
	public static final String FIND_USER_FOR_NAME_QUERY = "select user from com.ish.sms.service.entity.User user where user.name=:name";
	

}
