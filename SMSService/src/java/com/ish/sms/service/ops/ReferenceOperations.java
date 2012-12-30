package com.ish.sms.service.ops;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.ish.sms.service.dto.BloodGroupDTO;
import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ExtraCurricularDTO;
import com.ish.sms.service.dto.ModeofTransportDTO;
import com.ish.sms.service.dto.ReferenceListDTO;
import com.ish.sms.service.dto.StateDTO;
import com.ish.sms.service.entity.BloodGroup;
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
	@Transactional(readOnly = true)
	public ReferenceListDTO retrieveAllReferenceList() throws Exception {

		// TODO - may be later think of a generic way to do it.
		List<BloodGroupDTO> bloodGroupDTOList = new ArrayList<BloodGroupDTO>();
		List<BloodGroup> bloodGroups = referenceOperationsDAO.retrieveBloodGroupsList();
		for (BloodGroup bloodGroup : bloodGroups) {
			BloodGroupDTO bloodGroupDTO = new BloodGroupDTO();
			BeanUtils.copyProperties(bloodGroupDTO, bloodGroup);
			bloodGroupDTOList.add(bloodGroupDTO);
		}

		List<ExtraCurricularDTO> extraCurricularDTOList = new ArrayList<ExtraCurricularDTO>();
		List<ExtraCurricular> extraCurriculars = referenceOperationsDAO.retrieveExtraCurricularsList();
		for (ExtraCurricular extraCurricular : extraCurriculars) {
			ExtraCurricularDTO extraCurricularDTO = new ExtraCurricularDTO();
			BeanUtils.copyProperties(extraCurricularDTO, extraCurricular);
			extraCurricularDTOList.add(extraCurricularDTO);

		}

		List<ModeofTransportDTO> modeofTransportDTOList = new ArrayList<ModeofTransportDTO>();
		List<ModeofTransport> modeofTransports = referenceOperationsDAO.retrieveModeofTransportsList();
		for (ModeofTransport modeofTransport : modeofTransports) {
			ModeofTransportDTO modeofTransportDTO = new ModeofTransportDTO();
			BeanUtils.copyProperties(modeofTransportDTO, modeofTransport);
			modeofTransportDTOList.add(modeofTransportDTO);
		}

		List<StateDTO> stateDTOList = new ArrayList<StateDTO>();
		List<State> stateList = referenceOperationsDAO.retrievestateList();
		for (State state : stateList) {
			StateDTO stateDTO = new StateDTO();
			BeanUtils.copyProperties(stateDTO, state);
			stateDTOList.add(stateDTO);
		}

		List<ClassDTO> classDTOList = new ArrayList<ClassDTO>();
		List<com.ish.sms.service.entity.Class> classList = referenceOperationsDAO.retrieveClassList();
		for (com.ish.sms.service.entity.Class classEntity : classList) {
			ClassDTO classDTO = new ClassDTO();
			BeanUtils.copyProperties(classDTO, classEntity);
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
