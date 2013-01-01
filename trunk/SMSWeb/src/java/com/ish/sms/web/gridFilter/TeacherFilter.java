package com.ish.sms.web.gridFilter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Filter class to map the filter inputs in the student grids.
 * 
 * @author Naren
 *
 */
@ManagedBean(name="teacherFilter")
@ViewScoped
public class TeacherFilter implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer experienceFilter;
    private String educationFilter;
	/**
	 * @return the experienceFilter
	 */
	public Integer getExperienceFilter() {
		return experienceFilter;
	}
	/**
	 * @param experienceFilter the experienceFilter to set
	 */
	public void setExperienceFilter(Integer experienceFilter) {
		this.experienceFilter = experienceFilter;
	}
	/**
	 * @return the educationFilter
	 */
	public String getEducationFilter() {
		return educationFilter;
	}
	/**
	 * @param educationFilter the educationFilter to set
	 */
	public void setEducationFilter(String educationFilter) {
		this.educationFilter = educationFilter;
	}

}
