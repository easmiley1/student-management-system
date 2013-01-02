package com.ish.sms.web.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 * Custom converter for any date selections in the application
 * 
 * @author Naren
 *
 */
public class DateConverter implements Converter {
	
	private String pattern = "MM/dd/yyyy";

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {

		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if (value != null && value.length() > 0) {
			try {
				Date date = sdf.parse(value);
				result = sdf.format(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {

		String result = "";
		String valueStr = (String) value;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if (valueStr != null && valueStr.length() > 0) {
			try {
				Date date = sdf.parse(valueStr);
				result = sdf.format(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}