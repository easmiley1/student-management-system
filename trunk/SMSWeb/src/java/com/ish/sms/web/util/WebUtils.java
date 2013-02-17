package com.ish.sms.web.util;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.context.FacesContext;

/**
 * Class containing web utility methods
 * 
 * @author Naren
 * 
 */
public class WebUtils {

	
	public static enum CLASS_DEF_MODIFICATION {
    	Deleted, Added
    };
	/**
	 * @param beanName
	 * @return Bean
	 */
	@SuppressWarnings("unchecked")
	public static <T> T findBean(String beanName) {
		FacesContext context = FacesContext.getCurrentInstance();
		return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
	}

	/**
	 * Method to return the attendance month definition list
	 * 
	 * @return attendanceDefList
	 */
	public static List<String> getAttendanceMonthDefinition() {

		String[] monthNames = DateFormatSymbols.getInstance().getMonths();
		Calendar currentCalendar = GregorianCalendar.getInstance();
		int currentYear = currentCalendar.get(Calendar.YEAR);

		List<String> attendanceDefList = new ArrayList<String>();
		int nextYear = currentYear + 1;
		for (; currentYear <= nextYear; currentYear++) {

			for (int month = 0 ; month < 12 ; month++) {
				String attendanceMonth = monthNames[month] + "-" + currentYear;
				attendanceDefList.add(attendanceMonth);
			}
		}
		return attendanceDefList;
	}


}
