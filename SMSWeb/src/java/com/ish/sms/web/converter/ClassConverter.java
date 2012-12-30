package com.ish.sms.web.converter;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.web.bean.ReferenceBean;
import com.ish.sms.web.util.WebUtils;

@ManagedBean(name="classConverter")
public class ClassConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {

		ReferenceBean referenceBean = WebUtils.findBean("referenceBean");
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

	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {

		ClassDTO classDTO = (ClassDTO) value;
		if(classDTO ==null) return null;
		return classDTO.getName().toString();
	}

}