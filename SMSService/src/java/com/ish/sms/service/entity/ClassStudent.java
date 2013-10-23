package com.ish.sms.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.ish.sms.service.util.QueryConstants;

/**
 * This entity represents the class student table in the database
 * 
 * @author Naren
 * 
 */

@NamedQueries({ @NamedQuery(name = QueryConstants.FIND_CLASS_STUDENT_DETAILS, query = QueryConstants.FIND_CLASS_STUDENT_DETAILS_QUERY) })
@Entity@Table(name = "class_student_details")
public class ClassStudent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "class_student_details_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "class_id")
	private Class classObj;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@Column(name = "roll_no")
	private Integer rollNo;

	@Column(name="comments")
	private String comments;

	
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

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
	 * @return the classObj
	 */
	public Class getClassObj() {
		return classObj;
	}

	/**
	 * @param classObj the classObj to set
	 */
	public void setClassObj(Class classObj) {
		this.classObj = classObj;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @return the rollNo
	 */
	public Integer getRollNo() {
		return rollNo;
	}

	/**
	 * @param rollNo the rollNo to set
	 */
	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}
	
}
