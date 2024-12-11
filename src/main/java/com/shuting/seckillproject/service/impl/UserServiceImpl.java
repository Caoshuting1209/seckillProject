package com.shuting.seckillproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuting.seckillproject.common.Constants;
import com.shuting.seckillproject.common.LoginUser;
import com.shuting.seckillproject.entity.User;
import com.shuting.seckillproject.mapper.UserMapper;
import com.shuting.seckillproject.service.UserService;
import com.shuting.seckillproject.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    public Constants doRegister(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", user.getUserName());
        if(userMapper.selectOne(queryWrapper) != null){
            return Constants.USER_ALREADY_EXIST;
        }
        String inputPassword = user.getPassword();
        user.setSalt("1a2b3c4d");
        user.setPassword(MD5Util.inputPassToDBPass(inputPassword, user.getSalt()));
        int insert = userMapper.insert(user);
        if(insert == 1){
            return Constants.SUCCESS;
        }else {
            return Constants.ERROR;
        }
    }

    public Constants doLogin(LoginUser loginUser) {
        String name = loginUser.getUserName();
        String password = loginUser.getPassword();
        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(password)){
            return Constants.LOGIN_ERROR;
        }
        User user = userMapper.selectByName(loginUser.getUserName());
        if(user == null){
            return Constants.USER_NOT_EXIST;
        }
        if(!MD5Util.inputPassToDBPass(password,user.getSalt()).equals(user.getPassword())){
            return Constants.PASSWORD_ERROR;
        }
        return Constants.SUCCESS;
    }
}

