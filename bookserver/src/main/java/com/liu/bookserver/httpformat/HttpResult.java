package com.liu.bookserver.httpformat;

/**
 * 返回模板
 * @author lrn
 * @date :
 * @since : 2018/9/13 10:39
 */
public class HttpResult extends AbstractHttpResult {

    /**
     * 输出模板
     * @param success 成功
     * @param msg
     * @param data
     */
    public HttpResult(boolean success, MsgInterface msg, Object data) {
        if (msg != null) {
            this.code = msg.getCode();
            this.msg = msg.getMsg();
        }
        this.success = success;
        this.data = data;
    }

    /**
     * 输出模板（无返回数据）
     * @param success
     * @param msg
     */
    public HttpResult(boolean success, MsgInterface msg) {
        if (msg != null) {
            this.code = msg.getCode();
            this.msg = msg.getMsg();
        }
        this.success = success;
    }

    /**
     * 输出模板（无返回数据）
     * @param success
     * @param code
     * @param msg
     */
    public HttpResult(boolean success, String code, String msg) {
        this.code = code;
        this.success = success;
        this.msg = msg;
    }

    /**
     * 输出模板（无返回数据）
     * @param success
     * @param code
     * @param msg
     * @param data
     */
    public HttpResult(boolean success, String code, String msg, Object data) {
        this.code = code;
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功
     * @param msg
     * @param data
     */
    public static HttpResult success(MsgInterface msg, Object data) {
        return new HttpResult(true, msg, data);
    }

    /**
     * 成功
     * @param msg
     */
    public static HttpResult success(MsgInterface msg) {
        return new HttpResult(true, msg);
    }

    /**
     * 成功
     * @param code
     * @param msg
     * @param data
     */
    public static HttpResult success(String code, String msg, Object data) {
        return new HttpResult(true, code, msg, data);
    }

    /**
     * 成功
     * @param code
     * @param msg
     */
    public static HttpResult success(String code, String msg) {
        return new HttpResult(true, code, msg);
    }

    /**
     * 失败
     * @param code
     * @param msg
     */
    public static HttpResult fail(String code, String msg) {
        return new HttpResult(false, code, msg);
    }

    /**
     * 失败
     * @param msg
     */
    public static HttpResult fail(MsgInterface msg) {
        return new HttpResult(false, msg);
    }

    /**
     * 参数校验失败
     * @param msg
     */
    public static HttpResult fail(String msg){
        return new HttpResult(false,"100001",msg);
    }
}
