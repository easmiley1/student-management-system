package com.ish.sms.web.action;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "applicationThemeAction")
@SessionScoped
public class ApplicationThemeAction implements Serializable{

	private static final long serialVersionUID = 1L;
	private String theme = "classic";

	/**
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}
	

	public String initChangeTheme(){
		return "/pages/content/theme/changeTheme.xhtml";
	}
}
