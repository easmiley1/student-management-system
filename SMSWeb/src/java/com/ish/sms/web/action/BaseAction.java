package com.ish.sms.web.action;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.ish.sms.service.dto.ObjectFactory;
import com.ish.sms.web.business.AssociateBusiness;
import com.ish.sms.web.business.ClassBusiness;
import com.ish.sms.web.util.SMSSpringFactory;
import com.ish.sms.web.util.WebConstants;

public class BaseAction implements WebConstants,Serializable {

	private static final long serialVersionUID = 1L;
	protected ObjectFactory objfactory = new ObjectFactory();
	@Autowired
	protected AssociateBusiness associateBusiness;
	@Autowired
	protected ClassBusiness classBusiness;

	public BaseAction(){
		associateBusiness = (AssociateBusiness) SMSSpringFactory.getInstance().getBean("associateBusiness");
		classBusiness = (ClassBusiness) SMSSpringFactory.getInstance().getBean("classBusiness");
	}
}
