package com.ish.sms.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.ish.sms.service.util.QueryConstants;

@NamedQueries( { @NamedQuery(name = QueryConstants.FIND_CLASS_ATTENDANCE_DEF, query = QueryConstants.FIND_CLASS_ATTENDANCE_DEF_QUERY) })
@Entity
@Table(name = "class_attendance_def")

public class ClassAttendanceDef {

	@Id
	@Column(name = "attendance_month_id")
	private Integer id;

	@Column(nullable = false, name = "month")
	private Integer month;

	@Column(nullable = false, name = "year")
	private Integer year;
	
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
	 * @return the month
	 */
	public Integer getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(Integer month) {
		this.month = month;
	}

	/**
	 * @return the year
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(Integer year) {
		this.year = year;
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
