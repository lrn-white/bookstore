package com.liu.bookserver.httpformat;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author lrn
 * @createTime : 2018/9/13 11:33
 * @updateTime :
 */
public abstract class AbstractHttpResult {

	/**
	 * 消息
	 */
	String msg = "";

	/**
	 * code
	 */
	String code = "";

	/**
	 * 数据类型
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	Object data = null;

	/**
	 * 是否成功
	 */
	boolean success = false;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public <T> T getData() {
		return (T) data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
