package com.ish.sms.service.dao;

import java.util.List;

import com.ish.sms.service.entity.BloodGroup;
import com.ish.sms.service.entity.ExtraCurricular;
import com.ish.sms.service.entity.ModeofTransport;
import com.ish.sms.service.entity.State;

/**
 * DAO class for all the reference table related operations
 * 
 * @author Naren
 * 
 */
public class ReferenceOperationsDAO extends BaseOperationsDAO{

	/**
	 * Method to return the blood group reference list.
	 * 
	 * @return bloodGroupsList
	 */
	@SuppressWarnings("unchecked")
	public List<BloodGroup> retrieveBloodGroupsList(){

		List<BloodGroup> bloodGroups = (List<BloodGroup>) entityManager.createNamedQuery(FIND_ALL_BLOODGROUPS).getResultList();
		return bloodGroups;
	}

	/**
	 * Method to return the ExtraCurricular reference list.
	 * 
	 * @return extraCurricularsList
	 */	
	@SuppressWarnings("unchecked")
	public List<ExtraCurricular> retrieveExtraCurricularsList(){

		List<ExtraCurricular> extraCurriculars = (List<ExtraCurricular>) entityManager.createNamedQuery(FIND_ALL_EXTRACURRICULAR).getResultList();
		return extraCurriculars;
	}
	
	/**
	 * Method to return the ModeofTransport reference list.
	 * 
	 * @return modeofTransportsList
	 */	
	@SuppressWarnings("unchecked")
	public List<ModeofTransport> retrieveModeofTransportsList(){

		List<ModeofTransport> modeofTransports = (List<ModeofTransport>) entityManager.createNamedQuery(FIND_ALL_MODEOFTRANSPORTS).getResultList();
		return modeofTransports;
	}
	
	/**
	 * Method to return the State reference list.
	 * 
	 * @return stateList
	 */	
	@SuppressWarnings("unchecked")
	public List<State> retrievestateList(){

		List<State> stateList = (List<State>) entityManager.createNamedQuery(FIND_ALL_STATES).getResultList();
		return stateList;
	}

	/**
	 * Method to return the Classes reference list.
	 * 
	 * @return stateList
	 */	
	@SuppressWarnings("unchecked")
	public List<com.ish.sms.service.entity.Class> retrieveClassList(){

		List<com.ish.sms.service.entity.Class> classList = (List<com.ish.sms.service.entity.Class>) entityManager.createNamedQuery(FIND_ALL_CLASSES).getResultList();
		return classList;
	}
}
