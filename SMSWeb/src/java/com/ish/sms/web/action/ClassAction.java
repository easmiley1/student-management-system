package com.ish.sms.web.action;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Action Bean class which is in request scope for all the associate related actions.
 * 
 * @author Naren
 */
@ManagedBean(name = "classAction")
@ViewScoped
public class ClassAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	public String initAddClassDetails() {

		
		return SAVE_CLASS_PAGE;
	}

	
	public static void main(String args[]){
		
	}
}
