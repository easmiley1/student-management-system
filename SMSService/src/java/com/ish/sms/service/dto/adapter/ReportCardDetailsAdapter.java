package com.ish.sms.service.dto.adapter;

import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.ish.sms.service.dto.ClassExamReferenceDataDTO;
import com.ish.sms.service.dto.ReportCardDetails;
import com.ish.sms.service.dto.ReportCardDetailsDTO;
import com.ish.sms.service.dto.ReportCardDetailsMap;

/**
 * The XmlAdapter that does the conversion from list type to map for student grade details
 * 
 * @author Naren
 * 
 */
public class ReportCardDetailsAdapter extends XmlAdapter<ReportCardDetails, ReportCardDetailsMap<ClassExamReferenceDataDTO, ReportCardDetailsDTO>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public ReportCardDetails marshal(ReportCardDetailsMap<ClassExamReferenceDataDTO, ReportCardDetailsDTO> reportCardDetailsMap) throws Exception {

		ReportCardDetails reportCardDetails = new ReportCardDetails();
		for (Map.Entry<ClassExamReferenceDataDTO, ReportCardDetailsDTO> entry : reportCardDetailsMap.entrySet()) {
			ReportCardDetails.Entry e = new ReportCardDetails.Entry();
			e.setKey(entry.getKey());
			e.setValue(entry.getValue());
			reportCardDetails.getEntry().add(e);
		}
		return reportCardDetails;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public ReportCardDetailsMap<ClassExamReferenceDataDTO, ReportCardDetailsDTO> unmarshal(ReportCardDetails reportCardDetails) throws Exception {

		ReportCardDetailsMap<ClassExamReferenceDataDTO, ReportCardDetailsDTO> reportCardDetailsMap = new ReportCardDetailsMap<ClassExamReferenceDataDTO, ReportCardDetailsDTO>();
		for (ReportCardDetails.Entry e : reportCardDetails.getEntry()) {
			reportCardDetailsMap.put(e.getKey(), e.getValue());
		}
		return reportCardDetailsMap;
	}

}