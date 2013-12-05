package com.ish.sms.service.ops;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassGradeDetailsDTO;
import com.ish.sms.service.dto.ClassListDTO;
import com.ish.sms.service.dto.ClassPromotionDTO;
import com.ish.sms.service.dto.ClassStudentDTO;
import com.ish.sms.service.dto.ClassSubjectReferenceDataDTO;
import com.ish.sms.service.dto.ClassTimeTableListDTO;
import com.ish.sms.service.dto.GradeDetailsDTO;
import com.ish.sms.service.dto.ReportCardListDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.service.dto.StudentGradeDTO;
import com.ish.sms.service.dto.StudentGradeListDTO;
import com.ish.sms.service.entity.Class;
import com.ish.sms.service.entity.ClassExamReferenceData;
import com.ish.sms.service.entity.ClassStudent;
import com.ish.sms.service.entity.ClassSubjectReferenceData;
import com.ish.sms.service.entity.ClassTimeTable;
import com.ish.sms.service.entity.Student;
import com.ish.sms.service.entity.StudentGrade;
import com.ish.sms.service.entity.User;

/**
 * Class to handle all business logic for class related database operations
 * 
 * @author Naren
 * 
 */
public class ClassOperations extends BaseOperations {

	/**
	 * Method to return the class for a specific classid
	 * 
	 * @param classId
	 * @return {@link ClassDTO}
	 */
	@Transactional(readOnly = true)
	public ClassDTO retrieveClassForId(Integer classId) throws Exception {

		Class classObj = classOperationsDAO.retrieveClassForId(classId);
		ClassDTO classDTO = classOperationsUtil.convertClassEntityToDTO(classObj);
		return classDTO;
	}

	/**
	 * Method to return all the active classes
	 * 
	 * @return {@link ClassListDTO}
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ClassListDTO retrieveAllClassesForPromotion(String userName) throws Exception {

		/* Get list of active class for the previous year eligible for promotion */
		Map<String, Object> queryParametersMap = new HashMap<String, Object>();
		Integer promotionYear = Calendar.getInstance().get(Calendar.YEAR) - 1;
		queryParametersMap.put(START_YEAR, promotionYear);
		List<Class> classList = (List<Class>) classOperationsDAO.retrieveResultListForQueryWithParameters(FIND_ALL_CLASSES_FOR_PRMTN, queryParametersMap);

		/* Get list of classes that the user has access to. */
		queryParametersMap.clear();
		queryParametersMap.put(NAME, userName);
		User user = (User) userOperationsDAO.retrieveSingleResultForQueryWithParameters(FIND_USER_FOR_NAME, User.class, queryParametersMap);
		String[] classIdArray = user.getAssociateAccess().split(SEMI_COLON);
		List<Integer> classIdList = new ArrayList<Integer>();
		for (String classStr : classIdArray) {
			classIdList.add(new Integer(classStr));
		}

