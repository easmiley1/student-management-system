package com.ish.sms.service.ops;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.transaction.annotation.Transactional;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ReferenceDataDTO;
import com.ish.sms.service.dto.ReferenceListDTO;
import com.ish.sms.service.dto.TeacherListDTO;
import com.ish.sms.service.entity.Class;
import com.ish.sms.service.entity.ReferenceData;

/**
 * Class to handle all business logic for reference entity database operations
 * 
 * @author Naren
 * 
 */
public class ReferenceOperations extends BaseOperations {

	/**
	 * Method to call referenceoperationsDAO and get all the reference objects and set them to the ReferenceListDTO and return the same
	 * 
	 * @return ReferenceListDTO
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public ReferenceListDTO retrieveAllReferenceList() throws Exception {

		List<ReferenceData> referenceDataList = (List<ReferenceData>) referenceOperationsDAO.retrieveResultsForquery(FIND_ALL_REFERENCE_DATA);

		ReferenceListDTO referenceListDTO = new ReferenceListDTO();
		for (ReferenceData referenceData : referenceDataList) {
			ReferenceDataDTO referenceDataDTO = new ReferenceDataDTO();
			PropertyUtils.copyProperties(referenceDataDTO, referenceData);
			if (referenceData.getType().equals(REFERENCE_TYPE.BloodGroup.name())) {
				referenceListDTO.getBloodGroupDTOList().add(referenceDataDTO);
			} else if (referenceData.getType().equals(REFERENCE_TYPE.DayofWeek.name())) {
				referenceListDTO.getDayOfWeekDTOList().add(referenceDataDTO);
			} else if (referenceData.getType().equals(REFERENCE_TYPE.ExtraCurricularInterest.name())) {
				referenceListDTO.getExtraCurricularDTOList().add(referenceDataDTO);
			} else if (referenceData.getType().equals(REFERENCE_TYPE.StateName.name())) {
				referenceListDTO.getStateDTOList().add(referenceDataDTO);
			} else if (referenceData.getType().equals(REFERENCE_TYPE.SubjectName.name())) {
				referenceListDTO.getSubjectDTOList().add(referenceDataDTO);
			} else if (referenceData.getType().equals(REFERENCE_TYPE.Transportation.name())) {
				referenceListDTO.getModeofTransportDTOList().add(referenceDataDTO);
			} else if (referenceData.getType().equals(REFERENCE_TYPE.Exam.name())) {
				referenceListDTO.getExamDTOList().add(referenceDataDTO);
			}
		}

		List<ClassDTO> classDTOList = new ArrayList<ClassDTO>();
		List<Class> classList = (List<Class>) referenceOperationsDAO.retrieveResultsForquery(FIND_ALL_CLASSES);
		for (Class classEntity : classList) {
			ClassDTO classDTO = new ClassDTO();
			PropertyUtils.copyProperties(classDTO, classEntity);
			classDTOList.add(classDTO);
		}
		TeacherListDTO teacherListDTO = retrieveAllTeachers();
		referenceListDTO.setTeacherDTOList(teacherListDTO.getTeacherDTOList());
		referenceListDTO.setClassDTOList(classDTOList);

		return referenceListDTO;
	}

}
