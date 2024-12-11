package com.shuting.seckillproject.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shuting.seckillproject.common.Constants;
import com.shuting.seckillproject.common.LoginUser;
import com.shuting.seckillproject.entity.User;
import com.shuting.seckillproject.exception.ServiceException;

public interface UserService extends IService<User> {
    Constants doLogin(LoginUser loginUser);
    Constants doRegister(User user);
}
