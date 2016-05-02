package com.gwsj.j2ee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class BaseController {

	
	@Autowired
	private MessageSource messageSource;
	
	public String getMessage(String code) {
		return messageSource.getMessage(code, null, null);
	}

	public String getMessage(String code, Object[] params) {
		return messageSource.getMessage(code, params, null);
	}
}
