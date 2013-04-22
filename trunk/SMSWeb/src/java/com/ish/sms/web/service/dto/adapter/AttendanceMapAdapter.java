package com.ish.sms.web.service.dto.adapter;


import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.ish.sms.service.dto.Attendances;
import com.ish.sms.web.service.dto.AttendanceMap;

/**
 * The XmlAdapter that does the  conversion from list type to map for attendance details
 * 
 * @author Naren
 * 
 */
public class AttendanceMapAdapter extends XmlAdapter<Attendances, AttendanceMap<String, Boolean>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public Attendances marshal(AttendanceMap<String, Boolean> attendanceMap) throws Exception {

		Attendances attendances = new Attendances();
		for (Map.Entry<String, Boolean> entry : attendanceMap.entrySet()) {
			Attendances.Entry e = new Attendances.Entry();
			e.setKey(entry.getKey());
			e.setValue(entry.getValue());
			attendances.getEntry().add(e);
		}
		return attendances;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public AttendanceMap<String, Boolean> unmarshal(Attendances attendances) throws Exception {
		AttendanceMap<String, Boolean> attendanceMap = new AttendanceMap<String, Boolean>();
		for (Attendances.Entry e : attendances.getEntry()) {
			attendanceMap.put(e.getKey(), e.isValue());
		}
		return attendanceMap;
	}

}