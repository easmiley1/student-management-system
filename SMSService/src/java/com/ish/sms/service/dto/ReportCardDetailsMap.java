package com.ish.sms.service.dto;

import java.util.HashMap;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.ish.sms.service.dto.adapter.GradeDetailsAdapter; 
 
@SuppressWarnings("hiding")
@XmlJavaTypeAdapter(GradeDetailsAdapter.class)
public class ReportCardDetailsMap<ClassExamReferenceDataDTO, ReportCardDetailsDTO> extends HashMap<ClassExamReferenceDataDTO, ReportCardDetailsDTO> {

	private static final long serialVersionUID = 1L;
}
