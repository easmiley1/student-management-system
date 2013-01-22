package com.ish.sms.web.service.dto;

import java.util.HashMap;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.ish.sms.web.service.adapter.AttendanceDayMapAdapter;

@SuppressWarnings("hiding")
@XmlJavaTypeAdapter(AttendanceDayMapAdapter.class)
public class AttendanceMonthMap<String, AttendanceMonthsList> extends HashMap<String, AttendanceMonthsList> {

	private static final long serialVersionUID = 1L;
}
