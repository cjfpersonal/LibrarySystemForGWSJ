package com.gwsj.j2ee.Error;

/**
 * 检查 (Checked) 异常
 * 
 * @author zhaokaijia
 */
public class BaseAppException extends Exception {

	private static final long serialVersionUID = -1001515012018382228L;

	public BaseAppException() {}

	public BaseAppException(String message) {
		super(message);
	}

	public BaseAppException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseAppException(Throwable cause) {
		super(cause);
	}
}
