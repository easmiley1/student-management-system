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
/**
 * @author enselv
 * 
 */
public class WebUtils implements WebConstants {

	public static enum CLASS_DEF_MODIFICATION {
		Deleted, Added
	};

	public static enum REFERENCE_TYPE {
		bloodGroup, dayofWeek, extraCurricularInterest, transportation, stateName, subjectName, NoOfPeriods, exam
	};

	/**
	 * @param beanName
	 * @return Bean
	 */
	@SuppressWarnings("unchecked")
	public <T> T findBean(String beanName) {
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

			for (int month = 0; month < 12; month++) {
				String attendanceMonth = monthNames[month] + "-" + currentYear;
				attendanceDefList.add(attendanceMonth);
			}
		}
		return attendanceDefList;
	}

	/**
	 * Utility method to provide the yearList during class Creation
	 * 
	 * @return yearList
	 */
	public static List<Integer> getYearListForClass() {
		List<Integer> yearList = new ArrayList<Integer>();
		Calendar calendar = GregorianCalendar.getInstance();
		Integer year = calendar.get(Calendar.YEAR);
		yearList.add(year);
		yearList.add(year - 1);
		yearList.add(year + 1);
		return yearList;
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

	/**
	 * Utility method to register server error message to client
	 */
	public static void registerErrorMessage() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, SAVE_FAILED + new Date(), CONTACT_TECHNICAL_TEAM));
	}

	/**
	 * Utility method to register the given messages to the client
	 * 
	 * @param severity
	 * @param summary
	 * @param detail
	 */
	public static void registerMessage(Severity severity, String summary, String detail) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(severity, summary, detail));

	}

}
