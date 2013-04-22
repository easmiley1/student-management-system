package com.ish.sms.web.bean;

/**
 * Bean class containing individual student grade details for specific exam and subject
 * 
 * @author enselv
 *
 */
public class GradeDetailsBean {

	private Integer mark;
	private String grade;
	private Integer studentGradeId;

	/**
	 * @return the mark
	 */
	public Integer getMark() {
		return mark;
	}

	/**
	 * @param mark
	 *            the mark to set
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
	 * @param grade
	 *            the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the studentGradeId
	 */
	public Integer getStudentGradeId() {
		return studentGradeId;
	}

	/**
	 * @param studentGradeId
	 *            the studentGradeId to set
	 */
	public void setStudentGradeId(Integer studentGradeId) {
		this.studentGradeId = studentGradeId;
	}

}
