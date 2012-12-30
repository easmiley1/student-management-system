package com.ish.sms.service.ops;

import org.springframework.beans.factory.annotation.Autowired;

import com.ish.sms.service.dao.AssociateOperationsDAO;
import com.ish.sms.service.dao.ReferenceOperationsDAO;

public class BaseOperations {

	@Autowired
	protected ReferenceOperationsDAO referenceOperationsDAO;

	@Autowired
	protected AssociateOperationsDAO associateOperationsDAO;

}
