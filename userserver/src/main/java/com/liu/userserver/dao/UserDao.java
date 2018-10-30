package com.liu.userserver.dao;

import com.liu.userserver.model.OrgUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lrn
 * @createTime : 2018/10/26 14:12
 */
@Mapper
public interface UserDao {
    /**
     * 新增用户信息
     * @author : lrn
     * @createTime : 2018/10/29 10:48
     * @param orgUser id id
     * @param orgUser upassword 密码
     * @param orgUser uname 账号
     * @param orgUser upassword 密码
     * @return
     */
    int addUser(OrgUser orgUser);

    /**
     * 根据id修改用户信息
     * @author : lrn
     * @createTime : 2018/10/29 14:03
     * @param orgUser id id
     * @param orgUser uname 账号
     * @param orgUser upassword 密码
     * @return
     */
    int editUser(OrgUser orgUser);

    /**
     * 根据id获取某一用户信息
     * @author : lrn
     * @createTime : 2018/10/29 14:26
     * @param id id
     * @return
     */
    OrgUser getUser(String id);

    /**
     * 根据id修改用户是否为管理员
     * @author : lrn
     * @createTime : 2018/10/29 14:36
     * @param id id
     * @return
     */
    int chooseAdmin(String id);
}
