package com.liu.userserver.httpformat;

/**
 * @author lrn
 * @createTime : 2018/10/29 9:42
 */
public enum MsgEnum implements MsgInterface{
    /**
     * 传参校验失败
     */
    PARAM_FAILURE("100001", "参数错误"),
    /**
     * 数据库操作
     */
    DATA_ADD_FAILURE("100002", "数据库新增失败"),
    /**
     * 数据库操作
     */
    DATA_UPDATE_FAILURE("100003", "数据库修改失败"),
    /**
     * 数据库操作
     */
    DATA_SELECT_FAILURE("100004", "数据库查询失败"),
    /**
     * 数据库操作
     */
    DATA_DELETE_FAILURE("100005", "数据库删除失败"),
    /**
     * 数据库操作
     */
    DATA_ADD_SUCCESS("100006", "数据库新增成功"),
    /**
     * 数据库操作
     */
    DATA_UPDATE_SUCCESS("100007", "数据库修改成功"),
    /**
     * 数据库操作
     */
    DATA_DELETE_SUCCESS("100008", "数据库删除成功"),
    /**
     * 数据库操作
     */
    DATA_SELECT_SUCCESS("100009", "数据库查询成功"),
    ;
    private String code;
    private String msg;

    MsgEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode(){
        return code;
    }

    @Override
    public String getMsg(){
        return msg;
    }
}
