package com.ish.sms.web.action;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ish.sms.service.dto.ObjectFactory;
import com.ish.sms.web.business.AssociateBusiness;
import com.ish.sms.web.business.ClassBusiness;
import com.ish.sms.web.util.SMSSpringFactory;
import com.ish.sms.web.util.WebConstants;

public class BaseAction implements WebConstants, Serializable {

	private static final long serialVersionUID = 1L;
	protected ObjectFactory objfactory = new ObjectFactory();
	@Autowired
	protected AssociateBusiness associateBusiness;
	@Autowired
	protected ClassBusiness classBusiness;

	public BaseAction() {
		associateBusiness = (AssociateBusiness) SMSSpringFactory.getInstance().getBean(ASSOCIATE_BUSINESS_BEAN);
		classBusiness = (ClassBusiness) SMSSpringFactory.getInstance().getBean(CLASS_BUSINESS_BEAN);
	}

	protected void registerErrorMessage() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, SAVE_FAILED + new Date(), CONTACT_TECHNICAL_TEAM));
	}

	protected void registerMessage(Severity severity, String summary, String detail) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(severity, summary, detail));

	}
}
