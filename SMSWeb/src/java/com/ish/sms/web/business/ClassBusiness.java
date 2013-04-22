package com.ish.sms.web.business;

import java.util.List;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassGradeDetailsDTO;
import com.ish.sms.service.dto.ClassListDTO;
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
	 * Method to return the list of all active classes
	 * 
	 * @return classDTOList 
	 * @throws Exception
	 * 
	 */

	public List<ClassDTO> retrieveAllClasses() throws Exception {
		String classDTOXML = classBusinessDelegate.retrieveAllClasses();
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

}
