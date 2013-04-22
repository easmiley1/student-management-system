package com.ish.sms.service.ops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassGradeDetailsDTO;
import com.ish.sms.service.dto.ClassListDTO;
import com.ish.sms.service.dto.ClassSubjectReferenceDataDTO;
import com.ish.sms.service.dto.GradeDetailsDTO;
import com.ish.sms.service.dto.StudentGradeDTO;
import com.ish.sms.service.dto.StudentGradeListDTO;
import com.ish.sms.service.entity.Class;
import com.ish.sms.service.entity.ClassExamReferenceData;
import com.ish.sms.service.entity.ClassSubjectReferenceData;
import com.ish.sms.service.entity.Student;
import com.ish.sms.service.entity.StudentGrade;

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
	public ClassListDTO retrieveAllClasses() throws Exception {
		List<Class> classList = (List<Class>) classOperationsDAO.retrieveResultsForquery(FIND_ALL_CLASSES);
		ClassListDTO classListDTO = new ClassListDTO();
		for (Class classObj : classList) {
			ClassDTO classDTO = classOperationsUtil.convertClassEntityToDTO(classObj);
			classListDTO.getClassDTOList().add(classDTO);
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
	 * Method to update the student grade list and return the persisted list
	 * 
	 * @param  {@link ClassGradeDetailsDTO}
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
}
