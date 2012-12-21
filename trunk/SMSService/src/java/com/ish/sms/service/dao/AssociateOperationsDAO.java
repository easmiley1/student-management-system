package com.ish.sms.service.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ish.sms.service.entity.Student;

public class AssociateOperationsDAO {

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Student createOrUpdateStudent(Student student) {
		return entityManager.merge(student);
	}
}
