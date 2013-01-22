package com.ish.sms.web.service.dto;

import java.util.HashMap;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.ish.sms.web.service.adapter.AttendanceDayMapAdapter;

@SuppressWarnings("hiding")
@XmlJavaTypeAdapter(AttendanceDayMapAdapter.class)
public class AttendanceYearMap<String, AttendanceYearsList> extends HashMap<String, AttendanceYearsList> {

	private static final long serialVersionUID = 1L;
}
