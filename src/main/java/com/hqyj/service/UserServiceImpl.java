package com.hqyj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hqyj.mapper.UserMapper;
import com.hqyj.pojo.User;
import com.hqyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean isUserNameExists(String userName) {
        return userMapper.countByUserName(userName) > 0;
    }

    @Override
    public User getByUserName(String userName) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("user_name", userName));
    }

    @Override
    public boolean saveUser(User user) {
        return this.save(user); // 使用 MyBatis-Plus 的 save 方法
    }
}
