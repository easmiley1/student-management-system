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
 * Entity class for mapping to the class subject data table
 * 
 * @author Naren
 *
 */
@NamedQueries({ @NamedQuery(name = QueryConstants.FIND_CLASS_SUBJECT_REFERENCE_DATA, query = QueryConstants.FIND_CLASS_SUBJECT_REFERENCE_DATA_QUERY) })
@Entity
@Table(name = "class_subject_details")
public class ClassSubjectReferenceData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "class_subject_details_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "class_id")
	private Class classRef;

	@ManyToOne
	@JoinColumn(name = "subject_reference_data_id")
	private ReferenceData subjectReferenceData;
	
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacherRef;

	/**
	 * @return the teacherRef
	 */
	public Teacher getTeacherRef() {
		return teacherRef;
	}

	/**
	 * @param teacherRef the teacherRef to set
	 */
	public void setTeacherRef(Teacher teacherRef) {
		this.teacherRef = teacherRef;
	}

	/**
	 * @return the subjectReferenceData
	 */
	public ReferenceData getSubjectReferenceData() {
		return subjectReferenceData;
	}

	/**
	 * @param subjectReferenceData the subjectReferenceData to set
	 */
	public void setSubjectReferenceData(ReferenceData subjectReferenceData) {
		this.subjectReferenceData = subjectReferenceData;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the classRef
	 */
	public Class getClassRef() {
		return classRef;
	}

	/**
	 * @param classRef
	 *            the classRef to set
	 */
	public void setClassRef(Class classRef) {
		this.classRef = classRef;
	}

}
