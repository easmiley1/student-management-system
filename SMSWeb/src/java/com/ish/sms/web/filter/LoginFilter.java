package com.ish.sms.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.jboss.security.SecurityAssociation;

import com.ish.sms.service.dto.UserDetailsDTO;
import com.ish.sms.web.bean.UserBean;
import com.ish.sms.web.business.UserBusiness;
import com.ish.sms.web.util.SMSSpringFactory;

/**
 * Login filter for getting the user and set it in session if it is already not present.
 * 
 * @author Naren
 * 
 */
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

		String userName = SecurityAssociation.getPrincipal().getName();
		System.out.println("Yeeey! Get me here and find me in the database: " + userName);
		UserBusiness userBusiness = (UserBusiness) SMSSpringFactory.getInstance().getBean("userBusiness");
		HttpServletRequest request = (HttpServletRequest) servletRequest;

		try {
			UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
			if (userBean == null) {
				UserDetailsDTO userDetailsDTO = userBusiness.retrieveUser(userName);
				userBean = new UserBean();
				userBean.setUserDetailsDTO(userDetailsDTO);
				request.getSession().setAttribute("userBean", userBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
