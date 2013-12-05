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
 * Entity class that represents the time table of a class
 * 
 * @author Naren
 * 
 */
@NamedQueries({ @NamedQuery(name = QueryConstants.FIND_CLASS_TIME_TABLE, query = QueryConstants.FIND_CLASS_TIME_TABLE_QUERY),
		@NamedQuery(name = QueryConstants.FIND_CLASS_TIME_TABLE_FOR_TEACHER, query = QueryConstants.FIND_CLASS_TIME_TABLE_FOR_TEACHER_QUERY) })
@Entity
@Table(name = "class_time_table")
public class ClassTimeTable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "class_time_table_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "class_id")
	private Class classRef;

	@ManyToOne
	@JoinColumn(name = "day_id")
	private ReferenceData dayofWeek;

	@ManyToOne
	@JoinColumn(name = "subject_id")
	private ClassSubjectReferenceData classSubjectReferenceData;

	@Column(name = "class_start_time")
	private String startTime;

	@Column(name = "class_end_time")
	private String endTime;

	@Column(name = "period_seq")
	private String periodName;

	/**
	 * @return the classSubjectReferenceData
	 */
	public ClassSubjectReferenceData getClassSubjectReferenceData() {
		return classSubjectReferenceData;
	}

	/**
	 * @param classSubjectReferenceData
	 *            the classSubjectReferenceData to set
	 */
	public void setClassSubjectReferenceData(ClassSubjectReferenceData classSubjectReferenceData) {
		this.classSubjectReferenceData = classSubjectReferenceData;
	}

	/**
	 * @return the periodName
	 */
	public String getPeriodName() {
		return periodName;
	}

	/**
	 * @param periodName
	 *            the periodName to set
	 */
	public void setPeriodName(String periodName) {
		this.periodName = periodName;
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

	/**
	 * @return the dayofWeek
	 */
	public ReferenceData getDayofWeek() {
		return dayofWeek;
	}

	/**
	 * @param dayofWeek
	 *            the dayofWeek to set
	 */
	public void setDayofWeek(ReferenceData dayofWeek) {
		this.dayofWeek = dayofWeek;
	}

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
