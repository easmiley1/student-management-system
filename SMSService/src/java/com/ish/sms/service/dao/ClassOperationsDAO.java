package com.ish.sms.service.dao;

import java.util.HashMap;
import java.util.Map;

import com.ish.sms.service.entity.Class;

/**
 * DAO class for all the class related operations
 * 
 * @author Naren
 * 
 */
public class ClassOperationsDAO extends BaseOperationsDAO {

	/**
	 * Method to get the class for promoting/demoting the students if it is already there in database
	 * 
	 * @param toClass
	 * @param newStartYear
	 * @return classToPromoteDemote
	 */
	private Class getClassForNameAndYear(String toClass, Integer newStartYear) {
		Map<String, Object> queryParametersMap = new HashMap<String, Object>();
		queryParametersMap.put(NAME, toClass);
		queryParametersMap.put(START_YEAR, newStartYear);
		Class classObj = (Class) retrieveSingleResultForQueryWithParameters(FIND_NEW_CLASS, com.ish.sms.service.entity.Class.class, queryParametersMap);
		return classObj;
	}

	/**
	 * Creating the class to promote/demote if it is not already present in database
	 * 
	 * @param toClass
	 * @param newStartYear
	 * @return newClassToPromoteDemote
	 */
	private Class createNewClass(String toClass, Integer newStartYear) {
		Class classObj = new Class();
		classObj.setName(toClass);
		classObj.setStartYear(newStartYear);
		classObj.setActive(ACTIVE);
		classObj = (Class) createOrUpdateEntity(classObj);
		return classObj;
	}

	/**
	 * @param toClass
	 * @param newStartYear
	 * @return classToPromoteDemote
	 */
	public Class getClassToPromoteDemote(String toClass, Integer newStartYear) {
		Class classObj = getClassForNameAndYear(toClass, newStartYear);

		if (classObj == null) {
			classObj = createNewClass(toClass, newStartYear);
		}
		return classObj;
	}
}
