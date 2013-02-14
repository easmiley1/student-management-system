package com.ish.sms.service.dto;

import java.util.HashMap;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.ish.sms.service.dto.adapter.AttendanceMapAdapter;

@SuppressWarnings("hiding")
@XmlJavaTypeAdapter(AttendanceMapAdapter.class)
public class AttendanceMap<String, Boolean> extends HashMap<String, Boolean> {

	private static final long serialVersionUID = 1L;
}
