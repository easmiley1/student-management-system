package com.ish.sms.service.ops;

import org.springframework.beans.factory.annotation.Autowired;

import com.ish.sms.service.dao.AssociateOperationsDAO;
import com.ish.sms.service.dao.ClassOperationsDAO;
import com.ish.sms.service.dao.ReferenceOperationsDAO;
import com.ish.sms.service.ops.util.AssociateOperationsUtil;
import com.ish.sms.service.ops.util.ClassOperationsUtil;

public class BaseOperations {

	@Autowired
	protected ReferenceOperationsDAO referenceOperationsDAO;

	@Autowired
	protected AssociateOperationsDAO associateOperationsDAO;

	@Autowired
	protected ClassOperationsDAO classOperationsDAO;
	
	@Autowired
	protected AssociateOperationsUtil associateOperationsUtil;

	@Autowired
	protected ClassOperationsUtil classOperationsUtil;

}
