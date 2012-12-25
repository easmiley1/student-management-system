package com.ish.sms.web.filter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Filter class to map the filter inputs in the student grids.
 * 
 * @author Naren
 *
 */
@ManagedBean(name="studentFilter")
@ViewScoped
public class StudentFilter implements Serializable{

	private static final long serialVersionUID = 1L;
	private String joiningClassFilter;
    private String modeOfTransportFilter;
	/**
	 * @return the joiningClassFilter
	 */
	public String getJoiningClassFilter() {
		return joiningClassFilter;
	}
	/**
	 * @param joiningClassFilter the joiningClassFilter to set
	 */
	public void setJoiningClassFilter(String joiningClassFilter) {
		this.joiningClassFilter = joiningClassFilter;
	}
	/**
	 * @return the modeOfTransportFilter
	 */
	public String getModeOfTransportFilter() {
		return modeOfTransportFilter;
	}
	/**
	 * @param modeOfTransportFilter the modeOfTransportFilter to set
	 */
	public void setModeOfTransportFilter(String modeOfTransportFilter) {
		this.modeOfTransportFilter = modeOfTransportFilter;
	}
}
