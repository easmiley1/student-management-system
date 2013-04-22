package com.ish.sms.service.entity;

import java.io.Serializable;

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
 * Entity class representing class_grade_details table
 * 
 * @author Naren
 *
 */
@NamedQueries({ @NamedQuery(name = QueryConstants.FIND_CLASS_GRADE_DETAILS, query = QueryConstants.FIND_CLASS_GRADE_DETAILS_QUERY) })
@Entity
@Table(name = "class_grade_details")
public class StudentGrade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "class_grade_details_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "class_subject_details_id")
	private ClassSubjectReferenceData classSubjectReferenceData;

	@ManyToOne
	@JoinColumn(name = "class_exam_details_id")
	private ClassExamReferenceData classExamReferenceData;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@Column(name = "mark")
	private Integer mark;

	@Column(name = "grade")
	private String grade;

	@ManyToOne
	@JoinColumn(name = "class_id")
	private Class classRef;

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
	 * @return the classSubjectReferenceData
	 */
	public ClassSubjectReferenceData getClassSubjectReferenceData() {
		return classSubjectReferenceData;
	}

	/**
	 * @param classSubjectReferenceData the classSubjectReferenceData to set
	 */
	public void setClassSubjectReferenceData(ClassSubjectReferenceData classSubjectReferenceData) {
		this.classSubjectReferenceData = classSubjectReferenceData;
	}

	/**
	 * @return the classExamReferenceData
	 */
	public ClassExamReferenceData getClassExamReferenceData() {
		return classExamReferenceData;
	}

	/**
	 * @param classExamReferenceData the classExamReferenceData to set
	 */
	public void setClassExamReferenceData(ClassExamReferenceData classExamReferenceData) {
		this.classExamReferenceData = classExamReferenceData;
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
	 * @return the mark
	 */
	public Integer getMark() {
		return mark;
	}

	/**
	 * @param mark the mark to set
	 */
	public void setMark(Integer mark) {
		this.mark = mark;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the classRef
	 */
	public Class getClassRef() {
		return classRef;
	}

	/**
	 * @param classRef the classRef to set
	 */
	public void setClassRef(Class classRef) {
		this.classRef = classRef;
	}
	
	
	
}
