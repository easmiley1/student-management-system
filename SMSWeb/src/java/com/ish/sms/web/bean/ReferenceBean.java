package com.ish.sms.web.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ish.sms.service.dto.BloodGroupDTO;
import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ExtraCurricularDTO;
import com.ish.sms.service.dto.ModeofTransportDTO;
import com.ish.sms.service.dto.StateDTO;
import com.ish.sms.web.cache.JBossCacheProvider;
import com.ish.sms.web.util.SMSSpringFactory;

/**
 * Bean class to hold all reference data. They will be reference once a day.
 * 
 * @author Naren
 *
 */
@ManagedBean(name = "referenceBean")
@SessionScoped
public class ReferenceBean extends BaseBean {

	private static final long serialVersionUID = 1L;

	private JBossCacheProvider jbossCacheProvider;

	@SuppressWarnings("unchecked")
	public ReferenceBean() throws Exception {
		
		jbossCacheProvider = (JBossCacheProvider) SMSSpringFactory.getInstance().getBean("jbossCacheProvider");
		setBloodGroupDTOList((List<BloodGroupDTO>) jbossCacheProvider.get(BLOOD_GROUP_FQN, BLOOD_GROUP_KEY));
		setModeofTransportDTOList((List<ModeofTransportDTO>) jbossCacheProvider.get(MODE_OF_TRANSPORT_FQN, MODE_OF_TRANSPORT_KEY));
		setExtraCurricularDTOList((List<ExtraCurricularDTO>) jbossCacheProvider.get(EXTRA_CURRICULAR_FQN, EXTRA_CURRICULAR_KEY));
		setStateDTOList((List<StateDTO>) jbossCacheProvider.get(STATE_FQN, STATE_KEY));
		setClassDTOList((List<ClassDTO>)jbossCacheProvider.get(CLASS_FQN, CLASS_KEY));
	}

	private List<BloodGroupDTO> bloodGroupDTOList;

	private List<ModeofTransportDTO> modeofTransportDTOList;

	private List<ExtraCurricularDTO> extraCurricularDTOList;

	private List<StateDTO> stateDTOList;
	
	private List<ClassDTO> classDTOList;

	/**
	 * @return the classDTOList
	 */
	public List<ClassDTO> getClassDTOList() {
		return classDTOList;
	}

	/**
	 * @param classDTOList the classDTOList to set
	 */
	public void setClassDTOList(List<ClassDTO> classDTOList) {
		this.classDTOList = classDTOList;
	}

	/**
	 * @return the bloodGroupDTOList
	 */
	public List<BloodGroupDTO> getBloodGroupDTOList() {
		return bloodGroupDTOList;
	}

	/**
	 * @param bloodGroupDTOList
	 *            the bloodGroupDTOList to set
	 */
	public void setBloodGroupDTOList(List<BloodGroupDTO> bloodGroupDTOList) {
		this.bloodGroupDTOList = bloodGroupDTOList;
	}

	/**
	 * @return the modeofTransportDTOList
	 */
	public List<ModeofTransportDTO> getModeofTransportDTOList() {
		return modeofTransportDTOList;
	}

	/**
	 * @param modeofTransportDTOList
	 *            the modeofTransportDTOList to set
	 */
	public void setModeofTransportDTOList(List<ModeofTransportDTO> modeofTransportDTOList) {
		this.modeofTransportDTOList = modeofTransportDTOList;
	}

	/**
	 * @return the extraCurricularDTOList
	 */
	public List<ExtraCurricularDTO> getExtraCurricularDTOList() {
		return extraCurricularDTOList;
	}

	/**
	 * @param extraCurricularDTOList
	 *            the extraCurricularDTOList to set
	 */
	public void setExtraCurricularDTOList(List<ExtraCurricularDTO> extraCurricularDTOList) {
		this.extraCurricularDTOList = extraCurricularDTOList;
	}

	/**
	 * @return the stateDTOList
	 */
	public List<StateDTO> getStateDTOList() {
		return stateDTOList;
	}

	/**
	 * @param stateDTOList
	 *            the stateDTOList to set
	 */
	public void setStateDTOList(List<StateDTO> stateDTOList) {
		this.stateDTOList = stateDTOList;
	}

}
