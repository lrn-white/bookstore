package com.liu.userserver.service.serviceimpl;

import com.liu.userserver.dao.UserDao;
import com.liu.userserver.httpformat.HttpResult;
import com.liu.userserver.httpformat.MsgEnum;
import com.liu.userserver.model.OrgUser;
import com.liu.userserver.service.UserService;
import com.liu.userserver.utils.UUIDTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author lrn
 * @createTime : 2018/10/26 13:59
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public HttpResult addUser(OrgUser orgUser) {
        orgUser.setId(UUIDTool.getUUID());
        int flag = userDao.addUser(orgUser);
        if (flag == 0) {
            return HttpResult.fail(MsgEnum.DATA_ADD_FAILURE);
        }
        return HttpResult.success(MsgEnum.DATA_ADD_SUCCESS);
    }

    @Override
    public HttpResult editUser(OrgUser orgUser) {
        int flag = userDao.editUser(orgUser);
        if (flag == 0) {
            return HttpResult.fail(MsgEnum.DATA_UPDATE_FAILURE);
        }
        return HttpResult.success(MsgEnum.DATA_UPDATE_SUCCESS);
    }

    @Override
    public HttpResult getUser(String id) {
        OrgUser orgUser = userDao.getUser(id);
        if (ObjectUtils.isEmpty(orgUser)){
            return HttpResult.fail(MsgEnum.DATA_SELECT_FAILURE);
        }
        return HttpResult.success(MsgEnum.DATA_SELECT_SUCCESS,orgUser);
    }

    @Override
    public HttpResult chooseAdmin(String id) {
        int flag = userDao.chooseAdmin(id);
        if (flag == 0){
            return HttpResult.fail(MsgEnum.DATA_UPDATE_FAILURE);
        }
        return HttpResult.success(MsgEnum.DATA_UPDATE_SUCCESS);
    }
}
