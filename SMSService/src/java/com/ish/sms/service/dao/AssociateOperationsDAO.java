package com.ish.sms.service.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ish.sms.service.entity.Student;
import com.ish.sms.service.util.QueryConstants;

/**
 * DAO class for all the associate related entities.
 * 
 * @author Naren
 * 
 */
public class AssociateOperationsDAO implements QueryConstants {

	private EntityManager entityManager;

	/**
	 * @param entityManager
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Method to create or update a student.
	 * 
	 * @param student
	 * @return student
	 */
	public Student createOrUpdateStudent(Student student) {
		return entityManager.merge(student);
	}

	/**
	 * Method to return the list of all the students in the school.
	 * 
	 * @return studentList
	 */
	@SuppressWarnings("unchecked")
	public List<Student> retrieveAllStudents() {

		List<Student> studentsList = (List<Student>) entityManager.createNamedQuery(FIND_ALL_STUDENTS).getResultList();
		return studentsList;
	}
}
