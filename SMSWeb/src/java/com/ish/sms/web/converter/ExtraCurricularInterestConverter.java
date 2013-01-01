package com.ish.sms.web.converter;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.ish.sms.service.dto.ExtraCurricularDTO;
import com.ish.sms.web.bean.ReferenceBean;
import com.ish.sms.web.util.WebUtils;

@ManagedBean(name="extraCurricularInterestConverter")
@ViewScoped
public class ExtraCurricularInterestConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {

		ReferenceBean referenceBean = WebUtils.findBean("referenceBean");
		List<ExtraCurricularDTO> ExtraCurricularDTOList = referenceBean.getExtraCurricularDTOList();
		ExtraCurricularDTO selectedExtraCurricularDTO = null;
		for (ExtraCurricularDTO extraCurricularDTO : ExtraCurricularDTOList) {
			if (extraCurricularDTO.getName().equalsIgnoreCase(value)) {
				selectedExtraCurricularDTO = extraCurricularDTO;
				break;
			}
		}

		return selectedExtraCurricularDTO;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {

		ExtraCurricularDTO extraCurricularDTO = (ExtraCurricularDTO) value;
		if(extraCurricularDTO ==null) return null;
		return extraCurricularDTO.getName().toString();
	}

}