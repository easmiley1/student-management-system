package com.ish.sms.web.business;

import java.util.List;

import com.ish.sms.service.dto.AssociateAttendanceDTO;
import com.ish.sms.service.dto.AssociateAttendanceListDTO;
import com.ish.sms.service.dto.ClassAttendanceDefDTO;
import com.ish.sms.service.dto.ClassAttendanceDefListDTO;

/**
 * Business class for all class attendance related actions. This is called from the Action bean/class. The methods in the class also converts the DTO
 * to xml and vice-versa the response from the rest service.
 * 
 * @author Naren
 * 
 */
public class ClassAttendanceBusiness extends BaseBusiness {

	/**
	 * Method to get all the classAttendanceDefintion month year strings for the given class.
	 * 
	 * @param classId
	 * @return classAttendanceDefDTOList {@link ClassAttendanceDefDTO}
	 * @throws Exception
	 */
	public List<ClassAttendanceDefDTO> retrieveClassAttenDefStringList(Integer classId) throws Exception {

		String classAttendanceDefListDTOXML = classAttendanceBusinessDelegate.retrieveClassAttendanceDefList(classId);
		ClassAttendanceDefListDTO classAttendanceDefListDTO = serviceTransformer.parseXml(classAttendanceDefListDTOXML);
		return classAttendanceDefListDTO.getClassAttendanceDefDTOList();
	}

	/**
	 * Method to remove or delete the given ClassAttendanceDefDTO List.
	 * 
	 * @return setClassAttendanceDefDTOList
	 */

	public List<ClassAttendanceDefDTO> updateClassAttendanceDefList(List<ClassAttendanceDefDTO> classAttendanceDefDTOList) throws Exception {
		ClassAttendanceDefListDTO classAttendanceDefListDTO = new ClassAttendanceDefListDTO();
		classAttendanceDefListDTO.setClassAttendanceDefDTOList(classAttendanceDefDTOList);
		String classAttendanceDefListDTOXML = serviceTransformer.transformToXML(classAttendanceDefListDTO, CLASSATTENDANCEDEFLIST_DTO);
		classAttendanceDefListDTOXML = classAttendanceBusinessDelegate.updateClassAttendanceDefList(classAttendanceDefListDTOXML);
		classAttendanceDefListDTO = serviceTransformer.parseXml(classAttendanceDefListDTOXML);
		return classAttendanceDefListDTO.getClassAttendanceDefDTOList();

	}

	/**
	 * Method to return the class attendance data for the specified month
	 * 
	 * @param monthId
	 * @return associateAttendanceList
	 */
	public List<AssociateAttendanceDTO> retrieveClassAttendanceForMonth(Integer monthId) throws Exception {
		String associateAttendanceListDTOXML = classAttendanceBusinessDelegate.retrieveClassAttendanceForMonth(monthId);
		AssociateAttendanceListDTO associateAttendanceListDTO = serviceTransformer.parseXml(associateAttendanceListDTOXML);
		return associateAttendanceListDTO.getAssociateAttendanceListDTO();
	}

	/**
	 * Method to persist all the students in the attendance month.
	 * 
	 * @param associateAttendanceDTOList
	 * @return persistendAssociateAttendanceDTOList
	 * @throws Exception
	 */
	public List<AssociateAttendanceDTO> updateAssociateAttendanceList(List<AssociateAttendanceDTO> associateAttendanceDTOList) throws Exception {
		AssociateAttendanceListDTO associateAttendanceListDTO = new AssociateAttendanceListDTO();
		associateAttendanceListDTO.setAssociateAttendanceListDTO(associateAttendanceDTOList);
		String associateAttendanceListDTOXML = serviceTransformer.transformToXML(associateAttendanceListDTO, ASSOCIATEATTENDANCELIST_DTO);
		associateAttendanceListDTOXML = classAttendanceBusinessDelegate.updateAssociateAttendanceList(associateAttendanceListDTOXML);
		associateAttendanceListDTO = serviceTransformer.parseXml(associateAttendanceListDTOXML);
		return associateAttendanceListDTO.getAssociateAttendanceListDTO();

	}
}
