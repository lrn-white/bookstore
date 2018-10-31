package com.liu.userserver.controller;

import com.liu.userserver.httpformat.HttpResult;
import com.liu.userserver.model.OrgUser;
import com.liu.userserver.model.edit;
import com.liu.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * 用户管理
 * @author lrn
 * @createTime : 2018/10/26 14:13
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 新增用户信息
     * @author : lrn
     * @createTime : 2018/10/29 11:13
     * @param orgUser uname 账号
     * @param orgUser upassword 密码
     */
    @PostMapping("/addUser")
    public HttpResult addUser(@Validated OrgUser orgUser, BindingResult result){
        if (result.hasErrors()){
            return HttpResult.fail(result.getFieldError().getDefaultMessage());
        }
        return userService.addUser(orgUser);
    }

    /**
     * 根据id修改用户信息
     * @author : lrn
     * @createTime : 2018/10/29 13:39
     * @param orgUser id id
     * @param orgUser uname 账号
     * @param orgUser upassword 密码
     */
    @PostMapping("/editUser")
    public HttpResult editUser(@Validated({edit.class})OrgUser orgUser, BindingResult result){
        if (result.hasErrors()){
            return HttpResult.fail(result.getFieldError().getDefaultMessage());
        }
        return userService.editUser(orgUser);
    }

    /**
     * 根据id获取某一用户信息
     * @author : lrn
     * @createTime : 2018/10/29 14:26
     * @param id id
     * @return
     */
    @GetMapping("/getUser")
    public HttpResult getUser(@NotBlank(message = "id不能为空")@RequestParam(value = "id") String id){
        return userService.getUser(id);
    }

    /**
     * 根据id修改用户是否为管理员
     * @author : lrn
     * @createTime : 2018/10/29 14:36
     * @param id id
     * @return
     */
    @GetMapping("/chooseAdmin")
    public HttpResult chooseAdmin(@NotBlank(message = "id不能为空") String id){
        return userService.chooseAdmin(id);
    }
}
