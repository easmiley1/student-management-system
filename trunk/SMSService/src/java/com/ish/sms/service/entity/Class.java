package com.ish.sms.service.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ish.sms.service.util.QueryConstants;

@NamedQueries( { @NamedQuery(name = QueryConstants.FIND_ALL_CLASSES, query = QueryConstants.FIND_ALL_CLASSES_QUERY),
	 @NamedQuery(name = QueryConstants.FIND_CLASS_BY_ID, query = QueryConstants.FIND_CLASS_BY_ID_QUERY) })
@Entity
@Table(name = "class_details")
public class Class implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "class_id")
	private Integer id;

	@Column(nullable = false, name = "class_name")
	private String name;

	@OneToOne
	@JoinColumn(name = "class_teacher")
	private Teacher teacher;

	@Column(nullable=true, name="student_count")
	private Integer studentCount;

	@Column(nullable=true, name="class_start")
	private Integer startYear;
	
	@Column(nullable=true, name="class_end")
	private Integer endYear;

	@Column(nullable = false, name = "active")
	private String active;

	@OneToMany(mappedBy="classRef", cascade={CascadeType.ALL}, orphanRemoval=true)
	private Collection<ClassExamReferenceData> classExamReferenceData;
	
	@OneToMany(mappedBy="classRef", cascade={CascadeType.ALL}, orphanRemoval=true)
	private Collection<ClassSubjectReferenceData> classSubjectReferenceData;

	@OneToMany(mappedBy="classRef", cascade={CascadeType.ALL})
	private Collection<ClassTimeTable> classTimeTable;


	/**
	 * @return the classExamReferenceData
	 */
	public Collection<ClassExamReferenceData> getClassExamReferenceData() {
		return classExamReferenceData;
	}

	/**
	 * @param classExamReferenceData the classExamReferenceData to set
	 */
	public void setClassExamReferenceData(Collection<ClassExamReferenceData> classExamReferenceData) {
		this.classExamReferenceData = classExamReferenceData;
	}

	/**
	 * @return the classSubjectReferenceData
	 */
	public Collection<ClassSubjectReferenceData> getClassSubjectReferenceData() {
		return classSubjectReferenceData;
	}

	/**
	 * @param classSubjectReferenceData the classSubjectReferenceData to set
	 */
	public void setClassSubjectReferenceData(Collection<ClassSubjectReferenceData> classSubjectReferenceData) {
		this.classSubjectReferenceData = classSubjectReferenceData;
	}

	/**
	 * @return the classTimeTable
	 */
	public Collection<ClassTimeTable> getClassTimeTable() {
		return classTimeTable;
	}

	/**
	 * @param classTimeTable the classTimeTable to set
	 */
	public void setClassTimeTable(Collection<ClassTimeTable> classTimeTable) {
		this.classTimeTable = classTimeTable;
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
	

	
	/**
	 * @return the startYear
	 */
	public Integer getStartYear() {
		return startYear;
	}

	/**
	 * @param startYear the startYear to set
	 */
	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}

	/**
	 * @return the endYear
	 */
	public Integer getEndYear() {
		return endYear;
	}

	/**
	 * @param endYear the endYear to set
	 */
	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}
	
}
