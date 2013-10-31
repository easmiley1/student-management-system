package com.ish.sms.service.ops;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ish.sms.service.dao.AssociateOperationsDAO;
import com.ish.sms.service.dao.ClassAttendanceOperationsDAO;
import com.ish.sms.service.dao.ClassOperationsDAO;
import com.ish.sms.service.dao.ReferenceOperationsDAO;
import com.ish.sms.service.dao.ReportOperationsDAO;
import com.ish.sms.service.dao.UserOperationsDAO;
import com.ish.sms.service.dto.ClassAttendanceDefListDTO;
import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassListDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.service.dto.StudentListDTO;
import com.ish.sms.service.dto.TeacherDTO;
import com.ish.sms.service.dto.TeacherListDTO;
import com.ish.sms.service.entity.Class;
import com.ish.sms.service.entity.ClassAttendanceDef;
import com.ish.sms.service.entity.Student;
import com.ish.sms.service.entity.Teacher;
import com.ish.sms.service.ops.util.AssociateOperationsUtil;
import com.ish.sms.service.ops.util.ClassAttendanceOperationsUtil;
import com.ish.sms.service.ops.util.ClassOperationsUtil;
import com.ish.sms.service.ops.util.ReportOperationsUtil;
import com.ish.sms.service.ops.util.UserOperationsUtil;
import com.ish.sms.service.util.EntityConstants;
import com.ish.sms.service.util.QueryConstants;

public class BaseOperations implements QueryConstants, EntityConstants {

	@Autowired
	protected ReferenceOperationsDAO referenceOperationsDAO;

	@Autowired
	protected AssociateOperationsDAO associateOperationsDAO;

	@Autowired
	protected ClassOperationsDAO classOperationsDAO;

	@Autowired
	protected ClassAttendanceOperationsDAO classAttendanceOperationsDAO;

	@Autowired
	protected UserOperationsDAO userOperationsDAO;

	@Autowired
	protected ReportOperationsDAO reportOperationsDAO;

	@Autowired
	protected AssociateOperationsUtil associateOperationsUtil;

	@Autowired
	protected ClassOperationsUtil classOperationsUtil;

	@Autowired
	protected ClassAttendanceOperationsUtil classAttendanceOperationsUtil;

	@Autowired
	protected UserOperationsUtil userOperationsUtil;

	@Autowired
	protected ReportOperationsUtil reportOperationsUtil;

	/**
	 * Method to return the list of all the teachers in the school.
	 * 
	 * @return teacherList
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public TeacherListDTO retrieveAllTeachers() throws Exception {

		TeacherListDTO teacherListDTO = new TeacherListDTO();
		List<Teacher> teachersList = (List<Teacher>) associateOperationsDAO.retrieveResultsForquery(FIND_ALL_TEACHERS);
		for (Teacher teacher : teachersList) {
			TeacherDTO teacherDTO = associateOperationsUtil.convertTeacherEntityToDTO(teacher);
			teacherListDTO.getTeacherDTOList().add(teacherDTO);
		}
		return teacherListDTO;
	}

	/**
	 * Method to return the list of classes for a specified classid list
	 * 
	 * @param classIdList
	 * @return classList {@link ClassDTO}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public ClassListDTO retrieveClassesForIdList(List<Integer> classIdList) throws Exception {

		ClassListDTO classListDTO = new ClassListDTO();
		Map<String, Object> queryParametersMap = new HashMap<String, Object>();
		queryParametersMap.put(ID_LIST, classIdList);
		List<Class> classList = (List<Class>) classOperationsDAO.retrieveResultListForQueryWithParameters(FIND_ALL_CLASS_FOR_ID_LIST, queryParametersMap);
		for (Class classObj : classList) {
			ClassDTO classDTO = classOperationsUtil.convertClassEntityToDTO(classObj);
			classListDTO.getClassDTOList().add(classDTO);
		}
		return classListDTO;
	}

	/**
	 * Method to return the list of students for a specified studentid list
	 * 
	 * @param studentIdList
	 * @return studentList
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public StudentListDTO retrieveStudentForIdList(List<Integer> studentIdList) throws Exception {

		StudentListDTO studentListDTO = new StudentListDTO();
		Map<String, Object> queryParametersMap = new HashMap<String, Object>();
		queryParametersMap.put(ID_LIST, studentIdList);
		List<Student> studentList = (List<Student>) associateOperationsDAO.retrieveResultListForQueryWithParameters(FIND_ALL_STUDENTS_FOR_ID_LIST,
				queryParametersMap);
		for (Student student : studentList) {
			StudentDTO studentDTO = classOperationsUtil.convertStudentEntitytoDTO(student);
			studentListDTO.getStudentDTOList().add(studentDTO);
		}
		return studentListDTO;
	}

	/**
	 * Method to return the list of months in the attendance register
	 * 
	 * @param classId
	 * @return {@link ClassAttendanceDefListDTO}
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ClassAttendanceDefListDTO retrieveClassAttendanceDefListForClass(Integer classId) throws Exception {
		Map<String, Object> queryParametersMap = new HashMap<String, Object>();
		queryParametersMap.put(ID, classId);
		List<ClassAttendanceDef> classAttendanceList = (List<ClassAttendanceDef>) classAttendanceOperationsDAO.retrieveResultListForQueryWithParameters(
				FIND_CLASS_ATTENDANCE_DEF, queryParametersMap);
		return classAttendanceOperationsUtil.convertClassAttendanceListToDTO(classAttendanceList);
	}

	/**
	 * Method to return the student details for the given id.
	 * 
	 * @param studentId
	 * @return studentDTO
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public StudentDTO retrieveStudentDetails(Integer studentId) throws Exception {

		Map<String, Object> queryParametersMap = new HashMap<String, Object>();
		queryParametersMap.put(ID, studentId);
		Student student = (Student) associateOperationsDAO.retrieveSingleResultForQueryWithParameters(FIND_STUDENT, Student.class, queryParametersMap);
		StudentDTO studentDTO = associateOperationsUtil.convertStudentEntitytoDTO(student);
		return studentDTO;
	}
}
