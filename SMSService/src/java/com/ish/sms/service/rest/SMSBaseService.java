package com.ish.sms.service.rest;

import org.springframework.beans.factory.annotation.Autowired;

import com.ish.sms.service.ops.AssociateOperations;
import com.ish.sms.service.ops.ClassAttendanceOperations;
import com.ish.sms.service.ops.ClassOperations;
import com.ish.sms.service.ops.ReferenceOperations;
import com.ish.sms.service.ops.UserOperations;
import com.ish.sms.service.util.ServiceTransformer;

/**
 * Base Rest Service class which has all the injected operations
 * 
 * @author Naren
 *
 */
public class SMSBaseService {

	@Autowired
	protected ServiceTransformer serviceTransformer;

	@Autowired
	protected AssociateOperations associateOperations;
	
	@Autowired
	protected ReferenceOperations referenceOperations;

	@Autowired
	protected ClassOperations classOperations;
	
	@Autowired
	protected ClassAttendanceOperations classAttendanceOperations;
	
	@Autowired
	protected UserOperations userOperations;
	 
}
