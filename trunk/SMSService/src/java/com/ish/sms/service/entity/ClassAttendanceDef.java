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

@NamedQueries( { @NamedQuery(name = QueryConstants.FIND_CLASS_ATTENDANCE_DEF, query = QueryConstants.FIND_CLASS_ATTENDANCE_DEF_QUERY) })
@Entity
@Table(name = "class_attendance_def")

public class ClassAttendanceDef implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "attendance_month_id")
	private Integer id;

	@Column(nullable = false, name = "month_year")
	private String monthYear;
	
	@ManyToOne
	@JoinColumn(name = "class_id")
	private Class classRef;
	
	@Transient
	private String modification;

	/**
	 * @return the modification
	 */
	public String getModification() {
		return modification;
	}

	/**
	 * @param modification the modification to set
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
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the monthYear
	 */
	public String getMonthYear() {
		return monthYear;
	}

	/**
	 * @param monthYear the monthYear to set
	 */
	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
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
