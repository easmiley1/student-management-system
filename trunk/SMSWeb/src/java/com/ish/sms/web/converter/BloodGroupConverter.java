package com.ish.sms.web.converter;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.ish.sms.service.dto.BloodGroupDTO;
import com.ish.sms.web.bean.ReferenceBean;
import com.ish.sms.web.util.WebUtils;

@ManagedBean(name="bloodGroupConverter")
@ViewScoped
public class BloodGroupConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {

		ReferenceBean referenceBean = WebUtils.findBean("referenceBean");
		List<BloodGroupDTO> BloodGroupDTOList = referenceBean.getBloodGroupDTOList();
		BloodGroupDTO selectedBloodGroupDTO = null;
		for (BloodGroupDTO bloodGroupDTO : BloodGroupDTOList) {
			if (bloodGroupDTO.getName().equalsIgnoreCase(value)) {
				selectedBloodGroupDTO = bloodGroupDTO;
				break;
			}
		}

		return selectedBloodGroupDTO;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {

		BloodGroupDTO bloodGroupDTO = (BloodGroupDTO) value;
		if(bloodGroupDTO ==null) return null;
		return bloodGroupDTO.getName().toString();
	}

}