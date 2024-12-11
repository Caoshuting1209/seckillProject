package com.shuting.seckillproject.controller;

import com.shuting.seckillproject.common.Constants;
import com.shuting.seckillproject.common.LoginUser;
import com.shuting.seckillproject.entity.User;
import com.shuting.seckillproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("/doRegister")
    @ResponseBody
    public Constants doRegister(User user) {
        return userService.doRegister(user);
    }
}
