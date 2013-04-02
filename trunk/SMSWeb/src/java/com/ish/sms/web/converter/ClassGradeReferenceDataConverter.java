package com.ish.sms.web.converter;

import com.ish.sms.service.dto.ClassExamReferenceDataDTO;

import java.io.Serializable;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.ish.sms.service.dto.ClassReferenceDataDTO;
import com.ish.sms.web.bean.ClassGradeBean;
import com.ish.sms.web.util.WebConstants;
import com.ish.sms.web.util.WebUtils;

/**
 * Custom converter for class Reference data
 * 
 * @author Naren
 * 
 */
@FacesConverter(value = "classGradeReferenceDataConverter")
public class ClassGradeReferenceDataConverter implements Converter, Serializable, WebConstants {

	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {

		ClassGradeBean classGradeBean = new WebUtils().findBean(CLASS_GRADE_BEAN);
		List<ClassExamReferenceDataDTO> classReferenceDataDTOList = classGradeBean.getClassExamReferenceDataDTOList();

		ClassReferenceDataDTO selectedClassReferenceDataDTO = null;
		for (ClassReferenceDataDTO classReferenceDataDTO : classReferenceDataDTOList) {
			if (classReferenceDataDTO.getReferenceDataDTO().getName().equals(value)) {
				selectedClassReferenceDataDTO = classReferenceDataDTO;
				break;
			}
		}

		return selectedClassReferenceDataDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {

		ClassReferenceDataDTO classReferenceDataDTO = (ClassReferenceDataDTO) value;
		if (classReferenceDataDTO == null)
			return null;
		return classReferenceDataDTO.getReferenceDataDTO().getName().toString();
	}

}