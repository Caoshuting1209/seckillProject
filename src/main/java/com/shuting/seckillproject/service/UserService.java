package com.shuting.seckillproject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.shuting.seckillproject.common.config.exceptionConfig.GlobalException;
import com.shuting.seckillproject.common.http.Constants;
import com.shuting.seckillproject.common.http.Result;
import com.shuting.seckillproject.entity.LoginUser;
import com.shuting.seckillproject.entity.User;
import com.shuting.seckillproject.mapper.UserMapper;
import com.shuting.seckillproject.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired private UserMapper userMapper;

    public Result doRegister(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", user.getUserName());
        if (userMapper.selectOne(queryWrapper) != null) {
            throw new GlobalException(Constants.USER_ALREADY_EXIST);
        }
        String inputPassword = user.getPassword();
        user.setSalt("1a2b3c4d");
        user.setPassword(MD5Util.inputPassToDBPass(inputPassword, user.getSalt()));
        int insert = userMapper.insert(user);
        if (insert == 1) {
            return Result.success(Constants.SUCCESS);
        } else {
            throw new GlobalException(Constants.ERROR);
        }
    }

    public Result doLogin(LoginUser loginUser) {
        String name = loginUser.getUserName();
        String password = loginUser.getPassword();
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            throw new GlobalException(Constants.LOGIN_ERROR);
        }
        User user = userMapper.selectByName(loginUser.getUserName());
        if (user == null) {
            throw new GlobalException(Constants.USER_NOT_EXIST);
        }
        if (!MD5Util.inputPassToDBPass(password, user.getSalt()).equals(user.getPassword())) {
            throw new GlobalException(Constants.PASSWORD_ERROR);
        }
        return Result.success(Constants.SUCCESS);
    }
}

