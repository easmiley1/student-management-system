package com.ish.sms.web.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.ish.sms.web.businessdelegate.AssociateBusinessDelegate;
import com.ish.sms.web.businessdelegate.ClassAttendanceBusinessDelegate;
import com.ish.sms.web.businessdelegate.ClassBusinessDelegate;
import com.ish.sms.web.businessdelegate.ReferenceBusinessDelegate;
import com.ish.sms.web.businessdelegate.UserBusinessDelegate;
import com.ish.sms.web.service.ServiceTransformer;
import com.ish.sms.web.util.WebConstants;

/**
 * Base Business class which contains common operations for all business classes
 * 
 * @author Naren
 *
 */
public class BaseBusiness implements WebConstants{

	@Autowired
	protected ServiceTransformer serviceTransformer;
	
	@Autowired
	protected AssociateBusinessDelegate associateBusinessDelegate;

	@Autowired
	protected ReferenceBusinessDelegate referenceBusinessDelegate;

	@Autowired
	protected ClassBusinessDelegate classBusinessDelegate;
	
	@Autowired
	protected ClassAttendanceBusinessDelegate classAttendanceBusinessDelegate;
	
	@Autowired
	protected UserBusinessDelegate userBusinessDelegate;
}
