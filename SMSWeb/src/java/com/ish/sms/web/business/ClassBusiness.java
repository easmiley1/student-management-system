package com.ish.sms.web.business;

import java.util.List;

import com.ish.sms.service.dto.ClassAttendanceDefDTO;
import com.ish.sms.service.dto.ClassAttendanceDefListDTO;
import com.ish.sms.service.dto.ClassDTO;

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
	 * @return referenceListDTO
	 * @throws Exception
	 */
	public ClassDTO retrieveClassForId(Integer classId) throws Exception {
		String classDTOXML = classBusinessDelegate.retrieveClassForId(classId);
		ClassDTO classDTO = serviceTransformer.parseXml(classDTOXML);
		return classDTO;
	}

	/**
	 * Method to get all the classAttendanceDefintion month year strings for the given class.
	 * 
	 * @param classId
	 * @return monthYearList
	 * @throws Exception
	 */
	public List<ClassAttendanceDefDTO> retrieveClassAttenDefStringList(Integer classId) throws Exception {

		String classAttendanceDefListDTOXML = classBusinessDelegate.retrieveClassAttendanceDefList(classId);
		ClassAttendanceDefListDTO classAttendanceDefListDTO = serviceTransformer.parseXml(classAttendanceDefListDTOXML);
		return classAttendanceDefListDTO.getClassAttendanceDefDTOList();
	}

	/**
	 * Method to remove or delete the given ClassAttendanceDefDTO List. 
	 * 
	 * @return classAttendanceDefListDTOXML
	 */

	public List<ClassAttendanceDefDTO> updateClassAttendanceDefList(List<ClassAttendanceDefDTO> classAttendanceDefDTOList) throws Exception{
		ClassAttendanceDefListDTO classAttendanceDefListDTO = new ClassAttendanceDefListDTO();
		classAttendanceDefListDTO.setClassAttendanceDefDTOList(classAttendanceDefDTOList);
		String classAttendanceDefListDTOXML = serviceTransformer.transformToXML(classAttendanceDefListDTO, CLASSATTENDANCEDEFLIST_DTO);
		classAttendanceDefListDTOXML = classBusinessDelegate.updateClassAttendanceDefList(classAttendanceDefListDTOXML);
		classAttendanceDefListDTO =  serviceTransformer.parseXml(classAttendanceDefListDTOXML);
		return classAttendanceDefListDTO.getClassAttendanceDefDTOList();

	}
}
