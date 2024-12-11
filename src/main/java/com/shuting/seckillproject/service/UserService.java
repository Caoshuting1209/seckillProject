package com.shuting.seckillproject.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shuting.seckillproject.common.Constants;
import com.shuting.seckillproject.entity.LoginUser;
import com.shuting.seckillproject.entity.User;

public interface UserService extends IService<User> {
    Constants doLogin(LoginUser loginUser);
    Constants doRegister(User user);
}
