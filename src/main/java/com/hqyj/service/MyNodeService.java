package com.hqyj.service;

import java.util.HashMap;

public interface MyNodeService {
    //查询权限
    HashMap<String,Object> selectPower(String userName);
}