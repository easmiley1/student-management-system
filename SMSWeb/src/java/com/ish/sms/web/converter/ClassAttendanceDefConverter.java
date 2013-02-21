package com.ish.sms.web.converter;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.ish.sms.service.dto.ClassAttendanceDefDTO;
import com.ish.sms.web.bean.ClassAttendanceBean;
import com.ish.sms.web.util.WebConstants;
import com.ish.sms.web.util.WebUtils;

/**
 * Custom converter for Class Attendance Definition selection
 * 
 * @author Naren
 *
 */
@ManagedBean(name = WebConstants.CLASS_ATTENDANCE_DEF_CONVERTER)
@ViewScoped
public class ClassAttendanceDefConverter implements Converter, Serializable, WebConstants {

	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {

		ClassAttendanceBean classBean = WebUtils.findBean(CLASS_ATTENDANCE_BEAN);
		List<ClassAttendanceDefDTO> classAttendanceDefDTOList = classBean.getAttendanceRegisterBean().getClassAttendanceDefDTOList();
		ClassAttendanceDefDTO selectedClassAttendanceDefDTO = null;
		for (ClassAttendanceDefDTO classAttendanceDefDTO : classAttendanceDefDTOList) {
			if (classAttendanceDefDTO.getMonthYear().equalsIgnoreCase(value)) {
				selectedClassAttendanceDefDTO = classAttendanceDefDTO;
				break;
			}
		}

		return selectedClassAttendanceDefDTO;
	}

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {

		ClassAttendanceDefDTO classAttendanceDefDTO = (ClassAttendanceDefDTO) value;
		if (classAttendanceDefDTO == null)
			return null;
		return classAttendanceDefDTO.getMonthYear().toString();
	}

}