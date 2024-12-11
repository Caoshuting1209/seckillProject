package com.shuting.seckillproject.controller;

import com.shuting.seckillproject.common.Constants;
import com.shuting.seckillproject.common.LoginUser;
import com.shuting.seckillproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/doLogin")
    @ResponseBody
    public Constants doLogin(LoginUser loginUser) {
        return userService.doLogin(loginUser);
    }
}
