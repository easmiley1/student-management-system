package com.ish.sms.web.service.adapter;

import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.ish.sms.service.dto.AttendanceDays;
import com.ish.sms.service.dto.AttendanceDaysList;
import com.ish.sms.web.service.dto.AttendanceDayMap;

/**
 * The XmlAdapter that does the important conversion from list type to map:
 * 
 * @author Naren
 * 
 */
public class AttendanceDayMapAdapter extends XmlAdapter<AttendanceDays, AttendanceDayMap<String, AttendanceDaysList>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public AttendanceDays marshal(AttendanceDayMap<String, AttendanceDaysList> attendanceDayMap) throws Exception {

		AttendanceDays attendanceDays = new AttendanceDays();
		for (Map.Entry<String, AttendanceDaysList> entry : attendanceDayMap.entrySet()) {
			AttendanceDays.Entry e = new AttendanceDays.Entry();
			e.setKey(entry.getKey());
			e.setValue(entry.getValue());
			attendanceDays.getEntry().add(e);
		}
		return attendanceDays;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public AttendanceDayMap<String, AttendanceDaysList> unmarshal(AttendanceDays attendanceDays) throws Exception {
		AttendanceDayMap<String, AttendanceDaysList> attendanceDayMap = new AttendanceDayMap<String, AttendanceDaysList>();
		for (AttendanceDays.Entry e : attendanceDays.getEntry()) {
			attendanceDayMap.put(e.getKey(), e.getValue());
		}
		return attendanceDayMap;
	}

}