package com.ish.sms.web.converter;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.ish.sms.service.dto.StateDTO;
import com.ish.sms.web.bean.ReferenceBean;
import com.ish.sms.web.util.WebConstants;
import com.ish.sms.web.util.WebUtils;

/**
 * Custom converter for States reference selection
 * 
 * @author Naren
 *
 */
@ManagedBean(name = WebConstants.STATE_CONVERTER)
@ViewScoped
public class StateConverter implements Converter, Serializable, WebConstants {

	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {

		ReferenceBean referenceBean = WebUtils.findBean(REFERENCE_BEAN);
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

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {

		StateDTO stateDTO = (StateDTO) value;
		if (stateDTO == null)
			return null;
		return stateDTO.getName().toString();
	}

}