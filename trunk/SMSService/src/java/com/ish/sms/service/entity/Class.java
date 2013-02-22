package com.ish.sms.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ish.sms.service.util.QueryConstants;

@NamedQueries( { @NamedQuery(name = QueryConstants.FIND_ALL_CLASSES, query = QueryConstants.FIND_ALL_CLASSES_QUERY),
	 @NamedQuery(name = QueryConstants.FIND_CLASS_BY_ID, query = QueryConstants.FIND_CLASS_BY_ID_QUERY) })
@Entity
@Table(name = "class_details")
public class Class {

	@Id
	@Column(name = "class_id")
	private Integer id;

	@Column(nullable = false, name = "class_name")
	private String name;

	@OneToOne
	@JoinColumn(name = "class_teacher")
	private Teacher teacher;

	@Column(nullable=true, name="student_count")
	private Integer studentCount;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}

	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	/**
	 * @return the studentCount
	 */
	public Integer getStudentCount() {
		return studentCount;
	}

	/**
	 * @param studentCount the studentCount to set
	 */
	public void setStudentCount(Integer studentCount) {
		this.studentCount = studentCount;
	}
}
