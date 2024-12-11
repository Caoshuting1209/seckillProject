package com.shuting.seckillproject.controller;

import com.shuting.seckillproject.common.Constants;
import com.shuting.seckillproject.entity.LoginUser;
import com.shuting.seckillproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/doLogin")
    @ResponseBody
    public Constants doLogin(@Validated LoginUser loginUser) {
        return userService.doLogin(loginUser);
    }
}
