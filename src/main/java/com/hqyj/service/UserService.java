package com.hqyj.service;

import com.hqyj.pojo.User;

public interface UserService {

    boolean isUserNameExists(String userName);

    User getByUserName(String userName);

    boolean saveUser(User user);
}
