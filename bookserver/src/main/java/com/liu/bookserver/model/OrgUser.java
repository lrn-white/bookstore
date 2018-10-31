package com.liu.bookserver.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author lrn
 * @createTime : 2018/10/26 11:28
 */
@Data
public class OrgUser {
    /**
     * id
     */
    private String id;
    /**
     * 自增id
     */
    private Integer rowid;
    /**
     * 用户账号
     */
    private String uname;
    /**
     * 密码
     */
    private String upassword;
    /**
     * 是否为管理员，0为否，1为是，默认为0
     */
    private Integer isadmin;

}
