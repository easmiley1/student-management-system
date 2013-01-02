package com.ish.sms.web.util;

import javax.faces.context.FacesContext;

/**
 * Class containing web utility methods
 * 
 * @author Naren
 *
 */
public class WebUtils {

	/**
	 * @param beanName
	 * @return Bean
	 */
	@SuppressWarnings("unchecked")
	public static <T> T findBean(String beanName) {
	    FacesContext context = FacesContext.getCurrentInstance();
	    return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
	}
}
