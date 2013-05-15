package com.ish.sms.service.ops;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ish.sms.service.dto.AssociateAttendanceDTO;
import com.ish.sms.service.dto.AssociateAttendanceListDTO;
import com.ish.sms.service.dto.ClassAttendanceDefDTO;
import com.ish.sms.service.dto.ClassAttendanceDefListDTO;
import com.ish.sms.service.entity.AssociateAttendance;
import com.ish.sms.service.entity.ClassAttendanceDef;

/**
 * Class to handle all business logic for class Attendance related database operations
 * 
 * @author Naren
 * 
 */
public class ClassAttendanceOperations extends BaseOperations {

	/**
	 * Method to call classAttendanceOperationsDAO and get all the classAttendanceDefintion for a particular class. If no list is found
	 * 
	 * @return ClassAttendanceDefDTOList
	 * @throws Exception
	 */
	@Transactional
	public ClassAttendanceDefListDTO retrieveClassAttendanceDefList(Integer classId) throws Exception {
		ClassAttendanceDefListDTO classAttendanceDefListDTO = null;
		classAttendanceDefListDTO = retrieveClassAttendanceDefListForClass(classId);
		if (classAttendanceDefListDTO == null || classAttendanceDefListDTO.getClassAttendanceDefDTOList().size() == 0) {
			classAttendanceDefListDTO = new ClassAttendanceDefListDTO();
			ClassAttendanceDefDTO classAttendanceDefDTO = new ClassAttendanceDefDTO();
			ClassAttendanceDef classAttendanceDef = classAttendanceOperationsDAO.createDefaultClassAttendanceDef(classId);
			PropertyUtils.copyProperties(classAttendanceDefDTO, classAttendanceDef);
			classAttendanceDefListDTO.getClassAttendanceDefDTOList().add(classAttendanceDefDTO);
		}
		return classAttendanceDefListDTO;
	}

	/**
	 * Method to remove and delete the classAttendanceDefListDTO and return the updated one
	 * 
	 * @param classAttendanceDefListDTO
	 *            {@link ClassAttendanceDefListDTO}
	 * @return updatedClassAttendanceDefListDTO {@link ClassAttendanceDefListDTO}
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public ClassAttendanceDefListDTO updateClassAttendanceDefList(ClassAttendanceDefListDTO classAttendanceDefListDTO) throws Exception {

		List<ClassAttendanceDef> classAttendanceDefList = classAttendanceOperationsUtil.convertClassAttendanceDefListDTOToEntity(classAttendanceDefListDTO);
		classAttendanceOperationsDAO.updateClassAttendanceDefList(classAttendanceDefList);
		return retrieveClassAttendanceDefListForClass(classAttendanceDefList.get(0).getClassRef().getId());
	}

	/**
	 * Method to return the class attendance data for the specified month
	 * 
	 * @param monthId
	 * @return associateAttendanceList {@link AssociateAttendanceListDTO}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public AssociateAttendanceListDTO retrieveClassAttendanceForMonth(Integer monthId) throws Exception {

		Map<String, Object> queryParametersMap = new HashMap<String, Object>();
		queryParametersMap.put(ID, monthId);
		List<AssociateAttendance> associateAttendanceList = (List<AssociateAttendance>) classAttendanceOperationsDAO.retrieveResultListForQueryWithParameters(
				FIND_ASSOCIATE_ATTENDANCE_DATA, queryParametersMap);
		AssociateAttendanceListDTO associateAttendanceListDTO = new AssociateAttendanceListDTO();
		for (AssociateAttendance associateAttendance : associateAttendanceList) {
			AssociateAttendanceDTO associateAttendanceDTO = new AssociateAttendanceDTO();
			PropertyUtils.copyProperties(associateAttendanceDTO, associateAttendance);
			associateAttendanceDTO.setStudentDTO(associateOperationsUtil.convertStudentEntitytoDTO(associateAttendance.getStudent()));
			associateAttendanceListDTO.getAssociateAttendanceListDTO().add(associateAttendanceDTO);
		}
		return associateAttendanceListDTO;
	}

	/**
	 * Method to persist all the students in the attendance month
	 * 
	 * @param {@link AssociateAttendanceDTO}
	 * @return {@link AssociateAttendanceDTO}
	 * @throws Exception
	 * 
	 */
	@Transactional
	public AssociateAttendanceListDTO updateAssociateAttendanceList(AssociateAttendanceListDTO associateAttendanceListDTO) throws Exception {

		AssociateAttendanceListDTO updatedAssociateAttendanceListDTO = new AssociateAttendanceListDTO();

		for (AssociateAttendanceDTO associateAttendanceDTO : associateAttendanceListDTO.getAssociateAttendanceListDTO()) {
			AssociateAttendance associateAttendance = classAttendanceOperationsUtil.convertAssociateAttendanceDTOToEntity(associateAttendanceDTO);
			associateAttendance = (AssociateAttendance) classAttendanceOperationsDAO.createOrUpdateEntity(associateAttendance);
			AssociateAttendanceDTO updatedAssociateAttendanceDTO = classAttendanceOperationsUtil.convertAssociateAttendanceEntityToDTO(associateAttendance);
			updatedAssociateAttendanceListDTO.getAssociateAttendanceListDTO().add(updatedAssociateAttendanceDTO);
		}
		return updatedAssociateAttendanceListDTO;
	}

}
