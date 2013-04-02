package com.ish.sms.web.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ish.sms.service.dto.UserDetailsDTO;

@SessionScoped
@ManagedBean(name="userBean")
public class UserBean {

	private UserDetailsDTO userDetailsDTO;

	/**
	 * @return the userDetailsDTO
	 */
	public UserDetailsDTO getUserDetailsDTO() {
		return userDetailsDTO;
	}

	/**
	 * @param userDetailsDTO the userDetailsDTO to set
	 */
	public void setUserDetailsDTO(UserDetailsDTO userDetailsDTO) {
		this.userDetailsDTO = userDetailsDTO;
	}
	
	
	
	
}
