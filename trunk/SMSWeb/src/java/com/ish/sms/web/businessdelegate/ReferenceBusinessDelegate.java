package com.ish.sms.web.businessdelegate;


public class ReferenceBusinessDelegate extends BaseBusinessDelegate{

	public String retrieveAllReferenceList(){
		return smsServiceLocator.getSmsReferenceServiceInterface().retrieveAllReferenceList();
	}
}
