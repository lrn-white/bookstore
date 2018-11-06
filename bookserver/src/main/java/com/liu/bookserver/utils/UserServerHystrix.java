package com.liu.bookserver.utils;

import com.liu.bookserver.httpformat.HttpResult;
import com.liu.bookserver.service.UserServiceServer;
import org.springframework.stereotype.Component;

/**
 * 用户服务断路器
 * @author lrn
 * @createTime : 2018/11/6 8:57
 */
@Component
public class UserServerHystrix implements UserServiceServer{
    @Override
    public HttpResult getUser(String userid) {
        return HttpResult.fail("获取用户信息失败");
    }
}
