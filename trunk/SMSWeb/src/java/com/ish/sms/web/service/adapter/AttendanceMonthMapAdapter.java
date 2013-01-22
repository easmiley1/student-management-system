package com.ish.sms.web.service.adapter;


import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.ish.sms.service.dto.AttendanceMonths;
import com.ish.sms.service.dto.AttendanceMonthsList;
import com.ish.sms.web.service.dto.AttendanceMonthMap;

/**
 * The XmlAdapter that does the important conversion from list type to map:
 * 
 * @author Naren
 * 
 */
public class AttendanceMonthMapAdapter extends XmlAdapter<AttendanceMonths, AttendanceMonthMap<String, AttendanceMonthsList>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public AttendanceMonths marshal(AttendanceMonthMap<String, AttendanceMonthsList> attendanceMonthMap) throws Exception {

		AttendanceMonths attendanceMonths = new AttendanceMonths();
		for (Map.Entry<String, AttendanceMonthsList> entry : attendanceMonthMap.entrySet()) {
			AttendanceMonths.Entry e = new AttendanceMonths.Entry();
			e.setKey(entry.getKey());
			e.setValue(entry.getValue());
			attendanceMonths.getEntry().add(e);
		}
		return attendanceMonths;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public AttendanceMonthMap<String, AttendanceMonthsList> unmarshal(AttendanceMonths attendanceMonths) throws Exception {
		AttendanceMonthMap<String, AttendanceMonthsList> attendanceMonthMap = new AttendanceMonthMap<String, AttendanceMonthsList>();
		for (AttendanceMonths.Entry e : attendanceMonths.getEntry()) {
			attendanceMonthMap.put(e.getKey(), e.getValue());
		}
		return attendanceMonthMap;
	}

}