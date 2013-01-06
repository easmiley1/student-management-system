package com.ish.sms.web.action;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "loginAction")
@RequestScoped
public class LoginOutAction extends BaseAction {


	public String logoutAction(){
		
		return "/login/";
	}
}
