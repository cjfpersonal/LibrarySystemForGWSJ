package com.gwsj.j2ee.vo;

/*
 * 
 * 
 * 返回前端的结果对象
 * 通过respondbody注解变成json格式传回前端
 */
public class Result {
	private String errNum;   //错误码
	private String message;  //错误信息
	private Object data;    //数据

	public Result() {}

	public Result(String errNum, String message, Object data) {
		this.errNum = errNum;
		this.message = message;
		this.data = data;
	}

	public String getErrNum() {
		return errNum;
	}

	public void setErrNum(String errNum) {
		this.errNum = errNum;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
