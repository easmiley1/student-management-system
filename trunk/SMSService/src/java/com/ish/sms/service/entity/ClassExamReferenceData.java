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
import javax.persistence.Transient;

import com.ish.sms.service.util.QueryConstants;

@NamedQueries({ @NamedQuery(name = QueryConstants.FIND_CLASS_EXAM_REFERENCE_DATA, query = QueryConstants.FIND_CLASS_EXAM_REFERENCE_DATA_QUERY) })
@Entity
@Table(name = "class_exam_details")
public class ClassExamReferenceData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "class_exam_details_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "class_id")
	private Class classRef;

	@ManyToOne
	@JoinColumn(name = "exam_reference_data_id")
	private ReferenceData examReferenceData;

	@Transient
	private String modification;


	/**
	 * @return the examReferenceData
	 */
	public ReferenceData getExamReferenceData() {
		return examReferenceData;
	}

	/**
	 * @param examReferenceData
	 *            the examReferenceData to set
	 */
	public void setExamReferenceData(ReferenceData examReferenceData) {
		this.examReferenceData = examReferenceData;
	}

	/**
	 * @return the modification
	 */
	public String getModification() {
		return modification;
	}

	/**
	 * @param modification
	 *            the modification to set
	 */
	public void setModification(String modification) {
		this.modification = modification;
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
