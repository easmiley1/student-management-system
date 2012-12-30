package com.ish.sms.service.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ish.sms.service.util.QueryConstants;


public class BaseOperationsDAO implements QueryConstants{

	protected EntityManager entityManager;

	/**
	 * @param entityManager
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
