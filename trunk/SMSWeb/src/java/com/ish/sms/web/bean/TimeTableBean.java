package com.ish.sms.web.bean;

import java.util.ArrayList;
import java.util.List;

import com.ish.sms.service.dto.ClassTimeTableDTO;
import com.ish.sms.service.dto.ReferenceDataDTO;

public class TimeTableBean {

	private ReferenceDataDTO dayOfWeek;
	
	private List<ClassTimeTableDTO> periodList = new ArrayList<ClassTimeTableDTO>();

	/**
	 * @return the dayOfWeek
	 */
	public ReferenceDataDTO getDayOfWeek() {
		return dayOfWeek;
	}

	/**
	 * @param dayOfWeek the dayOfWeek to set
	 */
	public void setDayOfWeek(ReferenceDataDTO dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	/**
	 * @return the periodList
	 */
	public List<ClassTimeTableDTO> getPeriodList() {
		return periodList;
	}

	/**
	 * @param periodList the periodList to set
	 */
	public void setPeriodList(List<ClassTimeTableDTO> periodList) {
		this.periodList = periodList;
	}
	
	
}
