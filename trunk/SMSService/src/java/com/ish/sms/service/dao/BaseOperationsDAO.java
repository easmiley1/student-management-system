package com.ish.sms.service.dao;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.ish.sms.service.util.EntityConstants;
import com.ish.sms.service.util.QueryConstants;

public class BaseOperationsDAO implements QueryConstants, EntityConstants {

	protected EntityManager entityManager;

	/**
	 * @param entityManager
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Method to create or update entity
	 * 
	 * @param entity
	 * @return entity
	 */
	public Object createOrUpdateEntity(Object object) {
		return entityManager.merge(object);

	}

	/**
	 * Method to delete an entity
	 * 
	 * @param entity
	 */
	public void removeEntityByID(Class<?> classType, Integer id) {
		Object object = entityManager.find(classType, id);
		entityManager.remove(object);
	}
	/**
	 * Method to return the list of entities for the given select query.
	 * 
	 * @return entityList
	 */
	public Object retrieveResultsForquery(String query) {
		return entityManager.createNamedQuery(query).getResultList();
	}

	/**
	 * Method to return single result for the given query and namedParameters
	 * 
	 * @param query
	 * @param classArg
	 * @param queryParametersMap
	 * @return singleResult
	 */
	public Object retrieveSingleResultForQueryWithParameters(String query, Class<?> classArg, Map<String,Object> queryParametersMap){
		
		TypedQuery<?> namedQuery = entityManager.createNamedQuery(query, classArg);
		namedQuery = createTypedQueryForParameters(namedQuery, queryParametersMap);
		return namedQuery.getSingleResult();
		
	}
	
	/**
	 * Method to return resultList for the given query and namedParameters
	 * 
	 * @param query
	 * @param classArg
	 * @param queryParametersMap
	 * @return singleResult
	 */
	public Object retrieveResultListForQueryWithParameters(String query, Map<String,Object> queryParametersMap){
		
		Query namedQuery = entityManager.createNamedQuery(query);
		namedQuery = createQueryForParameters(namedQuery, queryParametersMap);
		return namedQuery.getResultList();
		
	}	

	/**
	 * Utility method to set the namedParameters in the given typedQuery
	 * 
	 * @param namedQuery
	 * @param queryParametersMap
	 * @return namedQuery
	 */
	private TypedQuery<?> createTypedQueryForParameters(TypedQuery<?> namedQuery, Map<String, Object> queryParametersMap) {
		
		for(String queryParametersKey : queryParametersMap.keySet()){
			namedQuery = namedQuery.setParameter(queryParametersKey, queryParametersMap.get(queryParametersKey));
		}
		return namedQuery;
	}


	/**
	 * Utility method to set the namedParameters in the given typedQuery
	 * 
	 * @param namedQuery
	 * @param queryParametersMap
	 * @return namedQuery
	 */
	private Query createQueryForParameters(Query namedQuery, Map<String, Object> queryParametersMap) {
		
		for(String queryParametersKey : queryParametersMap.keySet()){
			namedQuery = namedQuery.setParameter(queryParametersKey, queryParametersMap.get(queryParametersKey));
		}
		return namedQuery;
	}

}
