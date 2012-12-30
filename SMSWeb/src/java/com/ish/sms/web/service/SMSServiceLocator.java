package com.ish.sms.web.service;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import com.ish.sms.web.service.client.SMSAssociateServiceInterface;
import com.ish.sms.web.service.client.SMSReferenceServiceInterface;

/**
 * Service locator class which initializes the restful service interfaces and provides the look up for the same.
 * 
 * @author Naren
 *
 */
public class SMSServiceLocator {

	private SMSAssociateServiceInterface smsAssociateServiceInterface;
	
	private SMSReferenceServiceInterface smsReferenceServiceInterface;


	/**
	 * @return smsAssociateServiceInterface
	 */
	public SMSAssociateServiceInterface getSmsAssociateServiceInterface() {
		return smsAssociateServiceInterface;
	}


	/**
	 * @return the smsReferenceServiceInterface
	 */
	public SMSReferenceServiceInterface getSmsReferenceServiceInterface() {
		return smsReferenceServiceInterface;
	}

	/**
	 * Constructor initializes the restful service interfaces
	 */
	public SMSServiceLocator(String associateServiceURL, String referenceServiceURL) {
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
		smsAssociateServiceInterface = ProxyFactory.create(SMSAssociateServiceInterface.class, associateServiceURL);
		smsReferenceServiceInterface = ProxyFactory.create(SMSReferenceServiceInterface.class, referenceServiceURL);
	}
	
	public static void main(String args[]){
		
		SMSServiceLocator smsServiceLocator = new SMSServiceLocator("", "http://localhost:8080/SMSService/websvc/smsReferenceService");
		System.out.println(smsServiceLocator.getSmsReferenceServiceInterface().retrieveAllReferenceList());
	}
	
}
