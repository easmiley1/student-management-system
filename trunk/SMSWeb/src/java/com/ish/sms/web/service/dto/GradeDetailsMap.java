package com.ish.sms.web.service.dto;

import java.util.HashMap;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.ish.sms.web.service.dto.adapter.GradeDetailsAdapter;


@XmlJavaTypeAdapter(GradeDetailsAdapter.class)
public class GradeDetailsMap<ClassSubjectReferenceDataDTO, GradeDetailsDTO> extends HashMap<ClassSubjectReferenceDataDTO, GradeDetailsDTO> {

	private static final long serialVersionUID = 1L;
}
