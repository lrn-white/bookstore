package com.liu.userserver.model;

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
    @NotBlank(groups = {edit.class},message = "id不能为空")
    private String id;
    /**
     * 自增id
     */
    private Integer rowid;
    /**
     * 用户账号
     */
//    @NotBlank(message = "账号不能为空")
            @NotBlank
    private String uname;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String upassword;
    /**
     * 是否为管理员，0为否，1为是，默认为0
     */
    private Integer isadmin;
}
