package com.ish.sms.web.bean;

import org.primefaces.model.DualListModel;

public class MaintainRegisterMonthBean {

	
    private DualListModel<String> classAttendanceDTOModel = new DualListModel<String>();
	/**
	 * @return the classAttendanceDTOModel
	 */
	public DualListModel<String> getClassAttendanceDTOModel() {
		return classAttendanceDTOModel;
	}
	/**
	 * @param classAttendanceDTOModel the classAttendanceDTOModel to set
	 */
	public void setClassAttendanceDTOModel(DualListModel<String> classAttendanceDTOModel) {
		this.classAttendanceDTOModel = classAttendanceDTOModel;
	}  
    
    
    
}
