package com.ish.sms.service.util;

public interface EntityConstants {

	public static final String ID = "id";
	public static final String ID_LIST = "idList";
	public static final String EXAM_ID = "examId";
	public static final String NAME = "name";
	public static final String SEMI_COLON = ";";

	public static enum CLASS_DEF_MODIFICATION {
		Deleted, Added
	};

	public static enum REFERENCE_TYPE {
		BloodGroup, DayofWeek, ExtraCurricularInterest, Transportation, StateName, SubjectName, Exam
	};

	public static enum ROLE_NAME {
		ADMIN_ROLE, OFFICE_ROLE, PARENT_ROLE, TEACHER_ROLE
	}

}
