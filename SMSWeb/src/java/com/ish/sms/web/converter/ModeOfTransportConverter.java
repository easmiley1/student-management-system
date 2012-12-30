package com.ish.sms.web.converter;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.ish.sms.service.dto.ModeofTransportDTO;
import com.ish.sms.web.bean.ReferenceBean;
import com.ish.sms.web.util.WebUtils;

@ManagedBean(name="modeOfTransportConverter")
public class ModeOfTransportConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {

		ReferenceBean referenceBean = WebUtils.findBean("referenceBean");
		List<ModeofTransportDTO> ModeofTransportDTOList = referenceBean.getModeofTransportDTOList();
		ModeofTransportDTO selectedModeofTransport = null;
		for (ModeofTransportDTO modeofTransportDTO : ModeofTransportDTOList) {
			if (modeofTransportDTO.getName().equalsIgnoreCase(value)) {
				selectedModeofTransport = modeofTransportDTO;
				break;
			}
		}

		return selectedModeofTransport;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {

		ModeofTransportDTO modeofTransportDTO = (ModeofTransportDTO) value;
		if(modeofTransportDTO ==null) return null;
		return modeofTransportDTO.getName().toString();
	}

}