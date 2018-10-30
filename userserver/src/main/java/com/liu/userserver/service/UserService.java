package com.liu.userserver.service;

import com.liu.userserver.httpformat.HttpResult;
import com.liu.userserver.model.OrgUser;

/**
 * @author lrn
 * @createTime : 2018/10/26 13:56
 */
public interface UserService {
    /**
     * 新增用户信息
     * @author : lrn
     * @createTime : 2018/10/29 10:46
     * @param orgUser uname 账号
     * @param orgUser upassword 密码
     * @return
     */
    HttpResult addUser(OrgUser orgUser);

    /**
     * 根据id修改用户信息
     * @author : lrn
     * @createTime : 2018/10/29 14:01
     * @param orgUser id id
     * @param orgUser uname 账号
     * @param orgUser upassword 密码
     * @return
     */
    HttpResult editUser(OrgUser orgUser);

    /**
     * 根据id获取某一用户信息
     * @author : lrn
     * @createTime : 2018/10/29 14:26
     * @param id id
     * @return
     */
    HttpResult getUser(String id);

    /**
     * 根据id修改用户是否为管理员
     * @author : lrn
     * @createTime : 2018/10/29 14:36
     * @param id id
     * @return
     */
    HttpResult chooseAdmin(String id);
}
