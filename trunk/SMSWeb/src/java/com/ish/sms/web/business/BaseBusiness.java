package com.ish.sms.web.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.ish.sms.web.service.ServiceTransformer;

/**
 * Base Business class which contains common operations for all business classes
 * 
 * @author Naren
 *
 */
public class BaseBusiness {

	@Autowired
	protected ServiceTransformer serviceTransformer;
	
}
