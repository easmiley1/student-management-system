package com.ish.sms.web.converter;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.web.bean.AttendanceReportBean;
import com.ish.sms.web.util.WebConstants;
import com.ish.sms.web.util.WebUtils;

/**
 * Custom converter for Class reference selection
 * 
 * @author Naren
 * 
 */
@ManagedBean(name = WebConstants.STUDENT_CONVERTER)
@ViewScoped
public class StudentConverter implements Converter, Serializable, WebConstants {

	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext
	 * , javax.faces.component.UIComponent, java.lang.String)
	 */
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {

		AttendanceReportBean attendanceReportBean = new WebUtils().findBean(ATTENDANCE_REPORT_BEAN);
		List<StudentDTO> studentDTOList = attendanceReportBean.getStudentDTOList();
		StudentDTO selectedStudentDTO = null;
		for (StudentDTO studentDTO : studentDTOList) {
			if (studentDTO.getFirstName().equalsIgnoreCase(value)) {
				selectedStudentDTO = studentDTO;
				break;
			}
		}

		return selectedStudentDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext
	 * , javax.faces.component.UIComponent, java.lang.Object)
	 */
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {

		StudentDTO studentDTO = (StudentDTO) value;
		if (studentDTO == null || studentDTO.getFirstName() == null)
			return null;
		return studentDTO.getFirstName();
	}

}