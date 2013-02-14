package com.ish.sms.service.rest;

import org.springframework.beans.factory.annotation.Autowired;

import com.ish.sms.service.ops.AssociateOperations;
import com.ish.sms.service.ops.ClassOperations;
import com.ish.sms.service.ops.ReferenceOperations;
import com.ish.sms.service.util.ServiceTransformer;

public class SMSBaseService {

	@Autowired
	protected ServiceTransformer serviceTransformer;

	@Autowired
	protected AssociateOperations associateOperations;
	
	@Autowired
	protected ReferenceOperations referenceOperations;

	@Autowired
	protected ClassOperations classOperations;
}