		/* Return only the intersection of the above two list */
		ClassListDTO classListDTO = new ClassListDTO();
		for (Class classObj : classList) {
			if (classIdList.contains(classObj.getId())) {
				ClassDTO classDTO = classOperationsUtil.convertClassEntityToDTO(classObj);
				classListDTO.getClassDTOList().add(classDTO);
			}
		}
		return classListDTO;
	}

	/**
	 * Method to save class details in the database including the class timetable
	 * 
	 * @param {@link ClassDTO}
	 * @return {@link ClassDTO}
	 * @throws Exception
	 */
	@Transactional
	public ClassDTO saveClassDetails(ClassDTO classDTO) throws Exception {
		Class classObj = classOperationsUtil.convertClassDTOToEntity(classDTO);
		classObj = (Class) classOperationsDAO.createOrUpdateEntity(classObj);
		classDTO = classOperationsUtil.convertClassEntityToDTO(classObj);
		return classDTO;
	}
	
	/**
	 * Method to save class student details in the database
	 * 
	 * @param {@link ClassStudentDTO}
	 * @return {@link ClassStudentDTO}
	 * @throws Exception
	 */
	@Transactional
	public ClassStudentDTO saveClassStudentDetails(ClassStudentDTO classStudentDTO) throws Exception {
		ClassStudent classStudent = classOperationsUtil.convertClassStudentDTOToEntity(classStudentDTO);
		classStudent = (ClassStudent) classOperationsDAO.createOrUpdateEntity(classStudent);
		classStudentDTO = classOperationsUtil.convertClassStudentEntityToDTO(classStudent);
		return classStudentDTO;
	}
	

	/**
	 * Method to return the timetable for a particular teacher
	 * 
	 * @param teacherId
	 * @return classTimetableListDTO
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ClassTimeTableListDTO retrieveTimetableforTeacher(Integer teacherId) throws Exception {
		
		Map<String, Object> queryParametersMap = new HashMap<String, Object>();
		queryParametersMap.put(TEACHER_ID, teacherId);
		List<ClassTimeTable> classTimeTableList = (List<ClassTimeTable>) classOperationsDAO.retrieveResultListForQueryWithParameters(
				FIND_CLASS_TIME_TABLE_FOR_TEACHER, queryParametersMap);
		ClassTimeTableListDTO classTimeTableListDTO = classOperationsUtil.convertClassTimeTableListEntitytoDTO(classTimeTableList);
		return classTimeTableListDTO;
	}
	
	/**
	 * Method to retrieve the student grade details for a particular class id
	 * 
	 * @param classId
	 * @param classExamId
	 * @return {@link StudentGradeListDTO}
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public StudentGradeListDTO retrieveClassGradeDetails(Integer classId, Integer classExamId) throws Exception {

		Map<String, Object> queryParametersMap = new HashMap<String, Object>();
		queryParametersMap.put(ID, classId);
		queryParametersMap.put(EXAM_ID, classExamId);
		List<StudentGrade> studentGradeList = (List<StudentGrade>) classOperationsDAO.retrieveResultListForQueryWithParameters(FIND_CLASS_GRADE_DETAILS,
				queryParametersMap);
		StudentGradeListDTO studentGradeListDTO = classOperationsUtil.convertStudentGradeListtoDTO(studentGradeList);
		return studentGradeListDTO;

	}

	/**
	 * Method to retrieve the student grade details for a particular class id, exam and student
	 * 
	 * @param classId
	 * @param studentId
	 * @return {@link StudentGradeListDTO}
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ReportCardListDTO retrieveClassGradeDetailsForStudent(Integer classId, Integer studentID) throws Exception {

		Map<String, Object> queryParametersMap = new HashMap<String, Object>();
		queryParametersMap.put(ID, classId);
		queryParametersMap.put(STUDENT_ID, studentID);
		List<StudentGrade> studentGradeList = (List<StudentGrade>) classOperationsDAO.retrieveResultListForQueryWithParameters(
				FIND_CLASS_GRADE_DETAILS_FOR_STUDENT, queryParametersMap);
		ClassStudent classStudent = (ClassStudent) classOperationsDAO.retrieveSingleResultForQueryWithParameters(FIND_CLASS_STUDENT_DETAILS,
				ClassStudent.class, queryParametersMap);
		ClassStudentDTO classStudentDTO = classOperationsUtil.convertClassStudentEntityToDTO(classStudent);
		ReportCardListDTO reportCardListDTO = classOperationsUtil.convertStudentGradeListTODTO(studentGradeList);
		reportCardListDTO.setClassStudentDTO(classStudentDTO);
		return reportCardListDTO;

	}

	/**
	 * Method to update the student grade list and return the persisted list
	 * 
	 * @param {@link ClassGradeDetailsDTO}
	 * @return {@link StudentGradeListDTO}
	 * @throws Exception
	 */
	@Transactional
	public StudentGradeListDTO saveClassGradeDetails(ClassGradeDetailsDTO classGradeDetailsDTO) throws Exception {

		Class classObj = classOperationsUtil.convertClassDTOToEntity(classGradeDetailsDTO.getClassDTO());
		ClassExamReferenceData classExamReferenceData = classOperationsUtil.convertClassExamReferenceDataDTOtoEntity(classObj,
				classGradeDetailsDTO.getClassExamReferenceDataDTO());
		Map<Integer, ClassSubjectReferenceData> classSubjectReferenceDataMap = new HashMap<Integer, ClassSubjectReferenceData>();

		List<StudentGrade> studentGradeList = new ArrayList<StudentGrade>();

		for (StudentGradeDTO studentGradeDTO : classGradeDetailsDTO.getStudentGradeListDTO().getStudentGradeDTOList()) {

			Student student = classOperationsUtil.convertStudentDTOToEntity(studentGradeDTO.getStudentDTO());
			for (ClassSubjectReferenceDataDTO classSubjectReferenceDataDTO : studentGradeDTO.getGradeDetailsMap().keySet()) {

				StudentGrade studentGrade = new StudentGrade();
				ClassSubjectReferenceData classSubjectReferenceData = null;
				GradeDetailsDTO gradeDetailsDTO = studentGradeDTO.getGradeDetailsMap().get(classSubjectReferenceDataDTO);

				if (classSubjectReferenceDataMap.containsKey((classSubjectReferenceDataDTO).getId())) {
					classSubjectReferenceData = classSubjectReferenceDataMap.get((classSubjectReferenceDataDTO).getId());
				} else {
					classSubjectReferenceData = classOperationsUtil.convertClassSubjectReferenceDataDTOtoEntity(classObj, classSubjectReferenceDataDTO);
					classSubjectReferenceDataMap.put(classSubjectReferenceDataDTO.getId(), classSubjectReferenceData);
				}

				studentGrade.setClassExamReferenceData(classExamReferenceData);
				studentGrade.setClassRef(classObj);
				studentGrade.setClassSubjectReferenceData(classSubjectReferenceData);
				studentGrade.setGrade(gradeDetailsDTO.getGrade());
				studentGrade.setId(gradeDetailsDTO.getGradeDetailsId());
				studentGrade.setMark(gradeDetailsDTO.getMark());
				studentGrade.setStudent(student);
				studentGrade = (StudentGrade) classOperationsDAO.createOrUpdateEntity(studentGrade);
				studentGradeList.add(studentGrade);
			}

		}
		StudentGradeListDTO studentGradeListDTO = classOperationsUtil.convertStudentGradeListtoDTO(studentGradeList);
		return studentGradeListDTO;
	}

	/**
	 * Method to promote/demote students and also create new classes if required
	 * 
	 * @param fromClassId
	 * @param toClass
	 * @param promotestudentListDTO
	 * @param demoteStudentListDTO
	 * @return promotionEligibleClassList
	 * @throws Exception
	 */
	@Transactional
	public ClassListDTO promoteClass(ClassPromotionDTO classPromotionDTO) throws Exception {

		Integer newStartYear = Calendar.getInstance().get(Calendar.YEAR);
		Integer promotionYear = newStartYear - 1;

		Class toClassObj = classOperationsDAO.getClassToPromoteDemote(classPromotionDTO.getToClassName(), newStartYear);
		promoteDemoteStudents(classPromotionDTO.getPromoteStudentDTOList(), toClassObj);

		Class fromClassObj = classOperationsDAO.getClassToPromoteDemote(classPromotionDTO.getFromClassName(), newStartYear);
		promoteDemoteStudents(classPromotionDTO.getDemoteStudentDTOList(), fromClassObj);

		Class promotionClass = classOperationsDAO.getClassForNameAndYear(classPromotionDTO.getFromClassName(), promotionYear);
		promotionClass.setActive(INACTIVE);
		classOperationsDAO.createOrUpdateEntity(promotionClass);

		return retrieveAllClassesForPromotion(classPromotionDTO.getUserName());
	}

	/**
	 * Method to update student's new class current class details
	 * 
	 * @param studentListDTO
	 * @param classObj
	 * @throws Exception
	 */
	private void promoteDemoteStudents(List<StudentDTO> studentDTOList, Class classObj) throws Exception {
		for (StudentDTO studentDTO : studentDTOList) {
			Student student = classAttendanceOperationsUtil.convertStudentDTOToEntity(studentDTO);
			student.setCurrentClass(classObj);
			classOperationsDAO.createOrUpdateEntity(student);
		}
	}

}
