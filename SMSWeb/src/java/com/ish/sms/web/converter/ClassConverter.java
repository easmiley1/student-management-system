package com.ish.sms.web.converter;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.web.bean.ReferenceBean;
import com.ish.sms.web.util.WebConstants;
import com.ish.sms.web.util.WebUtils;

/**
 * Custom converter for Class reference selection
 * 
 * @author Naren
 * 
 */
@ManagedBean(name = WebConstants.CLASS_CONVERTER)
@ViewScoped
public class ClassConverter implements Converter, Serializable, WebConstants {

	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext
	 * , javax.faces.component.UIComponent, java.lang.String)
	 */
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {

		ReferenceBean referenceBean = new WebUtils().findBean(REFERENCE_BEAN);
		List<ClassDTO> ClassDTOList = referenceBean.getClassDTOList();
		ClassDTO selectedClassDTO = null;
		for (ClassDTO classDTO : ClassDTOList) {
			if (classDTO.getName().equalsIgnoreCase(value)) {
				selectedClassDTO = classDTO;
				break;
			}
		}

		return selectedClassDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext
	 * , javax.faces.component.UIComponent, java.lang.Object)
	 */
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {

		ClassDTO classDTO = (ClassDTO) value;
		if (classDTO == null)
			return null;
		return classDTO.getName().toString();
	}

}