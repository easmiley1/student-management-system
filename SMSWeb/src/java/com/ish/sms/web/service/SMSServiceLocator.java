package com.ish.sms.web.service;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import com.ish.sms.service.client.SMSAssociateServiceInterface;

/**
 * Service locator class which initializes the restful service interfaces and provides the look up for the same.
 * 
 * @author Naren
 *
 */
public class SMSServiceLocator {

	private SMSAssociateServiceInterface smsAssociateServiceInterface;


	/**
	 * @return smsAssociateServiceInterface
	 */
	public SMSAssociateServiceInterface getSmsAssociateServiceInterface() {
		return smsAssociateServiceInterface;
	}
	
	/**
	 * Constructor initializes the restful service interfaces
	 */
	public SMSServiceLocator(String associateServiceURL) {
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
		smsAssociateServiceInterface = ProxyFactory.create(SMSAssociateServiceInterface.class, associateServiceURL);
	}


}
