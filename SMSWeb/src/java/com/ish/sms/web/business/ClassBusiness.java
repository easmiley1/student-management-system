package com.ish.sms.web.business;

import java.util.List;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassGradeDetailsDTO;
import com.ish.sms.service.dto.ClassListDTO;
import com.ish.sms.service.dto.ClassPromotionDTO;
import com.ish.sms.service.dto.ClassStudentDTO;
import com.ish.sms.service.dto.ClassTimeTableListDTO;
import com.ish.sms.service.dto.ReportCardListDTO;
import com.ish.sms.service.dto.StudentGradeDTO;
import com.ish.sms.service.dto.StudentGradeListDTO;

/**
 * Business class for all class related actions. This is called from the Action bean/class. The methods in the class also converts the DTO
 * to xml and vice-versa the response from the rest service.
 * 
 * @author Naren
 * 
 */
public class ClassBusiness extends BaseBusiness {

	/**
	 * Method to get the class corresponding to the given id
	 * 
	 * @return {@link ClassDTO}
	 * @throws Exception
	 */
	public ClassDTO retrieveClassForId(Integer classId) throws Exception {
		String classDTOXML = classBusinessDelegate.retrieveClassForId(classId);
		ClassDTO classDTO = serviceTransformer.parseXml(classDTOXML);
		return classDTO;
	}

	/**
	 * Method to update/insert class.
	 * 
	 * @param {@link classDTO}
	 * @return {@link classDTO}
	 * @throws Exception
	 */
	public ClassDTO saveClass(ClassDTO classDTO) throws Exception {

		String classXML = serviceTransformer.transformToXML(classDTO, CLASS_DTO);
		classXML = classBusinessDelegate.saveClass(classXML);
		return serviceTransformer.parseXml(classXML);
	}

	/**
	 * Method to return the list of all active classes for the previous year for promotion
	 * 
	 * @return classDTOList
	 * @throws Exception
	 * 
	 */
	public List<ClassDTO> retrieveAllClassesForPromotion(String userName) throws Exception {
		String classDTOXML = classBusinessDelegate.retrieveAllClassesForPromotion(userName);
		ClassListDTO classListDTO = serviceTransformer.parseXml(classDTOXML);
		return classListDTO.getClassDTOList();
	}

	/**
	 * Method to retrieve the student grade details for a particular class id.
	 * 
	 * @param classId
	 * @param classExamId
	 * @return studentGradeDTOList
	 * @throws Exception
	 */
	public List<StudentGradeDTO> retrieveClassGradeDetails(Integer classId, Integer classExamId) throws Exception {
		String studentGradeListDTOXML = classBusinessDelegate.retrieveClassGradeDetails(classId, classExamId);
		StudentGradeListDTO studentGradeListDTO = serviceTransformer.parseXml(studentGradeListDTOXML);
		return studentGradeListDTO.getStudentGradeDTOList();
	}

	/**
	 * Method to retrieve the student grade details for a particular class id, studentId.
	 * 
	 * @param classId
	 * @param studentId
	 * @return studentGradeDTOList
	 * @throws Exception
	 */
	public ReportCardListDTO retrieveClassGradeDetailsForStudent(Integer classId, Integer studentId) throws Exception {
		String studentGradeListDTOXML = classBusinessDelegate.retrieveClassGradeDetailsForStudent(classId, studentId);
		ReportCardListDTO reportCardListDTO = serviceTransformer.parseXml(studentGradeListDTOXML);
		return reportCardListDTO;
	}

	/**
	 * Method to update/insert class grade details.
	 * 
	 * @param {@link StudentGradeListDTO}
	 * @return {@link StudentGradeListDTO}
	 * @throws Exception
	 */
	public StudentGradeListDTO saveClassGradeDetails(ClassGradeDetailsDTO classGradeDetailsDTO) throws Exception {

		String classGradeDetailsDTOXML = serviceTransformer.transformToXML(classGradeDetailsDTO, CLASSGRADEDETAILS_DTO);
		classGradeDetailsDTOXML = classBusinessDelegate.saveClassGradeDetails(classGradeDetailsDTOXML);
		return serviceTransformer.parseXml(classGradeDetailsDTOXML);
	}

	/**
	 * Method to promote/demote students and also create new classes if required.
	 * 
	 * @param classPromotionDTO
	 * @return promotionEligibleClassList
	 * @throws Exception
	 */
	public List<ClassDTO> promoteClass(ClassPromotionDTO classPromotionDTO) throws Exception {

		String classPromotionDTOXML = serviceTransformer.transformToXML(classPromotionDTO, CLASS_PROMOTION_DTO);
		String classListDTOXML = classBusinessDelegate.promoteClass(classPromotionDTOXML);
		ClassListDTO classListDTO = serviceTransformer.parseXml(classListDTOXML);
		return classListDTO.getClassDTOList();
	}

	/**
	 * Method to promote/demote students and also create new classes if required.
	 * 
	 * @param classPromotionDTO
	 * @return promotionEligibleClassList
	 * @throws Exception
	 */
	public ClassStudentDTO saveClassStudentDetails(ClassStudentDTO classStudentDTO) throws Exception {

		String classStudentDTOXML = serviceTransformer.transformToXML(classStudentDTO, CLASS_STUDENT_DTO);
		String classListDTOXML = classBusinessDelegate.saveClassStudentDetails(classStudentDTOXML);
		classStudentDTO = serviceTransformer.parseXml(classListDTOXML);
		return classStudentDTO;
	}

	/**
	 * Method to return the timetable for a particular teacher
	 * 
	 * @param teacherId
	 * @return ClassTimeTableListDTO
	 */
	public ClassTimeTableListDTO retrieveTimetableforTeacherInteger(Integer teacherId) throws Exception {
		String ClassTimeTableListDTOXML = classBusinessDelegate.retrieveTimetableforTeacherInteger(teacherId);
		ClassTimeTableListDTO classTimeTableListDTO = serviceTransformer.parseXml(ClassTimeTableListDTOXML);
		return classTimeTableListDTO;

	}
}
