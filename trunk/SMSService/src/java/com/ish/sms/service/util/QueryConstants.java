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
	public static final String FIND_ALL_TEACHERS = "FIND_ALL_TEACHERS";
	public static final String FIND_ALL_TEACHERS_QUERY = "select teacher from com.ish.sms.service.entity.Teacher teacher";
	public static final String FIND_ALL_STUDENTS_BY_CLASS = "FIND_ALL_STUDENTS_BY_CLASS";
	public static final String FIND_ALL_STUDENTS_BY_CLASS_QUERY = "select st from com.ish.sms.service.entity.Student st where st.currentClass.id =:id";
	
	/* Reference Data Operations related queries*/
	public static final String FIND_ALL_REFERENCE_DATA = "FIND_ALL_REFERENCE_DATA";
	public static final String FIND_ALL_REFERENCE_DATA_QUERY = "select ref from com.ish.sms.service.entity.ReferenceData ref";

	/*Class Operations related queries*/
	public static final String FIND_CLASS_BY_ID = "FIND_CLASS_BY_ID";
	public static final String FIND_CLASS_BY_ID_QUERY = "select cl from com.ish.sms.service.entity.Class cl where cl.id= :id";
	public static final String FIND_ALL_CLASSES = "FIND_ALL_CLASSES";
	public static final String FIND_ALL_CLASSES_QUERY = "select cl from com.ish.sms.service.entity.Class cl where cl.active='active'";
	public static final String FIND_CLASS_ATTENDANCE_DEF = "FIND_CLASS_ATTENDANCE_DEF";
	public static final String FIND_CLASS_ATTENDANCE_DEF_QUERY = "select cad from com.ish.sms.service.entity.ClassAttendanceDef cad where cad.classRef.id=:id";
	public static final String FIND_CLASS_EXAM_REFERENCE_DATA = "FIND_CLASS_EXAM_REFERENCE_DATA";
	public static final String FIND_CLASS_EXAM_REFERENCE_DATA_QUERY = "select cerd from com.ish.sms.service.entity.ClassExamReferenceData cerd where cerd.classRef.id=:id";
	public static final String FIND_CLASS_SUBJECT_REFERENCE_DATA = "FIND_CLASS_SUBJECT_REFERENCE_DATA";
	public static final String FIND_CLASS_SUBJECT_REFERENCE_DATA_QUERY = "select csrd from com.ish.sms.service.entity.ClassSubjectReferenceData csrd where csrd.classRef.id=:id";
	public static final String FIND_ASSOCIATE_ATTENDANCE_DATA = "FIND_ASSOCIATE_ATTENDANCE_DATA";
	public static final String FIND_ASSOCIATE_ATTENDANCE_DATA_QUERY = "select aa from com.ish.sms.service.entity.AssociateAttendance aa where aa.classAttendanceDef.id=:id";
	public static final String FIND_CLASS_TIME_TABLE = "FIND_CLASS_TIME_TABLE";
	public static final String FIND_CLASS_TIME_TABLE_QUERY = "select ctt from com.ish.sms.service.entity.ClassTimeTable ctt where ctt.classRef.id=:id";

}
