package com.ish.sms.service.ops;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.transaction.annotation.Transactional;

import com.ish.sms.service.dto.BloodGroupDTO;
import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ExtraCurricularDTO;
import com.ish.sms.service.dto.ModeofTransportDTO;
import com.ish.sms.service.dto.ReferenceListDTO;
import com.ish.sms.service.dto.StateDTO;
import com.ish.sms.service.entity.BloodGroup;
import com.ish.sms.service.entity.Class;
import com.ish.sms.service.entity.ExtraCurricular;
import com.ish.sms.service.entity.ModeofTransport;
import com.ish.sms.service.entity.State;

/**
 * Class to handle all business logic for reference entity database operations
 * 
 * @author Naren
 * 
 */
public class ReferenceOperations extends BaseOperations {

	/**
	 * Method to call referenceoperationsDAO and get all the reference objects
	 * and set them to the ReferenceListDTO and return the same
	 * 
	 * @return ReferenceListDTO
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public ReferenceListDTO retrieveAllReferenceList() throws Exception {

		// TODO - may be later think of a generic way to do it.
		List<BloodGroupDTO> bloodGroupDTOList = new ArrayList<BloodGroupDTO>();
		List<BloodGroup> bloodGroups = (List<BloodGroup>) referenceOperationsDAO.retrieveResultsForquery(FIND_ALL_BLOODGROUPS);
		for (BloodGroup bloodGroup : bloodGroups) {
			BloodGroupDTO bloodGroupDTO = new BloodGroupDTO();
			PropertyUtils.copyProperties(bloodGroupDTO, bloodGroup);
			bloodGroupDTOList.add(bloodGroupDTO);
		}

		List<ExtraCurricularDTO> extraCurricularDTOList = new ArrayList<ExtraCurricularDTO>();
		List<ExtraCurricular> extraCurriculars = (List<ExtraCurricular>) referenceOperationsDAO.retrieveResultsForquery(FIND_ALL_EXTRACURRICULAR);
		for (ExtraCurricular extraCurricular : extraCurriculars) {
			ExtraCurricularDTO extraCurricularDTO = new ExtraCurricularDTO();
			PropertyUtils.copyProperties(extraCurricularDTO, extraCurricular);
			extraCurricularDTOList.add(extraCurricularDTO);

		}

		List<ModeofTransportDTO> modeofTransportDTOList = new ArrayList<ModeofTransportDTO>();
		List<ModeofTransport> modeofTransports = (List<ModeofTransport>) referenceOperationsDAO.retrieveResultsForquery(FIND_ALL_MODEOFTRANSPORTS);
		for (ModeofTransport modeofTransport : modeofTransports) {
			ModeofTransportDTO modeofTransportDTO = new ModeofTransportDTO();
			PropertyUtils.copyProperties(modeofTransportDTO, modeofTransport);
			modeofTransportDTOList.add(modeofTransportDTO);
		}

		List<StateDTO> stateDTOList = new ArrayList<StateDTO>();
		List<State> stateList = (List<State>) referenceOperationsDAO.retrieveResultsForquery(FIND_ALL_STATES);
		for (State state : stateList) {
			StateDTO stateDTO = new StateDTO();
			PropertyUtils.copyProperties(stateDTO, state);
			stateDTOList.add(stateDTO);
		}

		List<ClassDTO> classDTOList = new ArrayList<ClassDTO>();
		List<com.ish.sms.service.entity.Class> classList = (List<Class>) referenceOperationsDAO.retrieveResultsForquery(FIND_ALL_CLASSES);
		for (com.ish.sms.service.entity.Class classEntity : classList) {
			ClassDTO classDTO = new ClassDTO();
			PropertyUtils.copyProperties(classDTO, classEntity);
			classDTOList.add(classDTO);
		}

		ReferenceListDTO referenceListDTO = new ReferenceListDTO();
		referenceListDTO.setBloodGroupDTOList(bloodGroupDTOList);
		referenceListDTO.setExtraCurricularDTOList(extraCurricularDTOList);
		referenceListDTO.setModeofTransportDTOList(modeofTransportDTOList);
		referenceListDTO.setStateDTOList(stateDTOList);
		referenceListDTO.setClassDTOList(classDTOList);

		return referenceListDTO;
	}

}
