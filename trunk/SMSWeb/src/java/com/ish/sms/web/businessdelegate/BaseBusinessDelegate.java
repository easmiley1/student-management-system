package com.ish.sms.web.businessdelegate;

import org.springframework.beans.factory.annotation.Autowired;

import com.ish.sms.web.service.SMSServiceLocator;

/**
 * Base business delegate class which contains the common logic for all business
 * delegate. It also encapsulates the SMSSericeLocator.
 * 
 * @author Naren
 * 
 */
public class BaseBusinessDelegate {

	@Autowired
	protected SMSServiceLocator smsServiceLocator;

}
