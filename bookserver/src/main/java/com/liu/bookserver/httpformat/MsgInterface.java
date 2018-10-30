package com.liu.bookserver.httpformat;

/**
 * 消息模板
 * 
 * @author lrn
 * @createTime : 2018/9/11 14:10
 * @updateTime :
 */
public interface MsgInterface {
	/**
	 * message code
	 * 
	 * @return
	 */
	String getCode();

	/**
	 * message
	 * 
	 * @return
	 */
	String getMsg();
}
