package com.liu.bookserver.service.serviceimpl;

import com.liu.bookserver.httpformat.HttpResult;
import com.liu.bookserver.model.OrgUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lrn
 * @createTime : 2018/10/30 10:07
 */
@FeignClient(value = "userserver")
public interface UserServiceServer {

    /**
     * 根据id获取某一用户信息
     * @author : lrn
     * @createTime : 2018/10/30 10:11
     * @param userid 用户id
     * @return
     */
    @GetMapping("/user/getUser")
    HttpResult getUser(@RequestParam(value = "id")String userid);
}
