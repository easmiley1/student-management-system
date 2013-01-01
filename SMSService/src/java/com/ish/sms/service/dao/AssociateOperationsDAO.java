package com.ish.sms.service.dao;

import java.util.List;

import com.ish.sms.service.entity.Student;
import com.ish.sms.service.entity.Teacher;

/**
 * DAO class for all the associate related entities.
 * 
 * @author Naren
 * 
 */
public class AssociateOperationsDAO extends BaseOperationsDAO {

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
	 * Method to create or update a teacher.
	 * 
	 * @param teacher
	 * @return teacher
	 */
	public Teacher createOrUpdateTeacher(Teacher teacher) {
		return entityManager.merge(teacher);
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

	/**
	 * Method to return the list of all the teachers in the school.
	 * 
	 * @return teacherList
	 */
	@SuppressWarnings("unchecked")
	public List<Teacher> retrieveAllTeachers() {

		List<Teacher> teachersList = (List<Teacher>) entityManager.createNamedQuery(FIND_ALL_TEACHERS).getResultList();
		return teachersList;
	}
	
}
