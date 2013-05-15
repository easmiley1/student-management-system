package com.ish.sms.web.service;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import com.ish.sms.web.service.client.SMSAssociateServiceInterface;
import com.ish.sms.web.service.client.SMSClassAttendanceServiceInterface;
import com.ish.sms.web.service.client.SMSClassServiceInterface;
import com.ish.sms.web.service.client.SMSReferenceServiceInterface;
import com.ish.sms.web.service.client.SMSReportServiceInterface;
import com.ish.sms.web.service.client.SMSUserServiceInterface;

/**
 * Service locator class which initializes the restful service interfaces and provides the look up for the same.
 * 
 * @author Naren
 * 
 */
public class SMSServiceLocator {

	private SMSAssociateServiceInterface smsAssociateServiceInterface;

	private SMSReferenceServiceInterface smsReferenceServiceInterface;

	private SMSClassServiceInterface smsClassServiceInterface;

	private SMSClassAttendanceServiceInterface smsClassAttendanceServiceInterface;

	private SMSUserServiceInterface smsUserServiceInterface;

	private SMSReportServiceInterface smsReportServiceInterface;

	/**
	 * @return the smsClassAttendanceServiceInterface
	 */
	public SMSClassAttendanceServiceInterface getSmsClassAttendanceServiceInterface() {
		return smsClassAttendanceServiceInterface;
	}

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
	 * @return the smsClassServiceInterface
	 */
	public SMSClassServiceInterface getSmsClassServiceInterface() {
		return smsClassServiceInterface;
	}

	/**
	 * @return the smsUserServiceInterface
	 */
	public SMSUserServiceInterface getSmsUserServiceInterface() {
		return smsUserServiceInterface;
	}

	/**
	 * @return the smsReportServiceInterface
	 */
	public SMSReportServiceInterface getSmsReportServiceInterface() {
		return smsReportServiceInterface;
	}

	/**
	 * Constructor initializes the restful service interfaces
	 */
	public SMSServiceLocator(String associateServiceURL, String referenceServiceURL, String classServiceURL, String classAttendanceServiceURL,
			String userServiceURL, String reportServiceURL) {
		
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
		smsAssociateServiceInterface = ProxyFactory.create(SMSAssociateServiceInterface.class, associateServiceURL);
		smsReferenceServiceInterface = ProxyFactory.create(SMSReferenceServiceInterface.class, referenceServiceURL);
		smsClassServiceInterface = ProxyFactory.create(SMSClassServiceInterface.class, classServiceURL);
		smsClassAttendanceServiceInterface = ProxyFactory.create(SMSClassAttendanceServiceInterface.class, classAttendanceServiceURL);
		smsUserServiceInterface = ProxyFactory.create(SMSUserServiceInterface.class, userServiceURL);
		smsReportServiceInterface = ProxyFactory.create(SMSReportServiceInterface.class, reportServiceURL);
	}

	public static void main(String args[]) {

		SMSServiceLocator smsServiceLocator = new SMSServiceLocator("", "", "http://localhost:8080/SMSService/websvc/smsClassService", "", "", "");
		String classxml = smsServiceLocator.getSmsClassServiceInterface().retrieveClassForId(1);
		System.out.println("class xml " + classxml);
	}

}
