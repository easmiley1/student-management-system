package com.ish.sms.service.dao.util;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Util class containing all the utility methods related to DAO operations
 * 
 * @author Naren
 * 
 */
public class ClassOperationsDAOUtil {

	/**
	 * Utility method for determining the no of days in the given month - year
	 * 
	 * @param monthYear
	 * @return noofdays
	 */
	public int getNoofDaysforMonth(String monthYear) {

		String[] monthYearSplit = monthYear.split("-");
		Integer year = new Integer(monthYearSplit[1]);
		List<String> monthsList = Arrays.asList(DateFormatSymbols.getInstance().getMonths());
		Integer month = monthsList.indexOf(monthYearSplit[0]);
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Utility method for determining the current month-year
	 * 
	 * @return monthYear
	 */
	public String getCurrentMonthYear() {
		Calendar calendar = GregorianCalendar.getInstance();
		Integer year = calendar.get(Calendar.YEAR);
		Integer monthInt = calendar.get(Calendar.MONTH);
		String month = DateFormatSymbols.getInstance().getMonths()[monthInt];
		String monthYear = month + "-" + year;
		return monthYear;
	}

}
