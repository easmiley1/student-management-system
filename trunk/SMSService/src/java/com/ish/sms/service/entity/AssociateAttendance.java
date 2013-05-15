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

import com.ish.sms.service.dto.AttendanceMap;
import com.ish.sms.service.util.QueryConstants;

/**
 * This entity represents the attendance data table in the database
 * 
 * @author Naren
 * 
 */

@NamedQueries({ @NamedQuery(name = QueryConstants.FIND_ASSOCIATE_ATTENDANCE_DATA, query = QueryConstants.FIND_ASSOCIATE_ATTENDANCE_DATA_QUERY),
		@NamedQuery(name = QueryConstants.FIND_ASSOCIATE_CURR_YEAR_ATT_DATA, query = QueryConstants.FIND_ASSOCIATE_CURR_YEAR_ATT_DATA_QUERY) })
@Entity
@Table(name = "student_attendance_details")
public class AssociateAttendance implements Serializable {

	private final static long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "attendance_data_id")
	protected Integer id;
	@Column(name = "attendance_data", nullable = true)
	protected AttendanceMap<String, Boolean> attendanceMap;
	@ManyToOne
	@JoinColumn(name = "student_id")
	protected Student student;
	@ManyToOne
	@JoinColumn(name = "attendance_month_id")
	protected ClassAttendanceDef classAttendanceDef;

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
	 * @return the attendanceMap
	 */
	public AttendanceMap<String, Boolean> getAttendanceMap() {
		return attendanceMap;
	}

	/**
	 * @param attendanceMap
	 *            the attendanceMap to set
	 */
	public void setAttendanceMap(AttendanceMap<String, Boolean> attendanceMap) {
		this.attendanceMap = attendanceMap;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student
	 *            the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @return the classAttendanceDef
	 */
	public ClassAttendanceDef getClassAttendanceDef() {
		return classAttendanceDef;
	}

	/**
	 * @param classAttendanceDef
	 *            the classAttendanceDef to set
	 */
	public void setClassAttendanceDef(ClassAttendanceDef classAttendanceDef) {
		this.classAttendanceDef = classAttendanceDef;
	}

}
