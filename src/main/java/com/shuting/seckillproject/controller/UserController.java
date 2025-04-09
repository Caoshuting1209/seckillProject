package com.shuting.seckillproject.controller;

import com.shuting.seckillproject.common.http.Result;
import com.shuting.seckillproject.entity.LoginUser;
import com.shuting.seckillproject.entity.User;
import com.shuting.seckillproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired private UserService userService;

    @PostMapping("/doLogin")
    @ResponseBody
    public Result doLogin(@Validated LoginUser loginUser) {
        return userService.doLogin(loginUser);
    }

    @PostMapping("/doRegister")
    @ResponseBody
    public Result doRegister(@Validated User user) {
        return userService.doRegister(user);
    }
}
