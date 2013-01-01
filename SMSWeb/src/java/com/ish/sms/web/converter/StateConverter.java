package com.ish.sms.web.converter;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.ish.sms.service.dto.StateDTO;
import com.ish.sms.web.bean.ReferenceBean;
import com.ish.sms.web.util.WebUtils;

@ManagedBean(name="stateConverter")
@ViewScoped
public class StateConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {

		ReferenceBean referenceBean = WebUtils.findBean("referenceBean");
		List<StateDTO> stateDTOList = referenceBean.getStateDTOList();
		StateDTO selectedState = null;
		for (StateDTO stateDTO : stateDTOList) {
			if (stateDTO.getName().equalsIgnoreCase(value)) {
				selectedState = stateDTO;
				break;
			}
		}

		return selectedState;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {

		StateDTO stateDTO = (StateDTO) value;
		if(stateDTO ==null) return null;
		return stateDTO.getName().toString();
	}

}