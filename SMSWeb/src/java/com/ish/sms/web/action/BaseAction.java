package com.ish.sms.web.action;

import java.io.Serializable;

import com.ish.sms.service.dto.ObjectFactory;
import com.ish.sms.web.util.WebConstants;

public class BaseAction implements WebConstants,Serializable {

	private static final long serialVersionUID = 1L;
	protected ObjectFactory objfactory = new ObjectFactory();
}
