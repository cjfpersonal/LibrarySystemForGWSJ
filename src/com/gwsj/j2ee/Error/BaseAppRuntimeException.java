package com.gwsj.j2ee.Error;

/**
 * 非检查 (Unchecked) 异常
 * 数据库连接错误/网络连接错误/文件打不开
 * 
 * @author zhaokaijia
 */
public class BaseAppRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 5791281529259369944L;

	public BaseAppRuntimeException() {}

	public BaseAppRuntimeException(String message) {
		super(message);
	}

	public BaseAppRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseAppRuntimeException(Throwable cause) {
		super(cause);
	}
}
