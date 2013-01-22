package com.ish.sms.web.service.adapter;


import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.ish.sms.service.dto.AttendanceYears;
import com.ish.sms.service.dto.AttendanceYearsList;
import com.ish.sms.web.service.dto.AttendanceYearMap;

/**
 * The XmlAdapter that does the important conversion from list type to map:
 * 
 * @author Naren
 * 
 */
public class AttendanceYearMapAdapter extends XmlAdapter<AttendanceYears, AttendanceYearMap<String, AttendanceYearsList>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public AttendanceYears marshal(AttendanceYearMap<String, AttendanceYearsList> attendanceYearMap) throws Exception {

		AttendanceYears attendanceYears = new AttendanceYears();
		for (Map.Entry<String, AttendanceYearsList> entry : attendanceYearMap.entrySet()) {
			AttendanceYears.Entry e = new AttendanceYears.Entry();
			e.setKey(entry.getKey());
			e.setValue(entry.getValue());
			attendanceYears.getEntry().add(e);
		}
		return attendanceYears;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public AttendanceYearMap<String, AttendanceYearsList> unmarshal(AttendanceYears attendanceYears) throws Exception {
		AttendanceYearMap<String, AttendanceYearsList> attendanceYearMap = new AttendanceYearMap<String, AttendanceYearsList>();
		for (AttendanceYears.Entry e : attendanceYears.getEntry()) {
			attendanceYearMap.put(e.getKey(), e.getValue());
		}
		return attendanceYearMap;
	}

}