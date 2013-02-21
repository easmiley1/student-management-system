package com.ish.sms.web.util;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * Class containing web utility methods
 * 
 * @author Naren
 * 
 */
public class WebUtils implements WebConstants{

	
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

	/**
	 * Utility method for determining the current month-year
	 * 
	 * @return monthYear
	 */
	public static String getCurrentMonthYear() {
		Calendar calendar = GregorianCalendar.getInstance();
		Integer year = calendar.get(Calendar.YEAR);
		Integer monthInt = calendar.get(Calendar.MONTH);
		String month = DateFormatSymbols.getInstance().getMonths()[monthInt];
		String monthYear = month + "-" + year;
		return monthYear;
	}

	public static void registerErrorMessage() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, SAVE_FAILED + new Date(), CONTACT_TECHNICAL_TEAM));
	}

	public static void registerMessage(Severity severity, String summary, String detail) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(severity, summary, detail));

	}

}
