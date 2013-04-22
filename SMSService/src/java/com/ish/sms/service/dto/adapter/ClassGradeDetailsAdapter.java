package com.ish.sms.service.dto.adapter;

import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.ish.sms.service.dto.ClassSubjectReferenceDataDTO;
import com.ish.sms.service.dto.GradeDetails;
import com.ish.sms.service.dto.GradeDetailsDTO;
import com.ish.sms.service.dto.GradeDetailsMap;

/**
 * The XmlAdapter that does the conversion from list type to map for student grade details
 * 
 * @author Naren
 * 
 */
public class ClassGradeDetailsAdapter extends XmlAdapter<GradeDetails, GradeDetailsMap<ClassSubjectReferenceDataDTO, GradeDetailsDTO>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public GradeDetails marshal(GradeDetailsMap<ClassSubjectReferenceDataDTO, GradeDetailsDTO> gradeDetailsMap) throws Exception {

		GradeDetails gradeDetails = new GradeDetails();
		for (Map.Entry<ClassSubjectReferenceDataDTO, GradeDetailsDTO> entry : gradeDetailsMap.entrySet()) {
			GradeDetails.Entry e = new GradeDetails.Entry();
			e.setKey(entry.getKey());
			e.setValue(entry.getValue());
			gradeDetails.getEntry().add(e);
		}
		return gradeDetails;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public GradeDetailsMap<ClassSubjectReferenceDataDTO, GradeDetailsDTO> unmarshal(GradeDetails gradeDetails) throws Exception {
		
		GradeDetailsMap<ClassSubjectReferenceDataDTO, GradeDetailsDTO> gradeDetailsMap = new GradeDetailsMap<ClassSubjectReferenceDataDTO, GradeDetailsDTO>();
		for (GradeDetails.Entry e : gradeDetails.getEntry()) {
			gradeDetailsMap.put(e.getKey(), e.getValue());
		}
		return gradeDetailsMap;
	}

}