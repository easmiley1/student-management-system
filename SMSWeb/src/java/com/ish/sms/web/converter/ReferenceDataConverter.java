package com.ish.sms.web.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.ish.sms.service.dto.ReferenceDataDTO;
import com.ish.sms.web.bean.ReferenceBean;
import com.ish.sms.web.util.WebConstants;
import com.ish.sms.web.util.WebUtils;

/**
 * Custom converter for  reference data selection
 * 
 * @author Naren
 * 
 */
@FacesConverter(value = WebConstants.REFERENCE_DATA_CONVERTER)

public class ReferenceDataConverter implements Converter, Serializable, WebConstants {

	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {

		ReferenceBean referenceBean = new WebUtils().findBean(REFERENCE_BEAN);
		List<ReferenceDataDTO> referenceDataDTOList = new ArrayList<ReferenceDataDTO>();
		if (component.getId().startsWith(WebUtils.REFERENCE_TYPE.bloodGroup.name())) {
			referenceDataDTOList = referenceBean.getBloodGroupDTOList();
		} else if (component.getId().startsWith(WebUtils.REFERENCE_TYPE.extraCurricularInterest.name())) {
			referenceDataDTOList = referenceBean.getExtraCurricularDTOList();
		} else if (component.getId().startsWith(WebUtils.REFERENCE_TYPE.stateName.name())) {
			referenceDataDTOList = referenceBean.getStateDTOList();
		} else if (component.getId().startsWith(WebUtils.REFERENCE_TYPE.transportation.name())) {
			referenceDataDTOList = referenceBean.getModeofTransportDTOList();
		} else if (component.getId().startsWith(WebUtils.REFERENCE_TYPE.subjectName.name())) {
			referenceDataDTOList = referenceBean.getSubjectDTOList();
		} else if (component.getId().startsWith(WebUtils.REFERENCE_TYPE.exam.name())) {
			referenceDataDTOList = referenceBean.getExamDataDTOList();
		} else if (component.getId().startsWith(WebUtils.REFERENCE_TYPE.className.name())) {
			referenceDataDTOList = referenceBean.getExamDataDTOList();
		}

		ReferenceDataDTO selectedReferenceDataDTO = null;
		for (ReferenceDataDTO referenceDataDTO : referenceDataDTOList) {
			if (referenceDataDTO.getName().equalsIgnoreCase(value)) {
				selectedReferenceDataDTO = referenceDataDTO;
				break;
			}
		}

		return selectedReferenceDataDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {

		ReferenceDataDTO referenceDataDTO = (ReferenceDataDTO) value;
		if (referenceDataDTO == null)
			return null;
		return referenceDataDTO.getName().toString();
	}

}