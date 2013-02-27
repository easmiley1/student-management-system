package com.ish.sms.web.bean;

import java.io.Serializable;

import com.ish.sms.service.dto.ObjectFactory;
import com.ish.sms.web.util.WebConstants;
import com.ish.sms.web.util.WebUtils;

public class BaseBean implements Serializable, WebConstants{

	private static final long serialVersionUID = 1L;
	protected ObjectFactory objfactory = new ObjectFactory();
	protected WebUtils webutils = new WebUtils();

}
